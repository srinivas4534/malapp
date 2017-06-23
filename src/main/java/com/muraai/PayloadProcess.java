package com.muraai;

import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;


public class PayloadProcess  {
	public void process(MimeMessage message) throws Exception{
		Folder folder = message.getFolder();
		folder.open(Folder.READ_WRITE);
		String messageId = message.getMessageID();
		System.out.println("messageId ============ "+messageId);
		Message[] messages = folder.getMessages();
		FetchProfile contentsProfile = new FetchProfile();
		contentsProfile.add(FetchProfile.Item.ENVELOPE);
		contentsProfile.add(FetchProfile.Item.CONTENT_INFO);
		contentsProfile.add(FetchProfile.Item.FLAGS);
		folder.fetch(messages, contentsProfile);
		// find this message and mark for deletion
		for (int i = 0; i < messages.length; i++) {
			if (((MimeMessage) messages[i]).getMessageID().equals(messageId)) {
				messages[i].setFlag(Flags.Flag.DELETED, true);
				break;
			}
		}

		
		folder.close(true);
		
	}


}
