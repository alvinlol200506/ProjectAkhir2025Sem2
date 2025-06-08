/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;

// import foldernya
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
        super(id, title); // merujuk ke LibraryItem
        this.title = title;
        this.isBorrowed = false;
        this.borrower = null;
    }
    
    @Override
    public String getTitle() { // dari abstrak LibraryItem.java
        return title;
    }

    @Override
    public String getId() { // dari abstrak LibraryItem.java
        return id;
    }
    
    @Override
    public String getDetails() { // dari abstrak LibraryItem.java
        return "Book: " + title + " (ID: " + id + ")";
    }

    @Override
    public void borrow(Member member) { // dari interface Borrowable.java
        if (!isBorrowed) {
            this.isBorrowed = true;
            this.borrower = member;
        }
    }

    @Override
    public void returnItem() { // dari interface Borrowable.java
        this.isBorrowed = false;
        this.borrower = null;
    }

    @Override
    public boolean isBorrowed() { // dari interface Borrowable.java
        return isBorrowed;
    }

    @Override
    public Member getBorrower() { // dari interface Borrowable.java
        return borrower;
    }

    @Override
    public void add() { // dari interface Manageable.java
        librarymanagementsystem.services.LibraryService.addBook(id, title, "Book");
    }

    @Override
    public void remove() { // dari interface Manageable.java
        librarymanagementsystem.services.LibraryService.removeBook(id);
    }

    @Override
    public void update() { // dari interface Manageable.java
        librarymanagementsystem.services.LibraryService.saveBooks();
    }
}
