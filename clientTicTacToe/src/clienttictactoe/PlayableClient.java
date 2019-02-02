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
public interface PlayableClient {
    	/*
	send your move to the server 
	*/
	public void sendYourMove(int newPosition);
	
	/*
	get the player 2 move from the server to display it 
	*/
	public int getPlayerTwoMove();
	
    
}
