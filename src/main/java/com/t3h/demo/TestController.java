package com.t3h.demo;

import com.t3h.demo.repository.FriendResponseRepository;
import com.t3h.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private FriendResponseRepository friendResponseRepository;
    @GetMapping(value = "/test")
    public Object test(){
        Student student = new Student();
        student.setAge(10);
        student.setName("Ha");
        return student;
    }

    @GetMapping(value = "/getAllUser")
    public Object getAllUser(){
        return userProfileRepository.findAll();
    }

    @GetMapping(value = "/getAllFriend")
    public Object getAllFriend(
            @RequestParam int id
    ){
        return friendResponseRepository.findAllFriend(id);
    }

    @GetMapping(value = "/test")
    public String test(){
        return "Test";
    }
}
