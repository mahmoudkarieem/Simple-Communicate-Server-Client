/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kanare
 */
public class Client {

   
    public static void main(String[] args) {
        // TODO code application logic here
        new Client();
    }
    Socket mySocket;
    DataInputStream dis;
    PrintStream pis;
    
    public Client(){
        try {
            mySocket= new Socket(InetAddress.getLocalHost(),5005);
            dis= new DataInputStream(mySocket.getInputStream());
            pis= new PrintStream(mySocket.getOutputStream());
            pis.println("Test Test");
            String replyMSg=dis.readLine();
            System.out.println(replyMSg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        try {
            mySocket.close();  pis.close();
        dis.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
