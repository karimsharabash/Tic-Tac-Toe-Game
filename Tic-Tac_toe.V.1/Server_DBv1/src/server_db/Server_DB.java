/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_db;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Takwa
 */
public class Server_DB {

    ServerSocket Ssocket;

    Server_DB() {
        try {
            Ssocket = new ServerSocket(5005);
            while (true) {
                Socket s = Ssocket.accept();
                new gamerHandler(s);
            }
        } catch (IOException ex) {
           System.out.println("no avaiable clients");
        }
    }

    public static void main(String[] args) {
        new Server_DB();
    }

}

class gamerHandler extends Thread {

    DataInputStream dis;  //input stream
    PrintStream ps;      //output stream
    String userName;
    String loginUserName;
    String signUpUserName;
    Socket Csocket;

    static Vector<gamerHandler> clientsVector = new Vector();
  //  static Vector<String> Username = new Vector();

    public gamerHandler(Socket cs) {
        Csocket = cs;
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
                String msg = dis.readLine();
                System.out.println("incoming " + msg);
              
                    directMsg(msg);
              
                // System.out.printf("msg is :\n",msg);

            } catch (IOException ex) {
                stop();
            }

        }
    }

    void sendMessageToAll() {

        for (gamerHandler ch : clientsVector) {
            ch.ps.println("start"); // to to update the list 
            for (gamerHandler gh : clientsVector) {
                if (gh.userName != null) // for connected clients but without entering his msg name
                {
                    ch.ps.println("op:"+gh.userName);
                    System.out.println("op:"+gh.userName);
                }

            }
        }

    }

    public void directMsg(String msg) throws IOException {
        System.out.println("start of direct msg");
        ValidateDB TestUser = new ValidateDB();
        String pass;
        String[] incommingMsg;

        if (msg != null) {
            incommingMsg = msg.split(":");
            switch (incommingMsg[0]) {
                case "s": //this is sign up verfication 

                    if (!TestUser.checkUsername(incommingMsg[1])) // true if name already exist so it can't register 
                    {
                        signUpUserName = incommingMsg[1];
                        System.out.println("register " + incommingMsg[1] + " if not already existed");
                        ps.println("s:a");
                    } else {
                        ps.println("s:n");
                        signUpUserName="";
                    }

                    break;
                case "sp":
                    if (!signUpUserName.equals("")) {
                        SignUp NewUser = new SignUp();
                        pass = incommingMsg[1];
                        NewUser.saveNewUser(signUpUserName, pass);
                    }
                    break;
                case "l": // login verfication  
                    System.out.println(incommingMsg[1] + " want to login");
                    loginUserName = incommingMsg[1];
                    if (TestUser.checkUsername(loginUserName)) 
                    {
                        ps.println("l:a");
                    } else {
                        ps.println("l:n");
                    }
                    break;
                case "lp":
                    pass = incommingMsg[1];
                    System.out.println(incommingMsg[1] + " pass is " + pass);

                  if (!(loginUserName.equals(""))) {
                        if (TestUser.checkUsername(loginUserName, pass)) {
                            ps.println("lp:a");
                            userName=loginUserName;
                                 sendMessageToAll();
                        } else {
                            ps.println("lp:n");
                        }
                   }
                    break;
                default:
            }
        } else {
            userName = null; // to prevent this msg from printing 
            sendMessageToAll();
            dis.close();
            ps.close();
            clientsVector.remove(this);
            stop();

        }
    }
}
