package com.lobin.base.thread;

public class TestThread {
	public static void main(String args[]){
		RunnableDemo r1=new RunnableDemo("thread-1");
		r1.start();
		
		RunnableDemo r2=new RunnableDemo("thread-2");
		r2.start();
		
		Thread t1=new ThreadDemo();
		t1.start();
		
		Thread t2=new ThreadDemo();
		t2.start();
	}

}
