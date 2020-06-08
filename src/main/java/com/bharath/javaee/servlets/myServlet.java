package com.bharath.javaee.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bharath.javaee.jms.MyMessageProducer;



@WebServlet(urlPatterns = "/")
public class myServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	MyMessageProducer producer;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "Hello Message from JavaEE Server using JMS!";
		producer.sendMessage(message);
		resp.getWriter().write("Published the message" + message);
	}
}
