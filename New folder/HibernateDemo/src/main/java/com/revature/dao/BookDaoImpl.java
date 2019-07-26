package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Book;
import com.revature.util.ConnectionUtil;

public class BookDaoImpl implements BookDao {
	
	private SessionFactory sf=ConnectionUtil.getSessionFactory();
	
	@Override
	public Book getBookByID(int id) {
		Book b=null;
		
		try{Session s=sf.openSession();
			Transaction tx=s.beginTransaction();
			b=(Book) s.get(Book.class, id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list=new ArrayList<>();
		
		Session s=sf.openSession();
		list=s.createQuery("from Book").getResultList();
		s.close();
		
		
		return list;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

}
