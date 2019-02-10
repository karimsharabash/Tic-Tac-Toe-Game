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
public class SignUp implements SetData {

    Connection conn = null;
    PreparedStatement pstmt;
    ResultSet rs = null;
    Statement stmt = null;
   DerbyDB obj;
    SignUp() {
         obj=DerbyDB.getInstance();
        conn = obj.testDerby();
       
    }

    @Override
    public void saveNewUser(String username, String passward) {
        try {
            pstmt = conn.prepareStatement("SELECT name FROM Player where name=?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Username already exists");
            } else {
                pstmt = conn.prepareStatement("insert into Player (name,pass) values(?,?)");
                pstmt.setString(1, username);
                pstmt.setString(2, passward);
                pstmt.executeUpdate();
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from Player");
            while (rs.next()) {
                System.out.printf("%d %s %s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }

            stmt.close();
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("there is no connection with database");
        }

    }

   /* public static void main(String[] args) {
        SignUp user = new SignUp();
        user.saveNewUser("taqwa", "1");
    }*/

}
