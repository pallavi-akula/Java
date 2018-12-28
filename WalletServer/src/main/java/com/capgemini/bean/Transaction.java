package com.capgemini.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private Date date;
	private int id;
	private String description;
	private BigDecimal amount;
	private BigDecimal balance;
	
	
	public Transaction(Date date, int id, String description, BigDecimal amount, BigDecimal balance) {
		super();
		this.date = date;
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	
	
	

}
