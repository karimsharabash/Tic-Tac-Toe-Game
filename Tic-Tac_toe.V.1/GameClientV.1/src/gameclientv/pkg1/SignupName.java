package gameclientv.pkg1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignupName extends AnchorPane {

    protected final ImageView imageView;
    protected final TextField NameTxtField;
    protected final TextField PassTxtField;
    protected final Label label;
    protected final Label label0;
    protected final ImageView back_pane;
    protected final Pane SubmitPane;
    protected final ImageView imageView1;
    protected final Pane ResetPane;
    protected final ImageView imageView2;
    protected final ImageView imageView3;

    static String oldSignUserName;
    static boolean userSignFlag=false;
    
    public SignupName(GameClientV1 client, Stage primaryStage) {

        imageView = new ImageView();
        NameTxtField = new TextField();
        PassTxtField = new TextField();
        label = new Label();
        label0 = new Label();
        back_pane = new ImageView();
        SubmitPane = new Pane();
        imageView1 = new ImageView();
        ResetPane = new Pane();
        imageView2 = new ImageView();
        imageView3 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(371.0);
        setPrefWidth(585.0);

        imageView.setFitHeight(379.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutX(-7.0);
        imageView.setLayoutY(-4.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("taqwa.jpeg").toExternalForm()));

        NameTxtField.setLayoutX(155.0);
        NameTxtField.setLayoutY(116.0);
        NameTxtField.setPrefHeight(25.0);
        NameTxtField.setPrefWidth(222.0);
        NameTxtField.setPromptText("Enter Your Name...");
        NameTxtField.setFont(new Font(16.0));

        PassTxtField.setAccessibleRole(javafx.scene.AccessibleRole.PASSWORD_FIELD);
        PassTxtField.setLayoutX(155.0);
        PassTxtField.setLayoutY(201.0);
        PassTxtField.setPrefHeight(25.0);
        PassTxtField.setPrefWidth(222.0);
        PassTxtField.setPromptText("Enter Your Password...");
        PassTxtField.setFont(new Font(16.0));

        label.setLayoutX(32.0);
        label.setLayoutY(110.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(109.0);
        label.setText("Username");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ebdddd"));
        label.setFont(new Font(20.0));

        label0.setLayoutX(32.0);
        label0.setLayoutY(198.0);
        label0.setPrefHeight(30.0);
        label0.setPrefWidth(157.0);
        label0.setText("Password");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#ebdddd"));
        label0.setFont(new Font(20.0));

        back_pane.setFitHeight(47.0);
        back_pane.setFitWidth(43.0);
        back_pane.setLayoutX(7.0);
        back_pane.setLayoutY(8.0);
        back_pane.setPickOnBounds(true);
        back_pane.setPreserveRatio(true);
        back_pane.setImage(new Image(getClass().getResource("img/back.png").toExternalForm()));
        back_pane.setCursor(Cursor.HAND);

        SubmitPane.setLayoutX(332.0);
        SubmitPane.setLayoutY(276.0);

        imageView1.setFitHeight(32.0);
        imageView1.setFitWidth(102.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("img/submit.gif").toExternalForm()));
        imageView1.setCursor(Cursor.HAND);

        ResetPane.setLayoutX(442.0);
        ResetPane.setLayoutY(274.0);

        imageView2.setFitHeight(52.0);
        imageView2.setFitWidth(102.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("img/reset.gif").toExternalForm()));
        imageView2.setCursor(Cursor.HAND);

        imageView3.setFitHeight(50.0);
        imageView3.setFitWidth(133.0);
        imageView3.setLayoutX(219.0);
        imageView3.setLayoutY(17.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("img/signup.gif").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(NameTxtField);
        getChildren().add(PassTxtField);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(back_pane);
        SubmitPane.getChildren().add(imageView1);
        getChildren().add(SubmitPane);
        ResetPane.getChildren().add(imageView2);
        getChildren().add(ResetPane);
        getChildren().add(imageView3);

        back_pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new Select_Login_SignupBase(client, primaryStage);
                Scene scene = new Scene(root);
                
                primaryStage.setScene(scene);
            }
        });
         SubmitPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                  String TextfieldContent = PassTxtField.getText();
                    if (TextfieldContent != null) {
                        client.ps.println("sp:" + TextfieldContent);
                    }
                if (userSignFlag == true) {
                        Select_Login_SignupBase.signUp(client, primaryStage);
                    } else {
                     
                    Select_Login_SignupBase.alertMsg("enter right username ");
                }
           

            }
        });

        ResetPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                LoginNamePageBase second = new LoginNamePageBase(client, primaryStage);
                Scene scene = new Scene(second);
                primaryStage.setScene(scene);

            }
        });

        NameTxtField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    String TextfieldContent = NameTxtField.getText();
                    if (!TextfieldContent.equals("") &&!TextfieldContent.equals(oldSignUserName)){
                        oldSignUserName=TextfieldContent;
                        client.ps.println("s:" + TextfieldContent);
                    }

                }
            }

        });
        /*PassTxtField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    String TextfieldContent = PassTxtField.getText();
                    if (TextfieldContent != null) {
                        client.ps.println("sp:" + TextfieldContent);
                    }
                }
            }

        });*/
    }
}
