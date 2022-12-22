package Mypack;

import java.io.BufferedInputStream;
import java.io.DataInputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;


    FileWriter fw;

    // constructor with port
    public Server(int port) {
        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("JustAPack.Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));


            String line = "";
            fw = new FileWriter("out.txt");
            //декларация нового текст файла


            // reads message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                    fw.write(line);
                    //теперь датаинпут вводится в текст файл
                    break;
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            fw.close();
            //закрыть поток файла
            // close connection
            socket.close();
            in.close();
            //close data input stream
        } catch (IOException i) {
            System.out.println(i);
        }
    }

}
