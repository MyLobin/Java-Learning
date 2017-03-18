package com.lobin.base;

import org.junit.Test;

public class BasicTypeTest {
BasicType basicType=new BasicType();
@Test
public void finalOperTest(){
	System.out.println(basicType.getId().toString());
	basicType.finalOper(basicType);
	System.out.println(basicType.des);
	System.out.println(BasicType.des);
}
}
