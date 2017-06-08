package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pengmin on 2017/5/6.
 */
@Controller
@RequestMapping("/test")
public class testController {

    @RequestMapping("/index")
    @ResponseBody
    public  String test(HttpServletRequest request){

		return "test";
    }
}