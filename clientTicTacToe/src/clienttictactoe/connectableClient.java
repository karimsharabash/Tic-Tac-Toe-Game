/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttictactoe;

/**
 *
 * @author Cross
 */
public interface connectableClient {
    	/* 
	 this method to send the username to the server upon output stream in two cases
	 -sign up : use "s:theusername"
	 -login : use "l:theusername"
	 so i can validate from the server side */
	public void  sendUserName(); 
	/*
	this method recieve msg from the input stream and check this message 
    if the reccieved message is "done" this means your user name or passward passed the server validation 
    some sort of acknowledgement 
	*/
	public boolean check();
	
	/*
	   this method to send the passward to the server upon output stream in two cases
	 -sign up : use "s:the passward"
	 -login : use "l:the passward"
	 so i can validate from the server side
	
	*/
	public void sendPassward();
}
