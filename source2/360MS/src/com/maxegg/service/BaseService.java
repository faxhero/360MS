package com.maxegg.service;

import com.maxegg.dao.BaseDao;
/*
 *  服务层的处理类
 */
public class BaseService {

	// 通用处理方式（可以封装异常等）
	public DealResult doService(DealInput input){
		BaseDao dao = BaseDao.getInteface(input.getHead());
		DealResult ret = dao.dealDao(input);
		return ret;
	}
}
