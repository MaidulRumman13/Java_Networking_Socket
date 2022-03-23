
package Final_SE_410.Networking;

import java.net.*;
import java.io.*;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket soc= new Socket("localhost", 6666);
            ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
            out.writeUTF("Hello Server");
            out.flush();
            out.close();
            soc.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}