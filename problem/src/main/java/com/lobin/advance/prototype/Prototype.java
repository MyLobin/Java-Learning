package com.lobin.advance.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerializableObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

public class Prototype implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String string;
	private SerializableObject obj;

	/**
	 * @return the string
	 */
	public String getString() {
		return string;
	}

	/**
	 * @param string
	 *            the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}

	/**
	 * @return the obj
	 */
	public SerializableObject getObj() {
		return obj;
	}

	/**
	 * @param obj
	 *            the obj to set
	 */
	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}

	public Object clone() throws CloneNotSupportedException {
		Prototype proto = (Prototype) super.clone();
		return proto;
	}

	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
}
