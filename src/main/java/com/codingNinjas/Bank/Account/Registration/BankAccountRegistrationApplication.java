package com.codingNinjas.Bank.Account.Registration;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Bank Registration Application!");
		System.out.println("Enter your name: ");
		String userName = sc.nextLine();
		
		myUser user = (myUser)context.getBean("myUser");
		user.setUserDetails(userName);
		
		System.out.println("Do you want to add acount? \n1. Yes \n2. No");
		int userChoice = sc.nextInt();
		
		if(userChoice == 1) {
			while(true) {
				System.out.println("Please select the account type: \n1. Current Account \n2. Savings Account");
				int accChoice = sc.nextInt();
				String accType = "";
				if(accChoice == 1) {
					accType = "currentAccount";
				} else if(accChoice == 2){
					accType = "savingsAccount";
				} else {
					System.out.println("Invalid Choice");
					break;
				}
				
				//create an account
				Account account = (Account) context.getBean(accType);
				
				System.out.println("Enter your opening balance: ");
				double openingBalance = sc.nextDouble();
				//add acountBalance
				account.addBalance(openingBalance);
				
				user.addAccount(account);
				
				System.out.println("Do you want to add more account? \n1. Yes \n2. No"); 
				int moreAccChoice = sc.nextInt();
				switch(moreAccChoice) {
				case 1 -> {
					// continue
					break;
				}
				case 2 -> {
					// display accountList
					System.out.println("Hi "+user.getName()+", here is the list of your accounts -");
					List<Account> allUserAccounts = user.getAllAccounts();
					for(int i=0; i<allUserAccounts.size(); i++) {
						System.out.println(allUserAccounts.get(i).getAccountType()+" : opening balance - "+allUserAccounts.get(i).getBalance()+" Reference Id "+allUserAccounts.get(i).toString());
					}
					break;
				}
				default -> {
					break;
				}
				}
				if(moreAccChoice != 1) {
					break;
				}
			}
		}
		
		sc.close();
		context.close();
	}

}
