package com.tensquare_friend.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * Friend
 *
 * @author Paulson
 * @date 2020/1/4 20:06
 */

@Data
@Entity(name = "tb_nofriend")
@IdClass(NoFriend.class)  // 联合主键
public class NoFriend implements Serializable {

    @Id
    private String userid;

    @Id
    private String friendid;

}
