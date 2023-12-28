package com.codingNinjas.Bank.Account.Registration;

import java.util.ArrayList;
import java.util.List;

/**
  This class is an implementation of a User Interface based on the selection 
  done in the console for user information.You need to complete this class 
  based on the following tasks.

   a. Adding common attributes: 
       1. String name
       2. List<Account> accountList.
   b. Override the methods of User Interface.
   c. Build the logic for all the methods based on the description mentioned in the Account Interface.

**/

public class myUser implements User{

	private String userName;
	private List<Account> allAccounts;
	
	public myUser() {
		this.allAccounts = new ArrayList<Account>();
	}
	
	public void init() {
		System.out.println("User Bean has been instantiated, I'm the init method");
	}
	
	public void destroy() {
		System.out.println(this.userName+"'s User Bean is now destroyed");
	}
	
	@Override
	public void setUserDetails(String name) {
		// TODO Auto-generated method stub
		this.userName = name;
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		this.allAccounts.add(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return this.allAccounts;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

}
