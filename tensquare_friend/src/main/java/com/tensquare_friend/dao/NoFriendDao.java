package com.tensquare_friend.dao;

import com.tensquare_friend.pojo.Friend;
import com.tensquare_friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * FriendDao
 *
 * @author Paulson
 * @date 2020/1/4 20:05
 */
public interface NoFriendDao extends JpaRepository<NoFriend, String> {
    public NoFriend findByUseridAndFriendid(String userid, String friendid);
}
