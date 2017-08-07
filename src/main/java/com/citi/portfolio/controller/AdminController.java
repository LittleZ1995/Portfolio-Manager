package com.citi.portfolio.controller;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.service.FundManagerService;
import com.citi.portfolio.util.JSONUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private FundManagerService fundManagerService;
	

	@RequestMapping("/mainpage")
    public String mainPage(HttpServletRequest request, Model model){

        return "adminPage";
	}
	
	@RequestMapping("/showManagers")
    public String showUser(HttpServletRequest request, Model model){
		List<FundManager> fundManagers = fundManagerService.getAllManagers();     
		model.addAttribute("fundManagers",fundManagers);
        return "admintest";
	}
	
	@RequestMapping("/addManager")
    public String addManager(HttpServletRequest request, Model model){
		String managerid = request.getParameter("managerid");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		int id = Integer.parseInt(managerid);
		FundManager fundManager = new FundManager(id, firstname, lastname, email, phonenumber, password);
		int result = fundManagerService.addManager(fundManager);
		if(result != 0)
			System.out.println("add successfully");
        return "adminPage";
	}
	
	@RequestMapping(value = "/deleteManagerById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteManagerById(@RequestBody String j)throws IOException{


	        JSONObject jo= JSONUtil.toJsonObject(j);
	        System.out.println("transfered json:"+jo);
	        int managerid=Integer.parseInt(jo.getString("managerid"));
	        System.out.println("managerid:"+managerid);

	        int res=fundManagerService.deleteManager(managerid);
	        System.out.println("res:["+res+"]");
	        Map<String,Object> map=new HashMap();
	        String message="";
	        if(res>=1)message="success";
	        else message="failed";
	        map.put("message",message);
	        return JSONUtil.toJsonString(map);
    }
	
}
