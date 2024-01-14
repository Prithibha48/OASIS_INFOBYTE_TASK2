package ATM_MACHINE;

import java.util.Scanner;

public class UserDetails {

    private String userId;
    private String userPin;
    private static int transaction = 0;
    private static long balance = 500000L;

    public UserDetails(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPin() {
        return userPin;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public void login() {
        System.out.println("Hey! Welcome to InfoBank.\nLogin to proceed!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter userId");
        String userId = sc.nextLine();

        if (!userId.isEmpty()) {
            System.out.println("Enter userPin");
            String userPin = sc.nextLine();

            if (!userPin.isEmpty()) {
                System.out.println("Login done successfully!\n************************");
                choices();
            } else {
                System.out.println("Enter valid details");
            }
        } else {
            System.out.println("Enter valid details");
        }
    }

    private void choices() {
        System.out.println("1.Transactions History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Quit");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                transDetails();
                break;
            case 2:
                withdraw();
                
                break;
            case 3:
                deposit();
                
                break;
            case 4:
                transfer();
                transDetails();
                break;
            case 5:
                quit();
                break;
            default:
                System.out.println("Invalid choice entered");
        }
    }

    private void transDetails() {
        if (transaction == 0) {
            System.out.println("No transaction done");
        } else {
            System.out.println(transaction + " time you have transferred");
        }
    }

    private void withdraw() {
        System.out.println("Enter withdraw amount");
        Scanner sc = new Scanner(System.in);
        long amount = sc.nextLong();
        try {
            if (amount <= balance) {
                transaction++;
                balance -= amount;
                System.out.println("Withdraw Successful");
                System.out.println("Your balance is " + balance);
            } else {
                System.out.println("Insufficient Balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter deposit amount");
        long amount = sc.nextLong();
        try {
            if (amount > 0) {
                transaction++;
                balance += amount;
                System.out.println("Amount deposited successfully");
                System.out.println("Your balance is " + balance);
            } else {
                System.out.println("Invalid deposit amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Recipient name");
        String recName = sc.nextLine();
        System.out.println("Enter amount to be transferred to " + recName);
        long amount = sc.nextLong();

        if (amount > 0 && amount <= balance) {
            transaction++;
            balance -= amount;
            System.out.println(amount + " transferred successfully");
            System.out.println("Your balance is " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance");
        }
    }

    private void quit() {
        System.out.println("Thank you!! Visit again :)");
    }

    public static void main(String[] args) {
        UserDetails user = new UserDetails("Prithibha", "1234");
        user.login();
    }
   
}

