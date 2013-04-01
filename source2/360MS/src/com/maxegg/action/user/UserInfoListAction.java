package com.maxegg.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.maxegg.service.DealInput;

public class UserInfoListAction extends Action {

	@Override 
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DealInput input = new DealInput("updateUser");
		String userID = request.getParameter("userID");   // 会员唯一标示
		// 需要更新的内容----------------------------------
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		String en_name = request.getParameter("userEnName");
		// 需要更新的内容----------------------------------
		input.addBody("", userID);
		
		
		
		return mapping.findForward("error");
	}
}
