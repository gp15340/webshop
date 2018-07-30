package com.webshop.dao;

import java.util.List;

import com.webshop.bean.Book;
import com.webshop.bean.BookType;
import com.webshop.bean.Page;

public interface BookDao {
	public List<Book> booklist();
	public Book selectBook(Book book);
	public boolean insert(Book book);
	public boolean update(Book book);
	public boolean delete(Integer id);
	public Book selectById(Integer bookId);
	public Long selectBookCount();
	public List<Book> booklist(Page page);
	public List<BookType> selectBookType();
	public boolean insertBookType(BookType bookType);
	public BookType selectBookTypeById(Integer typeId);
	public List<Book> booklistByType(Page page,BookType bookType);
	public List<Book> showSearchBook(String bookName);
	public List<Book> booklistByHot(Page page);
}
