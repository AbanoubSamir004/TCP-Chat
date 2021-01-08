//Name:Abanoub Samir Gergis 
//ID: 20190001
//Group: G.17package com.mycompany.tcp_chat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    Server(){
        try { 
            ServerSocket server= new ServerSocket(22000);
            while(true){
                Socket Client= server.accept();
                DataInputStream ClientReadSource= new DataInputStream(Client.getInputStream()) ;//INPUT
                DataOutputStream ClientWriteSource= new DataOutputStream(Client.getOutputStream()) ;//OUTPUT 
                while(true){
                    ClientWriteSource.writeUTF("You are Connected but not for long");
                    ClientWriteSource.writeUTF("you can only ask me once");

                    String str= ClientReadSource.readUTF();
                    System.out.println("Client Said: " + str);
                    if(str.equalsIgnoreCase("exit")){
                        break;
                    }
                    ClientWriteSource.writeUTF("we have no any services right now, goodbye");
                }
                ClientWriteSource.close();
                ClientReadSource.close();
                Client.close();
            }   
        }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
