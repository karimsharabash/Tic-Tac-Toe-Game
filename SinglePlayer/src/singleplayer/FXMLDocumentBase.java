package singleplayer;
//import javafx.stage.Stage; 

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;

public class FXMLDocumentBase extends AnchorPane {

    player player1;
    
    static boolean xWin = false;
    static boolean oWin = false;

    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Pane regionEight;
    protected final Pane regionOne;
    protected final Pane regionTwo;
    protected final Pane regionThree;
    protected final Pane regionSeven;
    protected final Pane regionNine;
    protected final Pane regionFour;
    protected final Pane regionFive;
    protected final Pane regionSix;
   static  Pane[] regions = new Pane[9];

    public FXMLDocumentBase() {
         
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        regionEight = new Pane();
        regionOne = new Pane();
        regionTwo = new Pane();
        regionThree = new Pane();
        regionSeven = new Pane();
        regionNine = new Pane();
        regionFour = new Pane();
        regionFive = new Pane();
        regionSix = new Pane();
        //regions = {regionOne,regionTwo,regionThree,regionFour,regionFive,regionSix,regionSeven,regionEight,regionNine};
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
        setPrefHeight(282.0);
        setPrefWidth(326.0);

        line.setEndX(100.0);
        line.setLayoutX(160.0);
        line.setLayoutY(74.0);
        line.setStartX(-100.0);

        line0.setEndX(100.0);
        line0.setLayoutX(160.0);
        line0.setLayoutY(135.0);
        line0.setStartX(-100.0);

        line1.setEndX(-33.0);
        line1.setEndY(141.0);
        line1.setLayoutX(152.0);
        line1.setLayoutY(34.0);
        line1.setStartX(-33.0);
        line1.setStartY(-3.0);

        line2.setEndX(100.0);
        line2.setLayoutX(101.0);
        line2.setLayoutY(31.0);
        line2.setStartX(100.0);
        line2.setStartY(143.0);

        regionEight.setLayoutX(120.0);
        regionEight.setLayoutY(136.0);
        regionEight.setPrefHeight(50.0);
        regionEight.setPrefWidth(81.0);

        regionOne.setLayoutX(46.0);
        regionOne.setLayoutY(22.0);
        regionOne.setPrefHeight(50.0);
        regionOne.setPrefWidth(74.0);

        regionTwo.setLayoutX(117.0);
        regionTwo.setLayoutY(24.0);
        regionTwo.setPrefHeight(50.0);
        regionTwo.setPrefWidth(81.0);

        regionThree.setLayoutX(199.0);
        regionThree.setLayoutY(16.0);
        regionThree.setPrefHeight(58.0);
        regionThree.setPrefWidth(74.0);

        regionSeven.setLayoutX(46.0);
        regionSeven.setLayoutY(133.0);
        regionSeven.setPrefHeight(58.0);
        regionSeven.setPrefWidth(74.0);

        regionNine.setLayoutX(199.0);
        regionNine.setLayoutY(135.0);
        regionNine.setPrefHeight(50.0);
        regionNine.setPrefWidth(74.0);

        regionFour.setLayoutX(34.0);
        regionFour.setLayoutY(74.0);
        regionFour.setPrefHeight(58.0);
        regionFour.setPrefWidth(81.0);

        regionFive.setLayoutX(119.0);
        regionFive.setLayoutY(76.0);
        regionFive.setPrefHeight(58.0);
        regionFive.setPrefWidth(81.0);

        regionSix.setLayoutX(200.0);
        regionSix.setLayoutY(71.0);
        regionSix.setPrefHeight(67.0);
        regionSix.setPrefWidth(74.0);

        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(regionEight);
        getChildren().add(regionOne);
        getChildren().add(regionTwo);
        getChildren().add(regionThree);
        getChildren().add(regionSeven);
        getChildren().add(regionNine);
        getChildren().add(regionFour);
        getChildren().add(regionFive);
        getChildren().add(regionSix);

        regionOne.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                game(regionOne, 1);
            }
        });
        regionTwo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                game(regionTwo, 2);
            }
        });
        regionThree.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                game(regionThree, 3);
            }
        });
        regionFour.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                game(regionFour, 4);
            }

        });

        regionFive.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                game(regionFive, 5);
            }
        });
        regionSix.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                game(regionSix, 6);
            }
        });
        regionSeven.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                game(regionSeven, 7);
            }
        });
        regionEight.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                game(regionEight, 8);
            }
        });
        regionNine.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                game(regionNine, 9);
            }
        });

    }

    static void game(Pane region, int place) {
        ImageView img = null;
        int newPlace=0;
        if (player.xTurn) {
            img = player.playerOneTurn(place);
            xWin = player.checkWin(player.xPlaces);
             System.out.println(place);
        }
        else if (!player.offlineGameMode) {
            img = player.playerTwoTurn((place));
            oWin = player.checkWin(player.oPlaces);
        }
        if (img != null) {
            region.getChildren().add(img);
            player.xTurn = !player.xTurn;
            if (xWin) {
                Alert alert = new Alert(Alert.AlertType.NONE, "X Wins", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
                return;
            } else if (oWin) {
                Alert alert = new Alert(Alert.AlertType.NONE, "O Wins", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
                return;
            } else if (player.turn == 9) {
                Alert alert = new Alert(Alert.AlertType.NONE, "Tie", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
                return;
            }
            if (player.offlineGameMode) {
                newPlace=player.computerPlay();
                img = player.playerTwoTurn(newPlace);
                oWin = player.checkWin(player.oPlaces);
                if (img != null) {
                   
                    regions[newPlace-1].getChildren().add(img);
                    player.xTurn = !player.xTurn;
                    if (xWin) {
                        Alert alert = new Alert(Alert.AlertType.NONE, "X Wins", ButtonType.OK);
                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                        return;
                    } else if (oWin) {
                        Alert alert = new Alert(Alert.AlertType.NONE, "O Wins", ButtonType.OK);
                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                        return;
                    } else if (player.turn == 9) {
                        Alert alert = new Alert(Alert.AlertType.NONE, "Tie", ButtonType.OK);
                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                        return;
                    }
                }
            }
        }

    }
}
