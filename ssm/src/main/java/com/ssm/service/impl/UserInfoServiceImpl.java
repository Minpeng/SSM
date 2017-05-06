package com.ssm.service.impl;

import com.ssm.dao.UserInfoDaoMapper;
import com.ssm.entity.UserInfo;
import com.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;


/**
 * Created by pengmin on 2017/5/6.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{


    private static Logger loger = Logger.getLogger(UserInfoServiceImpl.class);

    @Autowired
    UserInfoDaoMapper userInfoDaoMapper;

    /**
     *
     * @param id
     * @return
     */
    public UserInfo selectUser(int id)  {
        loger.warn("id 是："+id);
        UserInfo userInfo=userInfoDaoMapper.selectUserInfoById(id);

        return  userInfo;
    }

    public void addUser(UserInfo userInfo){
        userInfoDaoMapper.addUser(userInfo);
    }

    public List<UserInfo> findUsers(){
       return userInfoDaoMapper.findUsers();
    }
}
