package com.citi.portfolio.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Portfolio;
import com.citi.portfolio.entity.Position;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.Profit;
import com.citi.portfolio.entity.Security;
import com.citi.portfolio.service.BondService;
import com.citi.portfolio.service.EquityService;
import com.citi.portfolio.service.FutureService;
import com.citi.portfolio.service.PortfolioService;
import com.citi.portfolio.service.PositionService;
import com.citi.portfolio.service.PriceService;
import com.citi.portfolio.service.SecurityService;

@Controller
public class PortfolioController {

	@Resource
	private PortfolioService portfolioService;
	
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
	
	@Resource
	private PriceService priceService;
	
	@RequestMapping("/viewOnePortfolio")
    public String viewPortfolio(HttpServletRequest request, Model model,HttpSession httpSession){
	
		int portfolioid = Integer.parseInt(request.getParameter("portfolioid"));	
		Portfolio portfolio = portfolioService.getPortfolioByPortfolioId(portfolioid);
		List<Position> positions = positionService.getAllPositionsOfPortfolio(portfolioid);
		List<String> types = new ArrayList<>();
		List<String> symbols = new ArrayList<>();
		Map bondresults = new HashMap<>();
		Map equityresults = new HashMap<>();
		Map futureresults = new HashMap<>();
		double bondvalue = 0;
		double equityvalue = 0;
		double futurevalue = 0;
	
		for(int i = 0 ; i < positions.size() ; i++) {
			 
			int securityid = positions.get(i).getSecurityid();
			Security security = securityService.getSecurityTypeById(securityid);
			String type = security.getSecuritytype();
			types.add(type);
			if(type.equals("bond"))
			{
				symbols.add(bondService.getBondBySecurityId(securityid).getIsin()+"(bond)");
				bondresults.put(positions.get(i), bondService.getBondBySecurityId(securityid));
				
				String quantity = String.valueOf(positions.get(i).getQuantity());
				bondvalue += positions.get(i).getCurrentprice().multiply(new BigDecimal(quantity)).doubleValue();
				
			}
			else if(type.equals("equity"))
			{
				symbols.add(equityService.getEquityBySecurityId(securityid).getSymbol()+"(equity)");
				equityresults.put(positions.get(i), equityService.getEquityBySecurityId(securityid));
				
				String quantity = String.valueOf(positions.get(i).getQuantity());
				equityvalue += positions.get(i).getCurrentprice().multiply(new BigDecimal(quantity)).doubleValue();
			}
			else if(type.equals("future")){
				symbols.add(futureService.getFutureBySecurityId(securityid).getSymbol()+"(future)");
				futureresults.put(positions.get(i),futureService.getFutureBySecurityId(securityid));
				
				String quantity = String.valueOf(positions.get(i).getQuantity());
				futurevalue += positions.get(i).getCurrentprice().multiply(new BigDecimal(quantity)).doubleValue();
			}
		}	
		
		Map results = new HashMap<>();
		for(int i = 0; i < positions.size() ; i++){		
			results.put(positions.get(i), symbols.get(i));
		}
		
		List<Profit> historyProfits = portfolioService.getAllHistoryProfit(portfolioid);
		if(historyProfits != null){
			model.addAttribute("profits", historyProfits);
		} else {
			model.addAttribute("profits", new ArrayList<Profit>());
		}
		model.addAttribute("portfolio",portfolio);
		model.addAttribute("results",results);
		model.addAttribute("positions",positions);
		model.addAttribute("bondresults",bondresults);
		model.addAttribute("equityresults",equityresults);
		model.addAttribute("futureresults",futureresults);
		model.addAttribute("bondvalue",bondvalue);
		model.addAttribute("equityvalue",equityvalue);
		model.addAttribute("futurevalue",futurevalue);

		
		return "portfolioOfManager";
	}
	
	@RequestMapping("/addPortfolio")
    public String addPortfolio(HttpServletRequest request, Model model,HttpSession httpSession){
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
        return "portfolioListOfManager";
	}
	
	@RequestMapping("/showpositions")
	public String showposition(HttpServletRequest request, Model model,HttpSession httpSession){
		
		FundManager fundManager = (FundManager) httpSession.getAttribute("FundManager");
		List<Portfolio> portfolios = portfolioService.getAllPortfoliosOfManager(fundManager.getManagerid());
		
		int portfolioid = Integer.parseInt(request.getParameter("portfolioid"));

		Portfolio portfolio = portfolioService.getPortfolioByPortfolioId(portfolioid);	
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
		model.addAttribute("portfolios",portfolios);
		model.addAttribute("portfolio",portfolio);
		model.addAttribute("bondsresults",bondsresults);
		model.addAttribute("equityresults",equityresults);	
		model.addAttribute("futureresults",futureresults);
		
		return "securitiesListManager"; 

	}
	
