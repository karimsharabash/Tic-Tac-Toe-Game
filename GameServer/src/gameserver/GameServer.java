/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karim
 */
public class GameServer {

    ServerSocket serverSocket;

    public GameServer() {
        try {
            serverSocket = new ServerSocket(5005); //define the port of the server
            while (true) {
                Socket s = serverSocket.accept(); //accept is a blocking function that return socket object
                new gamerHandler(s);
            }
        } catch (IOException ex) {
            System.out.println("there is no client");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new GameServer();
        String[] users;
        users = new String[10];

    }

}

class gamerHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static Vector<gamerHandler> clientsVector = new Vector();
    static Vector<String> Username = new Vector();
    String userName;
    boolean playing = false;
    Socket mysoc;

    public gamerHandler(Socket cs) {
        mysoc = cs;
        try {
            dis = new DataInputStream(cs.getInputStream()); //reading from the client
            ps = new PrintStream(cs.getOutputStream()); //writting to the clients

            clientsVector.add(this);
            start();
        } catch (IOException ex) {
            System.out.println("the client is offline ");
        }
    }

    @Override
    public void run() {
        while (true) {

            try {
              
                if (!playing) {
                   String  msg = dis.readLine();
                
                
                System.out.println("incoming " + msg);

                directMsg(msg);
                }
            } catch (IOException ex) {
                stop();
            }

        }
    }

    void sendMessageToAll() {

        for (gamerHandler ch : clientsVector) {
            ch.ps.println("start"); // to to update the list 
            for (gamerHandler gh : clientsVector) {
                if (gh.userName != null) // for connected clients but without entering his user name
                {
                    ch.ps.println(gh.userName);
                }
            }
        }
    }

    public void directMsg(String user) throws IOException {
        String pass;

        boolean finish = false;
        String[] incommingMsg;
        if (user != null) {
            incommingMsg = user.split(":");
            switch (incommingMsg[0]) {
                case "s": //this is sign up verfication  
                    System.out.println("register " + incommingMsg[1] + " if not already existed");
                    pass = dis.readLine();
                    System.out.println(incommingMsg[1] + " pass is " + pass);

                    break;
                case "l": // login verfication  
                    System.out.println(incommingMsg[1] + " want to login");
                    pass = dis.readLine();
                    System.out.println(incommingMsg[1] + " pass is " + pass);
                    userName = incommingMsg[1];
                    sendMessageToAll();

                    break;
                case "p":
                    System.out.println(userName + " want to play with " + incommingMsg[1]);
                    //here the code for playing with other player
                     break;
                default:
            }
        } else {
            userName = null; // to prevent this user from printing 
            sendMessageToAll();
            stop();

        }
    }
}
