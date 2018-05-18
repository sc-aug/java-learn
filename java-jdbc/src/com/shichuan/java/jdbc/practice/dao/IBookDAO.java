package com.shichuan.java.jdbc.practice.dao;

import java.util.List;

import com.shichuan.java.jdbc.practice.beans.BookBean;

public interface IBookDAO {
	
	public int addBook(BookBean book);
	
	public int deleteBookById(int bookId);
	
	public int updateBook(BookBean book);
	
	public List<BookBean> getAllBooks();
	
	public BookBean getBookById(int bookId);
}