	@RequestMapping("/addposition")
	public String addposition(HttpServletRequest request, Model model,HttpSession httpSession){
		
		int portfolioid = Integer.parseInt(request.getParameter("selectedid"));
		Portfolio portfolio = portfolioService.getPortfolioByPortfolioId(portfolioid);
		int securityid = Integer.parseInt(request.getParameter("securityid"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double profit = 0;
		Security security = securityService.getSecurityTypeById(securityid);
		String type = security.getSecuritytype();
		
		List<String> types = new ArrayList<>();
		List<String> symbols = new ArrayList<>();
		Map bondresults = new HashMap<>();
		Map equityresults = new HashMap<>();
		Map futureresults = new HashMap<>();
		double bondvalue = 0;
		double equityvalue = 0;
		double futurevalue = 0;
		
		if(type.equals("bond"))
		{
			Bond bond = bondService.getBondBySecurityId(securityid);
			Price price = priceService.getPriceById(bond.getPriceid());
			BigDecimal profitdecimal = price.getOfferprice().subtract(price.getBidprice());
			profit = profitdecimal.multiply(new BigDecimal(quantity)).doubleValue();
			Position position = new Position(portfolioid, quantity, price.getBidprice(), price.getOfferprice(), securityid, profit);
			positionService.addPosition(position);
		}
		else if(type.equals("equity"))
		{
			Equity equity = equityService.getEquityBySecurityId(securityid);
			Price price = priceService.getPriceById(equity.getPriceid());
			BigDecimal profitdecimal = price.getOfferprice().subtract(price.getBidprice());
			profit = profitdecimal.multiply(new BigDecimal(quantity)).doubleValue();
			Position position = new Position(portfolioid, quantity, price.getBidprice(), price.getOfferprice(), securityid, profit);
			positionService.addPosition(position);
		}
		else if(type.equals("future")){
			Future future = futureService.getFutureBySecurityId(securityid);
			Price price = priceService.getPriceById(future.getPriceid());
			BigDecimal profitdecimal = price.getOfferprice().subtract(price.getBidprice());
			profit = profitdecimal.multiply(new BigDecimal(quantity)).doubleValue();
			Position position = new Position(portfolioid, quantity, price.getBidprice(), price.getOfferprice(), securityid, profit);
			positionService.addPosition(position);
		}
		
		List<Position> positions = positionService.getAllPositionsOfPortfolio(portfolioid);
		for(int i = 0 ; i < positions.size() ; i++) {
			 
			int securityid1 = positions.get(i).getSecurityid();
			Security security1 = securityService.getSecurityTypeById(securityid1);
			String type1 = security1.getSecuritytype();
			types.add(type1);
			if(type1.equals("bond"))
			{
				symbols.add(bondService.getBondBySecurityId(securityid1).getIsin()+"(bond)");
				bondresults.put(positions.get(i), bondService.getBondBySecurityId(securityid1));
				
				String quantity1 = String.valueOf(positions.get(i).getQuantity());
				bondvalue += positions.get(i).getCurrentprice().multiply(new BigDecimal(quantity1)).doubleValue();
				
			}
			else if(type1.equals("equity"))
			{
				symbols.add(equityService.getEquityBySecurityId(securityid1).getSymbol()+"(equity)");
				equityresults.put(positions.get(i), equityService.getEquityBySecurityId(securityid1));
				
				String quantity1 = String.valueOf(positions.get(i).getQuantity());
				equityvalue += positions.get(i).getCurrentprice().multiply(new BigDecimal(quantity1)).doubleValue();
			}
			else if(type1.equals("future")){
				symbols.add(futureService.getFutureBySecurityId(securityid1).getSymbol()+"(future)");
				futureresults.put(positions.get(i),futureService.getFutureBySecurityId(securityid1));
				
				String quantity1 = String.valueOf(positions.get(i).getQuantity());
				futurevalue += positions.get(i).getCurrentprice().multiply(new BigDecimal(quantity1)).doubleValue();
			}
		}	
		
		Map results = new HashMap<>();
		for(int i = 0; i < positions.size() ; i++){		
			results.put(positions.get(i), symbols.get(i));
		}
		model.addAttribute("portfolio",portfolio);
		model.addAttribute("results",results);
		model.addAttribute("positions",positions);
		model.addAttribute("bondresults",bondresults);
		model.addAttribute("equityresults",equityresults);
		model.addAttribute("futureresults",futureresults);
		model.addAttribute("bondvalue",bondvalue);
		model.addAttribute("equityvalue",equityvalue);
		model.addAttribute("futurevalue",futurevalue);
		
		return "portfolioOfManager";
		
	}
	
	
}
