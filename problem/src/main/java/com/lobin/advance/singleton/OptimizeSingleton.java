package com.lobin.advance.singleton;

class Singleton {
	private Singleton() {

	}

	public static class SingletonFactory {
		public static Singleton instance = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonFactory.instance;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return getInstance();
	}
}

public class OptimizeSingleton {
	public static void main(String... strings) {
		for (int i = 0; i < 3; i++) {
			System.out.println(Singleton.getInstance());
		}
	}
}
