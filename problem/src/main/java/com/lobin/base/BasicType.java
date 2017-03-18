package com.lobin.base;

public class BasicType {
//byte->short->char->int->long->float->double
	//boolean
	private String id="base";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static String des="static des";
	public void finalOper(final BasicType obj){
		obj.id="finalOper";
		System.out.println(obj.id.toString());
	}
	public void finalInt(final int num){
//		num=4;
	}
}
