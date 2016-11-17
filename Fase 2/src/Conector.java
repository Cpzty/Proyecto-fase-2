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
    
    public static Connection ConnectDB(){
    {
       
      try {
         Class.forName("org.postgresql.Driver");
         Connection c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/ReciGuate",
            "postgres", "root");
         c.setAutoCommit(false);
         return c;
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      return null;
    }
    
    }
    
    public JTable GetInfoFromQuery(String Query)
    {
        JTable result = new JTable();
        Connection c = null;
        Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/ReciGuate",
            "postgres", "root");
         c.setAutoCommit(false);
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully jojo");
        try {
            stmt = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //AQUI ESTA LA QUERY, LO QUE MANDE AQUI SE MUESTRA
            ResultSet rs = stmt.executeQuery(Query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            ArrayList<String> columnNames = new ArrayList<String>();
            ArrayList<String> columnLabels = new ArrayList<String>();
            ArrayList<String> columnTypes = new ArrayList<String>();
            for(int i=1; i<rsmd.getColumnCount()+1; i++)
            {
                String name = rsmd.getColumnName(i);
                //System.out.println("Column Name: " + name);
                String Label = rsmd.getColumnLabel(i);
                //System.out.println("Column Label: " + Label);
                String Type = rsmd.getColumnTypeName(i);
                System.out.println("Column Type: " + Type);
                columnNames.add(name);
                columnLabels.add(Label);
                columnTypes.add(Type);
            }
            
            Object columnN[] = columnNames.toArray();
            ArrayList<Object[]> Rows = new ArrayList<Object[]>();
            int counter =0;
            while(rs.next())
            {
                
                ArrayList<String> row = new ArrayList<String>();
                for(int i=0; i<columnNames.size(); i++)
                {
                    String toAdd = "";
                    if(columnTypes.get(i).equals("int4"))
                    {
                        int temp = rs.getInt(columnLabels.get(i));
                        toAdd = String.valueOf(temp);
                        row.add(toAdd);
                    }
                    else if(columnTypes.get(i).equals("varchar"))
                    {
                        toAdd = rs.getString(columnLabels.get(i));
                        row.add(toAdd);
                    }
                    else if(columnTypes.get(i).equals("bool"))
                    {
                        boolean temp = rs.getBoolean(columnLabels.get(i));
                        toAdd = String.valueOf(temp);
                        row.add(toAdd);
                    }
                    else if(columnTypes.get(i).equals("bytea"))
                    {
                        toAdd = "<binary data>";
                        row.add(toAdd);
                    }
                    else if(columnTypes.get(i).equals("date"))
                    {
                        Date temp = rs.getDate(columnLabels.get(i));
                        toAdd = String.valueOf(temp);
                        row.add(toAdd);
                    }
                    else if(columnTypes.get(i).equals("float4"))
                    {
                        float temp = rs.getFloat(columnLabels.get(i));
                        toAdd = String.valueOf(temp);
                        row.add(toAdd);
                    }
                }
                Object finna[] = row.toArray();
                Rows.add(finna);
                counter++;
            }
            Object rowData[][];
            rowData = new Object[counter][columnNames.size()];
            for(int i=0;i<counter; i++)
            {
               rowData[i] = Rows.get(i);
            }
            
            result = new JTable(rowData, columnN);
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    
    public void InsertIntoTable(String Query)
    {
        Connection c = null;
        Statement stmt = null;
        try {
           Class.forName("org.postgresql.Driver");
           c = DriverManager
              .getConnection("jdbc:postgresql://localhost:5432/ReciGuate",
              "postgres", "root");
           c.setAutoCommit(false);
           System.out.println("Opened database successfully");

           stmt = c.createStatement();
           stmt.executeUpdate(Query);

           stmt.close();
           c.commit();
           c.close();
        } catch (Exception e) {
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
           System.exit(0);
        }
        System.out.println("Record created successfully");
    }
    
    
  

}
