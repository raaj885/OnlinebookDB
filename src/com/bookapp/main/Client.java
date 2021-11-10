package com.bookapp.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookImpl;
import com.bookapp.dao.BookInter;
import com.bookapp.dao.ModelDAO;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class Client {
	public static void main(String[] args) throws AuthorNotFoundException, CategoryNotFoundException, BookNotFoundException{
		
//		String createTable = "create table Books(title varchar(20),authorName varchar(20),category varchar(20),bookId integer, price integer)";
//		
//		Connection connection = ModelDAO.openConnection(); 
//		PreparedStatement statement; 
//		try{ 
//			statement = connection.prepareStatement(createTable);
//			statement.execute();
//		    System.out.println("Table created"); 
//		  }
//		catch (SQLException e) {
//		  e.printStackTrace(); }
		int select = 0, bookid = 0, price = 0;
		String title, author, category,  categoryfind;
		
		
		BookInter bookInter = new BookImpl();
		Scanner sc= new Scanner(System.in);
		
		
		System.out.println("To Add Books press 1" + "\n" 
								+ "To Filter Books by Author press 2" + "\n" 
								+"To Filter Books by Category press 3"+ "\n"
								+"To Filter Books by Id press 4"+ "\n"
									+ "To Update Books press 5"+ "\n" 
										+ "To Delete Books press 6");
		
		int choice=sc.nextInt();
		
		switch(choice) {
		
		case 1:
			System.out.println("Number of books to add in Database");
			int noOfBooks= sc.nextInt();
			
		for ( int i = 0; i < noOfBooks; i++) {
			
			
			sc.nextLine();
			System.out.println("Enter the Title of Book");
			title = sc.nextLine();
			
			System.out.println("Enter the Name of the Author");
			author = sc.nextLine();
			
			System.out.println("Enter the Category of Book");
			category = sc.nextLine();
			
			System.out.println("Enter the BookId");
			bookid = sc.nextInt();
			
			System.out.println("Enter the Book Price");
			price = sc.nextInt();
			
			Book book = new Book(title, author, category, bookid, price);
			bookInter.addBook(book);
			break;
			
		}	
		
		break;
		
		case 2:
			
			System.out.println("Enter Author name: ");
			sc.nextLine();
			String authorName= sc.nextLine();
			bookInter.getBookbyAuthor(authorName);
			break;
			
		case 3:
			
			System.out.println("Enter Category: ");
			sc.nextLine();
			 category= sc.nextLine();
			bookInter.getBookbycategory(category);
			break;
		case 4:
			
			System.out.println("Enter Book Id: ");
			sc.nextLine();
			 bookid= sc.nextInt();
			bookInter.getBookById(bookid);
			break;
			
		case 5:
			System.out.println("Enter book Id to update");
			int updateId = sc.nextInt();
			
			System.out.println("Enter updated Price");
			int updatedprice = sc.nextInt();
			
			bookInter.updateBook(updateId, updatedprice);
			
			bookInter.getAllBooks();
			break;
			
		case 6 :
			System.out.println("Enter book Id to delete");
			int deleteId = sc.nextInt();
			
			
			
			bookInter.deleteBook(deleteId);
			
			bookInter.getAllBooks();
			break;
			
		default:
			System.out.println("Input invalid ");
			
			
			
	}
		sc.close();

  }
}
