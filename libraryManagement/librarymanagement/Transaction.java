package librarymanagement;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private Patron patron;
    private Book book;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    boolean isReturned;

    public Transaction(Patron patron, Book book) {
        this.patron = patron;
        this.book = book;
        this.checkoutDate = LocalDate.now();
        this.dueDate = checkoutDate.plusWeeks(2);  // 2 weeks checkout period
        this.isReturned = false;
    }

    public Patron getPatron() {
        return patron;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && !isReturned;
    }

    public void returnBook() {
        this.isReturned = true;
        book.setCheckedOut(false);
    }

    public double calculateFine() {
        if (isOverdue()) {
            long overdueDays = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
            return overdueDays * 2.0;  // $2 per day overdue
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "patron=" + patron +
                ", book=" + book +
                ", checkoutDate=" + checkoutDate +
                ", dueDate=" + dueDate +
                ", isReturned=" + isReturned +
                '}';
    }
}
