package com.muraai;

import java.io.IOException;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class Mailman {
	
	public void mailProcess(MimeMessage message) throws MessagingException, IOException {
		System.out.println("hello "+message);
		System.out.println("in try");
		//MimeMessage content = (MimeMessage)message.getContent();
		System.out.println("in try2");
		Folder folder = message.getFolder();
		folder.open(Folder.READ_ONLY);
		Message[] messages = folder.getMessages();
		for(Message m : messages) {
			System.out.println(m);
			System.out.println("in for");
			System.out.println("content type");
			System.out.println("content type = "+m.getContentType());
			System.out.println("content  = "+m.getContent());
			System.out.println("after content type");
		}
		System.out.println("Content id = "+message.getContentID());
	}

}