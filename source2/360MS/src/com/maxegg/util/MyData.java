package com.maxegg.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MyData {
	private List<List<Item>> datas;

	public MyData() {
		datas = new ArrayList<List<Item>>();
	}

	public List<List<Item>> getDatas() {
		return datas;
	}

	public void setDatas(List<List<Item>> datas) {
		this.datas = datas;
	}

	public List<Item> getRow(int rowId) {
		if (datas.size() <= rowId || rowId < 0)
			return null;
		return datas.get(rowId);
	}

	public List<Item> getColumn(int columnId) {
		List<Item> columns = null;
		for (int i = 0; i < datas.size(); i++) {
			List<Item> rows = datas.get(i);
			if (rows.size() <= columnId || columnId < 0)
				return columns;
			if (columns == null)
				columns = new ArrayList<Item>();
			columns.add(rows.get(columnId));
		}
		return columns;
	}

	public Item getData(int rowId, int columnId) {
		if (datas.size() <= rowId || rowId < 0)
			return null;
		if (datas.get(0).size() <= columnId || columnId < 0)
			return null;
		return datas.get(rowId).get(columnId);
	}

	public void setMyData(ResultSet rs) throws SQLException {
		if (rs == null) return;
		while (rs.next()) {
			List<Item> rows = new ArrayList<Item>();
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				Object obj = rs.getObject(i + 1);
				Item item = new Item(obj);
				rows.add(item);
			}
			datas.add(rows);
		}

	}

}
