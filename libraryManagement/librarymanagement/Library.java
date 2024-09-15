package librarymanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books;
    List<Patron> patrons;
    List<Transaction> transactions;

    public Library() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
        transactions = new ArrayList<>();
        loadData();  // Load data from files on startup
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
        saveData();
    }

    // Add patron to library
    public void addPatron(Patron patron) {
        patrons.add(patron);
        saveData();
    }

    // Checkout book
    public void checkoutBook(Patron patron, Book book) {
        if (!book.isCheckedOut()) {
            Transaction transaction = new Transaction(patron, book);
            transactions.add(transaction);
            book.setCheckedOut(true);
            saveData();
            System.out.println("Book checked out successfully!");
        } else {
            System.out.println("Book is already checked out!");
        }
    }

    // Return book
    public void returnBook(Book book) {
        for (Transaction transaction : transactions) {
            if (transaction.getBook().equals(book) && !transaction.isReturned) {
                transaction.returnBook();
                double fine = transaction.calculateFine();
                if (fine > 0) {
                    System.out.println("Book is overdue. Fine: $" + fine);
                }
                saveData();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found in transactions!");
    }

    // Save data to files
    private void saveData() {
        try (ObjectOutputStream oosBooks = new ObjectOutputStream(new FileOutputStream("books.dat"));
             ObjectOutputStream oosPatrons = new ObjectOutputStream(new FileOutputStream("patrons.dat"));
             ObjectOutputStream oosTransactions = new ObjectOutputStream(new FileOutputStream("transactions.dat"))) {

            oosBooks.writeObject(books);
            oosPatrons.writeObject(patrons);
            oosTransactions.writeObject(transactions);

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from files
    @SuppressWarnings("unchecked")
    private void loadData() {
        try (ObjectInputStream oisBooks = new ObjectInputStream(new FileInputStream("books.dat"));
             ObjectInputStream oisPatrons = new ObjectInputStream(new FileInputStream("patrons.dat"));
             ObjectInputStream oisTransactions = new ObjectInputStream(new FileInputStream("transactions.dat"))) {

            books = (List<Book>) oisBooks.readObject();
            patrons = (List<Patron>) oisPatrons.readObject();
            transactions = (List<Transaction>) oisTransactions.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("No previous data found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
