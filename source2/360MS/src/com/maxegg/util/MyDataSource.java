package com.maxegg.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MyDataSource {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/LiferayPool");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("获取上下文资源失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败！");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("未知异常！");
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(ResultSet rs, PreparedStatement ps,Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<HashMap<String, Object>> formatResultSet(
			ResultSet rs) {
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		if (rs != null) {
			try {
				ResultSetMetaData rm = rs.getMetaData();
				while (rs.next()) {
					HashMap<String, Object> tempMap = new HashMap<String, Object>();
					for (int i = 0; i < rm.getColumnCount(); i++) {

						String columnName = rm.getColumnName(i + 1);
						int columnType = rm.getColumnType(i + 1);
						if (Types.VARCHAR == columnType) {
							tempMap.put(columnName, rs.getString(i + 1));
						} else if (Types.SMALLINT == columnType) {
							tempMap.put(columnName, rs.getShort(i + 1));
						} else if (Types.INTEGER == columnType) {
							tempMap.put(columnName, rs.getInt(i + 1));
						} else if (Types.FLOAT == columnType) {
							tempMap.put(columnName, rs.getFloat(i + 1));
						} else if (Types.DOUBLE == columnType) {
							tempMap.put(columnName, rs.getDouble(i + 1));
						} else if (Types.TIMESTAMP == columnType) {
							tempMap.put(columnName, rs.getTimestamp(i + 1));
						} else if (Types.DATE == columnType) {
							tempMap.put(columnName, rs.getDate(i + 1));
						} else {
							tempMap.put(columnName, rs.getObject(i + 1) + "");
						}
					}
					resultList.add(tempMap);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(rs, null, null);
			}

		}
		return resultList;
	}
}
