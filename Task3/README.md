# 3A - Self Exercise/Exploration of Array and ArrayList

This project explores how to create and use arrays of objects in Java, based on slide pages 26-31 (Exercise: Account & Customer, and Bank). All classes are in package `Task3`.

## Project Structure
```
Task3/
├── Account.java
├── Customer.java
├── Bank.java
└── Main.java
README.md
```

## Classes

### Account
Represents one bank account.
- `private double balance`: the current balance.
- `Account(double init_balance)`: constructor that sets the starting balance.
- `getBalance()`: returns the current balance.
- `deposit(double amt)`: adds `amt` to the balance and returns `true`; returns `false` if `amt` is not greater than 0.
- `withdraw(double amt)`: subtracts `amt` from the balance and returns `true`; returns `false` if the balance is not enough.

### Customer
Represents one customer who can own several accounts.
- `firstName`, `lastName`: private attributes set by the constructor `Customer(String f, String l)`.
- `Account[] accounts`: an **array of Account objects** with a fixed size of 5.
- `numberOfAccounts`: counts how many slots of the array are used, so it also works as the next free index.
- `getFirstName()`, `getLastName()`: return the name.
- `setAccount(Account acct)`: stores the account in the array and increases `numberOfAccounts` (only while the array is not full).
- `getAccount(int account_index)`: returns the account at that index.
- `getNumOfAccounts()`: returns how many accounts the customer has.

### Bank
Represents the bank that holds all customers.
- `Customer[] customers`: an **array of Customer objects** with a fixed size of 10.
- `numberOfCustomers`: tracks the next free index of the array.
- `addCustomer(String f, String l)`: creates a new `Customer` from the parameters, places it in the array, and increases `numberOfCustomers`.
- `getNumOfCustomers()`: returns `numberOfCustomers`.
- `getCustomer(int index)`: returns the customer at that index.

### Main
The main method explores how to create and call the objects:
1. Creates a `Bank` and adds two customers (stored in the `customers` array).
2. Creates `Account` objects and attaches them to customers with `setAccount()`.
3. Calls `getBalance()`, `deposit()` and `withdraw()`, including a withdrawal that fails because the balance is not enough.
4. Loops through the `customers` array with a `for` loop and prints each customer's first account balance.

## How Arrays Are Used
- `Bank` has an array of `Customer`, and each `Customer` has an array of `Account`.
- An array has a fixed size, so a counter (`numberOfCustomers`, `numberOfAccounts`) is used to know the next free index.
- Elements are accessed with an index starting from 0, for example `bank.getCustomer(0).getAccount(0)`.

## How to Run
From the repository root (the folder that contains `Task3/`):
```bash
javac Task3/*.java
java Task3.Main
```

## Example Output
```
Number of customers: 2
Jane Simmons has 2 accounts
Balance: 500.0
Deposit 150: true
Balance: 650.0
Withdraw 1000: false
Balance: 650.0
Withdraw 200: true
Balance: 450.0
Jane Simmons - first account balance: 450.0
Owen Bryant - first account balance: 250.0
```