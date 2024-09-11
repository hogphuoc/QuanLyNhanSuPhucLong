package models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class ConnecttoSQLServer {  
    private static final String dbName = "QuanLyNhanSu";
    private static final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=" + dbName + ";IntegratedSecurity=true;user=sa;password=123";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbURL);
    }
    
    public static Statement getStatement() throws SQLException {
        return DriverManager.getConnection(dbURL).createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }  
}
