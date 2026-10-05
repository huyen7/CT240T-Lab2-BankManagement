public abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) throws InvalidAmountException {
        if (balance < 0) {
            throw new InvalidAmountException("Số dư ban đầu không được âm!");
        }
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Nạp tiền vào tài khoản
     * Pre-conditions: amount > 0[cite: 1]
     * Post-conditions: balance_new == balance_old + amount[cite: 1]
     */
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền nạp phải lớn hơn 0!");
        }
        this.balance += amount;
    }

    /**
     * Rút tiền khỏi tài khoản
     * Pre-conditions: amount > 0 và balance >= amount[cite: 1]
     * Post-conditions: balance_new == balance_old - amount[cite: 1]
     * Class Invariant: balance >= 0[cite: 1]
     */
    public abstract void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException;

    @Override
    public String toString() {
        return "STK: " + accountNumber + " | Chủ TK: " + holderName + " | Số dư: " + balance + " VNĐ";
    }
}