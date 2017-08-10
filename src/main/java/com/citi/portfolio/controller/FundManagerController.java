package com.citi.portfolio.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.entity.Portfolio;
import com.citi.portfolio.service.FundManagerService;
import com.citi.portfolio.service.PortfolioService;

@Controller
public class FundManagerController {
	
	public FundManagerController() {
		
	}

	@Resource
	private FundManagerService fundManagerService;
	
	@Resource
	private PortfolioService portfolioService;

	@RequestMapping("/viewPortfolios")
    public String showUser(HttpServletRequest request, Model model){
		List<Portfolio> portfolios = portfolioService.getAllPortfolios();
		model.addAttribute("portfolios",portfolios);
		return "portfolioListOfManager";
}
//	@RequestMapping("/showUser/{id}")
//	public String showUser(@PathVariable("id")Integer id, HttpServletRequest request,Model model) {
//		FundManager manager = fundManagerService.getManagerById(id);
//		model.addAttribute("manager", manager);
//		request.setAttribute("manager", manager);
//		return "showUser";
//	}
	
	

}
