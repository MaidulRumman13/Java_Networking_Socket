package Final_SE_410.Networking;

import java.io.*;
import java.net.*;

public class ServerQ {

    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(6600);
        System.out.println("Server started");
        System.out.println("Waiting for a client ...");
        Socket s = ss.accept();
        System.out.println("Connection established");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "", str2 = "";
        while (!str.equals("exit")) {
            str = din.readUTF();
            System.out.println("Client: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}
