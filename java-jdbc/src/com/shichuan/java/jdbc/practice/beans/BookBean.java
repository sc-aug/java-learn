package com.shichuan.java.jdbc.practice.beans;

public class BookBean {
    private int bookId;
    private String bookName;
    private String author;
    private String category;
    private float price;
    private int pageNo;
    
    public BookBean(int i, String n, String au, String cat, float p, int pn) {
        bookId = i;
        bookName = n;
        author = au;
        category = cat;
        price = p;
        pageNo = pn;
    }
    
    @Override
    public String toString() {
        return "ID:" + bookId + " <" + bookName + "> by " + author + " type:"
                + category + " $" + price + " pages:" + pageNo;
    }
    
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}


