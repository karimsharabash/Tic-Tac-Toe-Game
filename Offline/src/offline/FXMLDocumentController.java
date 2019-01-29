/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author karim
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Region regionTwo;
    @FXML
    private Region regiontwo;
    @FXML
    private Region regionFour;
    @FXML
    private Region regionFive;
    @FXML
    private Region regionSix;
    @FXML
    private Region regionSeven;
    @FXML
    private Region regionEight;
    @FXML
    private Region regionnine;
    @FXML
    private Rectangle regionOne;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
