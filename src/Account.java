/*public class Account {
    private double balance;
    public Account (double initialBalance){
        this.balance = initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("$" + amount+ "deposited successfullyy.");
        }else{
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("$" + amount + "withdraw successfully." );
        }else{
            System.out.println("Insufficient amount");
        }
    }
}*/
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account{
    private int accountNumber;
    private int pin;
    private double currentBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'##,##0.00");

    public Account(){
    }

    public Account(int accountNumber, int pin){
        this.accountNumber = accountNumber;
        this.pin  = pin;
    }

    public Account(int accountNumber, int pin, double currentBalance, double savingBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.currentBalance = currentBalance;
        this.savingBalance = savingBalance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getPin(){
        return pin;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public double getCurrentBalance(){
        return currentBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    private boolean isValidAmount(double amount, double balance, boolean isDeposit) {
        return isDeposit ? amount > 0 : (balance - amount) >= 0 && amount > 0;
    }

    private void updateBalance(double amount, boolean isCurrent, boolean isDeposit){
        if(isCurrent){
            currentBalance += isDeposit ? amount : -amount;
        }else{
            savingBalance += isDeposit ? amount : -amount;
        }
    }
    public double calcCurrentWithdraw(double amount) {
        currentBalance = (currentBalance - amount);
        return currentBalance;
    }
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
    public double calcCurrentDeposit(double amount) {
        currentBalance = (currentBalance + amount);
        return currentBalance;
    }
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }
    public void calcCheckTransfer(double amount) {
        currentBalance = currentBalance - amount;
        savingBalance = savingBalance + amount;
    }
    public void calcSavingTransfer(double amount) {
        currentBalance = currentBalance + amount;
        savingBalance = savingBalance - amount;
    }
    public void getCurrentWithdrawInput() {
       boolean end  = false;
       while(!end){
           try{
               System.out.println("\n Current Account Balance: " + moneyFormat.format(currentBalance));
               System.out.println("\n Amount you want to withdraw from Current account");
               double amount = input.nextDouble();
               if((currentBalance - amount) >= 0 && amount >= 0) {
                   calcCurrentWithdraw(amount);
                   System.out.println("\n Current Account Balance: " + moneyFormat.format(currentBalance));
                   end = true;
               }else{
                   System.out.println("\n Balance cannot be negative. ");
               }
           } catch (InputMismatchException e){
               System.out.println("\n Invalid choice. ");
               input.next();
           }
       }
    }
    public void getSavingWithdrawInput() {
        boolean end  = false;
        while(!end){
            try{
                System.out.println("\n Current Account Balance: " + moneyFormat.format(savingBalance));
                System.out.println("\n Amount you want to withdraw from Saving account");
                double amount = input.nextDouble();
                if((savingBalance - amount) >= 0 && amount >= 0) {
                    calcSavingWithdraw(amount);
                    System.out.println("\n Current Account Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                }else{
                    System.out.println("\n Balance cannot be negative. ");
                }
            } catch (InputMismatchException e){
                System.out.println("\n Invalid choice. ");
                input.next();
            }
        }
    }
    public void getCurrentDepositInput() {
        boolean end  = false;
        while(!end){
            try{
                System.out.println("\n Current Account Balance: " + moneyFormat.format(currentBalance));
                System.out.println("\n Amount you want to deposit from Current account");
                double amount = input.nextDouble();
                if((currentBalance + amount) >= 0 && amount >= 0) {
                    calcCurrentDeposit(amount);
                    System.out.println("\n Current Account Balance: " + moneyFormat.format(currentBalance));
                    end = true;
                }else{
                    System.out.println("\n Balance cannot be negative. ");
                }
            } catch (InputMismatchException e){
                System.out.println("\n Invalid choice. ");
                input.next();
            }
        }
    }
    public void getSavingDepositInput() {
        boolean end  = false;
        while(!end){
            try{
                System.out.println("\n Current Account Balance: " + moneyFormat.format(savingBalance));
                System.out.println("\n Amount you want to deposit from Saving account");
                double amount = input.nextDouble();
                if((savingBalance + amount) >= 0 && amount >= 0) {
                    calcSavingDeposit(amount);
                    System.out.println("\n Current Account Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                }else{
                    System.out.println("\n Balance cannot be negative. ");
                }
            } catch (InputMismatchException e){
                System.out.println("\n Invalid choice. ");
                input.next();
            }
        }
    }
    public void getTransferInput(String accType) {
        boolean end = false;
        while (!end) {
            try {
                if (accType.equals("Current")) {
                    System.out.println("\n Select an account you wish to transfers funds to: ");
                    System.out.println("1. Savings");
                    System.out.println("\n2. Exit");
                    System.out.println("\n Choice");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\n Current Account Balance: " + moneyFormat.format(currentBalance));
                            System.out.println("\n Amount you want to deposit into your Savings Account: ");
                            double amount = input.nextDouble();
                            if ((savingBalance + amount) >= 0 && (currentBalance - amount) >= 0 && amount >= 0) {
                                calcCheckTransfer(amount);
                                System.out.println("\n Saving Account Balance: " + moneyFormat.format(savingBalance));
                                System.out.println("\n Current Account Balance: " + moneyFormat.format(currentBalance));
                                end = true;
                            } else {
                                System.out.println("\n Balance cannot be negative. ");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\n Invalid Choice. ");
                            break;
                    }
                } else if (accType.equals("Saving")) {
                    System.out.println("\n Select an account you wish to transfers funds to: ");
                    System.out.println("1. Current");
                    System.out.println("\n2. Exit");
                    System.out.println("\n Choice");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\n Current Account Balance: " + moneyFormat.format(savingBalance));
                            System.out.println("\n Amount you want to deposit into your Savings Account: ");
                            double amount = input.nextDouble();
                            if ((currentBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                                calcSavingTransfer(amount);
                                System.out.println("\n Saving Account Balance: " + moneyFormat.format(currentBalance));
                                System.out.println("\n Current Account Balance: " + moneyFormat.format(savingBalance));
                                end = true;
                            } else {
                                System.out.println("\n Balance cannot be negative. ");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\n Invalid Choice. ");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("\n Invalid Choice. ");
                input.next();
            }
        }

    }
}

























