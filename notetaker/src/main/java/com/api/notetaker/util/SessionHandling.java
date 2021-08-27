package com.api.notetaker.util;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import static com.api.notetaker.util.NoteTakerConstants.*;
@Service
@SessionScope
public class SessionHandling {
	
	
	private static  HttpSession session;
//	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public void setSession(String username, HttpSession session)
	{
		SessionHandling.session = session;
		SessionHandling.session.setAttribute(ID,username);
		SessionHandling.session.setMaxInactiveInterval(3600);
//		LOGGER.log(Level.INFO, "Session Created");
	}
	public String getSession()
	{
		try {
			if(null != SessionHandling.session && null != SessionHandling.session.getAttribute(ID))
				return SessionHandling.session.getAttribute(ID).toString();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
//		LOGGER.log(Level.WARNING, "Session Timeout");
		return SESSION_TIMEOUT;
			
	}
	
	public boolean logout()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		///HttpSession session = sra.getRequest().getSession();
		if(null != SessionHandling.session)
			SessionHandling.session.invalidate();
		return true;
	}
	
	public int getSessionUsername()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpSession session = sra.getRequest().getSession();
		if(null != SessionHandling.session && null != SessionHandling.session.getAttribute(ID))
			return Integer.parseInt(SessionHandling.session.getAttribute(ID).toString());
		else
			return -1;
	}
	
	public Object getAttribute(String attribute) {
		return SESSION_TIMEOUT.equals(getSession()) ? null : SessionHandling.session.getAttribute(attribute);
	}
	
	public void setAttribute(String attributekey, Object attributeValue) {
		if(SESSION_TIMEOUT.equals(getSession())) return;
	
		SessionHandling.session.setAttribute(attributekey, attributeValue);
		return;
	}
		
}








