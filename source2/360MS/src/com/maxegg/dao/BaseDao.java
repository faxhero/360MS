package com.maxegg.dao;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.maxegg.service.DealInput;
import com.maxegg.service.DealResult;

/*
 *  操作数据库的接口，所有的接口要操作数据，都要实现该抽象类
 */
public abstract class BaseDao {

	// 动态加载类库
	private static Map<String,Class<?>> m_factory = new HashMap<String,Class<?>>();
	
	// 抽象操作类
	public abstract DealResult dealDao(DealInput input);
	
	static{
		init();
	}
	
	public static void add(String name,Class<?>  classitem){
		m_factory.put(name, classitem);
	}
	
	public static BaseDao getInteface(String name){
		BaseDao l_ret = null;
		if(m_factory.containsKey(name)){
			Class<?> l_class = m_factory.get(name);
			
			try{
				Object l_obj = l_class.newInstance();
				if(l_obj instanceof BaseDao){
					l_ret = (BaseDao)l_obj;
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return l_ret;
	}
	
	// 动态加载目标库
	public static void init(){
		try{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); 
			Enumeration<URL> resources = classLoader.getResources("com/maxegg/dao/"); 
			while (resources.hasMoreElements()) { 
				URL resource = resources.nextElement();
				File l_file = new File(resource.getFile());
				if(l_file.isDirectory()){
					String[] l_files = l_file.list();
					for(String l_item:l_files){
						if(l_item.endsWith("Dao.class")){
							Class.forName("com.maxegg.dao."+l_item.substring(0,l_item.length() - 6));
						}
					}
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
