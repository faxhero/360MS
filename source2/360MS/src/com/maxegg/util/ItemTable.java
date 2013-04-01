package com.maxegg.util;

import java.util.ArrayList;
import java.util.List;

public class ItemTable {
	
	private List<Item[]> tables;

	public Item[] getRow(int index){
		if(tables.size()<=index || index <0){
			return null;
		}
		return tables.get(index);
	}
	
	public Item getItem(int row,int column){
		if (tables.size() <= row || row < 0)
			return null;
		if (tables.get(0).length <= column || column < 0)
			return null;
		return tables.get(row)[column];
	}
	
	public List<Item> getColumn(int index){
		List<Item> columns = null;
		for (int i = 0; i < tables.size(); i++) {
			Item[] rows = tables.get(i);
			if (rows.length <= index || index < 0)
				return columns;
			if (columns == null)
				columns = new ArrayList<Item>();
			columns.add(rows[index]);
		}
		return columns;
	}
	
	public List<Item[]> getTables() {
		return tables;
	}

	public void setTables(List<Item[]> tables) {
		this.tables = tables;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<tables.size();i++){
			Item[] str = tables.get(i);
			for(int index=0;index<str.length;index++){
				sb.append(str[index]+"\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ItemTable it = new ItemTable();
		List<Item[]> tables = new ArrayList<Item[]>();
		Item str[] = new Item[4];
		for(int i=0;i<10;i++){
			str[0] = new Item("index"+i+"0");
			str[1] = new Item("index"+i+"1");
			str[2] = new Item("index"+i+"2");
			str[3] = new Item("index"+i+"3");
			tables.add(str);
		}
		it.setTables(tables);
		System.out.println(it);
	}
	
}
