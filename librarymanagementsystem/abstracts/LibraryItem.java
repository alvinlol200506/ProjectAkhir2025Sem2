/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.abstracts;

/**
 *
 * @author Alvin
 */
public abstract class LibraryItem { // kelas abstrak (requirment untuk project akhir)
    protected String id;
    protected String details;

    public LibraryItem(String id, String details) {
        this.id = id;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return details;
    }

    // Metode abstrak untuk polymorphism (requirment untuk project akhir)
    public abstract String getDetails();
}
