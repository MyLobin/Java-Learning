package com.lobin.advance.factory;

class BluePrinter implements Printer {

	public void printName() {
		System.out.println(this.getClass());
	}

}

class RedPrinter implements Printer {

	public void printName() {
		System.out.println(this.getClass());
	}

}

class Factory {
	public Printer produce(String brand) {
		Printer printer = null;
		switch (brand) {
		case "blue":
			printer = new BluePrinter();
			break;
		case "red":
			printer = new RedPrinter();
			break;
		default:
		}
		return printer;
	}

	// static method is static factory
	public Printer produceBluePrinter() {
		return new BluePrinter();
	}

	public Printer produceRedPrinter() {
		return new RedPrinter();
	}
}

public class SimpleFactory {
	public static void main(String... strings) {
		Factory factory = new Factory();
		factory.produce("blue").printName();
		factory.produce("red").printName();
		factory.produceBluePrinter().printName();
		factory.produceRedPrinter().printName();
	}
}
