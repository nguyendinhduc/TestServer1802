package com.t3h.demo.repository;

import com.t3h.demo.model.Friend;
import com.t3h.demo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

}
