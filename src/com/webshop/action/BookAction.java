package com.webshop.action;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webshop.bean.Book;
import com.webshop.bean.BookType;
import com.webshop.bean.Order;
import com.webshop.bean.Page;
import com.webshop.bean.Paging;
import com.webshop.service.BookService;
@Controller
public class BookAction {
	@Autowired
	private BookService bookService;
	@RequestMapping("/loadBookList")
	public String loadBookList(Model model,Integer pageS){	
		Long totalCount =bookService.getCount();
		Paging paging = new Paging();
		Page page = paging.checkByPage(totalCount, pageS);
		//设置每页显示的条数
		page.setPagecount(6);
		page.setTotalpage();
		List<Book> booklist= bookService.LoadBookList(page);
		List<BookType> typelist=bookService.getBookType();
		model.addAttribute("page",page);
		model.addAttribute("booklist", booklist);
		model.addAttribute("typelist", typelist);
		return "index";
	}
	@RequestMapping("/selectOneBook")
	public String selectOneBook(Model model,Integer bookId) {
		
		Book book=bookService.selectById(bookId);
		book.setBookHot(book.getBookHot()+1);
		bookService.update(book);
		model.addAttribute("book",book);
		return "bookDetail";
	}
	@RequestMapping("/showAllBook")
	public String showAllBook(Model model,Integer pageS) {
		Long totalCount =bookService.getCount();
		Paging paging = new Paging();
		Page page = paging.checkByPage(totalCount, pageS);
		List<Book> booklist= bookService.showBookList(page);
		model.addAttribute("page",page);
		model.addAttribute("booklist", booklist);
		return "adminShowBook";
	}
	
	@RequestMapping("/adminAddToBook")
	public String adminAddBook(Model model) {
		List<BookType> typelist=bookService.getBookType();
		model.addAttribute("typelist",typelist);
		return "adminAddBook";
	}
	@RequestMapping("/addBook")
	public String addBook(HttpServletRequest request,Book book,Integer typeId,@RequestParam MultipartFile file) {
		String rootPath = request.getServletContext().getRealPath("/");
		try {
			FileCopyUtils.copy(file.getBytes(),new File(rootPath + "/Images",file.getOriginalFilename()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String realPath = "Images/" + file.getOriginalFilename();
		book.setImgUrl(realPath);
		BookType bookType=bookService.selectBookTypeById(typeId);
		book.setBookType(bookType);
		book.setBookHot(0);
		bookService.insert(book);
		return "redirect:/showAllBook.do";
	}
	@RequestMapping("/addBookType")
	public String addBookType(BookType bookType) {
		bookService.addBookType(bookType);
		return "adminAddBook.do";
	}
	
	@RequestMapping("/adminUpdateBook")
	public String adminUpdateBook(Model model,Integer pageS) {
		Long totalCount =bookService.getCount();
		Paging paging = new Paging();
		Page page = paging.checkByPage(totalCount, pageS);
		List<Book> booklist= bookService.showBookList(page);
		model.addAttribute("page",page);
		model.addAttribute("booklist", booklist);
		return "adminUpdateBook";
	}
	@RequestMapping("/updateBookShow")
	public String updateBookShow(Integer bookId,Model model) {
		Book book=bookService.selectById(bookId);
		model.addAttribute("book",book);
		List<BookType> typelist=bookService.getBookType();
		model.addAttribute("typelist",typelist);
		return "updateBook";
	}
	@RequestMapping("/updateBook")
	public String updateBook(HttpServletRequest request,Book book,Integer typeId,@RequestParam MultipartFile file) {
		String rootPath = request.getServletContext().getRealPath("/");
		try {
			FileCopyUtils.copy(file.getBytes(),new File(rootPath + "/Images",file.getOriginalFilename()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String realPath = "Images/" + file.getOriginalFilename();
		if(realPath.length()>7) {
		book.setImgUrl(realPath);
		}
		BookType bookType=bookService.selectBookTypeById(typeId);
		book.setBookType(bookType);
		bookService.update(book);
		
		return "redirect:/adminUpdateBook.do";
	}
	@RequestMapping("/deleteBook")
	public String deleteBook(Integer bookId) {
		
		bookService.delete(bookId);
		return "redirect:/adminUpdateBook.do";
	}
	@RequestMapping("/selectBookByType")
	public String selectBookByType(Model model,Integer pageS,Integer typeId) {
		Long totalCount =bookService.getCount();
		Paging paging = new Paging();
		Page page = paging.checkByPage(totalCount, pageS);
		//设置每页显示的条数
		page.setPagecount(6);
		page.setTotalpage();
		BookType bookType=bookService.selectBookTypeById(typeId);
		List<Book> booklist= bookService.LoadBookListByType(page,bookType);
		List<BookType> typelist=bookService.getBookType();
		model.addAttribute("page",page);
		model.addAttribute("booklist", booklist);
		model.addAttribute("typelist", typelist);
		return "index";
	}
	@RequestMapping("/searchBookByName")
	public String searchBookByName(Model model,String bookName) {
		List<Book> booklist= bookService.showSearchBook(bookName);
		model.addAttribute("booklist",booklist);
		return "userSearchBook";
	}
	@RequestMapping("/adminSearchBookByName")
	public String adminSearchBookByName(Model model,String bookName) {
		List<Book> booklist= bookService.showSearchBook(bookName);
		model.addAttribute("booklist",booklist);
		return "adminShowBookByName";
	}
	@RequestMapping("/adminUpdateBookById")
	public String adminUpdateBookById(Model model,Integer bookId) {
		Book book=bookService.selectById(bookId);
		model.addAttribute("book",book);
		return "adminUpdateBookById";
	}
	@RequestMapping("/showHotBook")
	public String showHotBook(Model model,Integer pageS) {
		Long totalCount =bookService.getCount();
		Paging paging = new Paging();
		Page page = paging.checkByPage(totalCount, pageS);
		//设置每页显示的条数
		page.setPagecount(6);
		page.setTotalpage();
		List<Book> booklist= bookService.LoadBookListByHot(page);
		List<BookType> typelist=bookService.getBookType();
		model.addAttribute("page",page);
		model.addAttribute("booklist", booklist);
		model.addAttribute("typelist", typelist);
		return "showHotBook";
	}
	
	
}
