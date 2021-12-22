package com.in28minuterest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static List<Posts> posts = new ArrayList<>();
    private static int count = 4;
    private static int pcount = 2;

    static {
        users.add(new User(1, "shital", new Date(), 22, "Chicago", Arrays.asList(new Posts(1, "post1", new Date(), 100, 10))));
        users.add(new User(2, "Nilesh", new Date(), 26, "Cali", Arrays.asList(new Posts(2, "post2", new Date(), 600, 20), new Posts(1, "post1", new Date(), 100, 10))));
        users.add(new User(3, "Pilesh", new Date(), 52, "Texas", Arrays.asList(new Posts(3, "post2", new Date(), 400, 17))));
        users.add(new User(4, "Soniya", new Date(), 42, "Delhi", Arrays.asList(new Posts(4, "post2", new Date(), 500, 9))));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(++count);
        }
        users.add(user);
        return user;
    }
    public User removeUser(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user=iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
            return null;

    }
    public List<Posts> findAllPosts(int id) {
        for (User user1 : users) {
            if (user1.getId() == id) {
                List<Posts> posts1 = user1.getPosts();
                return posts1;
            }
        }
        return null;
    }

    public Posts findOnePost(int uid,int pid) {
        User ulist=users.stream().filter(user -> user.getId().equals(uid)).findFirst().get();
       Posts p= ulist.getPosts().stream().filter(posts1 -> posts1.getId().equals(pid)).findFirst().get();
        return p;
    }
    public Posts saveUserPost(int uid, Posts post) {
        User u=users.stream().filter(user -> user.getId().equals(uid)).findFirst().get();
        List<Posts> p=u.getPosts();
        ArrayList<Posts>pp=new ArrayList<>();
        pp.addAll(p);
        pp.add(post);
        u.setPosts(pp);
        return post;
    }

}
