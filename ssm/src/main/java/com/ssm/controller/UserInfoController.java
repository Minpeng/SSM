package com.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssm.common.page.PageList;
import com.ssm.common.util.PageUtil;
import com.ssm.entity.UserInfo;
import com.ssm.service.impl.UserInfoServiceImpl;

/**
 * Created by pengmin on 2017/5/6.
 */
@Controller
@RequestMapping( "/user" )
public class UserInfoController {

	@Autowired
	private UserInfoServiceImpl userInfoService;

	private static final Logger logger = LoggerFactory.getLogger( UserInfoController.class );

	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping( "/id" )
	@ResponseBody
	public Object getUserInfoById( HttpServletRequest request, HttpServletResponse response ) {
		// 获取参数
		String id = request.getParameter( "id" );
		if( "".equals( id ) || null == id ) {
			return "error";
		}
		int userId = Integer.parseInt( id );
		UserInfo userInfo = userInfoService.selectUser( userId );
		System.out.println( userInfo );
		if( null == userInfo ) {
			return "查询数据为空...";
		}
		logger.warn( userInfo.getAge() + userInfo.getId() + userInfo.getName() );

		return userInfo;
	}

	@RequestMapping( "/findAll" )
	@ResponseBody
	public String findAllUser( HttpServletRequest request, HttpServletResponse response ) {
		logger.info( "---------test" );
		String pageNo = request.getParameter( "pageNo" );
		String pageSize = request.getParameter( "pageSize" );
		String sortType = request.getParameter( "sortType" );

		Map<String, Object> model = new HashMap<>();

		model.put( "pageNo", Integer.parseInt( pageNo ) );
		model.put( "pageSize", Integer.parseInt( pageSize ) );

		String[] sortTypes = sortType.split( "\\." );
		model.put( "sortName", sortTypes[0] );
		model.put( "sortOrder", sortTypes[1] );

		Map<String, Object> pageResult = getNewPageList( model );

		Gson gson = new GsonBuilder().create();
		return getResult( gson, pageResult, 0, "成功" );

	}

	private <T> Map<String, Object> getNewPageList( Map<String, Object> model ) {
		PageList<UserInfo> userInfo = userInfoService.getPageList( model, Integer.parseInt( model.get( "pageNo" ).toString() ),
		    Integer.parseInt( model.get( "pageSize" ).toString() ) );
		Map<String, Object> result = PageUtil.getPageList( userInfo );
		return result;
	}

	public static String getResult( Gson gson, Object items, Object code, Object msg ) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put( "result", items );
		map.put( "code", code );
		map.put( "msg", msg );
		return gson.toJson( map );
	}
}
