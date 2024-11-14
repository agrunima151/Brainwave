//Atm interface
import java.util.Scanner;

public class task_1 {
    // User details and balance
    private static double balance = 1000.00;
    private static String userPIN = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the ATM!");
        
        // Authenticate user
        System.out.print("Enter your PIN: ");
        String inputPIN = scanner.nextLine();
        
        if (!inputPIN.equals(userPIN)) {
            System.out.println("Incorrect PIN. Access denied.");
        }
        
        int choice;
        do {
            // Display menu
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }

    // Method to check the balance
    private static void checkBalance() {
        balance=10000;
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to deposit money
    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        double depositAmount = scanner.nextDouble();
        
        if (depositAmount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        } else {
            balance += depositAmount;
            System.out.println("Successfully deposited $" + depositAmount);
            checkBalance();
        }
    }

    // Method to withdraw money
    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();
        
        if (withdrawAmount > balance) {
            System.out.println("Insufficient balance. Transaction canceled.");
        } else if (withdrawAmount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        } else {
            balance -= withdrawAmount;
            System.out.println("Successfully withdrawn $" + withdrawAmount);
            checkBalance();
        }
    }
}
