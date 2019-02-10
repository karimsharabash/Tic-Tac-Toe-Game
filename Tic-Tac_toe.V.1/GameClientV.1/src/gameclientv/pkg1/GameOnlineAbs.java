package gameclientv.pkg1;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOnlineAbs extends AnchorPane {

    protected final ImageView Player1Score;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Label PlayerXLable;
    protected final Label PlayerOLable;
    protected final Label TeiLable;
    protected final ImageView Back_pane;
    protected final ImageView regionOne;
    protected final ImageView regionFive;
    protected final ImageView regionFour;
    protected final ImageView regionTwo;
    protected final ImageView regionThree;
    protected final ImageView regionNine;
    protected final ImageView regionEight;
    protected final ImageView regionSix;
    protected final ImageView regionSeven;
    protected final Label Player1Score0;
    protected final Label TieScore;
    protected final Label Player2Score;

    static ImageView[] regions = new ImageView[9];

    public GameOnlineAbs(GameClientV1 client, Stage primaryStage) {

        Player1Score = new ImageView();
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        PlayerXLable = new Label();
        PlayerOLable = new Label();
        TeiLable = new Label();
        Back_pane = new ImageView();
        regionOne = new ImageView();
        regionFive = new ImageView();
        regionFour = new ImageView();
        regionTwo = new ImageView();
        regionThree = new ImageView();
        regionNine = new ImageView();
        regionEight = new ImageView();
        regionSix = new ImageView();
        regionSeven = new ImageView();
        Player1Score0 = new Label();
        TieScore = new Label();
        Player2Score = new Label();

        regions[0] = regionOne;
        regions[1] = regionTwo;
        regions[2] = regionThree;
        regions[3] = regionFour;
        regions[4] = regionFive;
        regions[5] = regionSix;
        regions[6] = regionSeven;
        regions[7] = regionEight;
        regions[8] = regionNine;

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        Player1Score.setFitHeight(595.0);
        Player1Score.setFitWidth(999.0);
        Player1Score.setLayoutX(-170.0);
        Player1Score.setLayoutY(-21.0);
        Player1Score.setPickOnBounds(true);
        Player1Score.setPreserveRatio(true);
        Player1Score.setImage(new Image(getClass().getResource("taqwa.jpeg").toExternalForm()));

        line.setEndX(480.0);
        line.setEndY(130.49996948242188);
        line.setLayoutX(118.0);
        line.setLayoutY(10.0);
        line.setStartX(80.0);
        line.setStartY(130.49996948242188);
        line.setStroke(javafx.scene.paint.Color.valueOf("#fff6f6"));
        line.setStrokeWidth(5.0);

        line0.setEndX(203.0);
        line0.setEndY(31.878679275512695);
        line0.setLayoutX(128.0);
        line0.setLayoutY(12.0);
        line0.setStartX(203.0);
        line0.setStartY(349.0);
        line0.setStroke(javafx.scene.paint.Color.valueOf("#fffefe"));
        line0.setStrokeWidth(5.0);

        line1.setEndX(486.0);
        line1.setEndY(130.49996948242188);
        line1.setLayoutX(117.0);
        line1.setLayoutY(132.0);
        line1.setStartX(79.0);
        line1.setStartY(130.49996948242188);
        line1.setStroke(javafx.scene.paint.Color.valueOf("#fff6f6"));
        line1.setStrokeWidth(5.0);

        line2.setEndX(216.0);
        line2.setEndY(31.0);
        line2.setLayoutX(251.0);
        line2.setLayoutY(9.0);
        line2.setStartX(216.0);
        line2.setStartY(356.0);
        line2.setStroke(javafx.scene.paint.Color.valueOf("#fffefe"));
        line2.setStrokeWidth(5.0);

        PlayerXLable.setLayoutX(206.0);
        PlayerXLable.setLayoutY(454.0);
        PlayerXLable.setPrefHeight(28.0);
        PlayerXLable.setPrefWidth(70.0);
        PlayerXLable.setText("Player X");
        PlayerXLable.setTextFill(javafx.scene.paint.Color.valueOf("#e4e4e4"));
        PlayerXLable.setFont(new Font("Bauhaus 93", 18.0));

        PlayerOLable.setLayoutX(523.0);
        PlayerOLable.setLayoutY(455.0);
        PlayerOLable.setPrefHeight(28.0);
        PlayerOLable.setPrefWidth(70.0);
        PlayerOLable.setText("Player O");
        PlayerOLable.setTextFill(javafx.scene.paint.Color.valueOf("#e4e4e4"));
        PlayerOLable.setFont(new Font("Bauhaus 93", 18.0));

        TeiLable.setLayoutX(384.0);
        TeiLable.setLayoutY(456.0);
        TeiLable.setPrefHeight(28.0);
        TeiLable.setPrefWidth(48.0);
        TeiLable.setText("Tie");
        TeiLable.setTextFill(javafx.scene.paint.Color.valueOf("#e4e4e4"));
        TeiLable.setFont(new Font("Bauhaus 93", 18.0));

        Back_pane.setFitHeight(48.0);
        Back_pane.setFitWidth(70.0);
        Back_pane.setLayoutX(7.0);
        Back_pane.setLayoutY(8.0);
        Back_pane.setPickOnBounds(true);
        Back_pane.setPreserveRatio(true);
        Back_pane.setImage(new Image(getClass().getResource("img/back.png").toExternalForm()));
        Back_pane.setCursor(Cursor.HAND);

        regionOne.setFitHeight(96.0);
        regionOne.setFitWidth(130.0);
        regionOne.setLayoutX(195.0);
        regionOne.setLayoutY(43.0);
        regionOne.setPickOnBounds(true);
        regionOne.setPreserveRatio(true);

        regionFive.setFitHeight(113.0);
        regionFive.setFitWidth(130.0);
        regionFive.setLayoutX(330.0);
        regionFive.setLayoutY(146.0);
        regionFive.setPickOnBounds(true);
        regionFive.setPreserveRatio(true);

        regionFour.setFitHeight(119.0);
        regionFour.setFitWidth(130.0);
        regionFour.setLayoutX(199.0);
        regionFour.setLayoutY(142.0);
        regionFour.setPickOnBounds(true);
        regionFour.setPreserveRatio(true);

        regionTwo.setFitHeight(96.0);
        regionTwo.setFitWidth(130.0);
        regionTwo.setLayoutX(335.0);
        regionTwo.setLayoutY(43.0);
        regionTwo.setPickOnBounds(true);
        regionTwo.setPreserveRatio(true);

        regionThree.setFitHeight(96.0);
        regionThree.setFitWidth(130.0);
        regionThree.setLayoutX(469.0);
        regionThree.setLayoutY(43.0);
        regionThree.setPickOnBounds(true);
        regionThree.setPreserveRatio(true);

        regionNine.setFitHeight(96.0);
        regionNine.setFitWidth(130.0);
        regionNine.setLayoutX(469.0);
        regionNine.setLayoutY(264.0);
        regionNine.setPickOnBounds(true);
        regionNine.setPreserveRatio(true);

        regionEight.setFitHeight(96.0);
        regionEight.setFitWidth(130.0);
        regionEight.setLayoutX(338.0);
        regionEight.setLayoutY(264.0);
        regionEight.setPickOnBounds(true);
        regionEight.setPreserveRatio(true);

        regionSix.setFitHeight(113.0);
        regionSix.setFitWidth(130.0);
        regionSix.setLayoutX(469.0);
        regionSix.setLayoutY(145.0);
        regionSix.setPickOnBounds(true);
        regionSix.setPreserveRatio(true);

        regionSeven.setFitHeight(96.0);
        regionSeven.setFitWidth(130.0);
        regionSeven.setLayoutX(200.0);
        regionSeven.setLayoutY(264.0);
        regionSeven.setPickOnBounds(true);
        regionSeven.setPreserveRatio(true);

        Player1Score0.setLayoutX(230.0);
        Player1Score0.setLayoutY(491.0);
        Player1Score0.setPrefHeight(17.0);
        Player1Score0.setPrefWidth(33.0);
        Player1Score0.setText("0");
        Player1Score0.setTextFill(javafx.scene.paint.Color.valueOf("#fffdfd"));
        Player1Score0.setFont(new Font("System Italic", 20.0));

        TieScore.setLayoutX(391.0);
        TieScore.setLayoutY(495.0);
        TieScore.setPrefHeight(28.0);
        TieScore.setPrefWidth(33.0);
        TieScore.setText("0");
        TieScore.setTextFill(javafx.scene.paint.Color.WHITE);
        TieScore.setFont(new Font(20.0));

        Player2Score.setLayoutX(547.0);
        Player2Score.setLayoutY(496.0);
        Player2Score.setText("0");
        Player2Score.setTextFill(javafx.scene.paint.Color.valueOf("#ebe3e3"));
        Player2Score.setFont(new Font("Arial Italic", 20.0));

        getChildren().add(Player1Score);
        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(PlayerXLable);
        getChildren().add(PlayerOLable);
        getChildren().add(TeiLable);
        getChildren().add(Back_pane);
        getChildren().add(regionOne);
        getChildren().add(regionFive);
        getChildren().add(regionFour);
        getChildren().add(regionTwo);
        getChildren().add(regionThree);
        getChildren().add(regionNine);
        getChildren().add(regionEight);
        getChildren().add(regionSix);
        getChildren().add(regionSeven);
        getChildren().add(Player1Score0);
        getChildren().add(TieScore);
        getChildren().add(Player2Score);
    }
}
