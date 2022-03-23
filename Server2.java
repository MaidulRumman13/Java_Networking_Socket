package Final_SE_410.Networking;

import java.io.*;
import java.net.*;

public class Server2 {

    public static void main(String[] args) throws Exception {
        // Create server Socket
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("Server started");
        System.out.println("Waiting for a client ...");
        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");
        // to send data to the client
        PrintStream ps = new PrintStream(s.getOutputStream());
        // to read data coming from the client
        DataInputStream br= new DataInputStream(new BufferedInputStream(s.getInputStream()));
        // to read data from the keyboard
        DataInputStream kb = new DataInputStream(System.in);
        // server executes continuously
        while (true) {
            String str, str1;
            // repeat as long as the client
            // does not send a null string
            // read from client
            while ((str = br.readLine()) != null) {
                System.out.println("Client: "+str);
                str1 = kb.readLine();
                // send to client
                ps.println(str1);
            }
            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();

            // terminate application
            System.exit(0);

        } // end of while
    }
}
