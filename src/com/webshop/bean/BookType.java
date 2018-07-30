package com.webshop.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class BookType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer typeId;
	private String typeName;
	@OneToMany(mappedBy="bookType", targetEntity=Book.class,cascade=CascadeType.ALL)
	private Set<Book> bookSet=new HashSet<Book>();
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
