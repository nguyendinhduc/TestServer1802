package com.t3h.demo.repository;

import com.t3h.demo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository
        extends JpaRepository<UserProfile, Integer> {
}
