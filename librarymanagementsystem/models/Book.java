/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;

import librarymanagementsystem.abstracts.LibraryItem;
import librarymanagementsystem.interfaces.Borrowable;
/**
 *
 * @author Alvin
 */
public class Book extends LibraryItem implements Borrowable {
    private String id; // Enkapsulasi (private)
    private String title; // details dari abstract class LibraryItem
    private boolean isBorrowed;

    // Constructor
    public Book(String id, String title) {
        super(id, title); // Memanggil constructor kelas abstrak
        this.id = id;
        this.title = title;
        this.isBorrowed = false;
    }

    // Getter dan Setter (Enkapsulasi)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Menggunakan metode abstrak dari LibraryItem (Polymorphism)
    @Override
    public String getDetails() {
        return "Book: " + title + " (ID: " + id + ")";
    }

    // Menggunakan metode dari interface Borrowable (Polymorphism)
    @Override
    public void borrow() {
        this.isBorrowed = true;
    }

    @Override
    public void returnItem() {
        this.isBorrowed = false;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}
