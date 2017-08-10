package com.citi.portfolio.util;

import javax.enterprise.inject.New;

import org.junit.Assert;
import org.junit.Test;

public class DoubleFormatTest {

	@Test
	public void testFormat(){
		Assert.assertEquals(new Double(0d),DoubleFormat.format(null));
		Assert.assertEquals(new Double(0d), DoubleFormat.format(0d));
		Assert.assertEquals(new Double(5.68),  DoubleFormat.format(5.6786347));
	}
}
