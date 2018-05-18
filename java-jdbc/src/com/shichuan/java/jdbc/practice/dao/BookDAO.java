package com.shichuan.java.jdbc.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shichuan.java.jdbc.practice.beans.BookBean;
import com.shichuan.java.jdbc.practice.utils.DBUtil;

public class BookDAO implements IBookDAO {

	@Override
	public int addBook(BookBean book) {
		Connection con = null;
		PreparedStatement ps = null;
		int res = -1;
		
        String query = "INSERT INTO BookShelfDB.Book "
                + "VALUES (NULL,?,?,?,?,?)";
        try {
        		con = DBUtil.getConnectionObject();
			ps = DBUtil.getPreparedStatement(con, query);
			ps = con.prepareStatement(query);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getCategory());
			ps.setFloat(4, book.getPrice());
			ps.setInt(5, book.getPageNo());
			res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
	}

	@Override
	public int deleteBookById(int bookId) {
		Connection con = null;
		PreparedStatement ps = null;
		int res = -1;
        
		String query = "DELETE FROM BookShelfDB.Book WHERE Book_Id = ?";
        try {
        		con = DBUtil.getConnectionObject();
			ps = DBUtil.getPreparedStatement(con, query);
            ps.setInt(1, bookId);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        		DBUtil.closeDbResources(con, ps);
        }
        return res;
	}

	@Override
	public int updateBook(BookBean book) {
		Connection con = null;
		PreparedStatement ps = null;
		int res = -1;
        
        String query = "UPDATE Book SET "
                + "Book_Name = ?, Author = ?, Category = ?, "
                + "Price = ?, Page_No = ? WHERE Book_Id = ?;";
        try {
        		con = DBUtil.getConnectionObject();
	        ps = con.prepareStatement(query);
	        ps.setString(1, book.getBookName());
	        ps.setString(2, book.getAuthor());
	        ps.setString(3, book.getCategory());
	        ps.setFloat(4, book.getPrice());
	        ps.setInt(5, book.getPageNo());
	        ps.setInt(6, book.getBookId());
	        res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        		DBUtil.closeDbResources(con, ps);
        }
        return res;
	}

	@Override
	public List<BookBean> getAllBooks() {
		Connection con = null;
		PreparedStatement ps = null;
		List<BookBean> bl = new ArrayList<BookBean>();
        ResultSet rs = null;
        String query = "SELECT * FROM BookShelfDB.Book";
        try {
        		con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                bl.add(new BookBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getInt(6)));
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        		DBUtil.closeDbResources(con, ps, rs);
        }
        return bl;
	}

	@Override
	public BookBean getBookById(int bookId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BookBean book = null;
        String query = "SELECT * FROM BookShelfDB.Book WHERE Book_Id = ?";
        try {
        		con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, bookId);
            rs = ps.executeQuery();
            if (rs.next()) {
                book = new BookBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        		DBUtil.closeDbResources(con, ps, rs);
        }
        return book;
	}

}
