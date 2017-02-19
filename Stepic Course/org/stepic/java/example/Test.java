package org.stepic.java.example;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }
    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        String h = null;
        try {
            throw new IllegalArgumentException("ddd");
        } catch (IllegalArgumentException e) {
            h = e.getStackTrace()[e.getStackTrace().length-1].getClassName()+"#"+e.getStackTrace()[e.getStackTrace().length-1].getMethodName();
        }
        return h;
    }
}