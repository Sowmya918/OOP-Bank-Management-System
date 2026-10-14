import java.util.ArrayList;
import java.util.Scanner;

public class BankEngine {

    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        accounts.add(new SavingsAccount("SAV101", "Alice Smith", 500.0, 0.04));
        accounts.add(new SavingsAccount("SAV102", "Bob Jones", 150.0, 0.04));

        while (true) {
            System.out.println("\n=== BANK OPERATIONS ENGINE ===");
            System.out.println("1. List All Accounts");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Select option: ");

            int choice;

            try {
                choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a number from 1 to 4.");
                scanner.nextLine();
                continue;
            }

            if (choice == 4) {
                break;
            }

            switch (choice) {
                case 1:
                    for (BankAccount acc : accounts) {
                        acc.displayAccountDetails();
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String depNum = scanner.next();

                    System.out.print("Enter deposit amount: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount.");
                        scanner.nextLine();
                        break;
                    }
                    double depAmt = scanner.nextDouble();

                    boolean depFound = false;

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equalsIgnoreCase(depNum)) {
                            acc.deposit(depAmt);
                            depFound = true;
                            break;
                        }
                    }

                    if (!depFound) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String witNum = scanner.next();

                    System.out.print("Enter withdrawal amount: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount.");
                        scanner.nextLine();
                        break;
                    }
                    double witAmt = scanner.nextDouble();

                    boolean witFound = false;

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equalsIgnoreCase(witNum)) {
                            acc.withdraw(witAmt);
                            witFound = true;
                            break;
                        }
                    }

                    if (!witFound) {
                        System.out.println("Account not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Choose 1 to 4.");
            }
        }

        scanner.close();
        System.out.println("Bank application closed.");
    }
}