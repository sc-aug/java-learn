package com.shichuan.java.jdbc.practice.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/BookShelfDB";
    private static final String UNAME = "root";
    private static final String PWD = "chuan";

    static {
	    	try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnectionObject() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, UNAME, PWD);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
    
    public static PreparedStatement getPreparedStatement(Connection con, String sql) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ps;
	}
    
    public static ResultSet getResult(PreparedStatement ps) {
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
    
    public static int executeUpdate(PreparedStatement ps) {
		int i = -1;
		try {
			i = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

    public static void closeDbResources(Connection con) {
		try {
			if(con!= null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
    
	public static void closeDbResources(Connection con, PreparedStatement ps) {
		try {
			if(ps!=null)
				ps.close();
			if(con!= null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeDbResources(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(con!= null)
				con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
