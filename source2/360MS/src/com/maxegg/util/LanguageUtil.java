package com.maxegg.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LanguageUtil {

	// 
	public static String getLanString(String lan,String key){
		String ret = "";
		String fileName = "LanguageResources_CN.properties";
		if(lan.toUpperCase().equals("EN")){
			fileName = "LanguageResources_EN.properties";
		}
		InputStream is = null;
		try{
			String path = LanguageUtil.class.getResource(fileName).toString().substring(6);
			is =  new BufferedInputStream(new FileInputStream(path));
			Properties properties = new Properties();
			properties.load(is);
			ret = properties.getProperty(key);
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(LanguageUtil.getLanString("cn", "username"));
	}
}