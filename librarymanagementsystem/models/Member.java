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

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return details;
    }

    public void setName(String name) {
        this.details = name;
    }

    @Override
    public String getDetails() {
        return "Member: " + details + " (ID: " + id + ")";
    }

    @Override
    public void add() {
        librarymanagementsystem.services.LibraryService.addMember(id, details);
    }

    @Override
    public void remove() {
        librarymanagementsystem.services.LibraryService.removeMember(id);
    }

    @Override
    public void update() {
        librarymanagementsystem.services.LibraryService.saveMembers();
    }
}
