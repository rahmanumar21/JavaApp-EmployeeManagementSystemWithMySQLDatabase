package com.employee.management.model;

public class Employee {

    // fields
    private int id;
    private String name;
    private double salary;
    private int age;

    // constructor
    public Employee() {}

    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    // getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // convert object to string

    @Override
    public String toString() {
        return name + " " + salary + " " + age;
    }

}
