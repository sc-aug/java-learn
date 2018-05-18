package com.shichuan.java.jdbc.basics;

import java.sql.*;

public class JDBC01Statement {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String UNAME = "root";
    private static final String PWD = "chuan";

    public static void main(String[] args) {
        try {  
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, UNAME, PWD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EmployeeDB.EmpInfo");  
            while(rs.next())
                System.out.println(rs.getInt(1)
                		+ "  " + rs.getString(2)
                		+ "  " + rs.getDouble(3));
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
