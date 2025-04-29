package com.self.service.impl;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Comparator;

import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookManagerImpl implements BookManager {
	
	ArrayList<java.awt.print.Book> books = null;
	public static final MAX_SIZE = 100;

	private static BookManagerImpl service = new BookManagerImpl();

	private BookManagerImpl() {
		books = new ArrayList<>();
	}

	public static BookManagerImpl getInstance() {
		return service;
	}


	@Override
	public void insertBook(Book book) {
		if (books.size() == MAX_SIZE) {
			System.out.println("더이상 책을 등록할 수 없습니다");
		} else {
			books.add(book);
			System.out.println(book.title+"이 등록되었습니다 ");
		}
	}

	@Override
	public void deleteBook(int isbn) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getIsbn() == isbn) {
				System.out.println(books.remove(i)+"가 삭제되었습니다.");
				break;
			}
		}
		
	}

	//test 필요
	@Override
	public void updateBook(Book book) {
		for(int i=0; i<books.size(); i++) {
			if (books.get(i).getIsbn() == book.getIsbn()) {
				books.set(i, book);
			}
		}
	}

	@Override
	public Book getBook(int isbn) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getIsbn() == isbn) {
				return books.get(i); 
				break;
			}
		}
		return null;
	}

	//test 필요 
	@Override
	public ArrayList<Book> getAllBook() {
		books.sort(new Comparator<Book>() {
		
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getIsbn() - b2.getIsbn();
			}
		});
		return books;
	}

	@Override
	public int getNumberOfBooks() {
		//책의 총 수량 
		
		return books.size();
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		ArrayList<Book> tempArrayList = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {
				tempArrayList.add(books.get(i));
			}
		}
		return tempArrayList;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int min, int max) {
		ArrayList<Book> tempArrayList = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getPrice() >= min && books.get(i).getPrice()<=max){
				tempArrayList.add(books.get(i));
			}
		}
		return tempArrayList;
	}

	@Override
	public double getSumPriceOfBooks() {
		double sum = 0;
		for(Book b : books) {
			sum += b.getPrice();
		}
		return sum;
	}

	@Override
	public double getAvgPriceOfBooks() {
		return getSumPriceOfBooks() / books.size();
	}

	@Override
	public ArrayList<Book> magazineOfThisYearInfo() {
		LocalDate now = LocalDate.now();
		int nowYear = now.getDayOfYear();
		ArrayList<Book> list = new ArrayList<>();
		
		for (Book b : books) {
			if (b instanceof Magazine && b.getPublishDate().getYear() == nowYear) {
				list.add(b);
			}
		}
		
		return list;
	}

}
