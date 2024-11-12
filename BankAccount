import java.util.Scanner;

class Account {
    String customerName;
    String accountNumber;
    double balance;

    public Account(String customerName, String accountNumber, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountDetails() {
        return "Account Number: " + accountNumber + ", Name: " + customerName + ", Balance: " + balance;
    }
}

class SavingsAccount extends Account {
    double interestRate;

    public SavingsAccount(String customerName, String accountNumber, double initialBalance, double interestRate) {
        super(customerName, accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("Interest deposited: " + interest);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }
}

class CurrentAccount extends Account {
    private static final double MINIMUM_BALANCE = 500.0;
    private static final double SERVICE_CHARGE = 50.0;

    public CurrentAccount(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, initialBalance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
        checkMinimumBalance();
    }

    void checkMinimumBalance() {
        if (balance < MINIMUM_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Minimum balance not maintained. Service charge of " + SERVICE_CHARGE + " applied.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;

        System.out.println("Bank type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.print("Enter your choice: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        if (type == 1) {
            System.out.print("Enter interest rate: ");
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(name, accountNumber, initialBalance, interestRate);
        } else if (type == 2) {
            account = new CurrentAccount(name, accountNumber, initialBalance);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Display Balance");
            System.out.println("3. Withdraw");
            if (account instanceof SavingsAccount) {
                System.out.println("4. Compute and Deposit Interest");
            }
           
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println(account.getAccountDetails());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).withdraw(withdrawAmount);
                    } else {
                        ((CurrentAccount) account).withdraw(withdrawAmount);
                    }
                    break;
                case 4:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).computeAndDepositInterest();
                    } else {
                        System.out.println("This option is not available for Current Accounts.");
                    }
                    break;
                                
		default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
