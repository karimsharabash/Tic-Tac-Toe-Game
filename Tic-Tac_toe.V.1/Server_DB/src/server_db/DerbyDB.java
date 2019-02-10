package server_db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Takwa
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.derby.jdbc.EmbeddedDriver;

public class DerbyDB {

    static DerbyDB instance = null;

    private DerbyDB() {
    }
    
     static public DerbyDB getInstance() {
        if (instance == null) {
            instance = new DerbyDB();
        }

        return instance;
    }

    public static Connection testDerby() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Driver derbyEmbeddedDriver = new EmbeddedDriver();
            DriverManager.registerDriver(derbyEmbeddedDriver);
            conn = DriverManager.getConnection("jdbc:derby:TicGameDB;create=true");
            conn.setAutoCommit(false);

        /*   String createSQL = "create table Player ("
                    + "id integer not null generated always as"
                    + " identity (start with 1, increment by 1),"
                    + "name varchar(30) not null,"
                    + "pass varchar(30) not null,"
                    + "constraint primary_key primary key (id))";

            stmt = conn.createStatement();
            stmt.execute(createSQL);
            System.out.println("table created ");
*/
            return conn;

        } catch (SQLException ex) {
            System.out.println("in connection " + ex);
            return null;
        }

    }
}
