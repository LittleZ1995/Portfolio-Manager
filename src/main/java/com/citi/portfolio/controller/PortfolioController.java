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
import com.citi.portfolio.service.PortfolioService;

@Controller
public class PortfolioController {

	@Resource
	private PortfolioService portfolioService;
	
	@RequestMapping("/addPortfolio")
    public String addManager(HttpServletRequest request, Model model,HttpSession httpSession){
		System.out.println("in add portfolio");
		String name = request.getParameter("name");
		System.out.println(name);
		
		FundManager fundManager = (FundManager) httpSession.getAttribute("FundManager");
		
		int managerid = fundManager.getManagerid();
		System.out.println(managerid);
		Portfolio portfolio = new Portfolio(name, managerid);
		int result = portfolioService.addPortfolio(portfolio);
		if(result != 0)
			System.out.println("add successfully");
		List<Portfolio> portfolios = portfolioService.getAllPortfoliosOfManager(managerid);	
		model.addAttribute("portfolios",portfolios);
        return "managerPage";
	}
	
}
