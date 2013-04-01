package com.maxegg.dao;

import com.maxegg.exception.ExceptionIndex;
import com.maxegg.service.DealInput;
import com.maxegg.service.DealResult;
import com.maxegg.sql.ClassSql;
import com.maxegg.util.MyData;
import com.maxegg.util.MyDataBase;
import com.maxegg.util.MyDataSource;

public class UserManagerDao extends BaseDao{

	static{
		BaseDao.add("AddUser", UserManagerDao.class);	
		BaseDao.add("ListUser", UserManagerDao.class);
	}
	
	@Override
	public DealResult dealDao(DealInput input) {
		DealResult ret = new DealResult(input.getDealId());
		MyDataBase mdb = new MyDataBase(MyDataSource.getConnection());
		ClassSql cs = new ClassSql();
		if (input.getHead().equals("ListUser")) {
			String sql = cs.getSql("user.sql", "list_user");
			MyData md = mdb.execSql(sql);
			if(md == null){
				ret.setErrorCode(ExceptionIndex.DATABASE_ERROR);
				return ret;
			}
			
		}
		
		return ret;
	}
}
