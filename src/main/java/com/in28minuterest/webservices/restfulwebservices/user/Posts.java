package com.in28minuterest.webservices.restfulwebservices.user;

import java.util.Date;

public class Posts {
    private Integer id;
    private String name;
    private Date postDate;
    private Integer likes;
    private Integer shares;

    public Posts(Integer id, String name, Date postDate, Integer likes, Integer shares) {
        this.id = id;
        this.name = name;
        this.postDate = postDate;
        this.likes = likes;
        this.shares = shares;
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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postDate=" + postDate +
                ", likes=" + likes +
                ", shares=" + shares +
                '}';
    }
}
