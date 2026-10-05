import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankManager {
    // Quản lý danh sách tài khoản bằng Map theo accountNumber[cite: 2]
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void transferMoney(String fromAcc, String toAcc, double amount)
            throws InsufficientBalanceException, InvalidAmountException {
        BankAccount src = findAccount(fromAcc);
        BankAccount dest = findAccount(toAcc);

        if (src == null || dest == null) {
            throw new IllegalArgumentException("Tài khoản nguồn hoặc đích không tồn tại!");
        }

        src.withdraw(amount);
        dest.deposit(amount);
    }

    // Áp dụng Generics Utility Method với Wildcards để tính tổng số dư[cite: 2]
    public double calculateTotalBalance(List<? extends BankAccount> accountsList) {
        double total = 0.0;
        for (BankAccount acc : accountsList) {
            total += acc.getBalance();
        }
        return total;
    }

    public Map<String, BankAccount> getAccounts() {
        return accounts;
    }
}