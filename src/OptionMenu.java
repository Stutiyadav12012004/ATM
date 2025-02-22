import java.util.Scanner;
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
}
