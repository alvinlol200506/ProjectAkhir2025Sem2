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
    private static int totalBooks = 0;
    private static int totalMembers = 0;
    private static final String BOOKS_FILE = "books.csv";
    private static final String MEMBERS_FILE = "members.csv";

    public static void loadData() { // dipanggil oleh LibraryUI
        loadMembers(); // dipakai Member.java
        loadBooks(); // dipakai Book.java 
    }

    public static void saveData() { // dipanggil oleh LibraryUI
        saveBooks(); // dipakai Book.java
        saveMembers(); // dipakai Member.java
    }

    private static void loadBooks() {
    try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length < 2) continue;

            Book book = null;
            String memberId = data.length > 2 ? data[data.length - 1] : "";

            if ("novel".equalsIgnoreCase(data[0])) {
                book = new Novel(data[1], data[2], "Unknown Author");
            } else if ("textbook".equalsIgnoreCase(data[0])) {
                try {
                    int edition = Integer.parseInt(data.length > 3 ? data[3] : "1");
                    book = new Textbook(data[1], data[2], edition);
                } catch (NumberFormatException e) {
                    book = new Book(data[1], data[2]);
                }
            } else if (data.length >= 2) {
                book = new Book(data[0], data[1]);
            }

            if (book != null) {
                books.add(book);
                totalBooks++;
                if (!memberId.isEmpty()) {
                    for (Member member : members) {
                        if (member.getId().equals(memberId)) {
                            book.borrow(member);
                            break;
                        }
                    }
                }
            }
        }
    } catch (IOException e) {
        
    }
}

    public static void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                String memberId = book.isBorrowed() ? book.getBorrower().getId() : "";
                if (book instanceof Novel) {
                    writer.write("novel," + book.getId() + "," + book.getTitle() + "," + memberId);
                } else if (book instanceof Textbook) {
                    writer.write("textbook," + book.getId() + "," + ((Textbook) book).getEdition() + "," + memberId);
                } else {
                    writer.write(book.getId() + "," + book.getTitle() + "," + memberId);
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
                    members.add(new Member(data[0], data[1]));
                    totalMembers++;
                }
            }
        } catch (IOException e) {
            // File belum ada saat pertama kali, ini normal
        }
    }

    public static void saveMembers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERS_FILE))) {
            for (Member member : members) {
                writer.write(member.getId() + "," + member.getName());
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
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getId().equals(id)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            totalBooks--;
            saveBooks();
        }
    }

    public static void addMember(String id, String name) {
        members.add(new Member(id, name));
        totalMembers++;
        saveMembers();
    }

    public static void removeMember(String id) {
        Member memberToRemove = null;
        for (Member member : members) {
            if (member.getId().equals(id)) {
                memberToRemove = member;
                break;
            }
        }
        if (memberToRemove != null) {
            // Hapus member dari peminjaman buku
            for (Book book : books) {
                if (book.isBorrowed() && book.getBorrower().getId().equals(id)) {
                    book.returnItem();
                }
            }
            members.remove(memberToRemove);
            totalMembers--;
            saveMembers();
            saveBooks();
        }
    }

    public static void borrowBook(String bookId, String memberId) {
        Book bookToBorrow = null;
        Member borrower = null;
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                bookToBorrow = book;
                break;
            }
        }
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                borrower = member;
                break;
            }
        }
        if (bookToBorrow != null && borrower != null && !bookToBorrow.isBorrowed()) {
            bookToBorrow.borrow(borrower);
            saveBooks();
        }
    }

    public static void returnBook(String bookId) {
        Book bookToReturn = null;
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                bookToReturn = book;
                break;
            }
        }
        if (bookToReturn != null && bookToReturn.isBorrowed()) {
            bookToReturn.returnItem();
            saveBooks();
        }
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
