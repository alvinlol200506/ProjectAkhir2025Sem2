/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;
import librarymanagementsystem.abstracts.LibraryItem;
import librarymanagementsystem.interfaces.Manageable;

/**
 *
 * @author Alvin
 */
public class Member extends LibraryItem implements Manageable {
    public Member(String id, String name) {
        super(id, name);
    }

    public void setName(String name) {
        this.details = name;
    }

    @Override
    public String getId() { // dari abstrak LibraryItem.java
        return id;
    }

    public String getName() {
        return details;
    }

    @Override
    public String getDetails() { // dari abstrak LibraryItem.java
        return "Member: " + details + " (ID: " + id + ")";
    }

    @Override
    public void add() { // dari interface Manageable.java
        librarymanagementsystem.services.LibraryService.addMember(id, details);
    }

    @Override
    public void remove() { // dari interface Manageable.java
        librarymanagementsystem.services.LibraryService.removeMember(id);
    }

    @Override
    public void update() { // dari interface Manageable.java
        librarymanagementsystem.services.LibraryService.saveMembers();
    }
}
