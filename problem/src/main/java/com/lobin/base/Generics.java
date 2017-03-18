package com.lobin.base;

public class Generics {
public static <T> void print(T t){
int a=0;
if(t instanceof Integer)
	System.out.println(a);
}
}
