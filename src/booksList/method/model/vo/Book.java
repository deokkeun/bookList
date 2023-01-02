package booksList.method.model.vo;

public class Book {
	
	private int bookNum;
	private String title;
	private String author;
	private String price;
	private String publisher;
	
	public Book() {}
	
	public Book(String title, String author, String price, String publisher) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	
	
	@Override
	public String toString() {
		return title + "  " + author + "  " + price + "원  " + publisher;
	}
	

}
