package com.shichuan.java.jdbc.practice.service;

import java.util.List;

import com.shichuan.java.jdbc.practice.beans.BookBean;

public interface IBookService {

	public int addBook(BookBean book);
	
	public int deleteBookById(int bookId);
	
	public int updateBook(BookBean book);
	
	public List<BookBean> getAllBooks();
	
	public BookBean getBookById(int bookId);
	
	// searchBookByCategory
}
