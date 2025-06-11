package BoolsManagementSystem;

public class LibrarySystemTest {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        // 1. 初始化数据
        manager.addBook(new Book("B001", "Java编程", "作者A"));
        manager.addBook(new Book("B002", "数据结构", "作者B"));
        manager.addUser(new Student("S001", "学生小明"));
        manager.addUser(new Employee("E001", "雇员小张"));

        // 2. 执行借还
        User student = manager.findUserById("S001");
        Book book1 = manager.findBookById("B001");

        manager.borrowBook(student, book1); // 借阅
        manager.returnBook(student, book1); // 归还

        // 3. 查看结果
        manager.listBooks();   // 查看图书状态
        manager.listBills();   // 查看账单记录
    }
}