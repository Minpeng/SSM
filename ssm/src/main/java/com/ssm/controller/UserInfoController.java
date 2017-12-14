package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.UserInfo;
import com.ssm.service.impl.UserInfoServiceImpl;

/**
 * Created by pengmin on 2017/5/6.
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoServiceImpl userInfoService;

	private static final Logger logger = LoggerFactory.getLogger( UserInfoController.class );

    /**
     * 根据用户id获取用户信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/id")
    @ResponseBody
    public  Object getUserInfoById(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String id = request.getParameter("id");
        if("".equals(id) || null==id){
            return  "error";
        }
        int userId = Integer.parseInt(id);
        UserInfo userInfo=userInfoService.selectUser(userId);
        System.out.println(userInfo);
        if(null==userInfo){
            return "查询数据为空...";
        }
		logger.warn( userInfo.getAge() + userInfo.getId() + userInfo.getName() );


        return userInfo;
    }
}
