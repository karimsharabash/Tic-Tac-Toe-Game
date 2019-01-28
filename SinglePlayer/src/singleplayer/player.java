/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleplayer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author karim
 */
public class player {
    static boolean xTurn=true;
    static boolean offlineGameMode=true; //true for computer 
    static int places[]=new int[9];    
    static int xPlaces[]=new int[5];    
    static int oPlaces[]=new int[5];
    static int turn =0;
    static int playerCount =0;
    static int compCount =0;
    

    public static boolean alreadyChosen(int pos)
    {
        for(int i=0; i<places.length;i++)
        {
            if(pos == places[i])
            {
                return true;
            }
        }
        return false;
    }
    
    public static ImageView playerOneTurn(int pos)
    {

       if(! alreadyChosen(pos))
       {
        ImageView xImg = new ImageView(new Image("x.png")); 
        xImg.setFitWidth(60);
        xImg.setFitHeight(30);
        xPlaces[playerCount++]=pos;
        places[turn++]=pos;
           return xImg;   
       }
       return null;
    }
    
    public static ImageView playerTwoTurn(int pos)
    {
      if(! alreadyChosen(pos))
       {
          ImageView oImg = new ImageView(new Image("o.png"));
          oImg.setFitWidth(60);
          oImg.setFitHeight(30);
          oPlaces[compCount++]=pos;
          places[turn++]=pos;
          return oImg;
       }
      return null;
    }
    
    public static int computerPlay( )
    {
        boolean found =true ; 
        int comuPlace=0;
        
        while(found)
        {
         comuPlace=(int)(Math.random()*9)+1 ;
         if(!contains(places, comuPlace))
         {
          found =false;   
         }
        }
        
        return comuPlace;
    }
    
    public static boolean checkWin(int[] plays)
    {
   
         if(contains(plays,1))
         {
             if(contains(plays,2) && contains(plays,3))
             {
                 return true;
             }
             else if(contains(plays,4) && contains(plays,7))
             {
              return true;   
             }
             else if (contains(plays,5) && contains(plays,9))
             {
               return true;
             }
         }
         else if (contains(plays,3))
         {
             if (contains(plays,6) && contains(plays,9))
             {
                return true; 
             }
             else if (contains(plays,5) && contains(plays,7))
             {
                return true; 
             }
         }
         else if (contains(plays,5))
         {
             if (contains(plays,2) && contains(plays,8))
             {
                return true; 
             }
             else if (contains(plays,4) && contains(plays,6))
             {
                return true; 
             }
         }
         else if (contains(plays,7) && contains(plays,8) && contains(plays,9))
         {
             return true ;
         }
    
  
     return false;
    }
    
    
    public static boolean contains(int[] arr, int element)
    {
        for(int i=0; i<arr.length;i++)
        {
            if(element == arr[i])
            {
             return true ;   
            }
        }
        return false ; 
    } 
    
    /*class Move
    {
     int place ;
     int imgSrc ;
    }*/
}


     