package com.lobin.advance.singleton;

/**
 * 单例设计模式 饿汉式
 * 
 * @author lobin
 *
 */
class HungerySingleton {
	// static field
	private static final HungerySingleton instance = new HungerySingleton();

	// private construct
	private HungerySingleton() {

	}

	// public method to get instance
	public static HungerySingleton getInstance() {
		return instance;
	}

	public void print(Object obj) {
		System.out.println(instance.toString() + ":" + obj);
	}
}

/**
 * 单例模式 懒汉式
 * 
 * @author lobin
 *
 */
class LazySingleton {
	// private construct
	private LazySingleton() {

	}

	private static LazySingleton instance = null;

	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}

	public void print(Object obj) {
		System.out.println(instance.toString() + ":" + obj);
	}
}

public class SimpleSingleton {
	public static void main(String... strings) {
		for (int i = 0; i < 3; i++) {
			HungerySingleton.getInstance().print(i);
			LazySingleton.getInstance().print(i);

		}
	}
}
