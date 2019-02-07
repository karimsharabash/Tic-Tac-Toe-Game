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
public class user {
    private int id;
	private String userName;
	private String password;
	private boolean status; // for online and offline status

	// this constractor creates a new user with the username and password
            /**
     *
     * @param id
     * @param username
     * @param Password
     */

	public user ( int id , String userName, String password){
		this.id = id;
		this.userName = userName;
		this.password = password;

	}
		// this constractor creates a new user with the username and password
	public user ( int id , String userName, String password , boolean status){
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.status = status;

	}
		// this constractor creates a new user with the username and password


	public void setId(int id){
		this.id=id;
	}
	public void setUserName(String userName){
		this.userName= userName;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setStatus(boolean status){
		this.status=status;
	}

	/// GETTERS FOR THE USER DETAILS 

	public String getUserName(){
		return this.userName;
	}
	public String getPassword(){
		return this.password;
	}
	public boolean getStatus(){
		return this.status;
	}
    
}
