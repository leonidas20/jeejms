package com.bharath.javaee.jms.mdbs;

import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMdb implements MessageListener {

	private static Logger LOGGER = Logger.getLogger(MyMdb.class.toString());

	public void onMessage(Message message) {

		if (message instanceof TextMessage) {
			try {
				String text = ((TextMessage) message).getText();
				LOGGER.info("Received Message is: " + text);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
