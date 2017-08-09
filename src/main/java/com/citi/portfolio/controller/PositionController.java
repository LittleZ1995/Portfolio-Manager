package com.citi.portfolio.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Position;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.Security;
import com.citi.portfolio.service.BondService;
import com.citi.portfolio.service.EquityService;
import com.citi.portfolio.service.FutureService;
import com.citi.portfolio.service.PositionService;
import com.citi.portfolio.service.SecurityService;

@Controller
public class PositionController {
	
	@Resource
	private PositionService positionService;
	
	@Resource
	private SecurityService securityService;
	
	@Resource
	private BondService bondService;
	
	@Resource
	private EquityService equityService;
	
	@Resource
	private FutureService futureService;
	
	@RequestMapping("/viewSecurity")
	public String viewSecurity(HttpServletRequest request, Model model,HttpSession httpSession) {
		
		int positionid = Integer.parseInt(request.getParameter("positionid"));
		Position position = positionService.getPositionByPositionId(positionid);
		Security security=securityService.getSecurityTypeById(positionid);
		int securityid = security.getSecurityid();
		String type = security.getSecuritytype();
		if(type.equals("bond"))
		{
			Bond bond = bondService.getBondBySecurityId(securityid);
			int bondid=bond.getBondid();
			List<Price> prices = bondService.findAllHistoryPrices(bondid);
			model.addAttribute("prices", prices);
			model.addAttribute("bond",bond);
		}
		else if(type.equals("equity"))
		{
			Equity equity = equityService.getEquityBySecurityId(securityid);
			int equityid = equity.getEquityid();
			List<Price> prices = equityService.findAllHistoryPrices(equityid);
			model.addAttribute("prices", prices);
			model.addAttribute("equity",equity);
		}
		else if(type.equals("future"))
		{
			Future future = futureService.getFutureBySecurityId(securityid);
			int futureid = future.getFutureid();
			List<Price> prices = futureService.findAllHistoryPrices(futureid);
			model.addAttribute("prices", prices);
			model.addAttribute("future",future);
		}
		
		return "securityDetail";
		
	}

}
