//Name:Abanoub Samir Gergis 
//ID: 20190001
//Group: G.17
package com.mycompany.tcp_chat;
import java.util.Scanner;
public class Starter {
    public static void main (String[] args){
         Scanner scan= new Scanner(System.in);
         if(scan.next().equals("server")){
             //code server
             Server s=new Server();
         }
         else{
             //code client
             Client c = new Client();
         }
    }
}
