package com.lobin.advance.factory;

interface Provider {
	Printer produce();
}

class BulePrinterFactory implements Provider {

	@Override
	public Printer produce() {
		return new BluePrinter();
	}

}

class RedPrinterFactory implements Provider {

	@Override
	public Printer produce() {
		return new RedPrinter();
	}

}

public class AbstractFactory {
	public static void main(String... strings) {
		Provider provider = new BulePrinterFactory();
		provider.produce().printName();
		provider = new RedPrinterFactory();
		provider.produce().printName();
	}
}
