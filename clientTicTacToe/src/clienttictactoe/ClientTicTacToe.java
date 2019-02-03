/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttictactoe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Cross
 */
public class ClientTicTacToe extends Thread implements connectableClient,PlayableClient, OtherClients{
    
    
String userName,Password;
  
    String localhost = "127.0.0.1";
    int port = 5005;
    Socket mySocket;
    static DataInputStream dis ;
    static DataOutputStream dos ;
    static PrintStream ps;
    Thread t1;
    int myMove, playerMOve;
    boolean status, S,l;

    public ClientTicTacToe() throws IOException {
        this.mySocket = new Socket(localhost, port);
        dos = new DataOutputStream(dos);
        dis = new DataInputStream(dis);
    }

    @Override
    public boolean check() {
        String check = dis.toString();
        if(check=="done")
        {
         status = true;
         return status ;
        }else{
         status = false;
         return status ;
       }
    }

    @Override
    public void sendPassward() {
        if(S==true){
    try {
        
        dos.writeBytes("S:"+Password);
    } catch (IOException ex) {
        Logger.getLogger(ClientTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
    }
        }else if (l==true)
        {
         try {
                dos.writeBytes("L:"+Password);
            } catch (IOException ex) {
                Logger.getLogger(ClientTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    @Override
    public void sendUserName ()
    {
       // dis   = new DataInputStream();
         if(S==true){
    try {
            dos.writeBytes("S:"+userName);
        } catch (IOException ex) {
            Logger.getLogger(ClientTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else if (l==true)
        {
         try {      
                dos.writeBytes("L:"+userName);
            } catch (IOException ex) {
                Logger.getLogger(ClientTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void start(Stage primaryStage) {
        TextField username = new TextField();
        TextField password = new TextField();
        Button loginBtn = new Button();
        Button regester = new Button();
        loginBtn.setText("LogIN");
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                l=true;
                S=false;
                userName=username.getText();
                sendUserName ();
                Password= password.getText();
                sendPassward();
            }
        });
        regester.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                S=true;
                l=false;
                userName=username.getText();
                sendUserName ();
                Password= password.getText();
                sendPassward();
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(regester);
        root.getChildren().add(loginBtn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("login page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void sendYourMove(int newPosition) {
    try {
        dos.write(newPosition);
    } catch (IOException ex) {
        Logger.getLogger(ClientTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public int getPlayerTwoMove() {
       int playerMove =0;
    try {
        playerMove = dis.read();
    } catch (IOException ex) {
        Logger.getLogger(ClientTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
    }
       return playerMove;
    }

    @Override
    public void getOnlineList(String[] onlineUsers) {

     StringTokenizer user = new StringTokenizer(onlineUsers[0],",");
        while (user.hasMoreTokens()) {  
         System.out.println(user.nextToken());  
     } 
    }

    @Override
    public void sendRequestToUser(String[] onlineUsers, int indexOfChosenOne) {
        

    }

    @Override
    public void recieveRequest() {

    }
    @Override   
    public void run()
    {
        recieveRequest();
    }
    
}
