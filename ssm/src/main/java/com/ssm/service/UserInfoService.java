package com.ssm.service;

import com.ssm.entity.UserInfo;

import java.util.List;

/**
 * Created by pengmin on 2017/5/6.
 */
public interface UserInfoService {
    /**
     * 增加用户信息
     * @param user
     */
    public void addUser(UserInfo user);

    /**
     * 根据用户id查询信息
     * @param id
     */
    public  UserInfo selectUser(int id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserInfo> findUsers();

}
