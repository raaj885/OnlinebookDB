package com.bookapp.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookImpl implements BookInter {
	
	
	Scanner input = new Scanner(System.in);
	
	@Override
	public void addBook(Book book) {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement("insert into books values(?,?,?,?,?)");
			st.setString(1, book.getTitle());
			st.setString(2, book.getAuthor());
			st.setString(3, book.getCategory());
			st.setInt(4, book.getBookid());
			st.setInt(5, book.getPrice());
			st.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
		
	}

	@Override
	public boolean deleteBook(int bookid) throws BookNotFoundException {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement("delete from books where bookId=? ");
			st.setInt(1, bookid);
			st.execute();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		// TODO Auto-generated method stub
		Connection connection =ModelDAO.openConnection();
		PreparedStatement st=null;
		try {
			st = connection.prepareStatement("select * from books where bookId=?");
			st.setInt(1, bookid);
			ResultSet resultset = st.executeQuery();
			if(resultset!=null) {
				while (resultset.next()) {
					String title = resultset.getString(1);
					String author = resultset.getString(2);
					String category = resultset.getString(3);
					int id = resultset.getInt(4);
					int price = resultset.getInt(5);
					System.out.println(title + "     " + author + "     " + category + "      " + id + "      " + price);
				}
			}
			
			else {
				throw new BookNotFoundException("Book not Found ");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	

	@Override
	public boolean updateBook(int bookid, int price) {
		Connection connection = ModelDAO.openConnection();
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement("update books set price=? where bookId =?");
			st.setInt(1, price);
			st.setInt(2, bookid);
			
			st.execute();
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book getAllBooks() {
		// TODO Auto-generated method stub
		Connection connection =ModelDAO.openConnection();
		PreparedStatement st=null;
		try {
			st = connection.prepareStatement("select * from books ");
			ResultSet resultset = st.executeQuery();
			while (resultset.next()) {
				String title = resultset.getString(1);
				String authorName = resultset.getString(2);
				String category = resultset.getString(3);
				int id = resultset.getInt(4);
				int price = resultset.getInt(5);
				System.out.println(title + "     " + authorName + "     " + category + "      " + id + "      " + price);
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Book getBookbyAuthor(String author) throws AuthorNotFoundException{
		// TODO Auto-generated method stub
		Connection connection =ModelDAO.openConnection();
		PreparedStatement st=null;
		try {
			st = connection.prepareStatement("select * from books where authorName=?");
			st.setString(1, author);
			ResultSet resultset = st.executeQuery();
			if(resultset!=null) {
			while (resultset.next()) {
				String title = resultset.getString(1);
				String authorName = resultset.getString(2);
				String category = resultset.getString(3);
				int id = resultset.getInt(4);
				int price = resultset.getInt(5);
				System.out.println(title + "     " + authorName + "     " + category + "      " + id + "      " + price);
			}
			
		}
			
			else {
				throw new AuthorNotFoundException("Author not Found ");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookbycategory(String category) throws CategoryNotFoundException{
		// TODO Auto-generated method stub
		
		Connection connection =ModelDAO.openConnection();
		PreparedStatement st=null;
		try {
			st = connection.prepareStatement("select * from books where category=?");
			st.setString(1, category);
			ResultSet resultset = st.executeQuery();
			if(resultset!=null) {
			while (resultset.next()) {
				String title = resultset.getString(1);
				String authorName = resultset.getString(2);
				String catagory = resultset.getString(3);
				int id = resultset.getInt(4);
				int price = resultset.getInt(5);
				System.out.println(title + "     " + authorName + "     " + catagory + "      " + id + "      " + price);
			}
			
		}
			
			else {
				throw new CategoryNotFoundException("category not Found ");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	


}
