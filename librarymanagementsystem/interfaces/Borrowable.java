/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package librarymanagementsystem.interfaces;
import librarymanagementsystem.models.Member;

/**
 *
 * @author Alvin
 */
public interface Borrowable {
    void borrow(Member member);
    void returnItem();
    boolean isBorrowed();
    Member getBorrower();
}
