package com.lobin.advance.prototype;

import java.io.IOException;

public class TestClone {
	public static void main(String... strings) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Prototype proto=new Prototype();
		proto.setString("proto");
		proto.setObj(new SerializableObject());
		print("proto:"+proto.getString());
		print("proto:"+proto.getObj());
		
		print("-------------------------------------------------------");
		Prototype clone=(Prototype)proto.clone();
		print(clone.getString());
		print(clone.getObj());
		print("proto:"+proto.getString());
		print("proto:"+proto.getObj());
		
		print("-------------------------------------------------------");
		Prototype deepClone=(Prototype)proto.deepClone();
		print(deepClone.getString());
		print(deepClone.getObj());
		print("proto:"+proto.getString());
		print("proto:"+proto.getObj());
	}
	public static void print(Object obj){
		System.out.println(obj);
	}
}
