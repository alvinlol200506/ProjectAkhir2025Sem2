/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;
import librarymanagementsystem.ui.LibraryUI;
import javax.swing.UIManager;
/**
 *
 * @author Alvin
 */
public class Main {
    public static void main(String[] args){
    UIManager.put("Button.focusPainted", Boolean.FALSE); // ketika buttonnya dipencet tidak meninggalkan outline

    // menjalankan UInya
    java.awt.EventQueue.invokeLater(() -> {
        new LibraryUI().setVisible(true);
    });
    }
}
