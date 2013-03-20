package com.maxegg.dao;

import com.maxegg.service.DealInput;
import com.maxegg.service.DealResult;
import com.maxegg.sql.ClassSql;
import com.maxegg.util.MyDataBase;
import com.maxegg.util.MyDataSource;

public class UserManagerDao extends BaseDao{

	static{
		BaseDao.add("AddUser", UserManagerDao.class);	
	}
	
	@Override
	public DealResult dealDao(DealInput input) {
		DealResult ret = new DealResult(input.getDealId());
		MyDataBase mdb = new MyDataBase(MyDataSource.getConnection());
		ClassSql cs = new ClassSql();
		
		
		return ret;
	}
}
