package com.springsts.reader.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springsts.reader.customer.Customer;
import com.springsts.reader.dao.CustomerDAO;

@Controller
public class CustomerController {

	CustomerDAO customerDao = new CustomerDAO();
	
	@RequestMapping(value="/orderList", method=RequestMethod.GET)
	public String orderList(ModelMap model) {
		
		
		ArrayList<Customer> customerList = customerDao.getCustomerListFromCSV();
			
		model.put("customerList", customerList);

		return "orderList";
	}
	
	
	
}
