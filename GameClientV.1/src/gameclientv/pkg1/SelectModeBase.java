package gameclientv.pkg1;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelectModeBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView _Pane;
    protected final ImageView imageView0;
    protected final ImageView friendPane;
    protected final ImageView compPane;

    public SelectModeBase(Stage primaryStage) {

        imageView = new ImageView();
        _Pane = new ImageView();
        imageView0 = new ImageView();
        friendPane = new ImageView();
        compPane = new ImageView();

        setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        setPrefHeight(365.0);
        setPrefWidth(596.0);
        getStylesheets().add("/gameclientv/pkg1/style.css");

        imageView.setFitHeight(528.0);
        imageView.setFitWidth(1002.0);
        imageView.setLayoutY(-14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("taqwa.jpeg").toExternalForm()));

        _Pane.setFitHeight(43.0);
        _Pane.setFitWidth(51.0);
        _Pane.setLayoutX(8.0);
        _Pane.setLayoutY(12.0);
        _Pane.setPickOnBounds(true);
        _Pane.setPreserveRatio(true);
        _Pane.setImage(new Image(getClass().getResource("img/back.png").toExternalForm()));
        _Pane.setCursor(Cursor.HAND);

        imageView0.setFitHeight(74.0);
        imageView0.setFitWidth(384.0);
        imageView0.setLayoutX(119.0);
        imageView0.setLayoutY(66.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("img/opponent.gif").toExternalForm()));

        friendPane.setFitHeight(100.0);
        friendPane.setFitWidth(372.0);
        friendPane.setLayoutX(115.0);
        friendPane.setLayoutY(141.0);
        friendPane.setPickOnBounds(true);
        friendPane.setPreserveRatio(true);
        friendPane.setImage(new Image(getClass().getResource("img/friend.gif").toExternalForm()));
        friendPane.setCursor(Cursor.HAND);

        compPane.setFitHeight(46.0);
        compPane.setFitWidth(252.0);
        compPane.setLayoutX(182.0);
        compPane.setLayoutY(232.0);
        compPane.setPickOnBounds(true);
        compPane.setPreserveRatio(true);
        compPane.setImage(new Image(getClass().getResource("img/computer.gif").toExternalForm()));
        compPane.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(_Pane);
        getChildren().add(imageView0);
        getChildren().add(friendPane);
        getChildren().add(compPane);
          friendPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Game.offlineGameMode=false;
                 GameOfflineAbs Second = new GameOfflineAbs();// the second scene

                Scene SecondOnline = new Scene(Second);
                primaryStage.setScene(SecondOnline);
            }

        });
        
        compPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Game.offlineGameMode=true;
                 GameOfflineAbs Second = new GameOfflineAbs();// the second scene

                Scene SecondOnline = new Scene(Second);
                primaryStage.setScene(SecondOnline);
            }

        });


    }
}
