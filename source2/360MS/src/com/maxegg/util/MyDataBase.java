package com.maxegg.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDataBase {
	private String error = "";
	private Connection conn = null;
	// log的处理

	public MyDataBase(Connection conn){
		this.conn = conn;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public MyData execSql(String sql) {
		return execSql(sql, null);
	}

	public MyData execSql(String sql, Object[] objs) {
		if (conn == null)
			return null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MyData myData = new MyData();
		try {
			ps = conn.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i + 1, objs[i]);
				}
			}
			rs = ps.executeQuery();
			myData.setMyData(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps!=null)
				try{
					ps.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			if (rs!=null)
				try{
					rs.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
		}
		return myData;
	}
	
	public boolean updateSql(String sql){
		return updateSql(sql, null);
	}

	public boolean updateSql(String sql, Object[] objs) {
		boolean res = false;
		if (conn == null) return res;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i + 1, objs[i]);
				}
			}
			ps.executeUpdate();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps!=null)
				try{
					ps.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
		}
		return res;
	}
	
	public boolean commit(){
		boolean res = false;
		if (conn == null) return res;
		try {
			conn.commit();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean rollback(){
		boolean res = false;
		if (conn == null) return res;
		try {
			conn.rollback();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
