package com.shichuan.java.jdbc.practice.service;

import java.util.List;

import com.shichuan.java.jdbc.practice.beans.BookBean;
import com.shichuan.java.jdbc.practice.dao.*;

public class BookService implements IBookService {
	
	public static IBookDAO db = new BookDAO();

	@Override
	public int addBook(BookBean book) {
		return db.addBook(book);
	}

	@Override
	public int deleteBookById(int bookId) {
		return db.deleteBookById(bookId);
	}

	@Override
	public int updateBook(BookBean book) {
		return  db.updateBook(book);
	}

	@Override
	public List<BookBean> getAllBooks() {
		return db.getAllBooks();
	}

	@Override
	public BookBean getBookById(int bookId) {
		return db.getBookById(bookId);
	}

}
