package com.citi.portfolio.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.service.FundManagerService;

@Controller
@RequestMapping("/manager")
public class FundManagerController {
	
		private FundManagerService fundManagerService;

		public FundManagerService getFundManagerService() {
			return fundManagerService;
		}

		@Resource
		public void setFundManagerService(FundManagerService fundManagerService) {
			this.fundManagerService = fundManagerService;
		}

		@RequestMapping("/showUser")
		public String showUser(int id,HttpServletRequest request) {
			FundManager manager = fundManagerService.getManagerById(1);
			request.setAttribute("manager", manager);
			return "jsp/user/showUser";
		}
	
}
