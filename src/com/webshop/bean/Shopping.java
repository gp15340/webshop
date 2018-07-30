package com.webshop.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Shopping {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shoppingId;
	@ManyToOne               
	@JoinColumn(name="cartId")
	private ShoppingCart cart;
	private int bookId;
	private String bookName;
	private double bookPrice;
	private String bookImgUrl;
	private int number;
	private double total;
	public int getShoppingId() {
		return shoppingId;
	}
	public void setShoppingId(int shoppingId) {
		this.shoppingId = shoppingId;
	}
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getBookImgUrl() {
		return bookImgUrl;
	}
	public void setBookImgUrl(String bookImgUrl) {
		this.bookImgUrl = bookImgUrl;
	}
	
}
