package com.in28minuterest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserService {
    private static List<User>users=new ArrayList<>();
    private static int count=5;
    static {
        users.add(new User(1,"shital",new Date(),22,"Chicago"));
        users.add(new User(2,"Nilesh",new Date(),26,"Cali"));
        users.add(new User(3,"Pilesh",new Date(),52,"Texas"));
        users.add(new User(4,"Soniya",new Date(),42,"Delhi"));
    }
    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    public User saveUser(User user){
        if(user.getId()==null){
            user.setId(++count);
        }
        users.add(user);
        return user;
    }

}
