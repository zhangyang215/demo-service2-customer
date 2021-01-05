/*
 * Created by 2021-01-05 20:29:24 
 */
package com.demo2.customer.contract;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alibaba.fastjson.JSON;
import com.demo2.customer.entity.Customer;
import com.demo2.support.utils.DateUtils;

/**
 * @author fangang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerContractTest {
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testSaveAndDelete() throws Exception {
		Customer customer = new Customer();
		Long id = new Long(10010);
		customer.setId(id);
		customer.setName("Johnwood");
		customer.setSex("Male");
		customer.setBirthday(DateUtils.getDate("1999-01-01","yyyy-MM-dd"));
		customer.setIdentification("110211199901013322");
		customer.setPhoneNumber("010-88897070");
		String json = JSON.toJSONStringWithDateFormat(customer, "yyyy-MM-dd HH:mm:ss");
		
		mvc.perform(post("/orm/customer/save")
				.param("id", id.toString())
				.param("name", "Johnwood")
				.param("sex", "Male")
				.param("birthday", "1999-01-01")
				.param("identification", "110211199901013322")
				.param("phoneNumber", "010-88897070"))
		.andExpect(status().isOk());
		
		mvc.perform(get("/orm/customer/load")
				.param("id", id.toString()))
		.andExpect(status().isOk())
		.andExpect(content().json(json));
		
		mvc.perform(get("/orm/customer/delete")
				.param("id", id.toString()))
		.andExpect(status().isOk());
		
		mvc.perform(get("/orm/customer/load")
				.param("id", id.toString()))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}

}
