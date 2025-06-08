/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;

/**
 *
 * @author Alvin
 */
public class Textbook extends Book { // anak kelas dari Book
    private int edition;

    public Textbook(String id, String title, int edition) {
        super(id, title); // Dari parent class Book
        this.edition = edition;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String getDetails() { // dari parent class Book yang menggunakan abstract class LibraryItem
        return "Textbook: " + getTitle() + " (Edition: " + edition + ", ID: " + getId() + ")";
    }
}
