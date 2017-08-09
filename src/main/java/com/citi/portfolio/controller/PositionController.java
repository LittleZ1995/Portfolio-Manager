package com.citi.portfolio.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
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
import com.citi.portfolio.util.JSONUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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
//		Position position = positionService.getPositionByPositionId(positionid);
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
	
	@RequestMapping(value = "/salePosition" , method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String salePosition(@RequestBody String json)throws IOException{
		JSONObject jsonObject= JSONUtil.toJsonObject(json);
		
        int posId = Integer.parseInt(jsonObject.getString("posId"));
        int sale = Integer.parseInt(jsonObject.getString("sale"));
        
        Position position = positionService.getPositionByPositionId(posId);
        int orgQuantity = position.getQuantity();
        int currentQuantity = orgQuantity - sale;
        
        double profit = 0;
        BigDecimal profitDecimal = position.getCurrentprice().subtract(position.getInitialprice());
        profit = profitDecimal.multiply(new BigDecimal(currentQuantity)).doubleValue();
        
        position.setQuantity(currentQuantity);
        position.setProfit(profit);
        
        int res = positionService.updatePosition(position);
        
        int securityId = position.getSecurityid();
        Security security = securityService.getSecurityTypeById(securityId);
        String securityType = security.getSecuritytype();
        
        Map<String,Object> map=new HashMap();
        String message="";
        if(res>=1)message="success";
        else message="failed";

        map.put("message",message);
        map.put("currentQuantity", currentQuantity);
        map.put("securityType", securityType);
        map.put("profit", profit);
        return JSONUtil.toJsonString(map);

    }


}