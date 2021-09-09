package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double inicialBalance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		deposit(inicialBalance);
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

	public void deposit(Double amount) {
		validateWithdraw(amount);
		this.balance += amount;
	}

	public void whithdraw(Double amount) {
		
		this.balance -= amount;
	}
	
	public void validateWithdraw(Double amount) {
		if (this.balance == 0) {
			throw new DomainException("Balance dont have money");
	}	if (withdrawLimit < amount) {
		throw new DomainException("You dont have enough money");

	}
	}
	
	@Override
	public String toString() {
		return "Account number "+this.number+ ": "+String.format("%.2f",this.balance)+ "€";
	}

}
