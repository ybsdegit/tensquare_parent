package com.tensquare_friend.service;

import com.tensquare_friend.dao.FriendDao;
import com.tensquare_friend.dao.NoFriendDao;
import com.tensquare_friend.pojo.Friend;
import com.tensquare_friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FriendService
 *
 * @author Paulson
 * @date 2020/1/4 19:55
 */

@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    public int addFriend(String userid, String friendid) {
        // 先判断 userid 到 friendid 是否有数据，有就是重复添加， 返回0
        Friend friend = friendDao.findByUseridAndFriendid(userid, friendid);
        if (friend != null){
            return 0;
        }
        // 直接添加好友，让好友表中 userid 到 friendid 方向的 type 为 0
        friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);
        // 判断从friendid 到 userid 是否有数据，如果有，把双方的状态改为1
        if (friendDao.findByUseridAndFriendid(friendid, userid) != null){
            friendDao.updateIslike("1", userid, friendid);
            friendDao.updateIslike("1", friendid, userid);
        }
        return 1;
    }

    public int addNoFriend(String userid, String friendid) {
        // 先判断 userid 到 friendid 是否有数据，有就是重复添加， 返回0
        NoFriend noFriend = noFriendDao.findByUseridAndFriendid(userid, friendid);
        if (noFriend != null){
            return 0;
        }
        // 直接添加好友，让好友表中 userid 到 friendid 方向的 type 为 1
        noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
        return 1;
    }

    public void deleteFriend(String userid, String friendid) {
        // 删除好友表中 userid 到 friendid 这条数据
        friendDao.deleteFriend(userid, friendid);
        // 更新从 friendid 到 userid 的 islike 为0
        friendDao.updateIslike("0", friendid, userid);
        // 非好友表中添加数据
        NoFriend noFriend = new NoFriend();
        noFriend.setFriendid(friendid);
        noFriend.setUserid(userid);
        noFriendDao.save(noFriend);

    }
}
