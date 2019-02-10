package server_db;

public interface CheckData {

    public boolean checkUsername(String username); //check if this user name is existed or not 

    public boolean checkUsername(String username, String passward); // check if this is the passward for this username 	

}
