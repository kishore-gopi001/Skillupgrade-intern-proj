package librarymanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Sample interaction
        library.addBook(new Book("1984", "George Orwell", "1234567890"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "0987654321"));
        library.addPatron(new Patron("John Doe", "P001"));

        while (true) {
            System.out.println("\n1. Checkout Book");
            System.out.println("2. Return Book");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Patron ID: ");
                    String patronId = scanner.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String isbn = scanner.nextLine();

                    Patron patron = library.patrons.stream()
                            .filter(p -> p.getPatronId().equals(patronId))
                            .findFirst()
                            .orElse(null);
                    Book book = library.books.stream()
                            .filter(b -> b.getISBN().equals(isbn))
                            .findFirst()
                            .orElse(null);

                    if (patron != null && book != null) {
                        library.checkoutBook(patron, book);
                    } else {
                        System.out.println("Invalid Patron ID or Book ISBN.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter Book ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = library.books.stream()
                            .filter(b -> b.getISBN().equals(isbn))
                            .findFirst()
                            .orElse(null);

                    if (book != null) {
                        library.returnBook(book);
                    } else {
                        System.out.println("Invalid Book ISBN.");
                    }
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
