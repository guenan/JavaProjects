/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.*;

/**
 *
 * @author lenanguelo
 */
public class DatabaseConnexion {
    public Connection c;
    public Statement s;

    public DatabaseConnexion() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///ebs","root","admin");
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
        
}
