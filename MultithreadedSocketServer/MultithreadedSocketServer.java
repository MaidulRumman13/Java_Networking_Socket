package Final_SE_410.Networking;

import java.net.*;
import java.io.*;
public class MultithreadedSocketServer {
  public static void main(String[] args) throws Exception {
    try{
      ServerSocket server=new ServerSocket(8888);
      int counter=0;
      System.out.println("Server Started ....");
      while(true){
        counter++;
        Socket serverClient=server.accept();  //server accept the client connection request
        System.out.println(" >> " + "Client No:" + counter + " started!");
        ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
        sct.start();
      }
    }catch(Exception e){
      System.out.println(e);
    }
  }
}

class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
    int squre;

    ServerClientThread(Socket inSocket, int counter) {
        serverClient = inSocket;
        clientNo = counter;
    }

    public void run() {
        try {
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage = "", serverMessage = "";
            while (!clientMessage.equals("bye")) {
                clientMessage = inStream.readUTF();
                System.out.println("From Client-" + clientNo + ":  " + clientMessage);
                System.out.println("Enter Your Message :");
                serverMessage = br.readLine();
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }
            inStream.close();
            outStream.close();
            serverClient.close();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
}
