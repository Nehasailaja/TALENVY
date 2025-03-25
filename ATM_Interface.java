import java.util.Scanner;

class UserAccount {
    private double acc_balance = 0.0; 

    public double getBalance() {
        return acc_balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= acc_balance) {
            acc_balance -= amount;
            System.out.println("Withdrawn Successfully! \nYour current balance: " + acc_balance);
        } else if (amount > acc_balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            acc_balance += amount;
            System.out.println("Amount successfully deposited! \nYour current balance: " + acc_balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserAccount user = new UserAccount(); 
        int choice  = 0;

        do {
            System.out.println("\n<<<<< ATM MENU >>>>>");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {  // Input validation
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // Clear invalid input
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    if (!sc.hasNextDouble()) { 
                        System.out.println("Invalid amount! Please enter a valid number.");
                        sc.next();
                        break;
                    }
                    user.withdraw(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    if (!sc.hasNextDouble()) { 
                        System.out.println("Invalid amount! Please enter a valid number.");
                        sc.next();
                        break;
                    }
                    user.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Your current balance: " + user.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        sc.close();
    }
}
