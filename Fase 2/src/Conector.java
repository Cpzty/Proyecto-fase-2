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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
    
    public void agregar(String nombre, String contrasenia){
    	 Connection c = null;
         Statement stmt = null;
         try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
               .getConnection("jdbc:postgresql://localhost:5432/ReciGuate", "postgres", "root");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
            int contador = 0;
            while ( rs.next() ) {
            	contador++;
            }
            contador = contador+1;
            String sql = "INSERT INTO USUARIOS (ID,NAME,PASSWORD) "
		               + "VALUES ("+contador+", '"+nombre+"', '"+contrasenia+"');";
            
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