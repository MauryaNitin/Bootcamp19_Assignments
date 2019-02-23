package com.ttn.java_session_2;

/**
 * 13. Create a custom exception that do not have any stack trace.
 */

class MyException extends Throwable{
//  public MyException(String msg,Throwable cause, boolean enableSuppression,boolean writeStackTrace){
    public MyException(String msg, boolean flag){
        super(msg, null, flag, !flag);
    }
    public MyException(String msg){
        super(msg);
    }
}


public class Ques13_Custom_exception {
    public static void main(String[] args) {
        try{
//            throw new MyException("Custom exception with Stack Trace");
            throw new MyException("Custom exception without Stack Trace", true);

        }
        catch (MyException exp){
            System.out.println("Caught custom exception: " + exp.getMessage());
            exp.printStackTrace();
        }
    }
}
