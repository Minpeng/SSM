package com.ssm.dao;

import com.ssm.entity.UserInfo;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * Created by pengmin on 2017/5/6.
 */

@Repository
public interface  UserInfoDaoMapper {

    UserInfo selectUserInfoById( @Param ("id") int id);

    List<UserInfo> findUsers();

    void addUser(UserInfo userInfo);
}
