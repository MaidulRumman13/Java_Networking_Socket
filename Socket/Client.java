package Final_SE_410.Socket;

import java.net.*;
import java.io.*;

public class Client {
    // initialize socket and import outputs streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put IP address and port
    public Client(String address, int port)
    {
        // establish Connection
        try {
            {
                socket = new Socket(address, port);
                System.out.println("Connected.");

                // takes input from tarminal
                input = new DataInputStream(System.in);

                // sends output to the socket
                out = new DataOutputStream(socket.getOutputStream());
            }
        } catch (UnknownHostException u) {
            //TODO: handle exception
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        // String to read message from input tab
        String line = "";

        // keep reading until "Bye" is displayed on the screen
        while (!line.equals("Bye")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                //TODO: handle exception
                System.out.println(i);
            }
        }
        
        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            //TODO: handle exception
            System.out.println(i);
        }
    }
    public static void main(String  args[]) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
