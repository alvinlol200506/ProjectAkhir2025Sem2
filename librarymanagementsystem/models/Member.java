/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;
import librarymanagementsystem.abstracts.LibraryItem;
import java.util.ArrayList;
/**
 *
 * @author Alvin
 */
public class Member extends LibraryItem {
    private ArrayList<Book> borrowedBooks;

    public Member(String id, String name) {
        super(id, name); // Panggil konstruktor LibraryItem dengan id dan name
        this.borrowedBooks = new ArrayList<>();
    }

    public String getId() {
        return id; // Gunakan id dari LibraryItem
    }

    public String getName() {
        return details; // Gunakan details dari LibraryItem sebagai name
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String getDetails() {
        return "Member: " + details + " (ID: " + id + ")";
    }
}
