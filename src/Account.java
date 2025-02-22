public class Account {
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
}
