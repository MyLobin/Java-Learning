package com.lobin.base.generics;

import java.io.Serializable;

public class GenericsClass<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public static void print(GenericsClass<? extends Serializable> obj) {
		System.out.println(obj);
	}

	public static void main(String... strings) {
		GenericsClass<Integer> intBox = new GenericsClass<Integer>();
		intBox.setT(1);
		System.out.println(intBox.getT());
		print(intBox);
		
		GenericsClass<String> strBox=new GenericsClass<String>();
		strBox.setT("test");
		System.out.println(strBox.getT());
		print(strBox);
	}

}
