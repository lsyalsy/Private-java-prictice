package BoolsManagementSystem;

import java.util.Date;

public class Bill {
    private String id;
    private User user;
    private Book book;
    private String action; // 借阅/归还
    private Date date;

    public Bill(String id, User user, Book book, String action) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.action = action;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", user=" + user.getName() +
                ", book=" + book.getTitle() +
                ", action='" + action + '\'' +
                ", date=" + date +
                '}';
    }
}