package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name ="book_description")
	private String bookDescription;
	
	@Column(name= "price")
	private Double price;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	public Book() {} 

	public Book(int id, String name, String description, Double price, String isbn, int quantity) {
		this.id = id;
		this.bookName = name;
		this.bookDescription = description;
		this.price = price;
		this.isbn = isbn;
		this.quantity = quantity;
	}

	public Book(String name, String description, Double price, String isbn, int quantity) {
		this.bookName = name;
		this.bookDescription = description;
		this.price = price;
		this.isbn = isbn;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return bookName;
	}

	public void setName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return bookDescription;
	}

	public void setDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookDescription == null) ? 0 : bookDescription.hashCode());
		result = prime * result + id;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookDescription == null) {
			if (other.bookDescription != null)
				return false;
		} else if (!bookDescription.equals(other.bookDescription))
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + bookName + ", description=" + bookDescription + ", price=" + price + ", isbn="
				+ isbn + ", quantity=" + quantity + "]";
	}

}
