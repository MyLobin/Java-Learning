package com.lobin.base.mail;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class Receive {
public static void main(String...strings) throws Exception{
	String host="imap-mail.outlook.com";
	String port="993";
	Properties props=new Properties();
	props.setProperty("mail.store.protocol", "imap"); 
    props.setProperty("mail.imap.host", host); 
    props.setProperty("mail.imap.port",port); 
    props.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
    props.setProperty("mail.imap.socketFactory.port","993");  
    
    Session session=Session.getInstance(props);
    Store store=session.getStore("imap");
    store.connect("lobin.tong@hotmail.com", "*****");
    Folder folder=store.getFolder("INBOX");
    folder.open(Folder.READ_WRITE);
    Message[] messages=folder.getMessages();
    print("count:"+messages.length+" unreader:"+folder.getUnreadMessageCount());
    
    Folder folders=store.getDefaultFolder();
    Folder[] folderArray=folders.list();
    for(Folder f:folderArray){
    	print(f.getFullName());
    }
}
public static void print(Object obj){
	System.out.println(obj);
}
}
