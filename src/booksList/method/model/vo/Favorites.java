package booksList.method.model.vo;

public class Favorites extends Book{

	public Favorites() {
		super();
	}
	
	public Favorites(int bookNum, String title, String author) {
		super.setBookNum(bookNum);
		super.setTitle(title);
		super.setAuthor(author);
	}
	

	@Override
	public String toString() {
		return "도서 등록 번호 : " + getBookNum() + ", 제목 : " + getTitle() + ", 작가 : " + getAuthor() + "\n";
	}
}
