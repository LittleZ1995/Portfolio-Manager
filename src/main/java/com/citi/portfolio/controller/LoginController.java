package com.citi.portfolio.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.entity.Portfolio;
import com.citi.portfolio.service.FundManagerService;
import com.citi.portfolio.service.PortfolioService;

@Controller

public class LoginController {
	
	@Resource
	private FundManagerService fundManagerService;
	
	@Resource
	private PortfolioService portfolioService;
	
	@RequestMapping("/loginpage")
    public String mainPage(HttpServletRequest request, Model model){

        return "login";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model, HttpSession httpSession){
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		if(account.equals("admin") && password.equals("admin"))
			return "adminPage";		
		else{
			FundManager fundManager = null;
			fundManager = fundManagerService.selectByEmail(account);
			if(fundManager == null)
			{
				System.out.println("account does not exist");
				return "login";
			}
			else if(!fundManager.getPassword().equals(password))
			{
				System.out.println("password is wrong");
				return "login";
			}
			else {
				httpSession.setAttribute("FundManager", fundManager);
				List<Portfolio> portfolios = portfolioService.getAllPortfoliosOfManager(fundManager.getManagerid());
				model.addAttribute("portfolios",portfolios);
				return "managerPage";
			}
		}
		
	}
}
