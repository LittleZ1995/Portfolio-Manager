package com.citi.portfolio.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

public class DoubleFormat {

	public static Double format(Double value){
		
		if(value == null)
			return new Double(0d);
		
		BigDecimal decimal = new BigDecimal(value);
		
		return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
	}
}
