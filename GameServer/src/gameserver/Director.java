/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

import java.io.IOException;

/**
 *
 * @author karim
 */
public class Director  {
    
    public static void  directMsg(gamerHandler handler,String user) throws IOException
    {
         String pass;
        String[] incommingMsg;
        
        incommingMsg=user.split(":");
        switch(incommingMsg[0])
        {
            case "s": //this is sign up verfication  
              System.out.println("register "+incommingMsg[1]+" if not already existed");
                 pass=handler.dis.readLine();
                  System.out.println(incommingMsg[1]+" pass is "+pass);
               
                break;
            case "l": // login verfication  
               System.out.println(incommingMsg[1]+" want to login");
                pass=handler.dis.readLine();
                  System.out.println(incommingMsg[1]+" pass is "+pass);
               handler.userName=incommingMsg[1];
                break;
            default :
        }
       
        
       
    }
   /* public void sendACk()
    {
        
    }*/
    public String getPassward(String[] passwards,String pass)
    {
       String[] incommingMsg;
        
        incommingMsg=pass.split(":");
        
           switch(incommingMsg[0])
        {
            case "s": //this is sign up verfication  
                 System.out.println("Done");   

               //store the passward
                break;
            case "l": // login verfication  
               //check the passward
                break;
            default :
           }
    
       
 return "done";
    
    }
}
