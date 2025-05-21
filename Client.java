package client_server;

import java.io.*;
import java.net.*;

public class Client {

    // simple UI, printing out prompt
    private static void printOp() {
        System.out.println("\n_______________ Enter END to quit _______________");
        System.out.println("\nEnter expression in form [ operator num1 num2 ]");
        System.out.println("Choose from these operations: + - * /");
    }

    public static void main(String[] args) throws IOException {
        Socket server = null;
        PrintWriter serverOut = null;
        BufferedReader serverIn = null;
    try {
        // Creates new socket connection (ip,port)
        server = new Socket("localhost", 4444);

        // Creates new writer for data out from client to the server
        serverOut = new PrintWriter(server.getOutputStream(), true);

        // Creates new receiver for data in from server to client
        serverIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
    } catch (UnknownHostException e) {
        System.err.println("\nCan't find localhost.\n");
        return;
    } catch (IOException e) {
        System.err.println("\nIO Error on connection to localhost. Is server running?\n");
        return;
    }

    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String userInput;

    // all lines enclosed are performed
    // unless/until the user enters "END"
    do {
    // prints the UI and prompt for user to answer
    printOp();
    System.out.print("\nClient: ");

    // records user input according to the prompt (operator operand operand)
        userInput = stdIn.readLine();

    // if user enters "END", client quits and displays a closing message
    if (userInput.equals("END")){
        System.out.println("\nClient-Server Session Has Ended.\n");
        break;
    }

    // sends user input to server, server performs computations on this input
    serverOut.println(userInput);
    
    // data is received from the server and displayed to the user
    System.out.println("Server: " + serverIn.readLine ());
    } while(true);

    // sending & receiving data channel is closed
    // the connection to the server is closed
    serverOut.close();
    serverIn.close();
    server.close();
    }
}