package com.lobin.base.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<Integer>{

	public static void main(String...strings){
		CallableDemo cd=new CallableDemo();
		FutureTask<Integer>ft=new FutureTask<Integer>(cd);
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			if(i==2){
				new Thread(ft,"return thread").start();
			}
		}
		try {
			System.out.println("ft return:"+ft.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Integer call() throws Exception {
		int i=0;
		for(i=0;i<10;i++){
			System.out.println("call:"+i);
		}
		return i;
	}

}
