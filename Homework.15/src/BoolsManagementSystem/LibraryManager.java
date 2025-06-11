package BoolsManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Bill> bills = new ArrayList<>();
    private int billIdCounter = 1;

    // 增删改查方法（示例：添加图书/用户）
    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    // 借还核心逻辑
    public boolean borrowBook(User user, Book book) {
        if (user.borrow(book)) {
            bills.add(new Bill(String.valueOf(billIdCounter++), user, book, "借阅"));
            return true;
        }
        return false;
    }

    public boolean returnBook(User user, Book book) {
        if (user.returnBook(book)) {
            bills.add(new Bill(String.valueOf(billIdCounter++), user, book, "归还"));
            return true;
        }
        return false;
    }

    // 辅助：根据ID查找图书/用户（简化实现）
    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }

    public User findUserById(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) return u;
        }
        return null;
    }

    // 查看数据（示例：打印图书状态、账单）
    public void listBooks() {
        for (Book b : books) {
            System.out.println(b.getTitle() + " [" + (b.isBorrowed() ? "已借" : "可借") + "]");
        }
    }

    public void listBills() {
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }
}