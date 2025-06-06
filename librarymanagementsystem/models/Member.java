/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;
import librarymanagementsystem.abstracts.LibraryItem;

/**
 *
 * @author Alvin
 */
public class Member extends LibraryItem {
    private String id;
    private String name;

    public Member(String id, String name) {
        super(id, name); // Sesuai dengan konstruktor LibraryItem
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return "Member: " + name + " (ID: " + id + ")";
    }
}
