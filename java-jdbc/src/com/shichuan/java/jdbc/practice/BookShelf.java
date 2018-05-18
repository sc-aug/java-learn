package com.shichuan.java.jdbc.practice;

import java.util.List;
import java.util.Scanner;

import com.shichuan.java.jdbc.practice.beans.BookBean;
import com.shichuan.java.jdbc.practice.service.IBookService;
import com.shichuan.java.jdbc.practice.service.BookService;


public class BookShelf {

    private static Scanner sc;
    private static IBookService bs;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        bs = new BookService();
        run();
        sc.close();
    }
    
    private static void run() {
        boolean flag = true;
        String sign = null;
        help();
        while(flag) {
            System.out.print("bookos> ");
            sign = sc.next();
            switch(sign) {
            case "9": flag = false; break;
            case "0": help(); break;
            case "1": list(); break;
            case "2": add(); break;
            case "3": delete(); break;
            case "4": update(); break;
            default: System.out.println("Invalid Input");
            }
        }
    }
    
    public static void help() {
        System.out.println("--------------------------\n"
            + "Operation List:\n"
            + "  0 - HELP\n"
            + "  1 - List books on shelf\n"
            + "  2 - Add a book to shelf\n"
            + "  3 - Delete a book\n"
            + "  4 - Update a book info\n"
            + "  9 - EXIT\n"
            + "--------------------------");
    }
    
    private static void list() {
        List<BookBean> ls = bs.getAllBooks();
        for (BookBean b: ls) System.out.println(b);
    }

    private static void add() {
        //ID:1 <Harry Potter> by JK Rowling type:Fiction $21.5 pages:364
        int pages = 0;
        float price = 0f;
        String name, author, cat;
        System.out.println("  Input info of the book that you want to remove from the book shelf");
        System.out.print("    [string] book title: ");
        name = sc.next();
        System.out.print("    [string] book author: ");
        author = sc.next();
        System.out.print("    [string] book category: ");
        cat = sc.next();
        System.out.print("    [float]  book price: ");
        price = sc.nextFloat();
        System.out.print("    [int]    book pages: ");
        pages = sc.nextInt();
        
        BookBean b = new BookBean(0, name, author, cat, price, pages);
        
        if (bs.addBook(b) > 0) {
            System.out.println("Succeeded!");
        } else {
            System.out.println("Failed!");
        }
    }
    
    private static void delete() {
        int id = 0;
        System.out.println("  Input ID of the book you want to remove from the book shelf");
        System.out.print("    [int]    book id: ");
        id = sc.nextInt();
        if (bs.deleteBookById(id) > 0) {
            System.out.println("Succeeded!");
        } else {
            System.out.println("Failed!");
        }
    }


    private static void update() {
        System.out.println("update");
        int id = 0;
        	int pages = 0;
        float price = 0f;
        String name = "";
        String author = "";
        String cat = "";
        
        System.out.println("  Input Info of the book you want to update");
        System.out.print("    [int]  book id: ");
        id = sc.nextInt();
        
        BookBean b = bs.getBookById(id);
        
        System.out.println("    [FYI]: " + b);
        System.out.print("    [string] book title: " + b.getBookName() + "\tnew name: ");
        b.setBookName(sc.next());
        System.out.print("    [string] book author: " + b.getAuthor() + "\tnew author: ");
        b.setAuthor(sc.next());
        System.out.print("    [string] book category: " + b.getCategory() + "\tnew category: ");
        b.setCategory(sc.next());
        System.out.print("    [float]  book price: " + b.getPrice() + "\tnew price: ");
        b.setPrice(sc.nextFloat());
        System.out.print("    [int]    book pages: " + b.getPageNo() + "\tnew pages: ");
        b.setPageNo(sc.nextInt());
        
        if (bs.updateBook(b) > 0) {
            System.out.println("Succeeded!");
        } else {
            System.out.println("Failed!");
        }
    }

}
