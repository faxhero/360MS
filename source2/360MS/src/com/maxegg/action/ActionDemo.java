package com.maxegg.action;

import com.maxegg.dao.BaseDao;
import com.maxegg.service.BaseService;
import com.maxegg.service.DealInput;
import com.maxegg.service.DealResult;

// 模拟实现的界面：用struts1.x
public class ActionDemo {

	public static void main(String[] args) {
		demo2();
	}
	
	// 更新用户信息
	public static void demo3() {
		BaseService bs = new BaseService();
		DealInput input = new DealInput("UPDATE_USER");
		
		input.addBody("NAME", "weixin");
		input.addBody("PWD", "111111");
		
		// 处理   以后所有的实现都要调用
		DealResult ret = bs.doService(input);
		if(ret.getErrorCode().equals("")){
			System.out.println("Update is Success!");
		}else{
			System.out.println("Update is fail,please update again!");
		}
	}
	
	public static void demo2() {
		BaseService bs = new BaseService();
		DealInput input = new DealInput("LONGIN");
		
		input.addBody("NAME", "tony");
		input.addBody("PWD", "1234");
		
		// 处理   以后所有的实现都要调用
		DealResult ret = bs.doService(input);
		
		if(ret.getErrorCode().equals("")){
			System.out.println("登陆成功！");
			System.out.println("会员信息：");
			System.out.println("\t姓名："+ret.getRet("NAME").getStringColumn());
			System.out.println("\t年龄："+ret.getRet("AGE").getIntegerColumn());
			System.out.println("\t性别："+ret.getRet("GR").getStringColumn());
			System.out.println("\t地址："+ret.getRet("AS").getStringColumn());
			System.out.println("\t手机："+ret.getRet("TEL").getStringColumn());
			System.out.println("\t邮箱："+ret.getRet("EM").getStringColumn());
		}
		System.out.println(ret.getErrorCode());
	}
	
	public static void demo1() {
		// LONGIN就相当于一个标识 ，通过LONGIN来标识来实现底层
		BaseDao dao = BaseDao.getInteface("LONGIN");
		DealInput input = new DealInput("LONGIN");

		System.out.println(dao);
		
		input.addBody("NAME", "tony");
		input.addBody("PWD", "1234");
		
		// 处理   以后所有的实现都要调用BaseDao中的dealDao方法
		DealResult ret = dao.dealDao(input);
		
		if(ret.getErrorCode().equals("")){
			System.out.println("登陆成功！");
			System.out.println("会员信息：");
			System.out.println("\t姓名："+ret.getRet("NAME").getStringColumn());
			System.out.println("\t年龄："+ret.getRet("AGE").getStringColumn());
			System.out.println("\t性别："+ret.getRet("GR").getStringColumn());
			System.out.println("\t地址："+ret.getRet("AS").getStringColumn());
			System.out.println("\t手机："+ret.getRet("TEL").getStringColumn());
			System.out.println("\t邮箱："+ret.getRet("EM").getStringColumn());
		}
		System.out.println(ret.getErrorDesc());
	}
}
