package com.shichuan.java.multithread.helper;

public class Employee {
    public int empId;
    public String name;
    public Employee(int id, String n) {
        empId = id;
        name = n;
    }
    public String toString() {
        return String.format("EmpInfo: %03d # %s", empId, name.substring(2, 6));
    }
}
