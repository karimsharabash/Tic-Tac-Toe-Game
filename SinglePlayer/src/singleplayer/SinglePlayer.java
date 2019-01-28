/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author karim
 */
public class SinglePlayer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root =new FXMLDocumentBase();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    /*     regionTwo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "This is Karim's NotaPad", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
                  ImageView img = new ImageView(new Image("red.png"));
               regionOne.getChildren().add(img);

            }
        });*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
