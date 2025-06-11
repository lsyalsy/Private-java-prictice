package BoolsManagementSystem;

public abstract class User {
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // 借还抽象方法，由子类实现
    public abstract boolean borrow(Book book);
    public abstract boolean returnBook(Book book);

    // Getter
    public String getId() { return id; }
    public String getName() { return name; }
}