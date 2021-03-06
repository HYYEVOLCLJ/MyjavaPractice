package cn.practice.DesignPatterns.CreateModel.Singleton;

/**
 * 饿汉式
 */
public class Student {
    // 构造私有
    private Student() {
    }

    // 自己造一个
    // 静态方法只能访问静态成员变量，加静态
    // 为了不让外界直接访问修改这个值，加private
    private static Student s = new Student();

    // 提供公共的访问方式
    // 为了保证外界能够直接使用该方法，加静态
    public static Student getStudent() {
        return s;//就一个原子性操作。所以不会出现线程安全问题。
    }
}
