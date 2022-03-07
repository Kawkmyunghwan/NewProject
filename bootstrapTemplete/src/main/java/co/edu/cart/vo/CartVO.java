package co.edu.cart.vo;

public class CartVO {
	private String bookId;
	private String id;
	private String bookName;
	private int bookPrice;
	private String bookCompany;
	private String image;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
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
	
	@Override
	public String toString() {
		return "CartVO [bookId=" + bookId + ", id=" + id + ", bookName=" + bookName + ", bookPrice=" + bookPrice
				+ ", bookCompany=" + bookCompany + ", image=" + image + "]";
	}
	
	
	
	
	

	
	
}
