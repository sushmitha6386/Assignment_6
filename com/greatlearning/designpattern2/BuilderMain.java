package com.greatlearning.designpattern2;

public class BuilderMain {
	public static void main(String[] args)
	{
	BankAccount account = new BankAccount.Builder(1234L)
    .withAccount_Type("Savings")
    .atBranch("Springfield")
    .openingBalance(100)
    .build();
	
	System.out.println(account);

BankAccount anotherAccount = new BankAccount.Builder(4567L)
    .withAccount_Type("Current")
    .atBranch("Springfield")
    .openingBalance(400)
    .build();
System.out.println(anotherAccount);


}

}
