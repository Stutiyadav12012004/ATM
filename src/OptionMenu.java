/*import java.util.Scanner;
public class OptionMenu {
    private Account account;
    private Scanner scanner = new Scanner(System.in);

    public OptionMenu() {
        this.account = new Account(2000);
    }

    public void showMenu(){
        while(true){
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Your Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid option.Try again.");
            }
        }
    }
}*/


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'##,##0.00");
    HashMap<Integer, Account> data = new HashMap<Integer, Account>();

    public void showMenu() throws IOException {
        data.put(100220156, new Account(100220156, 1201, 500, 1000));
        data.put(100220108, new Account(100220108, 7012, 5000, 10000));
        boolean end = false;
        while(!end) {
            try {
                System.out.println("\n Type 1 - Login");
                System.out.println("\n Type 2 - Create Account");
                System.out.print("\n Choice: ");
                int choice = menuInput.nextInt();
                switch (choice) {
                    case 1:
                        getLogin();
                        end = true;
                        break;
                    case 2:
                        createAccount();
                        end = true;
                        break;
                    default:
                        System.out.println("\n Invalid Choice.");
                }
            } catch(InputMismatchException e) {
                System.out.println("\n Invalid Choice.");
                menuInput.next();
            }
        }
        System.out.println("\n Thanks for using this ATM. \n");
        menuInput.close();
        return;
    }

    public void getLogin() throws IOException {
        boolean end = false;
        int accountNumber = 0;
        int pin = 0;
        while(!end) {
            try {
                System.out.println("\n Enter Your account number: ");
                accountNumber = menuInput.nextInt();
                System.out.println("\n Enter your PIN Number: ");
                pin = menuInput.nextInt();

                if(data.containsKey(accountNumber)) {
                    Account acc = data.get(accountNumber);
                    if(pin == acc.getPin()) {
                        getAccountType(acc);
                        end = true;
                    } else{
                        System.out.println("\n Wring PIN");
                    }
                } else{
                    System.out.println("\n Account Number not found");
                }
            } catch (InputMismatchException e ) {
                System.out.println("\n Invalid Characters(s). Only Numbers.");
                menuInput.nextLine();
            }
        }
    }

    public void createAccount() throws IOException {
        int accountNumber = 0;
        boolean end = false;

        while(!end) {
            try {
                System.out.println("\n Enter your Account Number: ");
                accountNumber = menuInput.nextInt();

                if(data.containsKey(accountNumber)) {
                    System.out.println("\n This account number is already registered. ");
                } else{
                    end = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n Invalid input. ");
                menuInput.nextLine();
            }
        }
        int pin = 0;
        boolean validPin = false;

        while(!validPin) {
            try {
                System.out.println("\n Enter a PIN to be registered: ");
                pin = menuInput.nextInt();

                if(pin >= 1000 && pin <= 9999) {
                    validPin = true;
                }else{
                    System.out.println("\n Invalid PIN");
                }
            } catch (InputMismatchException e ){
                System.out.println("\n Invalid input");
                menuInput.nextLine();
            }
        }

        data.put(accountNumber,new Account(accountNumber, pin));
        System.out.println("\n Your new account has been successfully registered! ");
        System.out.println("\n Redirecting to login.........");

        getLogin();
    }

    public void getAccountType(Account acc) {
        boolean end = false;
        while(!end) {
            try {
                System.out.println("\n Select the account you want to access: ");
                System.out.println("\n Type 1 - Current Account");
                System.out.println("\n Type 2 - Saving Account");
                System.out.println("\n Type 3 - Exit");
                System.out.print("\n Choice: ");

                int choice = menuInput.nextInt();
                switch(choice){
                    case 1:
                        getCurrent(acc);
                        break;
                    case 2:
                        getSaving(acc);
                        break;
                    case 3:
                        end = true;
                        break;
                    default:
                        System.out.println("\n Invalid Choice. ");

                }
            } catch(InputMismatchException e ){
                System.out.println("\n Invalid Choice. ");
                menuInput.nextLine();
            }
        }
    }

    public void getCurrent(Account acc){
        boolean end = false;
        while(!end) {
            try {
                System.out.println("\n Current Account ");
                System.out.println("\n Type 1 - View Balance ");
                System.out.println("\n Type 2 - Withdraw Funds");
                System.out.println("\n Type 3 - Deposit Funds");
                System.out.println("\n Type 4 - Transfer Funds");
                System.out.println("\n Type 5 - Exit");
                System.out.print("\n Choice: ");

                int choice = menuInput.nextInt();

                switch(choice){
                    case 1:
                        System.out.print("\n Checking Account Balance: " + moneyFormat.format(acc.getCurrentBalance()));
                        break;
                    case 2:
                        acc.getCurrentWithdrawInput();
                        break;
                    case 3:
                        acc.getCurrentDepositInput();
                        break;
                    case 4:
                        acc.getTransferInput("Current");
                        break;
                    case 5:
                        end = true;
                        break;
                    default:
                        System.out.print("\n Invalid Choice ");
                }
            } catch(InputMismatchException e ){
                System.out.print("\n Invalid Choice ");
                menuInput.next();
            }
        }
    }

    public void getSaving(Account acc){
        boolean end = false;
        while(!end) {
            try {
                System.out.println("\n Saving Account ");
                System.out.println("\n Type 1 - View Balance ");
                System.out.println("\n Type 2 - Withdraw Funds");
                System.out.println("\n Type 3 - Deposit Funds");
                System.out.println("\n Type 4 - Transfer Funds");
                System.out.println("\n Type 5 - Exit");
                System.out.print("\n Choice: ");

                int choice = menuInput.nextInt();

                switch(choice){
                    case 1:
                        System.out.print("\n Savings Account Balance: " + moneyFormat.format(acc.getSavingBalance()));
                        break;
                    case 2:
                        acc.getSavingWithdrawInput();
                        break;
                    case 3:
                        acc.getSavingDepositInput();
                        break;
                    case 4:
                        acc.getSavingInput("Current");
                        break;
                    case 5:
                        end = true;
                        break;
                    default:
                        System.out.print("\n Invalid Choice ");
                }
            } catch(InputMismatchException e ){
                System.out.print("\n Invalid Choice ");
                menuInput.next();
            }
        }
    }
}