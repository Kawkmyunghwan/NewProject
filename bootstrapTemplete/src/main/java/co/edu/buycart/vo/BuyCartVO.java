package co.edu.buycart.vo;

import java.util.Arrays;

public class BuyCartVO {
	private String id;
	private String bookId;
	private String bookName;
	private String bookCompany;
	private String image;
	private int bookPrice;
	private String bookBuyDate;
	
	public String getBookBuyDate() {
		return bookBuyDate;
	}
	public void setBookBuyDate(String bookBuyDate) {
		this.bookBuyDate = bookBuyDate;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCompany() {
		return bookCompany;
	}
	public void setBookCompany(String bookCompany) {
		this.bookCompany = bookCompany;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	@Override
	public String toString() {
		return "BuyCartVO [id=" + id + ", bookId=" + bookId + ", bookName=" + bookName + ", bookCompany=" + bookCompany
				+ ", image=" + image + ", bookPrice=" + bookPrice + "]";
	}
	
	
	

	
	
	
	
}
