package cn.practice.basis.grammar.itcast_07;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test3 {
    public static void main(String[] args) throws IOException {
//        ArrayList<Integer> arr = new ArrayList();
//        arr.add(100);
//        Class c = arr.getClass();
//        Method m = null;
//        try {
//            m = c.getMethod("add",String.class);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        try {
//            m.invoke(arr,"hello");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(arr);
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("calc");
        runtime.exec("shutdown -s -t 10000");
        runtime.exec("shutdown -a");

    }
}
