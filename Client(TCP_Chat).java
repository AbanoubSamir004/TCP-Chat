//Name:Abanoub Samir Gergis 
//ID: 20190001
//Group: G.17
package com.mycompany.tcp_chat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    Client(){
        try {
            InetAddress ip= InetAddress.getLocalHost();
            System.out.println(ip);
            Socket other= new Socket(ip, 22000);
            
            Scanner scan= new Scanner(System.in);
            DataInputStream otherReadSource= new DataInputStream(other.getInputStream()) ;//INPUT
            DataOutputStream otherWriteSource= new DataOutputStream(other.getOutputStream()) ;//OUTPUT 
            
            String str= "";
            while(true){
                str=otherReadSource.readUTF();
                System.out.println(str);
                str=otherReadSource.readUTF();
                 System.out.println(str);

                str=scan.nextLine();
                otherWriteSource.writeUTF(str);
                if(str.equalsIgnoreCase("exit")){
                    break;
                }
                str=otherReadSource.readUTF();
                System.out.println(str);
            }
            otherReadSource.close();
            otherWriteSource.close();
            other.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
