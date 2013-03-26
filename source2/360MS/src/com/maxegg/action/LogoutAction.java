package com.maxegg.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LogoutAction extends Action {
	
	@Override 
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		Enumeration ent = session.getAttributeNames(); 
		while(ent.hasMoreElements()){ 
			String sessionName = (String)ent.nextElement(); 
			session.removeAttribute(sessionName); 
		}
		return mapping.findForward("logout"); 
	}
	
}
