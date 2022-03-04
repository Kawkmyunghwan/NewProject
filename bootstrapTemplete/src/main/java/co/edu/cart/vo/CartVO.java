package co.edu.cart.vo;

public class CartVO {
	private String bookId;
	private String bookName;
	private int bookPrice;
	private int bookQuantity;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
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
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	
	@Override
	public String toString() {
		return "CartVO [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookQuantity="
				+ bookQuantity + "]";
	}
	
	
}
