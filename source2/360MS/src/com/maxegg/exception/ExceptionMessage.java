package com.maxegg.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.maxegg.sql.ClassSql;

public class ExceptionMessage {

	private static Map<Integer, String> errorMap = new HashMap<Integer, String>();

	static {
		try {
			String sqlFile = ClassSql.class.getResource("exception.info")
					.toString().substring(6);
			File file = new File(sqlFile);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String stt = "";
			while ((stt = br.readLine()) != null) {
				if (stt.trim().equals("") || stt.startsWith("--"))
					continue;
				String str[] = stt.split(":");
				if (str.length != 2)
					continue;
				errorMap.put(Integer.parseInt(str[0].trim()), str[1].trim());
			}
		} catch (Exception e) {
			System.out.println("Exception file not found,System Error!");
		}
	}

	public static String getErrorDesc(int errorCode){
		return errorMap.get(errorCode);
	}

}
