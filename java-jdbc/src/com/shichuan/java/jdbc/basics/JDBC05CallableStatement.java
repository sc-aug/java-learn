package com.shichuan.java.jdbc.basics;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC05CallableStatement {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String UNAME = "root";
    private static final String PWD = "chuan";

    public static void main(String[] args) {
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try{
            con = DriverManager.getConnection(URL, UNAME, PWD);
            String query = "CALL GetEmpById(?)";
            cstmt = con.prepareCall(query);
            cstmt.setInt(1, 3);
            rs = cstmt.executeQuery();
            while(rs.next())  
                System.out.println(rs.getInt(1) + "  "
                        + rs.getString(2) + "  " + rs.getFloat(3));  
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
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
