/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.EmbeddedDriver;

/**
 *
 * @author Takwa
 */
public class ValidateDB implements CheckData {

    Connection conn;
    ResultSet rs;
    PreparedStatement pstmt;
    ValidateDB() {
       DerbyDB obj=DerbyDB.getInstance();
        conn = obj.testDerby();
    }

    @Override
    public boolean checkUsername(String username) {
        boolean usernameExists = false;
        try {
            pstmt = conn.prepareStatement("SELECT name FROM Player where name=?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Username already exists");
                usernameExists = true;
            }
            pstmt.close();
            rs.close();
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("there is no connection with database checkUsername bas ");

        }
        return usernameExists;
    }

    @Override
    public boolean checkUsername(String username, String passward) {
        boolean PasswordMatch = false;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Player where name=? and pass=?");
            pstmt.setString(1, username);
            pstmt.setString(2, passward);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Password is correct ,You can Login now ");
                PasswordMatch = true;
            } else {
                System.out.println("Password is wrong, try again");
            }
            pstmt.close();
            rs.close();
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("there is no connection with database checkUsername w pass ");
        }
        return PasswordMatch;
    }

   /* public static void main(String[] args) {
        boolean chk;
        ValidateDB user = new ValidateDB();
        chk = user.checkUsername("taqwa", "1");
        System.out.println(chk);
    }*/

}
