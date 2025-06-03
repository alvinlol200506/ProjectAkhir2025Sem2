/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.services;

import librarymanagementsystem.models.Book;
import librarymanagementsystem.models.Member;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Alvin
 */
public class LibraryService {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Member> members = new ArrayList<>();
    private static int totalBooks = 0;
    private static int totalMembers = 0;
    private static final String BOOKS_FILE = "books.csv";
    private static final String MEMBERS_FILE = "members.csv";

    // Muat data saat aplikasi mulai
    public static void loadData() {
        loadBooks();
        loadMembers();
    }

    // Simpan data saat aplikasi ditutup
    public static void saveData() {
        saveBooks();
        saveMembers();
    }

    private static void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    Book book = new Book(data[0], data[1]);
                    books.add(book);
                    totalBooks++;
                }
            }
        } catch (IOException e) {
            // File belum ada saat pertama kali, ini normal
        }
    }

    private static void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getTitle());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadMembers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    Member member = new Member(data[0], data[1]);
                    members.add(member);
                    totalMembers++;
                }
            }
        } catch (IOException e) {
            // File belum ada saat pertama kali, ini normal
        }
    }

    private static void saveMembers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBERS_FILE))) {
            for (Member member : members) {
                writer.write(member.getId() + "," + member.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBook(String id, String title) {
        Book book = new Book(id, title);
        books.add(book);
        totalBooks++;
        saveBooks(); // Simpan setiap kali ada perubahan
    }

    public static void removeBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
        totalBooks--;
        saveBooks();
    }

    public static void addMember(String id, String name) {
        Member member = new Member(id, name);
        members.add(member);
        totalMembers++;
        saveMembers();
    }

    public static void removeMember(String id) {
        members.removeIf(member -> member.getId().equals(id));
        totalMembers--;
        saveMembers();
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getTotalMembers() {
        return totalMembers;
    }
}
