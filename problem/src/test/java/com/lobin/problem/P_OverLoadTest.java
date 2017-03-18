package com.lobin.problem;

import org.junit.Test;

public class P_OverLoadTest {
	P_OverLoad addOper = new P_OverLoad();

	@Test
	public void testAdd() {
		int intNum = 1;
		Integer integerNum=1;
		short shortNum = 1;
		double doubleNum = 1;
		addOper.add(intNum+2);
		addOper.add(integerNum+2);
		addOper.add(shortNum+2);
		addOper.add(doubleNum+2);
	}
}
