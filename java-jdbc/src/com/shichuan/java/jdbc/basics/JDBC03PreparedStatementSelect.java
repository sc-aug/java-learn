package com.shichuan.java.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC03PreparedStatementSelect {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String UNAME = "root";
    private static final String PWD = "chuan";

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try{
            con = DriverManager.getConnection(URL, UNAME, PWD);
            String query = "SELECT * FROM EmpInfo WHERE EmpId = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, 2); // Search Employee with ID = 2 
            rs = pstmt.executeQuery();
            while(rs.next())  
                System.out.println(
                		"ID:" + rs.getInt(1)
                		+ "  Name:" + rs.getString(2)
                		+ "  Salary:" + rs.getFloat(3)
                		+ "  Address:" + rs.getString(4));
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
