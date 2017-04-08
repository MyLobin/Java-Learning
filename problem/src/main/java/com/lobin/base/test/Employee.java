package com.lobin.base.test;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4432381568197631102L;
	public String name;
	   public String address;
	   public transient int SSN;
	   public int number;
	   public void mailCheck()
	   {
	      System.out.println("Mailing a check to " + name
	                           + " " + address);
	   }
}
