package com.self.service.impl;

import java.util.ArrayList;

import com.self.service.BookManager;
import com.self.vo.Book;

public class BookManagerImpl implements BookManager {

	@Override
	public void insertBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(int isbn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getBook(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> getAllBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfBooks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSumPriceOfBooks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAvgPriceOfBooks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Book> magazineOfThisYearInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
