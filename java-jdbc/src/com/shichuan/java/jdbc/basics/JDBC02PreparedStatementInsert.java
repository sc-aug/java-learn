package com.shichuan.java.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC02PreparedStatementInsert {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String UNAME = "root";
    private static final String PWD = "chuan";

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        try{
            con = DriverManager.getConnection(URL, UNAME, PWD);
            String query = "INSERT INTO EmpInfo VALUES (NULL,?,?,NULL)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "Dummy Guy");
            pstmt.setFloat(2, 100f);
            if (pstmt.executeUpdate() > 0) {
                System.out.println("success");
            } else {
            		System.out.println("failed");
            }
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
