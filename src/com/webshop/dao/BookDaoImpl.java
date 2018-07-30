package com.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.bean.Address;
import com.webshop.bean.Book;
import com.webshop.bean.BookType;
import com.webshop.bean.Page;
@Repository
@Transactional
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Book> booklist() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Book>booklist= session.createQuery("from Book").list();
		return booklist;
	}

	@Override
	public Book selectBook(Book book) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Book where bookId=?");
		query.setInteger(0, book.getBookId());
		Book b=(Book)query.uniqueResult();
		return b;
	}

	@Override
	public boolean insert(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(book);
		return true;
	}

	@Override
	public boolean update(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Book set bookName=?,bookPrice=?,author=?,publisher=?,imgUrl=?,bookType=?,bookDetail=?,bookHot=? where bookId=?");
		query.setParameter(0, book.getBookName());
		query.setParameter(1, book.getBookPrice());
		query.setParameter(2, book.getAuthor());
		query.setParameter(3, book.getPublisher());
		query.setParameter(4, book.getImgUrl());
		query.setParameter(5, book.getBookType());
		query.setParameter(6, book.getBookDetail());
		query.setParameter(7, book.getBookHot());
		query.setParameter(8, book.getBookId());
		query.executeUpdate();
		return true;
	}

	@Override
	public boolean delete(Integer bookId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from Book where bookId=?");
		query.setParameter(0, bookId);
		query.executeUpdate();
		return true;
	}

	@Override
	public Book selectById(Integer bookId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Book where bookId=?");
		query.setInteger(0, bookId);
		Book b=(Book)query.uniqueResult();
		return b;
	}

	@Override
	public Long selectBookCount() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("select count(*)from Book");
		Long count=(Long)query.uniqueResult();
		return count;
	}

	@Override
	public List<Book> booklist(Page page) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Book order by bookId asc");
		query.setFirstResult((page.getDpage()-1) * page.getPagecount());
		query.setMaxResults(page.getPagecount());
		List<Book>booklist=query.list();
		return booklist;
	}

	@Override
	public List<BookType> selectBookType() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from BookType ");
		List<BookType> bookType=query.list();
		return bookType;
	}

	@Override
	public boolean insertBookType(BookType bookType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(bookType);
		return true;
	}

	@Override
	public BookType selectBookTypeById(Integer typeId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BookType where typeId=?");
		query.setInteger(0, typeId);
		BookType bookType=(BookType)query.uniqueResult();
		return bookType;
	}

	@Override
	public List<Book> booklistByType(Page page,BookType bookType) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Book where bookType=?");
		query.setParameter(0, bookType);
		query.setFirstResult((page.getDpage()-1) * page.getPagecount());
		query.setMaxResults(page.getPagecount());
		List<Book>booklist=query.list();
		return booklist;
	}

	@Override
	public List<Book> showSearchBook(String bookName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Book where bookName like '%"+bookName+"%'");
		List<Book>booklist=query.list();
		return booklist;
	}

	@Override
	public List<Book> booklistByHot(Page page) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Book order by bookHot desc");
		query.setFirstResult((page.getDpage()-1) * page.getPagecount());
		query.setMaxResults(page.getPagecount());
		List<Book>booklist=query.list();
		return booklist;
	}

}
