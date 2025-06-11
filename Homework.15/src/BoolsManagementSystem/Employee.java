package BoolsManagementSystem;

// 雇员类（逻辑可扩展，此处与学生一致）
public class Employee extends User {
    public Employee(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean borrow(Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            return true;
        }
        return false;
    }
}