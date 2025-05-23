package com.myhealthteam.staffapp.models;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String bloodGroup;
    private boolean isActive; // True for active, false for inactive

    public Patient(int id, String name, int age, String sex, String bloodGroup, boolean isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.bloodGroup = bloodGroup;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

}

