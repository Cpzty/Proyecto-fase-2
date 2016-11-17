/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author María Mercedes Retolaza Reyna 
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
public class Conector {
    public void conectar(){
    	 Connection c = null;
         try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ReciGuate", "postgres", "root");
         } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
         }
         System.out.println("Opened database successfully");
    }
    
    public void agregar(String sql){
    	 Connection c = null;
         Statement stmt = null;
         try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
               .getConnection("jdbc:postgresql://localhost:5432/ReciGuate", "postgres", "root");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
         } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
         }
         System.out.println("Records created successfully");
    }
    
    public boolean buscar(String nombre, String contrasenia){
    	 Connection c = null;
         Statement stmt = null;
         boolean encontro = false;
         try {
         Class.forName("org.postgresql.Driver");
           c = DriverManager
              .getConnection("jdbc:postgresql://localhost:5432/ReciGuate", "postgres", "root");
           c.setAutoCommit(false);
           System.out.println("Opened database successfully");

           stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
           while ( rs.next() ) {
              int id = rs.getInt("id");
              String  name = rs.getString("name");
              String pass = rs.getString("password");
              if (name.equals(nombre) && pass.equals(contrasenia)){
            	  encontro = true;
              }
              
           }
           rs.close();
           stmt.close();
           c.close();
         } catch ( Exception e ) {
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
           System.exit(0);
         }
         System.out.println("Operation done successfully");
         return encontro;
    }
    
}