/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author karim
 */
public class Offline extends Application {
    
@Override
    public void start(Stage stage) throws Exception {
        Parent root =new FXMLDocumentBase();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}

class OfflineGame extends Game
{
    public static int computerPlay( )
    {
        boolean found =true ; 
        int comuPlace=0;
        
        while(found)
        {
         comuPlace=(int)(Math.random()*9)+1 ;
         if(!contains(places, comuPlace))
         {
          found =false;   
         }
        }
        return comuPlace;
    }
}
