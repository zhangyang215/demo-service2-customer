/* 
 * Created by 2019年1月13日
 */
package com.demo2.customer.service.impl;

import com.demo2.support.dao.BasicDao;

import com.demo2.customer.entity.Customer;
import com.demo2.customer.service.CustomerService;

/**
 * The implement of the customer service
 * @author fangang
 */
public class CustomerServiceImpl implements CustomerService {
	private BasicDao dao;
	/**
	 * @return the dao
	 */
	public BasicDao getDao() {
		return dao;
	}
	/**
	 * @param dao the dao to set
	 */
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	@Override
	public void save(Customer customer) {
		dao.insertOrUpdate(customer);
	}
	@Override
	public void delete(long id) {
		Customer customer = new Customer();
		customer.setId(id);
		dao.delete(customer);
	}
}
