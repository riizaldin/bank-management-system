package bank;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3308/bank2", "root", "Unimed2023");
            s = c.createStatement();
        } catch (Exception e){
            e.printStackTrace(); // This will print the full stack trace of the exception
            System.out.println("Failed to connect to the database: " + e.getMessage());
        
    }
}
}
