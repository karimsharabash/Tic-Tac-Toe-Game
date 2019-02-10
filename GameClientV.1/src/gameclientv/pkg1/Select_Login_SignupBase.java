package gameclientv.pkg1;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Select_Login_SignupBase extends AnchorPane {

    protected final VBox vBox;
    protected final Pane pane;
    protected final ImageView LoginPane;
    protected final Pane pane0;
    protected final ImageView SignupPane;
    protected final ImageView back_pane;
    static ArrayList<String> onlinePlayer= new ArrayList<>();

    public Select_Login_SignupBase(GameClientV1 client, Stage primaryStage) {

        vBox = new VBox();
        pane = new Pane();
        LoginPane = new ImageView();
        pane0 = new Pane();
        SignupPane = new ImageView();
        back_pane = new ImageView();

        setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        setPrefHeight(365.0);
        setPrefWidth(596.0);
        getStylesheets().add("/gameclientv/pkg1/style.css");

        AnchorPane.setBottomAnchor(vBox, 0.0);
        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setRightAnchor(vBox, 0.0);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setId("AnchorPane");
        vBox.setPrefHeight(365.0);
        vBox.setPrefWidth(596.0);
        vBox.setSpacing(20.0);

        pane.setPrefHeight(173.0);
        pane.setPrefWidth(691.0);

        LoginPane.setFitHeight(64.0);
        LoginPane.setFitWidth(223.0);
        LoginPane.setLayoutX(202.0);
        LoginPane.setLayoutY(109.0);
        LoginPane.setPickOnBounds(true);
        LoginPane.setPreserveRatio(true);
        LoginPane.setImage(new Image(getClass().getResource("img/login.gif").toExternalForm()));
        LoginPane.setCursor(Cursor.HAND);

        pane0.setPrefHeight(200.0);
        pane0.setPrefWidth(200.0);

        SignupPane.setFitHeight(51.0);
        SignupPane.setFitWidth(156.0);
        SignupPane.setLayoutX(214.0);
        SignupPane.setLayoutY(20.0);
        SignupPane.setPickOnBounds(true);
        SignupPane.setPreserveRatio(true);
        SignupPane.setImage(new Image(getClass().getResource("img/signup.gif").toExternalForm()));
        SignupPane.setCursor(Cursor.HAND);

        back_pane.setFitHeight(43.0);
        back_pane.setFitWidth(51.0);
        back_pane.setLayoutX(8.0);
        back_pane.setLayoutY(12.0);
        back_pane.setPickOnBounds(true);
        back_pane.setPreserveRatio(true);
        back_pane.setImage(new Image(getClass().getResource("img/back.png").toExternalForm()));
        back_pane.setCursor(Cursor.HAND);

        pane.getChildren().add(LoginPane);
        vBox.getChildren().add(pane);
        pane0.getChildren().add(SignupPane);
        vBox.getChildren().add(pane0);
        getChildren().add(vBox);
        getChildren().add(back_pane);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String ack = client.dis.readLine();
                        System.out.println(ack);
                        Select_Login_SignupBase.directMsgClient(ack);
                    } catch (IOException ex) {
                       System.out.println("server closed");
                    }
                }
            }

        }).start();
        LoginPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                LoginNamePageBase Second = new LoginNamePageBase(client, primaryStage);// the second scene
                Scene SecondOnline = new Scene(Second, 660, 400);
                primaryStage.setScene(SecondOnline);

            }
        });

        SignupPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SignupName Second = new SignupName(client, primaryStage);
                Scene SecondOnline = new Scene(Second, 660, 400);
                primaryStage.setScene(SecondOnline);
                //primaryStage.initStyle(StageStyle.TRANSPARENT);
            }
        });

        back_pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root = new Online_offlineBase(client, primaryStage);
                Scene scene = new Scene(root, 660, 400);
                primaryStage.setTitle("Tic Tac Toe");
                primaryStage.setScene(scene);
              

            }
        });

    }

    static void alertMsg(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    static void signUp(GameClientV1 client, Stage primaryStage) {
        LoginNamePageBase second = new LoginNamePageBase(client, primaryStage);
        Scene scene = new Scene(second);
        primaryStage.setScene(scene);
    }

    static void Login(GameClientV1 client, Stage primaryStage) {
        ListOfContactsBase third = new ListOfContactsBase(client, primaryStage);
        Scene scene = new Scene(third);
        primaryStage.setScene(scene);
    }

    static void directMsgClient(String ack) {
        System.out.println("start of direct msg in client ");
        String pass;
        String[] incommingMsg;
        if (ack != null) {
            incommingMsg = ack.split(":");
            System.out.println(incommingMsg.length);
            System.out.println(ack);

            System.out.println(incommingMsg[0]);
            //System.out.println(incommingMsg[1]);

            switch (incommingMsg[0]) {
                case "l":
                    if (incommingMsg[1].equals("a")) {
                        System.out.println("username found ");
                        LoginNamePageBase.userLoginFlag = true;

                        if (incommingMsg[1].equals("n")) {
                            System.out.println("Invalid username");
                            LoginNamePageBase.userLoginFlag = false;
                        }

                    }
                    break;
                case "lp":
                    if (incommingMsg[1].equals("a")) {
                        System.out.println("you can now enter");
                        LoginNamePageBase.passLoginFlag = true;

                        if (incommingMsg[1].equals("n")) {

                            System.out.println("please enter valid password in client");
                            LoginNamePageBase.passLoginFlag = false;

                        }
                    }
                    break;
                case "s":
                    if (incommingMsg[1].equals("a")) {
                        System.out.println("you can now enter");
                        SignupName.userSignFlag = true;

                        if (incommingMsg[1].equals("n")) {

                            System.out.println("please enter valid password in client");
                            SignupName.userSignFlag = false;

                        }

                    }
                    break;
                case "start": // start of online player list receiving 
                    if(onlinePlayer.size()>0)
                    {
                        onlinePlayer.clear(); //to refresh it 
                    }
                    break;
                case "op":
                    if(!incommingMsg[1].equals(""))
                    {
                        System.out.println(incommingMsg[1]+"is added");
                    onlinePlayer.add(incommingMsg[1]);
                    }
                    break;
            }
        }
    }
}
