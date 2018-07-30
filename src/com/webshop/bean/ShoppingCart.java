package com.webshop.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	@OneToOne(cascade=CascadeType.ALL)               
	@JoinColumn(name="userId") 
	private User user;
	@OneToMany(mappedBy="cart", targetEntity=Shopping.class,cascade=CascadeType.ALL)
	private Set<Shopping> shopping;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Shopping> getShopping() {
		return shopping;
	}
	public void setShopping(Set<Shopping> shopping) {
		this.shopping = shopping;
	}
	
	
	
	
	
}
