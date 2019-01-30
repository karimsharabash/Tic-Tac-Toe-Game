public interface ConnectableClient
{
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


public interface OtherClients()
{
	/*
	 this method to get the name all the online users (form the server)
	 and should be called once the client is connected 
	 refreshed every one minute 
	  onlineUsers is array defined in the class you will implement this interface in so you can use it 
	  again to choose from thim later
	*/
	
	public void getOnlineList(String[] onlineUsers );
	
	/*
	 this method to send the user name of the chosen one to the server 
	 you will need to use the array you have already stored the elements inside it 
	 and the index of the chosen one 
	*/
	public void sendRequestToUser(String[] onlineUsers,int indexOfChosenOne)	

	/*
	 request recieved from the server(another client sent it to the server and choosed me ) and the client can accept or deny it 
	*/
    public void recieveRequest();
       	
}


public interface PlayableClient()
{
	/*
	send your move to the server 
	*/
	public void sendYourMove(int newPosition);
	
	/*
	get the player 2 move from the server to display it 
	*/
	public int getPlayerTwoMove();
	
}

