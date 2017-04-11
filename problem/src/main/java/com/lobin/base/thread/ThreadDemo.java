package com.lobin.base.thread;

public class ThreadDemo extends Thread{

	@Override
	public void run() {
		System.out.println("thread demo:"+super.getName());
	}

}
