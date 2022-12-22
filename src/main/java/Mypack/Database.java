package Mypack;

import java.sql.*;
import java.sql.DriverManager;



public class Database {


    //public static void main(String [] args){
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    private String table;

    public Database() {

    }

    public Connection getConn() {
        return conn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public Statement getStmt() {
        return stmt;
    }



    public ResultSet ConnectDatabase(Statement stmt, Connection conn, ResultSet rs) {

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/PCStore",
                    "root",
                    "TroyisAbedandAbedisTroy!@#"
            );
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
            return null;
        }

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + table);

            // Iterate through the result set and print the data

            return rs;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public void CloseDatabase() {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



