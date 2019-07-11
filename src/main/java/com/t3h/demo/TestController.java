package com.t3h.demo;

import com.t3h.demo.model.FriendId;
import com.t3h.demo.repository.FriendIdRepository;
import com.t3h.demo.repository.FriendResponseRepository;
import com.t3h.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private FriendResponseRepository friendResponseRepository;
    @Autowired
    private FriendIdRepository friendIdRepository;
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


    @GetMapping(value = "/getAllNotFriend")
    public Object getAllNotFriend(
            @RequestParam int id
    ){
        List<FriendId> friendIds=
                friendIdRepository.findAllNotFriend(id);
        List<Integer> fIds = new ArrayList<>();
        for (FriendId friendId : friendIds) {
            if (friendId.getReceiverId() == id){
                fIds.add(friendId.getSenderId());
            }else {
                fIds.add(friendId.getReceiverId());
            }
        }
        return
                userProfileRepository.findAllNotFriend(fIds);

    }

    @GetMapping(value = "testAhihi")
    public String testAhihi() {
        return "TesteAhihi";
    }


    @GetMapping(value = "test1")
    public String test1(){
        return "Test";
    }
}
