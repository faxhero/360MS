package com.maxegg.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.maxegg.util.Item;

/*
 *  输出类：操作数据库后结果类
 */
public class DealResult implements Serializable {

	private static final long serialVersionUID = -88000340003235847L;
	private Map<String, Item> items = new HashMap<String, Item>();
	private String errorCode = "";
	private String errorDesc = "";
	private String dealId = "";

	public DealResult(String dealId) {
		this.dealId = dealId;
	}
	
	public void addRet(String aName,Object obj){
		Item item = new Item(obj);
		items.put(aName, item);
	}
	
	public Item getRet(String aName){
		if(items.containsKey(aName)){
			return (Item)(items.get(aName));
		}
		return null;
	}

	public Map<String, Item> getItems() {
		return items;
	}

	public void setItems(Map<String, Item> items) {
		this.items = items;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public void setError(String errorCode, String errorDesc) {
		setErrorCode(errorCode);
		setErrorDesc(errorDesc);
	}
}
