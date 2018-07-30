package com.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.bean.Book;
import com.webshop.bean.BookType;
import com.webshop.bean.Page;
import com.webshop.dao.BookDao;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	public List<Book> LoadBookList(Page page){
		return bookDao.booklist(page);
	}
	public Book selectOneBook(Book book) {
		return bookDao.selectBook(book);
	}
	public Book selectById(Integer bookId) {
		return bookDao.selectById(bookId);
	}
	public Long getCount() {
		// TODO Auto-generated method stub
		return bookDao.selectBookCount();
	}
	public List<Book> showBookList(Page page) {
		// TODO Auto-generated method stub
		return bookDao.booklist(page);
	}
	public boolean insert(Book book) {
		// TODO Auto-generated method stub
		return bookDao.insert(book);
	}
	public List<BookType> getBookType() {
		// TODO Auto-generated method stub
		return bookDao.selectBookType();
	}
	public boolean addBookType(BookType bookType) {
		// TODO Auto-generated method stub
		return bookDao.insertBookType(bookType);
	}
	public BookType selectBookTypeById(Integer typeId) {
		// TODO Auto-generated method stub
		return bookDao.selectBookTypeById(typeId);
	}
	public boolean update(Book book) {
		// TODO Auto-generated method stub
		return bookDao.update(book);
	}
	public boolean delete(Integer bookId) {
		// TODO Auto-generated method stub
		return bookDao.delete(bookId);
	}
	public List<Book> LoadBookListByType(Page page,BookType bookType) {
		// TODO Auto-generated method stub
		return bookDao.booklistByType(page,bookType);
	}
	public List<Book> showSearchBook(String bookName) {
		// TODO Auto-generated method stub
		return bookDao.showSearchBook(bookName);
	}
	public List<Book> LoadBookListByHot(Page page) {
		// TODO Auto-generated method stub
		return bookDao.booklistByHot(page);
	}

}
