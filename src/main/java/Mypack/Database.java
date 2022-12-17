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




      /*  public void start() {
            try {
                serverSocket = new ServerSocket(5000);
                while (true) {
                    // Accept an incoming connection
                    Socket clientSocket = serverSocket.accept();
                    // Add the socket to the list of client sockets
                    clientSockets.add(clientSocket);

                    // Start a new thread to handle communication with the client
                    new Thread(new ClientHandler(clientSocket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Close the server socket and the database connection
                try {
                    serverSocket.close();
                    conn.close();
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        private class ClientHandler implements Runnable {
            private Socket clientSocket;

            public ClientHandler(Socket clientSocket) {
                this.clientSocket = clientSocket;
            }

            @Override
            public void run() {
                try {
                    // Get the input and output streams from the socket
                    BufferedReader in = new BufferedReader(new InputStreamReader());

            }
        }
        }
    }
    */

