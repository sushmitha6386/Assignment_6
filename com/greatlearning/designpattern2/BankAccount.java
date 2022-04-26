package com.greatlearning.designpattern2;

public class BankAccount {
	 private long accountNumber; 
     private String account_type;
     private String branch;
     private double balance;
     private double atmTransactions;
     private String emiSchedule;

     private BankAccount(Builder builder) {
         this.accountNumber = builder.accountNumber;
         this.account_type = builder.account_type;
         this.branch = builder.branch;
         this.balance = builder.balance;
         this.atmTransactions = builder.atmTransactions;
         this.emiSchedule     =builder.emiSchedule;
     }
     public long getAccountNumber() {
         return accountNumber;
     }
     public String getAccount_Type() {
         return account_type;
     }
     public String getBranch() {
         return branch;
     }
     public double getBalance() {
         return balance;
     }
     public double getAtmTransactions() {
         return atmTransactions;
     }
     public String getEmiSchedule() {
         return emiSchedule;
     }
     
  
     @Override
     public String toString() {
         return "User: "+this.accountNumber+", "+this.account_type+", "+this.branch+", "+this.balance+", "+this.atmTransactions+", "+this.emiSchedule;
     }

    public static class Builder {

        private long accountNumber; 
        private String account_type;
        private String branch;
        private double balance;
        private double atmTransactions;
        private String emiSchedule;
        
        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder withAccount_Type(String account_type){
            this.account_type = account_type;

            return this;  
        }

        public Builder atBranch(String branch){
            this.branch = branch;

            return this;
        }

        public Builder openingBalance(double balance){
            this.balance = balance;

            return this;
        }

        public Builder atAtmTransactions(double atmTransactions){
            this.atmTransactions = atmTransactions;

            return this;
        }
        
        public Builder atEmiSchedule(String emiSchedule){
            this.emiSchedule = emiSchedule;

            return this;
        }

        public BankAccount build(){
            //Here we are creating the bank account object
            BankAccount account = new BankAccount();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            account.accountNumber = this.accountNumber;
            account.account_type = this.account_type;
            account.branch = this.branch;
            account.balance = this.balance;
            account.atmTransactions = this.atmTransactions;
            account.emiSchedule = this.emiSchedule;


            return account;
        }
    }

    private BankAccount() {
        //Constructor is now private.
    }
}
