package gameclientv.pkg1;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Online_offlineBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView Offline_btn;
    protected final ImageView Online_btn;
    protected final ImageView Credits_btn;

    public Online_offlineBase(GameClientV1 client,Stage primaryStage) {

        imageView = new ImageView();
        imageView0 = new ImageView();
        Offline_btn = new ImageView();
        Online_btn = new ImageView();
        Credits_btn = new ImageView();

        setId("AnchorPane");
        setPrefHeight(405.0);
        setPrefWidth(597.0);

        imageView.setFitHeight(481.0);
        imageView.setFitWidth(666.0);
        imageView.setLayoutY(-6.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("taqwa.jpeg").toExternalForm()));

        imageView0.setFitHeight(92.0);
        imageView0.setFitWidth(385.0);
        imageView0.setLayoutX(141.0);
        imageView0.setLayoutY(70.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("img/Tic Tac Toe.gif").toExternalForm()));

        Offline_btn.setFitHeight(126.0);
        Offline_btn.setFitWidth(259.0);
        Offline_btn.setLayoutX(342.0);
        Offline_btn.setLayoutY(182.0);
        Offline_btn.setPickOnBounds(true);
        Offline_btn.setPreserveRatio(true);
        Offline_btn.setImage(new Image(getClass().getResource("img/offline.gif").toExternalForm()));
        Offline_btn.setCursor(Cursor.HAND);

        Online_btn.setFitHeight(83.0);
        Online_btn.setFitWidth(246.0);
        Online_btn.setLayoutX(73.0);
        Online_btn.setLayoutY(188.0);
        Online_btn.setPickOnBounds(true);
        Online_btn.setPreserveRatio(true);
        Online_btn.setImage(new Image(getClass().getResource("img/online.gif").toExternalForm()));
        Online_btn.setCursor(Cursor.HAND);

        Credits_btn.setFitHeight(150.0);
        Credits_btn.setFitWidth(200.0);
        Credits_btn.setLayoutX(-26.0);
        Credits_btn.setLayoutY(341.0);
        Credits_btn.setPickOnBounds(true);
        Credits_btn.setPreserveRatio(true);
        Credits_btn.setImage(new Image(getClass().getResource("img/credits.gif").toExternalForm()));
        Credits_btn.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(Offline_btn);
        getChildren().add(Online_btn);
        getChildren().add(Credits_btn);

        Credits_btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Stage newWindow = new Stage();
                creditsBase credit = new creditsBase(newWindow);
                Scene scene = new Scene(credit);
                newWindow.setScene(scene);
         
                newWindow.initStyle(StageStyle.TRANSPARENT);
                newWindow.initOwner(primaryStage);
                newWindow.show();
            }
        }
        );

        Offline_btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SelectModeBase mood = new SelectModeBase(primaryStage);
                Scene scene = new Scene(mood,660,400);
                primaryStage.setScene(scene);
               primaryStage.setResizable(false);

            }
        }
        );
          Online_btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Select_Login_SignupBase mood = new Select_Login_SignupBase(client,primaryStage);
                Scene scene = new Scene(mood,660,400);
                primaryStage.setScene(scene);
               primaryStage.resizableProperty().setValue(Boolean.FALSE);

            }
        }
        );
    }
}
