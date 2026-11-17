
package com.mycompany.m3a2_adiova;

public class BorrowingDemo {

    public static void main(String[] args) {

        Book book1 = new Book("Java Programming");

        Member member1 = new Member("Ana");
        Member member2 = new Member("Ben");

        System.out.println("=== One-Book Borrowing System ===");

        System.out.println("\nTest 1:");
        member1.borrow(book1);
        member1.displayBorrowedBook();
        System.out.println("Book available: " + book1.isAvailable());

        System.out.println("\nTest 2:");
        member2.borrow(book1);
        member2.displayBorrowedBook();
    }
}
