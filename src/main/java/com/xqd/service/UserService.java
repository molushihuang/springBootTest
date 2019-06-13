package com.xqd.service;


import com.xqd.dao.userBeanMapper;
import com.xqd.entity.userBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private userBeanMapper mUserBeanMapper;

    public List<userBean> getUserList() {
        return mUserBeanMapper.selectAll();
    }

    /**
     * 插入数据
     *
     * @param userBean
     */
    public void addUser(userBean userBean) {
        mUserBeanMapper.insertSelective(userBean);
    }

    /**
     * 更新数据
     *
     * @param
     */
    public void updateUser(int id, String name, int number) {

//        userBean userBean = mUserBeanMapper.selectByPrimaryKey(id);
//        userBean.setLuckyNumber(number);
//        userBean.setName(name);
//
//        mUserBeanMapper.updateByPrimaryKeySelective(userBean);

        //        mUserBeanMapper.updateUser(id,name,number);


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", id);
        map.put("name", name);
        map.put("number", number);
        mUserBeanMapper.updateUser(map);

    }


    /**
     * 删除数据
     *
     * @param id
     */
    public void delUser(int id) {
        mUserBeanMapper.deleteByPrimaryKey(id);
    }
}
