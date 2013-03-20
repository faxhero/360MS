package com.maxegg.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ClassSql {
	
	public static Map<String,String> loadFile(String fileName){
		Map<String,String> sqlMap = new HashMap<String, String>();	
		try {
			String sqlFile = ClassSql.class.getResource(fileName)
										.toString().substring(6);
			File file = new File(sqlFile);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String stt = "";
			String sql = "";
			String flag = "";
			while((stt=br.readLine())!=null){
				stt = stt.trim();
				if(stt.equals(""))  continue;
				if(stt.startsWith("--")&&stt.endsWith("start")){
					flag = stt.substring(stt.indexOf("##")+2,stt.indexOf("start"));
				}else if(stt.startsWith("--")&&stt.endsWith("end")){
					sqlMap.put(flag.trim(), sql.trim());
					sql = "";
					flag = "";
				}else if(!stt.startsWith("--")){
					sql = sql + " " + stt;
				}
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return sqlMap;
	}
	
	
	public String getSql(String fileName,String flag){
		return loadFile(fileName).get(flag);
	}
}
