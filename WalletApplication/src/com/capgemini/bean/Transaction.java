package com.capgemini.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private int transactionId;
	private Date date;
	private String description;
	private BigDecimal balance;
	private BigDecimal amount;

	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
	return "TransactionId=" + transactionId + ", Date=" + date+ ", Description=" + description + ", Balance=" + balance + ",Amount=" +amount;
			 
}
}
