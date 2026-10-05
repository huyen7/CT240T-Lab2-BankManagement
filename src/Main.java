import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankManager manager = new BankManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== QUẢN LÝ TÀI KHOẢN NGÂN HÀNG =====");
            System.out.println("1. Thêm tài khoản tiết kiệm");
            System.out.println("2. Tìm kiếm tài khoản");
            System.out.println("3. Nạp tiền");
            System.out.println("4. Rút tiền");
            System.out.println("5. Chuyển khoản");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) break;

                switch (choice) {
                    case 1:
                        System.out.print("Nhập STK: ");
                        String stk = scanner.nextLine();
                        System.out.print("Nhập tên chủ TK: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập số dư ban đầu (>= 50,000): ");
                        double bal = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhập lãi suất (%): ");
                        double rate = Double.parseDouble(scanner.nextLine());

                        SavingAccount sa = new SavingAccount(stk, name, bal, rate);
                        manager.addAccount(sa);
                        System.out.println("Thêm tài khoản thành công!");
                        break;

                    case 2:
                        System.out.print("Nhập STK cần tìm: ");
                        String searchStk = scanner.nextLine();
                        BankAccount acc = manager.findAccount(searchStk);
                        if (acc != null) {
                            System.out.println(acc);
                        } else {
                            System.out.println("Không tìm thấy tài khoản!");
                        }
                        break;

                    case 3:
                        System.out.print("Nhập STK: ");
                        String depStk = scanner.nextLine();
                        System.out.print("Nhập số tiền nạp: ");
                        double depAmt = Double.parseDouble(scanner.nextLine());
                        BankAccount depAcc = manager.findAccount(depStk);
                        if (depAcc != null) {
                            depAcc.deposit(depAmt);
                            System.out.println("Nạp tiền thành công!");
                        } else {
                            System.out.println("Tài khoản không tồn tại!");
                        }
                        break;

                    case 4:
                        System.out.print("Nhập STK: ");
                        String wStk = scanner.nextLine();
                        System.out.print("Nhập số tiền rút: ");
                        double wAmt = Double.parseDouble(scanner.nextLine());
                        BankAccount wAcc = manager.findAccount(wStk);
                        if (wAcc != null) {
                            wAcc.withdraw(wAmt);
                            System.out.println("Rút tiền thành công!");
                        } else {
                            System.out.println("Tài khoản không tồn tại!");
                        }
                        break;

                    case 5:
                        System.out.print("Nhập STK nguồn: ");
                        String from = scanner.nextLine();
                        System.out.print("Nhập STK đích: ");
                        String to = scanner.nextLine();
                        System.out.print("Nhập số tiền chuyển: ");
                        double transAmt = Double.parseDouble(scanner.nextLine());
                        manager.transferMoney(from, to, transAmt);
                        System.out.println("Chuyển tiền thành công!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (InvalidAmountException | InsufficientBalanceException e) {
                System.out.println("LỖI NGHIỆP VỤ: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("LỖI ĐỊNH DẠNG: Vui lòng nhập số hợp lệ!");
            } catch (Exception e) {
                System.out.println("LỖI: " + e.getMessage());
            }
        }
        scanner.close();
    }
}