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


public class LoginAction extends Action {
	
	@Override 
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String lan = request.getParameter("language");	
		if(lan == null) lan = "CN";
		BaseService bs = new BaseService();
		DealInput input = new DealInput("LONGIN");
		
		HttpSession session = request.getSession();
		
		// 也可以通过beanForm来传递值
		input.addBody("NUMBER", request.getParameter("usernumber"));
		input.addBody("PWD", request.getParameter("passwd"));
		
		// 处理   以后所有的实现都要调用
		DealResult ret = bs.doService(input);
		
		// 登陆成功,页面去保存信息
		if(ret.getErrorCode()==0){
			session.setAttribute("number", ret.getRet("NUMBER"));  // 员工工号
			session.setAttribute("name", ret.getRet("NAME"));	   // 员工姓名	
			session.setAttribute("language", lan);       // 语言设置
			session.setAttribute("userStaus", "active"); // 登陆标记	
			return mapping.findForward("success");
		}	
		return mapping.findForward("error");
	}
}
