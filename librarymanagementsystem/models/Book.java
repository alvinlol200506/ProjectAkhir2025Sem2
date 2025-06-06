/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;

import librarymanagementsystem.abstracts.LibraryItem;
import librarymanagementsystem.interfaces.*;
/**
 *
 * @author Alvin
 */
public class Book extends LibraryItem implements Borrowable, Manageable {
    protected String title;
    private boolean isBorrowed;
    private Member borrower;

    public Book(String id, String title) {
        super(id, title);
        this.title = title;
        this.isBorrowed = false;
        this.borrower = null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDetails() {
        return "Book: " + title + " (ID: " + id + ")";
    }

    @Override
    public void borrow(Member member) {
        if (!isBorrowed) {
            this.isBorrowed = true;
            this.borrower = member;
        }
    }

    @Override
    public void returnItem() {
        this.isBorrowed = false;
        this.borrower = null;
    }

    @Override
    public boolean isBorrowed() {
        return isBorrowed;
    }

    @Override
    public Member getBorrower() {
        return borrower;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void add() {
        librarymanagementsystem.services.LibraryService.addBook(id, title, "Book");
    }

    @Override
    public void remove() {
        librarymanagementsystem.services.LibraryService.removeBook(id);
    }

    @Override
    public void update() {
        // Logika update akan memanggil saveBooks() setelah perubahan
        librarymanagementsystem.services.LibraryService.saveBooks();
    }
}
