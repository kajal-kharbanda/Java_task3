import java.sql.SQLOutput;
import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance) {
        if(initialBalance>=0){
           this.balance=initialBalance;
        }else{
            System.out.println("Balance Can't be negative so, its 0");
            this.balance=0;
        }
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposit successfully. New Balance: $"+balance);
        }else{
            System.out.println("Deposit amount must be positive");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance)
        {
            balance-=amount;
            System.out.println("Withdrwal successfully. New Balance: $"+balance);
        }else if(amount<0 || amount>balance){
            System.out.println("Insufficient balance. Transaction failed. OR Withdrawal amount must be positive.");
        }
    }
    public double getBalance()
    {
        return balance;
    }
}
class ATM{
    private BankAccount account;

    public ATM(BankAccount account){
        this.account=account;
    }
    public void displayMenu(){
        System.out.println("\n***********ATM Menu************");
        System.out.println("1. check balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.println("Choose an option");

    }
    public void handleUserActions(){
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            displayMenu();
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Current Balance: $"+account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount=sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = sc.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }while(choice!=4);
    }
}
public class ATM_Interface {
    public static void main(String[] args) {
        BankAccount userAccount=new BankAccount(10000.00);
        ATM atmmachine =new ATM(userAccount);

        atmmachine.handleUserActions();
    }
}
