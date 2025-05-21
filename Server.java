package client_server;

import java.net.*;
import java.io.*;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.print("\nListening on port 4444\n");
        }
        catch (IOException e) {
            System.err.println("\nCould not listen on port: 4444.");
            System.exit(-1);
        }
        while (listening) {
            // when a new client connects, a new thread is created
            new Thread (new ClientHandler (serverSocket.accept())).start();
            System.out.println("\nbird. \nClient connected  on "+serverSocket.getInetAddress());
        }
        
        serverSocket.close();
    }
}