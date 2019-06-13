package com.xqd.dao;

import com.xqd.entity.userBean;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface userBeanMapper extends Mapper<userBean> {

    /**
     * 更新用户信息
     * @param userId
     * @param name
     * @param number
     * @return
     */
    int updateUser(@Param("userId") int userId,@Param("name") String name,@Param("number") int number);

    int updateUser(Map map);
}