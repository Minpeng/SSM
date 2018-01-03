package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.common.page.PageList;
import com.ssm.common.page.PageTurn;
import com.ssm.dao.UserInfoDaoMapper;
import com.ssm.entity.UserInfo;
import com.ssm.service.UserInfoService;


/**
 * Created by pengmin on 2017/5/6.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{


	private static final Logger logger = LoggerFactory.getLogger( UserInfoServiceImpl.class );

    @Autowired
    UserInfoDaoMapper userInfoDaoMapper;

    /**
     *
     * @param id
     * @return
     */
    public UserInfo selectUser(int id)  {
		logger.warn( "id 是：" + id );
        UserInfo userInfo=userInfoDaoMapper.selectUserInfoById(id);

        return  userInfo;
    }

    public void addUser(UserInfo userInfo){
        userInfoDaoMapper.addUser(userInfo);
    }

    public List<UserInfo> findUsers(){
       return userInfoDaoMapper.findUsers();
    }

	public PageList<UserInfo> getPageList( Map<String, Object> model, int pageNo, int pageSize ) {
		// 首先查询count数目
		int rowscount = userInfoDaoMapper.selectByMap_count( model );
		PageTurn retTurn = new PageTurn( pageNo, pageSize, rowscount );

		// 查询
		PageList<UserInfo> pagelist = new PageList<UserInfo>();
		pagelist.setPageTurn( retTurn );
		List<UserInfo> userInfoList = userInfoDaoMapper.selectByMap( model );
		pagelist.addAll( userInfoList );
		return pagelist;
	}
}
