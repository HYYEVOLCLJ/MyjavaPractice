package cn.practice.BZhan.DesignPatterns.Factory.SimpleFactory;

public class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}