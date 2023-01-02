package booksList.method.model.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import booksList.method.model.vo.Book;
import booksList.method.model.vo.Favorites;

public class BookService {

	List<Book> bookList = new ArrayList<Book>();
	List<Favorites> favoritesList = new ArrayList<Favorites>();
	Scanner sc = new Scanner(System.in);
	static int favoritesCount = 0;
	
	public void display(){
		
		int input = 0;
	
		do {
			System.out.println(" - 도서 목록 프로그램 - ");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 조회");
			System.out.println("3. 도서 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 즐겨찾기 등록");
			System.out.println("6. 즐겨찾기 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호 입력 : ");
			
		try {
				input = sc.nextInt();
				switch(input) {
				case 1: addBook(); break;
				case 2: selectBook(); break;
				case 3: updateBook(); break;
				case 4: removeBook(); break;
				case 5: favorites(); break;
				case 6: favoritesRemove(); break;
				case 0: System.out.println("프로그램을 종료 합니다."); break;
				default : System.out.println("범위내의 숫자를 입력해주세요.");
				}
				
		} catch(Exception e) {
			sc.nextLine();
			input = -1;
			System.out.println("잘못된 입력입니다. 다시 입력해주세요");
			
		}
			
		} while(input != 0);
		
	}
	
	
	public void addBook() throws Exception{
		
		System.out.println("\n - 도서 등록 - ");
		
		System.out.print("제목 : ");
		String title = sc.next();
		sc.nextLine();
		
		System.out.print("작가 : ");
		String author = sc.next();
		sc.nextLine();
		
		System.out.print("가격 : ");
		String price = sc.next();
		sc.nextLine();
		
		System.out.print("출판사 : ");
		String publisher = sc.next();
		sc.nextLine();
		
		if(bookList.add(new Book(title, author, price, publisher))) {
			System.out.println("도서 등록이 완료 되었습니다.\n");
		} else {
			System.out.println("도서 등록에 실패하였습니다.");
		}
		
	}
	
	
	public void selectBook() {
		
		if(bookList.size() != 0) {
			System.out.println("\n - 도서 목록 조회 - ");
			
			for(Book list : bookList) {
				System.out.println(list);
				fileWriter();
				
			}
		} else {
			System.out.println("등록된 도서 목록이 없습니다!");
		}
	}
	
	
	public void updateBook() {
		System.out.println("\n - 도서 목록 수정 - ");
		selectBook();
		
		System.out.println("수정하실 도서의 제목을 입력해주세요");
		System.out.print("제목 : ");
		String title1 = sc.next();
		
		for(int i = 0; i < bookList.size(); i++) {
			if(title1.equals(bookList.get(i).getTitle())) {
				
				System.out.print(bookList.get(i).getTitle() + "의 도서정보를 수정 하시겠습니까?");
				System.out.print("(Y / N) : ");
				char ch = sc.next().toUpperCase().charAt(0);
				
				if(ch == 'Y') {
					System.out.println(bookList.get(i) + "의 도서 정보를 수정합니다.");
					
					System.out.print("제목 : ");
					String title = sc.next();
					
					System.out.print("작가 : ");
					String author = sc.next();
					
					System.out.print("가격 : ");
					String price = sc.next();
					
					System.out.print("출판사 : ");
					String publisher = sc.next();
					
					Book temp = bookList.set(i, new Book(title, author, price, publisher));
					
					System.out.println(temp.getTitle() + "의 도서 정보 수정이 완료되었습니다.");
					
					break;
					
					// 도서 정보 수정
					
				} else if(ch == 'N') {
					System.out.println("수정을 취소 하고 돌아갑니다.");
					break;
				}
				
				
			} else {
				System.out.println("도서의 정보가 없습니다.");
			}
			
		}
	}
		
		
	
	public void removeBook() {
		System.out.println("\n - 도서 목록 삭제 - ");
		
		selectBook();
		System.out.println("삭제하실 도서의 제목을 입력해주세요");
		
		System.out.print("제목 : ");
		String title = sc.next();
		
		for(int i = 0; i < bookList.size(); i++) {
			if(title.equals(bookList.get(i).getTitle())) {
				System.out.print(bookList.get(i).getTitle() + "의 도서정보를 정말 삭제 하시겠습니까?");
				
				System.out.print("(Y / N) : ");
				char ch = sc.next().toUpperCase().charAt(0);
				
				if(ch == 'Y') {
					Book temp = bookList.remove(i);
					System.out.println(temp.getTitle() + "의 도서 정보가 삭제 되었습니다..");
					break;
					
				} else if(ch == 'N') {
					System.out.println("삭제를 취소 하고 돌아갑니다.");
					break;
				}
			} else {
				System.out.println("일치하는 제목의 도서가 없습니다.");
			}
		}
		
	}
	
	
	public void favorites() {
		
		if(bookList.size() != 0) {
			System.out.println("\n - 즐겨찾기 추가 - ");
			selectBook();
			
			System.out.println("목록에서 즐겨찾기에 추가를 원하는 도서의 제목을 입력해주세요");
			
			System.out.print("제목 : ");
			String name = sc.next();
			sc.nextLine();
			
			for(int i = 0; i < bookList.size(); i++) {
				if(name.equals(bookList.get(i).getTitle())) {
					int bookNum = favoritesCount++;
					String title = bookList.get(i).getTitle();
					String author = bookList.get(i).getAuthor();
					
					if(favoritesList.add(new Favorites(bookNum, title, author))) {
						System.out.println(title + "의 도서가 즐겨찾기에 추가되었습니다.");
					}
					break;
				} else {
					System.out.println("제목을 다시 확인해주세요!");
				}
			}
		}
	}
	
	
	public void fileWriter() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("favorites.txt");
			
			for(Favorites f : favoritesList) {
				String str = f.toString();
				fw.write(str);
				
			}
			
		} catch(IOException e) {
			System.out.println("");
		} finally {
			
			try {
				fw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void favoritesRemove(){
		
		if(bookList.size() != 0) {
			System.out.println("\n - 즐겨찾기 삭제 - ");
			for(Favorites count : favoritesList) {
				System.out.print(count);
			}
			
			System.out.println("목록에서 즐겨찾기에 삭제를 원하는 도서의 제목을 입력해주세요");
			System.out.print("제목 : ");
			String name = sc.next();
			sc.nextLine();
		
			for(int i = 0; i < favoritesList.size(); i++) {
				if(name.equals(favoritesList.get(i).getTitle())) {
					Favorites str = favoritesList.remove(i);
					System.out.println(str.getTitle() + "의 도서정보를 즐겨찾기에서 삭제 했습니다.");
					break;
				} else {
					System.out.println("도서의 제목을 다시 확인해주세요!");
				}
			}
			
		}else {
			System.out.println("즐겨찾기에 등록된 정보가 없습니다.");
		}
	}
	
	
	
}
