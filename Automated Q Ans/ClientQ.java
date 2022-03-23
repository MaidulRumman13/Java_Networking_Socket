package Final_SE_410.Networking;

import java.io.*;
import java.net.*;

public class ClientQ {

    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 6600);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("exit")) {
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = din.readUTF();
            System.out.println("Server: " + str2);
        }

        dout.close();
        s.close();
    }
}
