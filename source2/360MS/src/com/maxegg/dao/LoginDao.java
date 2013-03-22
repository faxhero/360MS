package com.maxegg.dao;

import java.util.List;

import com.maxegg.exception.ExceptionIndex;
import com.maxegg.service.DealInput;
import com.maxegg.service.DealResult;
import com.maxegg.sql.ClassSql;
import com.maxegg.util.Item;
import com.maxegg.util.MyData;
import com.maxegg.util.MyDataBase;
import com.maxegg.util.MyDataSource;

/*
 *   登陆的具体的是实现类
 */
public class LoginDao extends BaseDao {

	// 注册登陆的类，使其加入父类，能动态加载该类
	static {
		// LONGIN就相当于一个标识 ，通过LONGIN来标识来实现底层
		BaseDao.add("LONGIN", LoginDao.class);
	}

	// // 具体实现操作类: 开发有2个手册：标识信息比对手册以及错误信息比对手册
	@Override
	public DealResult dealDao(DealInput input) {
		DealResult ret = new DealResult(input.getDealId());
		MyDataBase mdb = new MyDataBase(MyDataSource.getConnection());

		ClassSql cs = new ClassSql();
		// 用户登录处理方法
		if (input.getHead().equals("LONGIN")) {
			String name = input.getBodyItem("NAME").getStringColumn();
			String passwd = input.getBodyItem("PWD").getStringColumn();
			String sql = String.format(cs.getSql("user.sql", "login"), name,
					passwd);
			// 操作数据库,用JDBC
			MyData md = mdb.execSql(sql);
			List<Item> users = md.getRow(0);
			if (users != null && users.size() >= 0) {
				// 通过标识信息比对手册查找，容易扩张,和上面查询的结果对应
				ret.addRet("NUMBER", users.get(0).getStringColumn());
				ret.addRet("NAME", users.get(1).getStringColumn());
				ret.addRet("PWD", users.get(2).getStringColumn());
				return ret;
			}
			// 这个地方可以错误信息隐藏，具体需要错误信息比对手册
			ret.setErrorCode(ExceptionIndex.USER_PASSWORD_ERROR);
			return ret;
		}
		ret.setErrorCode(ExceptionIndex.SYSTEM_ERROR);
		return ret;
	}
}
