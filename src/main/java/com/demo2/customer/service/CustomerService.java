/* 
 * Created by 2019年1月13日
 */
package com.demo2.customer.service;

import com.demo2.customer.entity.Customer;

/**
 * The service of customer
 * @author fangang
 */
public interface CustomerService {
	/**
	 * save a customer
	 * @param customer
	 */
	public void save(Customer customer);
	/**
	 * delete a customer
	 * @param id
	 */
	public void delete(long id);
}
