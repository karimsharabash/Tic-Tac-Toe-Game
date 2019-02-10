/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclientv.pkg1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Takwa
 */
public class GameClientV1 extends Application {

    Socket socket;
    DataInputStream dis;
    PrintStream ps;

    @Override
    public void start(Stage primaryStage) {
        try {
            socket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(socket.getInputStream());
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.printf("Start fun in client exception ");
        }

       Parent root = new Online_offlineBase(this,primaryStage);
        Scene scene = new Scene(root,660,400);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

   @Override
    public void stop() throws IOException {
        System.out.println("Stop");
        // Platform.exit();
        ps.close();
        dis.close();
        socket.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
