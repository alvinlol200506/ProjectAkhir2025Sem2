/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;

/**
 *
 * @author Alvin
 */
public class Novel extends Book { // anak kelas dari Book
    private String author;

    public Novel(String id, String title, String author) {
        super(id, title); // Dari parent class Book
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getDetails() { // dari parent class Book yang menggunakan abstract class LibraryItem
        return "Novel: " + getTitle() + " by " + author + " (ID: " + getId() + ")";
    }
}
