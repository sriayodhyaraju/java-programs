import java.util.Scanner;

class Customer {
    private String name;
    private int cid;
    private int accno;
    private String branch;
    private String bank;
    private int balance = 0;
    private int pin = 5566;
   
    public Customer(String name, int cid, int accno, String branch, String bank) {
        this.name = name;
        this.cid = cid;
        this.accno = accno;
        this.branch = branch;
        this.bank = bank;
    }

    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    public void displayDetails() {
        System.out.println("\n----- Customer Details -----");
        System.out.println("Name   : " + name);
        System.out.println("CID    : " + cid);
        System.out.println("Acc No : " + accno);
        System.out.println("Branch : " + branch);
        System.out.println("Bank   : " + bank);
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully. New Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully. Remaining Balance: ₹" + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Available Balance: ₹" + balance);
    }

    public void changePin(Scanner sc) {
        System.out.print("Enter your current PIN: ");
        int currentPin = sc.nextInt();
        if (verifyPin(currentPin)) {
            System.out.print("Enter new 4-digit PIN: ");
            int newPin = sc.nextInt();
            if (newPin >= 1000 && newPin <= 9999) {
                pin = newPin;
                System.out.println("PIN changed successfully!");
            } else {
                System.out.println("PIN must be a 4-digit number.");
            }
        } else {
            System.out.println("Incorrect current PIN.");
        }
    }
}

public class AtmApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        // Create Customer
        System.out.println("------ ATM Registration ------");
        System.out.print("Enter Name   : ");
        String name = sc.nextLine();
        System.out.print("Enter Branch : ");
        String branch = sc.nextLine();
        System.out.print("Enter Bank   : ");
        String bank = sc.nextLine();
        System.out.print("Enter CID    : ");
        int cid = sc.nextInt();
        System.out.print("Enter Acc No : ");
        int accno = sc.nextInt();

        Customer customer = new Customer(name, cid, accno, branch, bank);

        System.out.println("\nRegistration successful. Please log in with your PIN.");

        // Pin Verification with 3 Attempts
        int attempts = 0;
        final int maxAttempts = 3;
        boolean authenticated = false;

        while (attempts < maxAttempts) {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();
            if (customer.verifyPin(enteredPin)) {
                authenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (maxAttempts - attempts));
            }
        }

        if (!authenticated) {
            System.out.println("Too many incorrect attempts. Exiting...");
            return;
        }

        // Menu Loop
        int choice;
        do {
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. View Account Details");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    customer.displayDetails();
                    break;
                case 2:
                    customer.checkBalance();
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    int depositAmount = sc.nextInt();
                    customer.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to withdraw: ₹");
                    int withdrawAmount = sc.nextInt();
                    customer.withdraw(withdrawAmount);
                    break;
                case 5:
                    customer.changePin(sc);
                    break;
                case 6:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 6);
       
        sc.close();
    }
}