package client_server;

import java.net.*;
import java.util.StringTokenizer;
import java.io.*;

public class ClientHandler implements Runnable
{
  private Socket client;

  public ClientHandler (Socket c)
  {
    client = c;
  }

  public void run ()
  {
    BufferedReader clientIn = null;
    PrintWriter clientOut = null;
    String input = null;

    try
    {
      // create new input stream from client
      // create new output stream to client 
      clientIn = new BufferedReader (new InputStreamReader (client.getInputStream ()));
      clientOut = new PrintWriter (client.getOutputStream (), true);
    }
    catch (Exception e)
    {
      e.printStackTrace ();
    }
    System.out.println();
    do
    {      
      try
      {
        // receives client input (type: String)
        // input SHOULD BE in form : operator operand operand
        // example: + 2 3
        // BUG: any other input will not work
        input = clientIn.readLine ();
        
        // Input String gets split by each character
        StringTokenizer st = new StringTokenizer(input);
        String operator = st.nextToken();
        float term1 = Float.parseFloat(st.nextToken());
        float term2 = Float.parseFloat(st.nextToken());

        float result = -9999; // default value
        String equals = " = ";

        System.out.println("Calculating...");

        // Switch-Case : 
        // takes the operator and does corresponding calculation
        // result is assigned to variable
        switch (operator) {
            case "+":
                result = term1 + term2;
                break;
            case "-":
                result = term1 - term2;
                break;
            case "*":
                result = term1 * term2;
                break;
            case "/":
                result = (float) (term1 / term2);
                break;       
            default:
                // sends message to server when unexpected operator is received
                System.out.println("Something went wrong.");
                break;
        }

        clientOut.println(term1 + " " +operator +" " +term2 + equals + result + "       -[" + Thread.currentThread().getName() + "]");

      } 
      catch (Exception e)
      {
        e.printStackTrace ();
      }
    }
    while (! input.equals ("END"));

    try
    {
      clientIn.close ();
      clientOut.close ();
      client.close ();
    }
    catch (Exception e)
    {
      e.printStackTrace ();
    }
  }
}