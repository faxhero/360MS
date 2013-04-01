package com.maxegg.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.maxegg.util.Item;
import com.maxegg.util.ItemTable;

/*
 *  输入类：操作数据库的内容类
 */
public class DealInput implements Serializable{
	
	private static final long serialVersionUID = -4845409831231016586L;
	private String head;
	private Map<String, Item> body = new HashMap<String, Item>();
	private Map<String, ItemTable> itemTable = new HashMap<String, ItemTable>();
	private String dealId;
	
	public DealInput(String head){
		this.head = head;
		body = new HashMap<String, Item>();
		createId();
	}
	
	public void addItemTable(String itemName,ItemTable itemTable){
		this.itemTable.put(itemName, itemTable);
	}
	
	public void addBody(String aName,Object obj){
		if(obj == null) return;
		Item item = new Item(obj);
		body.put(aName, item);
	}
	
	
	public Map<String, ItemTable> getItemTable() {
		return itemTable;
	}

	public void setItemTable(Map<String, ItemTable> itemTable) {
		this.itemTable = itemTable;
	}

	public Item getBodyItem(String name){
		if(body.containsKey(name)){
			return (Item)(body.get(name));
		}
		return new Item("");
	}
	
	public void createId(){
		dealId = UUID.randomUUID().toString();
	}
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Map<String, Item> getBody() {
		return body;
	}
	public void setBody(Map<String, Item> body) {
		this.body = body;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	 
	public Set<String> getBodyRmk(){
		return body.keySet();
	}
	@Override
	public String toString(){
		StringBuffer dealAll = new StringBuffer();
		dealAll.append(head+"-->[");
		Iterator<String> it = getBodyRmk().iterator();
		while(it.hasNext()){
			String aName = it.next();
			if(!getBodyItem(aName).getStringColumn().trim().equals("")){
				dealAll.append(aName+":"+getBodyItem(aName).getStringColumn()+",");
			}
		}
		return dealAll.toString().substring(0, dealAll.length()-1)+"]";
	}
	
	public DealInput toDealInput(String dealAll){
		DealInput di = null;
		if(dealAll==null||!dealAll.contains("-->[")||!dealAll.contains("]")
					||!dealAll.contains(":")||!dealAll.contains(",")){
			return di;
		}
		String arr[] = dealAll.split("-->[");
		di = new DealInput(arr[0]);
		String bodys[] = arr[1].split(",");
		for(int num=0;num<bodys.length;num++){
			String str[] = bodys[num].split(":");
			if(num!=bodys.length-1) {
				di.addBody(str[0], str[1]);
			}else{
				di.addBody(str[0], str[1].replace("]", ""));
			}
		}
		return di;
	}
}
