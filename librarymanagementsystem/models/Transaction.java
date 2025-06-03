/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem.models;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private Book book;
    private Member member;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public Transaction(String transactionId, Book book, Member member) {
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDateTime.now();
        this.returnDate = null;
        book.borrow(); // Panggil metode borrow dari interface Borrowable
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void returnBook() {
        this.returnDate = LocalDateTime.now();
        book.returnItem(); // Panggil metode returnItem dari interface Borrowable
    }
}
