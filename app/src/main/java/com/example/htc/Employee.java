package com.example.htc;

import java.util.List;

public class Employee implements Comparable<Employee> {

    private String name;
    private int phone_number;
    private List<String> skills;

    public Employee(String name, int phone_number, List<String> skills) {
        this.name = name;
        this.phone_number = phone_number;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        if (this.name != null && otherEmployee.getName() != null) {
            return this.name.compareTo(otherEmployee.getName());
        }
        return -1;
    }
}
