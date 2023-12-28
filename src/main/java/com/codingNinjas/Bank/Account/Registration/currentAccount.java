package com.codingNinjas.Bank.Account.Registration;

/**

  This class is an implementation of a "Account" Interface based on the selection 
  done in the console for account type .You need to complete this class
  based on the following tasks.

     Tasks:
   a. Create attribute amount(double) 
   b. Override the methods of Account Interface.
   c. Build the logic for all the methods based on the description mentioned in the Account Interface.

**/

public class currentAccount implements Account{

	private String accountType;
	private double balance;
	
	public currentAccount() {
		this.accountType = "Current Account";
		this.balance = 0;
	}
	
	void init() {
		System.out.println("A new Bean for Current Account is created");
	}
	
	@Override
	public String getAccountType() {
		// TODO Auto-generated method stub
		return this.accountType;
	}

	@Override
	public void addBalance(double balance) {
		// TODO Auto-generated method stub
		this.balance+=balance;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}

}
