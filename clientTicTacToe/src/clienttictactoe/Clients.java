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
public class Clients implements OtherClients{
    /*
	 this method to get the name all the online users (form the server)
	 and should be called once the client is connected 
	 refreshed every one minute 
	  onlineUsers is array defined in the class you will implement this interface in so you can use it 
	  again to choose from thim later
    getline();
	*/

    @Override
    public void getOnlineList(String[] onlineUsers) {
      
    }
/*
	 this method to send the user name of the chosen one to the server 
	 you will need to use the array you have already stored the elements inside it 
	 and the index of the chosen one 
	*/
    @Override
    public void sendRequestToUser(String[] onlineUsers, int indexOfChosenOne) {
        
    }
	/*
	 request recieved from the server(another client sent it to the server and choosed me ) and the client can accept or deny it 
	*/
    @Override
    public void recieveRequest() {
       
    }
    
}
