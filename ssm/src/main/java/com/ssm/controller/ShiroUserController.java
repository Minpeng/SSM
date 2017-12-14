package com.ssm.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@RequestMapping( value = "index", method = { RequestMethod.GET, RequestMethod.POST } )
	public String index() {
		return "login";
	}

	@RequestMapping( value = "login", method = { RequestMethod.GET, RequestMethod.POST } )
	public String loginUrl() {
		return "login";
	}

	private static final Logger logger = LoggerFactory.getLogger( ShiroUserController.class );

	@RequestMapping( "loginAdmin" )
	public String login( ShiroUserEntity shiroUser, Model model ) {
		Subject subject = SecurityUtils.getSubject();
		if(subject==null || shiroUser.getUserName()==null){
			logger.warn("subject is null");
			return "login";
		}
		logger.warn( shiroUser.getUserName() + ":" + shiroUser.getPassword() );

		UsernamePasswordToken token = new UsernamePasswordToken( shiroUser.getUserName(), shiroUser.getPassword() );
		try {
			subject.login( token );

			model.addAttribute("shiroUser",shiroUser);
			return "main";
		}
		catch( Exception e ) {
			// 这里将异常打印关闭是因为如果登录失败的话会自动抛异常
			// e.printStackTrace();
			model.addAttribute( "error", "用户名或密码错误" );
			model.addAttribute("code",-1);
			return "login";
		}
	}


	@RequestMapping(value="logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/index.do";
	}
	@RequestMapping( "admin" )
	public String admin() {
		return "admin";
	}

	@RequestMapping( "student" )
	public String student() {
		return "student";
	}

	@RequestMapping( "teacher" )
	public String teacher() {
		return "teacher";
	}

	@RequestMapping("nopower")
	public String noPower(){
		return  "nopower";
	}

}
