package com.citi.portfolio.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.service.FundManagerService;

@Controller
@RequestMapping("/manager")
public class FundManagerController {
	
	public FundManagerController() {
		
	}

	@Resource
	private FundManagerService fundManagerService;

	@RequestMapping("/showUser/{id}")
	public String showUser(@PathVariable("id")Integer id, HttpServletRequest request,Model model) {
		FundManager manager = fundManagerService.getManagerById(1);
		model.addAttribute("manager", manager);
//		request.setAttribute("manager", manager);
		return "showUser";
	}

}
