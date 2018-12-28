package com.capgemini.bean;

import java.math.BigDecimal;

public class Wallet {

	
	private  BigDecimal balance;
//	private Set<Transaction> transaction;
	
	public Wallet(BigDecimal amount) {
		this.balance=amount;
	}
	public  BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
	return ", balance="+balance;
	}

}
