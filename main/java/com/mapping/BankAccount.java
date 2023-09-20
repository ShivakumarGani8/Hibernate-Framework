package com.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BankAccount {
	@Id
	@Column(name="account_no")
	private int accountNo;
	
	@Column(name="bank_name")
	private String bankName;
	private double balance;
	
	@ManyToOne
	private Person person;
	
	
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int accountNo, String bankName, double balance,Person person) {
		super();
		this.accountNo=accountNo;
		this.bankName = bankName;
		this.balance = balance;
		this.person=person;
	}
	
	
	
}
