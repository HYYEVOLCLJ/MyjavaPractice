package cn.practice.BZhan._05_aop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * AOP框架的简单实现
 */
public class BeanFactory {
    Properties prop = new Properties();
    public BeanFactory(InputStream in){
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name){
        String className = prop.getProperty(name);
        Object bean = null;
        try {
            // 获取ProxyFactoryBean的class对象
            Class<?> aClass = Class.forName(className);
            // 实例化对象
            bean = aClass.newInstance();
            // 根据配置文件实例化advice和target对象
            Object target = Class.forName(prop.getProperty(name + ".target"))
                    .newInstance();
            Object advice = Class.forName(prop.getProperty(name + ".advice"))
                    .newInstance();

            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor: propertyDescriptors){
                String name1 = propertyDescriptor.getName();
                Method writeMethod = propertyDescriptor.getWriteMethod();
                if ("target".equals(name1)){
                    // 第二个参数是需要传入的参数
                    writeMethod.invoke(bean,target);
                } else if ("advice".equals(name1)){
                    writeMethod.invoke(bean,advice);
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IntrospectionException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
