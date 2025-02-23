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
}

























