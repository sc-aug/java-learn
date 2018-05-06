package com.shichuan.java.multithread.helper;

public class EmpFactory {
    public static Employee genEmp() {
        Employee e = new Employee((int)(Math.random()*1000), String.valueOf(Math.random()).substring(0, 9));
        return e;
    }
}