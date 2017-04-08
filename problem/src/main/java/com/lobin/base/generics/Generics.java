package com.lobin.base.generics;

public class Generics {
	public static <T extends Comparable<T>> void print(T t) {
		int a = 0;
		System.out.println("class:"+t.getClass()+" value:"+t);
	}
	public static void main(String...strings){
		Integer[] intArray={1,2,3};
		String[] strArray={"asdf","asdf"};
		String str="test";
//		print(intArray);
//		print(strArray);
		print(str);
	}
	
}
