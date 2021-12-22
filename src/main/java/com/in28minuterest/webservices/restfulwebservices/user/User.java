package com.in28minuterest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private Integer id;
    private String name;
    private Date BirthDate;
    private Integer age;
    private String city;
    private List<Posts> posts=new ArrayList<>();



    public User(Integer id, String name, Date birthDate, Integer age, String city, List<Posts> posts) {
        this.id = id;
        this.name = name;
        BirthDate = birthDate;
        this.age = age;
        this.city = city;
        this.posts = posts;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
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
                ", posts=" + posts +
                '}';
    }
}
