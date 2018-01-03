package com.ssm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.entity.UserInfo;
/**
 * Created by pengmin on 2017/5/6.
 */

@Repository
public interface  UserInfoDaoMapper {

    UserInfo selectUserInfoById( @Param ("id") int id);

    List<UserInfo> findUsers();

    void addUser(UserInfo userInfo);

	int selectByMap_count( Map<String, Object> model );

	List<UserInfo> selectByMap( Map<String, Object> model );
}
