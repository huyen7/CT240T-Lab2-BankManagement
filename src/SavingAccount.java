public class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(String accountNumber, String holderName, double balance, double interestRate) throws InvalidAmountException {
        super(accountNumber, holderName, balance);
        if (balance < 50000) {
            throw new InvalidAmountException("Số dư tối thiểu của tài khoản tiết kiệm phải >= 50,000 VNĐ!");
        }
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền rút phải lớn hơn 0!");
        }
        if (getBalance() - amount < 50000) {
            throw new InsufficientBalanceException("Số dư còn lại sau khi rút không được nhỏ hơn 50,000 VNĐ!");
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return super.toString() + " | Lãi suất: " + interestRate + "%";
    }
}