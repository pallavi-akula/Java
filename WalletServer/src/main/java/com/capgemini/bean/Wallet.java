package com.capgemini.bean;

import java.math.BigDecimal;
import java.util.Set;

public class Wallet {
	
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	private BigDecimal balance;
	private Set<Transaction> transaction;
	
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Set<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}
	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
		this.transaction = transaction;
	}
	
	

}
