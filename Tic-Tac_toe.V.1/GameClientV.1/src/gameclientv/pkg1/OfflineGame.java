/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclientv.pkg1;

import java.io.File;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author Takwa
 */
public class OfflineGame extends Game{
    public static int computerPlay() {
        boolean found = true;
        int comuPlace = 0;

        while (found) {
            comuPlace = (int) (Math.random() * 9) + 1;
            if (!contains(places, comuPlace)) {
                found = false;
            }
        }
        return comuPlace;
    }

    public static void playOffline(ImageView[] regions, int place) {
        Image img = null;
        int newPlace = 0;

        if (xTurn) {
            img = playerOneTurn(place);
            xWin = checkWin(xPlaces);
            System.out.println("x " + xWin);

        } else if (!offlineGameMode) {
            img = playerTwoTurn((place));
            oWin = checkWin(oPlaces);
        }
        if (img != null) {
            regions[place - 1].setImage(img);
            xTurn = !xTurn;
            if (xWin) {
                //FXMLDocumentBase.gameResult("X Won");
                //Game.replayGame(regions);
                String path = "You_Did_It.MP4";  
                Media media = new Media(new File(path).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
                MediaView mediaView = new MediaView(mediaPlayer);
                Stage primaryStage = new Stage();
                Group root = new Group();
                root.getChildren().add(mediaView);
                Scene scene = new Scene(root, 400, 300);
                primaryStage.setTitle("Playing Video");
                primaryStage.setScene(scene);
                primaryStage.show();
                mediaPlayer.play();
                 
                 mediaPlayer.setOnEndOfMedia(new Runnable(){
                    @Override
                    public void run() {
                        Label lb=new Label();
                        lb.setText("Do You want to play again ?");
                        Group root = new Group();
                        root.getChildren().add(lb);
                        Scene scene2 = new Scene(root, 400, 300);
                        primaryStage.setScene(scene2);
                        
                        
                        
                    }
                     
                 });
                return;
            } else if (oWin) {
                GameOffline.gameResult("O Won");
                return;
            } else if (OfflineGame.turn == 9) {
                GameOffline.gameResult("Tie");
                return;
            }
            if (offlineGameMode) {
                newPlace = computerPlay();
                img = playerTwoTurn(newPlace);
                oWin = checkWin(OfflineGame.oPlaces);
                System.out.println(oWin);
                if (img != null) {
                    regions[newPlace - 1].setImage(img);
                    xTurn = !xTurn;
                    if (xWin) {
                        GameOffline.gameResult("X Won");
                        Game.resetGame(regions);
                        return;
                    } else if (oWin) {
                        GameOffline.gameResult("O Won");
                        resetGame(regions);
                        return;
                    } else if (turn == 9) {
                        GameOffline.gameResult("Tie");
                        resetGame(regions);
                        return;
                    }
                }
            }
        }

    }
}