import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**En esta clase se creará la tabla "Empresa" que se utilizará en la base de datos "ReciGuate" para almacenar los datos de las Empresas
 * @author María Mercedes Retoalza 
 *
 */
public class Empresa {
   public static void main( String args[] )
     {
       Connection c = null;//Se crea un objeto de tipo coneccion para conectar a la base de datos
       Statement stmt = null;//Se crea un objeto de tipo statement, que se usara para enviarle la orden a la base de datos
       try {
         Class.forName("org.postgresql.Driver");//Driver que se utilizará 
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/ReciGuate",
            "postgres", "root");// Instrucción que obtiene la conexion de la base de datos, incluye el nombre d ela base, el puerto , contraseña y host 
         System.out.println("Opened database successfully");//Mensaje que indica que la base de datos se ha abierto satisfactoriamente 

         stmt = c.createStatement();
         String sql = "CREATE TABLE EMPRESA " +
                 "(ID INT PRIMARY KEY     NOT NULL," +
                 " NOMBRE           TEXT    NOT NULL, " +
                 " PASSWORD         INT     NOT NULL),"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Table created successfully");
     }
}