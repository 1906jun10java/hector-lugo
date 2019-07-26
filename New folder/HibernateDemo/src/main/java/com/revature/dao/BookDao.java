package com.revature.dao;

import java.util.List;

import com.revature.beans.Book;

public interface BookDao {
	
	public Book getBookByID(int id);
	
	public List<Book> getAllBooks();
	
	public boolean addBook(Book book);
	
	
	
}
