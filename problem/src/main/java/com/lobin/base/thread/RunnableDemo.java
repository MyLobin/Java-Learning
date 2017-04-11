package com.lobin.base.thread;

public class RunnableDemo implements Runnable{
	private Thread t;
	private String threadName;
	RunnableDemo(String name){
		threadName=name;
		print("thread name:"+threadName);
	}
	void print(Object obj){
		System.out.println(obj);
	}
	public void run(){
		print("running");
		try {
			for(int i=4;i>0;i--){
				print(threadName+":"+i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			print("InterruptedException");
			e.printStackTrace();
		}
		print("exit");
	}
	public void start(){
		print(threadName+":start");
		if(t==null){
			print("thread is null");
			t=new Thread(this,threadName);
			t.start();
		}
	}
}
