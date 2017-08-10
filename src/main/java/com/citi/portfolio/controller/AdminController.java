package com.citi.portfolio.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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
import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Portfolio;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.Security;
import com.citi.portfolio.entity.dao.BondMapper;
import com.citi.portfolio.entity.dao.EquityMapper;
import com.citi.portfolio.entity.dao.FutureMapper;
import com.citi.portfolio.service.AdminService;
import com.citi.portfolio.service.BondService;
import com.citi.portfolio.service.EquityService;
import com.citi.portfolio.service.FundManagerService;
import com.citi.portfolio.service.FutureService;
import com.citi.portfolio.service.PortfolioService;
import com.citi.portfolio.service.PriceService;
import com.citi.portfolio.util.JSONUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Resource
	private FundManagerService fundManagerService;
	
	@Resource 
	private AdminService adminService;
	
	@Resource
	private PortfolioService portfolioService;
	
	@Resource
	private BondService bondService;
	
	@Resource
	private PriceService priceService;
	
	@Resource
	private EquityService equityService;
	
	@Resource
	private FutureService futureService;
	
	@Resource
	private BondMapper bondMapper;
	
	@Resource 
	private EquityMapper equityMapper;
	
	@Resource
	private FutureMapper futureMapper;

	@RequestMapping("/showManagers")
	public String showUser(HttpServletRequest request, Model model) {
		List<FundManager> fundManagers = fundManagerService.getAllManagers();
		fundManagerService.formatProfit(fundManagers);
		model.addAttribute("fundManagers", fundManagers);
		return "fundManagerList";
	}

	@RequestMapping("/mainpage")
	public String mainPage(HttpServletRequest request, Model model) {
		List<FundManager> fundManagers = fundManagerService.getAllManagers();
		fundManagerService.formatProfit(fundManagers);
		model.addAttribute("fundManagers", fundManagers);
		return "fundManagerList";
	}

	@RequestMapping("/addManager")
	public String addManager(HttpServletRequest request, Model model) {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");

		FundManager fundManager = new FundManager(firstname, lastname, email, phonenumber, password);
		int result = fundManagerService.addManager(fundManager);
		if (result != 0)
			System.out.println("add successfully");

		List<FundManager> fundManagers = fundManagerService.getAllManagers();
		fundManagerService.formatProfit(fundManagers);
		model.addAttribute("fundManagers", fundManagers);
		return "fundManagerList";
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

	@RequestMapping(value = "/updatePrices", produces = "application/json; charset=utf-8")
	public String updatePrices(HttpServletRequest request,Model model){
		Map<String,Object> map=new HashMap();
		System.out.println("in updatecontroller");
		logger.info("Start to Update Price");
		
		adminService.updatePrices();
		
		logger.info("End to Update Price");
		logger.info("The largest PriceID :" + adminService.getLargestPriceID());
		
		List<Bond> bonds =  bondService.getAllBonds();
		Map bondsresults = new HashMap<>();		
		for(int i = 0 ; i < bonds.size() ; i++) {	
			Price price = priceService.getPriceById(bonds.get(i).getPriceid());
			bondsresults.put(bonds.get(i), price);			
		}
		List<Equity> equities = equityService.getAllEquities();
		Map equityresults = new HashMap<>();
		for(int i = 0 ; i < equities.size() ; i++) {	
			Price price = priceService.getPriceById(equities.get(i).getPriceid());
			equityresults.put(equities.get(i), price);			
		}
		
		List<Future> futures = futureService.getAllFutures();
		Map futureresults = new HashMap<>();
		for(int i = 0 ; i < futures.size() ; i++) {	
			Price price = priceService.getPriceById(futures.get(i).getPriceid());
			futureresults.put(futures.get(i), price);			
		}
		
		model.addAttribute("bondsresults",bondsresults);
		model.addAttribute("equityresults",equityresults);	
		model.addAttribute("futureresults",futureresults);
		model.addAttribute("message", "Success to update prices");
        return "securitiesList";
	}
	
	@RequestMapping("viewSecurities")
	public String viewSerurities(HttpServletRequest request, Model model){
		
		List<Bond> bonds =  bondService.getAllBonds();
		Map bondsresults = new HashMap<>();		
		for(int i = 0 ; i < bonds.size() ; i++) {	
			Price price = priceService.getPriceById(bonds.get(i).getPriceid());
			bondsresults.put(bonds.get(i), price);			
		}
		List<Equity> equities = equityService.getAllEquities();
		Map equityresults = new HashMap<>();
		for(int i = 0 ; i < equities.size() ; i++) {	
			Price price = priceService.getPriceById(equities.get(i).getPriceid());
			equityresults.put(equities.get(i), price);			
		}
		
		List<Future> futures = futureService.getAllFutures();
		Map futureresults = new HashMap<>();
		for(int i = 0 ; i < futures.size() ; i++) {	
			Price price = priceService.getPriceById(futures.get(i).getPriceid());
			futureresults.put(futures.get(i), price);			
		}
		
		model.addAttribute("bondsresults",bondsresults);
		model.addAttribute("equityresults",equityresults);	
		model.addAttribute("futureresults",futureresults);
		
		return "securitiesList";
	}
	
	@RequestMapping("/viewportfoliosofmanager")
	public String viewportfoliosofmanager(HttpServletRequest request, Model model) {

		int managerid = Integer.parseInt(request.getParameter("managerid"));
		List<Portfolio> portfolios = portfolioService.getAllPortfoliosOfManager(managerid);
		portfolioService.formatProfit(portfolios);
		model.addAttribute("portfolios",portfolios);
		
		return "portfolioListOfManagerByadmin";
	}

}
