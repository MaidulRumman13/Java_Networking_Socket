
package Final_SE_410.Networking;

import java.net.*;
import java.io.*;

public class MyServer
{
   public static void main(String[] args) {
       try {
           ServerSocket sos = new ServerSocket(6666);
           //establish the connection
           Socket soc = sos.accept();

           ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
           String str = (String)ois.readUTF();
           
           System.out.println("message= "+str);
                   

           sos.close();
       } catch (Exception e) {
           //TODO: handle exception
           System.out.println(e);
       }
   } 
}