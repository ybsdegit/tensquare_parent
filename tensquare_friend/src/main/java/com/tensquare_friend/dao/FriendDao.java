package com.tensquare_friend.dao;

import com.tensquare_friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * FriendDao
 *
 * @author Paulson
 * @date 2020/1/4 20:05
 */
public interface FriendDao extends JpaRepository<Friend, String> {
    public Friend findByUseridAndFriendid(String userid, String friendid);

    @Modifying
    @Query(value = "UPDATE tb_friend set islike = ? where userid = ? AND friendid = ?", nativeQuery = true)
    public void updateIslike(String islike, String userid, String friendid);

    @Modifying
    @Query(value = "delete FROM tb_friend where userid = ? AND friendid = ?", nativeQuery = true)
    public void deleteFriend(String userid, String friendid);
}
