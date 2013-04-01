package com.maxegg.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionMessage {

	private static Map<Integer, String> errorMap = new HashMap<Integer, String>();

	static {
		errorMap.put(1000, "用户不存在");
		errorMap.put(1001, "用户信息不全");
		
		errorMap.put(3000, "数据错误");
	}

	public static String getErrorDesc(int errorCode){
		return errorMap.get(errorCode);
	}

}
