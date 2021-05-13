package com.info.sky.quizbattle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.info.sky.quizbattle.entity.AdminEntity;



@Component
public class SessionRecord 
{
	@Autowired
	HttpSession session;
	
	public int id;
	public String loginStatus;
	public String adminName;
	public String adminUnq;
	
	public String adminPhone;
	public String adminEmail;
	
	public String adminToken;
	public boolean isdeveloper;

	

	public HttpSession getSession() {
		return session;
	}
	
	public int getId() {
		return (int)session.getAttribute("loginid");
	}

	public String getLoginStatus() {
		return (String)session.getAttribute("loginStatus");
	}
	
	public String getAdminName() {
		return (String)session.getAttribute("adminName");
	}
	
	public String getAdminUnq() {
		return (String)session.getAttribute("adminUnq");
	}


	public String getAdminPhone() {
		return (String)session.getAttribute("adminPhone");
	}

	public String getAdminEmail() {
		return (String)session.getAttribute("adminEmail");
	}

	public String getAdminToken() {
		return (String)session.getAttribute("adminToken");
	}

	public boolean isIsdeveloper() {
		return (boolean)session.getAttribute("isdeveloper");
	}
	
	
	
	public void setAllValue(AdminEntity entity)
	{
		session.setAttribute("loginid", entity.getId());
		session.setAttribute("loginStatus", "true");
		session.setAttribute("adminName", entity.getName());
		session.setAttribute("adminUnq", entity.getUqid());
		session.setAttribute("adminPhone", entity.getPhone());
		session.setAttribute("adminEmail", entity.getEmail());
		session.setAttribute("adminToken", entity.getToken());
		session.setAttribute("isdeveloper",entity.getIsdeveloper());
	}

	public void getActiveSessions() {
		Enumeration keys = session.getAttributeNames();
		while (keys.hasMoreElements())
		{
		  String key = (String)keys.nextElement();
		  System.out.println(key + " : " + session.getValue(key));
		}
    }
	
	public void removeAll() {
		session.setAttribute("loginid", null);
		session.setAttribute("loginStatus", "false");
		session.setAttribute("adminName",null);
		session.setAttribute("adminUnq", null);
		session.setAttribute("adminPhone", null);
		session.setAttribute("adminEmail", null);
		session.setAttribute("adminToken", null);
		session.setAttribute("isdeveloper",null);
		
		session.invalidate();
    }
	
	public boolean isLogin()
	{
		String val=(String)session.getAttribute("loginStatus");
		if(val!=null&&val.equalsIgnoreCase("true"))
			return true;
		else
			return false;
	}
	
	
}
