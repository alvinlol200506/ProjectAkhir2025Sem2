/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.services;

import librarymanagementsystem.models.*;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Alvin
 */
public class LibraryService {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static int totalBooks = 0;
    private static int totalMembers = 0;
    private static final String BOOKS_FILE = "books.csv";
    private static final String MEMBERS_FILE = "members.csv";
    private static final String TRANSACTIONS_FILE = "transactions.csv";

    // Muat data saat aplikasi mulai
    public static void loadData() {
        loadBooks();
        loadMembers();
        loadTransactions();
    }

    // Simpan data saat aplikasi ditutup
    public static void saveData() {
        saveBooks();
        saveMembers();
        saveTransactions();
    }

    private static void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3 && data[0].equals("novel")) {
                    books.add(new Novel(data[1], data[2], "Unknown Author"));
                } else if (data.length == 3 && data[0].equals("textbook")) {
                    books.add(new Textbook(data[1], data[2], Integer.parseInt(data[2].split(" ")[0])));
                } else if (data.length == 2) {
                    books.add(new Book(data[0], data[1]));
                }
                totalBooks++;
            }
        } catch (IOException e) {
            // File belum ada saat pertama kali, ini normal
        }
    }

    private static void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                if (book instanceof Novel) {
                    writer.write("novel," + book.getId() + "," + book.getTitle());
                } else if (book instanceof Textbook) {
                    writer.write("textbook," + book.getId() + "," + book.getTitle());
                } else {
                    writer.write(book.getId() + "," + book.getTitle());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadMembers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    Member member = new Member(data[0], data[1]);
                    members.add(member);
                    totalMembers++;
                }
            }
        } catch (IOException e) {
            // File belum ada saat pertama kali, ini normal
        }
    }

    private static void saveMembers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERS_FILE))) {
            for (Member member : members) {
                writer.write(member.getId() + "," + member.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadTransactions() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Implementasi load transaction nanti (butuh parsing tambahan)
            }
        } catch (IOException e) {
            // File belum ada, ini normal
        }
    }
    
    private static void saveTransactions() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE))) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.getTransactionId() + "," + transaction.getBook().getId() + "," + transaction.getMember().getId());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void addBook(String id, String title, String type) {
        Book book;
        if ("novel".equalsIgnoreCase(type)) {
            book = new Novel(id, title, "Unknown Author");
        } else if ("textbook".equalsIgnoreCase(type)) {
            book = new Textbook(id, title, 1);
        } else {
            book = new Book(id, title);
        }
        books.add(book);
        totalBooks++;
        saveBooks();
    }

    public static void removeBook(String id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));
        if (removed) {
            totalBooks--;
            saveBooks();
        }
    }

    public static void addMember(String id, String name) {
        Member member = new Member(id, name);
        members.add(member);
        totalMembers++;
        saveMembers();
    }

    public static void removeMember(String id) {
        members.removeIf(member -> member.getId().equals(id));
        totalMembers--;
        saveMembers();
    }
    
    public static void addTransaction(String transactionId, Book book, Member member) {
        Transaction transaction = new Transaction(transactionId, book, member);
        transactions.add(transaction);
        saveTransactions();
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getTotalMembers() {
        return totalMembers;
    }
}
