package model.entities;

import model.exceptions.WithdrawException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	public Account() {
		
	}


	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getHolder() {
		return holder;
	}


	public void setHolder(String holder) {
		this.holder = holder;
	}


	public Double getBalance() {
		return balance;
	}


	public Double getWithdrawLimit() {
		return withdrawLimit;
	}


	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	
	public  void deposit(Double value) {
		
		balance+= value;
		
	}
	
	public void withdraw(Double value) {
		validateWithdraw(value);			
		
		balance-= value;
	}
	
	public void validateWithdraw(Double value) {
		if (value > balance) {
			throw new WithdrawException("Withdraw Error: the amount exceeds account balance.");
			
		}
		
		if (value > withdrawLimit) {
			throw new WithdrawException("Withdraw Error: the amount exceeds withdraw limit");
			
		}
	}
	
	
	
	
	
}
