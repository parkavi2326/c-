#include <iostream>
using namespace std;

class BankAccount {
private:
    double balance;
    
public:
    // Static variable to store total bank funds across all accounts
    static double bankFunds;

    // Constructor to initialize the account with a balance
    BankAccount(double initialBalance = 0) {
        balance = initialBalance;
        // Update total bank funds whenever a new account is created
        bankFunds += balance;
    }

    // Deposit method: Adds money to the account balance and updates bank funds
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            bankFunds += amount;  // Update total bank funds
        } else {
            cout << "Deposit amount must be positive." << endl;
        }
    }

    // Withdraw method: Deducts money from the account balance and updates bank funds
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            bankFunds -= amount;  // Update total bank funds
        } else if (amount <= 0) {
            cout << "Withdrawal amount must be positive." << endl;
        } else {
            cout << "Insufficient funds for withdrawal." << endl;
        }
    }

    // Static method to get the total bank funds across all accounts
    static double getBankFunds() {
        return bankFunds;
    }
};

// Initialize static variable
double BankAccount::bankFunds = 0;

int main() {
    // Creating two bank accounts
    BankAccount account1(1000);  // Account with initial balance of 1000
    BankAccount account2(500);   // Account with initial balance of 500

    // Deposit into account1
    account1.deposit(200);

    // Withdraw from account2
    account2.withdraw(100);

    // Check the total bank funds
    cout << "Total bank funds: $" << BankAccount::getBankFunds() << endl;

    return 0;
}
