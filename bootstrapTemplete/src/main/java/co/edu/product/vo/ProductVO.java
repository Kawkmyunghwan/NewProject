package co.edu.product.vo;

public class ProductVO {
	private String bookId;
	private String bookName;
	private int bookPrice;
	private String bookCompany;
	private String bookContent;
	private int bookNum;
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
	public String getBookCompany() {
		return bookCompany;
	}
	public void setBookCompany(String bookCompany) {
		this.bookCompany = bookCompany;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	
	@Override
	public String toString() {
		return "ProductVO [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookCompany="
				+ bookCompany + ", bookContent=" + bookContent + ", bookNum=" + bookNum + "]";
	}
	
	
	
	
	
	
}
