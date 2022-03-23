package Final_SE_410.Networking;

import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) throws Exception{
        // Create Client Socket
        Socket soc= new Socket("localhost", 6666);
        // Send the data to server
        DataOutputStream out = new DataOutputStream(soc.getOutputStream());
        // Read the data coming from server
        DataInputStream dat= new DataInputStream(new BufferedInputStream(soc.getInputStream()));
        // Read the data from terminal 
        DataInputStream inp = new DataInputStream(System.in);
        //  Over to exit
        String str1, str2;
        while(!(str1= inp.readLine()).equals("exit")){
            // send to server
            out.writeUTF(str1 + "\n");
            // Receive data from server
            str2 =dat.readLine();
            
            System.out.println("Server: "+str2);
        }
        // close the connection
        out.close();
        dat.close();
        inp.close();
        soc.close();
    }
}
