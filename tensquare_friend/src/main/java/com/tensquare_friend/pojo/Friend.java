package com.tensquare_friend.pojo;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Friend
 *
 * @author Paulson
 * @date 2020/1/4 20:06
 */

@Data
@Entity(name = "tb_friend")
@IdClass(Friend.class)  // 联合主键
public class Friend implements Serializable {

    @Id
    private String userid;

    @Id
    private String friendid;

    private String islike;

}
