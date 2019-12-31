package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
    /**
     * 查询推荐职位列表(按创建日期降序排序)
     * @return
     */
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state); // where state = ? order by createtime

    /**
     * 最新职位列表
     * @param state
     * @return
     */
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state); // where state != ? order by create

}
