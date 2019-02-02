/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttictactoe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
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
public class ClientTicTacToe extends Thread implements connectableClient{
    
    
String userName,password;
  
    static Socket mySocket = null;
    static DataInputStream dis = null;
    static DataOutputStream dos = null;
    static PrintStream ps;
    Scanner scanner;
    boolean status;

    @Override
    public boolean check() {
        
         return status ;
       
    }

    @Override
    public void sendPassward() {
        
    }
    @Override
    public void sendUserName ()
    {
       // dis   = new DataInputStream();
        try {
            dos = new DataOutputStream(mySocket.getOutputStream());
            
            
        } catch (IOException ex){
            Logger.getLogger(ClientTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
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
                
                userName=username.getText();
            }
        });
        regester.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               userName=userName.password.getText();
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
    
}
