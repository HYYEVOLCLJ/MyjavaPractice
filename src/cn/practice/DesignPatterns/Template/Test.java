package cn.practice.DesignPatterns.Template;

public class Test {
    @org.junit.Test
    public void test(){
        UserManager um = new UserManager();
        um.action("admin","add");
    }
}
