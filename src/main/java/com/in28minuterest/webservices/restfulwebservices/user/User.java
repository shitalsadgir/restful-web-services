package com.in28minuterest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Date BirthDate;
    private Integer age;
    private String city;

    public User(Integer id, String name, Date birthDate, Integer age, String city) {
        this.id = id;
        this.name = name;
        BirthDate = birthDate;
        this.age = age;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", BirthDate=" + BirthDate +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
