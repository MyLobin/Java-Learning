package com.lobin.advance.proxy;

interface Network {
	void browse();
}

class Real implements Network {
	public void browse() {
		System.out.println("browser...");
	}
}

class Proxy implements Network {
	private Network network;

	public Proxy(Network network) {
		this.network = network;
	}

	public void browse() {
		System.out.println("check...");
		network.browse();
	}
}

public class ProxyMethod {
	public static void main(String... strings) {
		Network net = new Proxy(new Real());
		net.browse();
	}
}
