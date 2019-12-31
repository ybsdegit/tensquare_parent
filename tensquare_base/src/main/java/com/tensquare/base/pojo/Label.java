package com.tensquare.base.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Label
 *
 * @author Paulson
 * @date 2019/12/31 1:39
 */

@Data
@Entity
@Table(name="tb_label")
public class Label implements Serializable {

    @Id
    private String id;//
    private String labelname;//标签名称
    private String state;//状态
    private Long count;//使用数量
    private Long fans;//关注数
    private String recommend;//是否推荐

}
