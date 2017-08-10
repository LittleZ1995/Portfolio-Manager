package com.citi.portfolio.controller;

import java.util.ArrayList;
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
		List<String> portfolionames = new ArrayList<>();
		String names = "a";
		String profits = "";
		if(account.equals("admin") && password.equals("admin"))
		{
//			List<FundManager> fundManagers = fundManagerService.getAllManagers();     
//			model.addAttribute("fundManagers",fundManagers);	
			
			
			
			return "redirect:/admin/mainpage";	
		}
				
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
				portfolioService.formatProfit(portfolios);
//				for(int i = 0; i < portfolios.size()-1 ; i++){		
//					portfolionames.add(portfolios.get(i).getName());
//					names += (portfolios.get(i).getName() + ",");
//					profits += (portfolios.get(i).getProfit() + ",");
//				}
//				names += portfolios.get(portfolios.size()-1).getName();
//				profits += (portfolios.get(portfolios.size()-1).getProfit());
				
				model.addAttribute("portfolios",portfolios);
//				model.addAttribute("names",names);
//				model.addAttribute("profits",profits);
//				model.addAttribute("portfolionames",portfolionames);
				return "portfolioListOfManager";
			}
		}
		
	}
	
	@RequestMapping("/logout")
	public String loginout(HttpServletRequest request, Model model, HttpSession httpSession){
		
		httpSession.invalidate();
		return "login";
	
	}
}
