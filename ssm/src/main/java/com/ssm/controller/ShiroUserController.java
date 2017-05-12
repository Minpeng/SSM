package com.ssm.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.entity.ShiroUserEntity;

@Controller
@RequestMapping( "/" )
public class ShiroUserController {

	@RequestMapping( method = { RequestMethod.GET, RequestMethod.POST } )
	public String loginIndex() {
		return "login";
	}

	@RequestMapping( value = "/index", method = { RequestMethod.GET, RequestMethod.POST } )
	public String index() {
		return "login";
	}

	private static Logger logger = Logger.getLogger( ShiroUserController.class );

	@RequestMapping( "/loginAdmin" )
	public String login( ShiroUserEntity shiroUser, Model model ) {
		Subject subject = SecurityUtils.getSubject();
		logger.warn( shiroUser.getUserName() + ":" + shiroUser.getPassword() );

		UsernamePasswordToken token = new UsernamePasswordToken( shiroUser.getUserName(), shiroUser.getPassword() );
		try {
			subject.login( token );
			return "admin";
		}
		catch( Exception e ) {
			// 这里将异常打印关闭是因为如果登录失败的话会自动抛异常
			// e.printStackTrace();
			model.addAttribute( "error", "用户名或密码错误" );
			return "login";
		}
	}

	@RequestMapping( "/admin" )
	public String admin() {
		return "admin";
	}

	@RequestMapping( "/student" )
	public String student() {
		return "admin";
	}

	@RequestMapping( "/teacher" )
	public String teacher() {
		return "admin";
	}


}
