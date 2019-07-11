package com.t3h.demo.repository;

import com.t3h.demo.model.FriendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendIdRepository extends
        JpaRepository<FriendId, Integer> {

    @Query(nativeQuery = true,
    value = "SELECT id, sender_id, receiver_id " +
            "FROM friend " +
            "WHERE sender_id = :userId OR " +
            "receiver_id = :userId")
    List<FriendId> findAllNotFriend(
            @Param(value = "userId") int userId
    );
}
