package com.maxegg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.maxegg.service.BaseService;
import com.maxegg.service.DealInput;
import com.maxegg.service.DealResult;

// 用struts1.2 处理类
public class LoginAction extends Action {
	
	@Override 
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String lan = request.getParameter("language");
		
		System.out.println("language = " + lan);
		
		BaseService bs = new BaseService();
		DealInput input = new DealInput("LONGIN");
		
		HttpSession session = request.getSession();
		
		// 也可以通过beanForm来传递值
		input.addBody("NAME", request.getParameter("usernumber"));
		input.addBody("PWD", request.getParameter("passwd"));
		
		// 处理   以后所有的实现都要调用
		DealResult ret = bs.doService(input);
		
		// 登陆成功
		if(ret.getErrorCode().equals("")){
			request.setAttribute("name", ret.getRet("NUMBER"));
			request.setAttribute("age", ret.getRet("NAME"));
			request.setAttribute("gender", ret.getRet("PWD"));
			
			session.setAttribute("userStaus", "active");
			
			return mapping.findForward("success");
		}
		
		return mapping.findForward("error");
	}

}
