package gameclientv.pkg1;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class creditsBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Text text;
    protected final ImageView imageView0;
    protected final ImageView close_btn;

    public creditsBase(Stage primaryStage) {

        imageView = new ImageView();
        text = new Text();
        imageView0 = new ImageView();
        close_btn = new ImageView();

        setId("AnchorPane");
        setOpacity(0.94);
        setPrefHeight(247.0);
        setPrefWidth(326.0);

        imageView.setFitHeight(324.0);
        imageView.setFitWidth(497.0);
        imageView.setLayoutY(-1.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("taqwa.jpeg").toExternalForm()));

        text.setFill(javafx.scene.paint.Color.valueOf("#c6b9b9"));
        text.setLayoutX(12.0);
        text.setLayoutY(42.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("This game is made by:                          1)Taqwa Nabil         2) Karim Goda                 3)Yara Mamdoh      4)Kerols saad                                                                   The game is played on a grid that's 3 squares by 3 squares.2. You are X or O, your friend (or the computer ) is the oppoite symbol. Players take turns putting their marks in empty squares.      The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.   When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.");
        text.setWrappingWidth(322.13671875);
        text.setFont(new Font(16.0));

        imageView0.setFitHeight(40.0);
        imageView0.setFitWidth(162.0);
        imageView0.setLayoutX(160.0);
        imageView0.setLayoutY(-2.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("img/credits.gif").toExternalForm()));

        close_btn.setFitHeight(33.0);
        close_btn.setFitWidth(48.0);
        close_btn.setLayoutX(450.0);
        close_btn.setLayoutY(8.0);
        close_btn.setPickOnBounds(true);
        close_btn.setPreserveRatio(true);
        close_btn.setImage(new Image(getClass().getResource("img/close.png").toExternalForm()));
        close_btn.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(text);
        getChildren().add(imageView0);
        getChildren().add(close_btn);

        close_btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
               getScene().getWindow().hide();
            }
        });

    }
}
