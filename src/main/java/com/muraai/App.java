package com.muraai;

import java.io.IOException;

import org.springframework.transaction.PlatformTransactionManager;

import javax.mail.Folder;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mail.AbstractMailReceiver;
import org.springframework.integration.mail.ImapMailReceiver;
import org.springframework.integration.mail.MailReceiver;
import org.springframework.integration.mail.Pop3MailReceiver;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.util.SystemPropertyUtils;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/mailConfig.xml");
		//Mailman mailman = (Mailman)factory.getBean("mailman");
		//MessageChannel receiveEmailChannel = (MessageChannel)factory.getBean("receiveEmailChannel");
		//receiveEmailChannel.send((Message<String>)MessageBuilder.withPayload("test").build());
//		while(true){
//			
//		}
		
        DirectChannel inputChannel = context.getBean("receiveEmailChannel", DirectChannel.class);
        //System.out.println(inputChannel);
        
        inputChannel.subscribe(new MessageHandler() {
            
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
            	
            	System.out.println(message);
            	
//            	MessageHeaders headers = message.getHeaders();
//            	System.out.println("FROM "+headers.get("mail_from"));
//                System.out.println("Message: " + message.getPayload().getClass());
//                System.out.println("Payload class "+message.getPayload().getClass());
                //message.getPayload();
                
//               
//                try {
//                	javax.mail.Message[] messages = (javax.mail.Message[])payload.receive();
//					for(javax.mail.Message m : messages) {
//						System.out.println(m.getContent());
//					}
//					
//				} catch (javax.mail.MessagingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
                	
					
				
           
                System.out.println("---------------------------------------------------------------------------------------");
                //logger.info("Message: " + message);
            }
        });

	}

}