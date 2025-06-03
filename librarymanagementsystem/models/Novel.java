/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;

/**
 *
 * @author Alvin
 */
public class Novel extends Book {
    private String author;

    public Novel(String id, String title, String author) {
        super(id, title); // Memanggil constructor Book
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getDetails() {
        return "Novel: " + getTitle() + " by " + author + " (ID: " + getId() + ")";
    }
}
