package cn.practice.basis.grammar.demo;

//public class MyException extends Exception{
//    public MyException(){}
//
//    public MyException(String message){
//        super(message);
//    }
//}

public class MyException extends RuntimeException{
    public MyException(){}

    public MyException(String message){
        super(message);
    }
}