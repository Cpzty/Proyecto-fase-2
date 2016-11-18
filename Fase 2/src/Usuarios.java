import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 * @author María Mercedes Retolaza 
 *
 */
public class Usuarios {
   /** En esta clase se creará la tabla que se utilizará para guardar los datos de los usuarios en la base de datos "ReciGuate"
 * @param args
 */
public static void main( String args[] )
     {
       Connection c = null;//
       Statement stmt = null;//
       try {
         Class.forName("org.postgresql.Driver");// //Driver de postgresql a utilizar
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/ReciGuate",
            "postgres", "root");// hace una conexion con la base de datos, aquí se necesitan los parámatros de contraeña, nombre y servidor 
         System.out.println("Opened database successfully");// mensaje que le indica al usuario que la base de datos se ha abierto correctamente 

         stmt = c.createStatement(); //Se instancia el statement que se enviará a la base de datos
         String sql =  "CREATE TABLE USUARIOS " +
	                 "(ID INT PRIMARY KEY     NOT NULL," +
	                 " NAME           TEXT    NOT NULL, " +
	                 " PASSWORD       TEXT     NOT NULL, "+
	                 " BUSSINES       BOOLEAN  NOT NULL)"; // Instrucción sql que inserta los parámetros de las tablas 
         stmt.executeUpdate(sql); //Se envia la orden de ingreso a la base de datos
         stmt.close();//Se cierra el statement
         c.close();//Se cierra la conexion a la base de datos
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Table created successfully"); //Mensaje que indica que la tabla fue creada de manera exitosa 
     }
}