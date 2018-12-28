package com.capgemini;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Wallet;


@Configuration

@ComponentScan(basePackages="com.capgemini")
public class AppConfig {
	
	@Bean(value="map")
	public Map<String,Customer> getMap(){
		
		Map<String, Customer> customerData = new HashMap<String,Customer>();
		customerData.put("9850276767", new Customer("Premam","9850276767",new Wallet(new BigDecimal(40000))));
		
		return customerData;
	}
}