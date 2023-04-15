package io.renren.config;

public class Hello {
    public static void main(String[] args) {
        method("123456");


    }

    public static void method(String i) {

        String username = "hello";
        String password = "123456";

        if (i == password) {
            System.out.println("密码正确");
        } else {
            System.out.println("密码不正确");
        }

    }
}
