/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclientv.pkg1;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author karim
 */
public class Game {

    static boolean xTurn = true;
    static boolean offlineGameMode = true; //true for computer 
    static int places[] = new int[9];

    static int xPlaces[] = new int[5];
    static int oPlaces[] = new int[5];
     static boolean xWin = false;
    static boolean oWin = false;
    static int turn = 0;
    static int playerCount = 0; //player one 
    static int compCount = 0;  // player two or computer

    static boolean xPlayFirst = true;
    static int replayPlaces[] = new int[9];
    static int replayedTurns = 0;

    public static Image playerOneTurn(int pos) {
        if (!contains(places, pos)) {
            Image xImg = new Image("x.png");
            xPlaces[playerCount++] = pos;
            places[turn++] = pos;
            return xImg;
        }
        return null;
    }

    public static Image playerTwoTurn(int pos) {
        if (!contains(places, pos)) {
            Image oImg =new Image("o.png");
            oPlaces[compCount++] = pos;
            places[turn++] = pos;
            return oImg;
        }
        return null;
    }

    public static boolean checkWin(int[] plays) {

        if (contains(plays, 1)) {
            if (contains(plays, 2) && contains(plays, 3)) {
                return true;
            } else if (contains(plays, 4) && contains(plays, 7)) {
                return true;
            } else if (contains(plays, 5) && contains(plays, 9)) {
                return true;
            }
        } else if (contains(plays, 3)) {
            if (contains(plays, 6) && contains(plays, 9)) {
                return true;
            } else if (contains(plays, 5) && contains(plays, 7)) {
                return true;
            }
        } else if (contains(plays, 5)) {
            if (contains(plays, 2) && contains(plays, 8)) {
                return true;
            } else if (contains(plays, 4) && contains(plays, 6)) {
                return true;
            }
        } else if (contains(plays, 7) && contains(plays, 8) && contains(plays, 9)) {
            return true;
        }

        return false;
    }

    public static void resetGame(ImageView[] regions) {

        for (int i = 0; i < turn; i++) {
            System.out.println(places[i]);
            regions[places[i] - 1].setImage(null);
        }
        replayPlaces = places;
         places=new int[9];    
        xPlaces = new int[5];
        oPlaces = new int[5];
        if(turn !=0)  replayedTurns = turn;
        turn = 0;
        playerCount = 0; //player one 
        compCount = 0;  // player two or computer
        xTurn = true;
    }

    public static void replayGame(ImageView[] regions) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                resetGame(regions);
                for (int i = 0; i < replayedTurns; i++) {
                       try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(i);
                    Image img;
                    if (xPlayFirst) {
                        img = new Image("x.png");

                    } else {
                        img =new Image("o.png");

                    }
                    System.out.println(replayPlaces[i]);
                    regions[replayPlaces[i] - 1].setImage(img);
                    xPlayFirst = !xPlayFirst;
                 
                }
                  resetGame(regions);
            }
        }).start();
    }

    public static boolean contains(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (element == arr[i]) {
                return true;
            }
        }
        return false;
    }
}
