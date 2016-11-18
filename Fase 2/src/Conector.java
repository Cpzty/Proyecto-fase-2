
/**
 *
 * @author María Mercedes Retolaza Reyna 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
    
	/**
	 * Metodo para agregar nuevos usuarios a la base de datos
	 * @param nombre El nombre del usuario
	 * @param contrasenia La contrasenia del usuario
	 */
    public void agregar(String nombre, String contrasenia, String empresa){
    	 Connection c = null; //Se crea un objeto de tipo coneccion para conectar a la base de datos
         Statement stmt = null; //Se crea un objeto de tipo statement, que se usara para enviarle la orden a la base de datos
         try {
			Class.forName("org.postgresql.Driver"); //Driver de postgresql a utilizar
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ReciGuate", "postgres", "root"); //Se hace la conexión con el objeto c (instancia de "Connection") y la base de datos aqui se incluye el nombre de la base de datos, el nombre del usuario y la contraseña 
			c.setAutoCommit(false); //Se le quita el estado de AutoCommit a la conexión, para que se hagan todas las acciones nesesarias, y luego se envién todas juntas a la base de datos
			//System.out.println("Opened database successfully");
			
			stmt = c.createStatement(); //Se instancia el statement que se enviará a la base de datos
			ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" ); //Se crea un Resultset que "TOMA" los datos que se encuentran en la base de datos en la tabla  USUARIOS
			int contador = 0; //Contador que se utilizara para encontrar el tamaño de la base de datos
			while ( rs.next() ) { //ciclo (while) que le suma uno al contador cada vez que pasa por una fila de la tabla
				contador++;
			}
			contador = contador+1; //Se le suma uno al tamanio final de la tabla para ser usado como un nuevo ID
			String sql = "INSERT INTO USUARIOS (ID,NAME,PASSWORD,BUSSINES) " + "VALUES ("+contador+", '"+nombre+"', '"+contrasenia+"', "+empresa+");"; //Se crea un String con la notacion especial de base de datos este debe de ir  con el  orden de Ingreso de datos (de la tabla)
			
			stmt.executeUpdate(sql); //Se envia la orden de ingreso a la base de datos
			
			stmt.close(); //Se cierra el statement
			c.commit(); //Se envian todas las ordenes (como en git)
			c.close(); //Se cierra la conexion a la base de datos
         } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() ); //Se imprime la exception que tira
            System.exit(0);
         }
         //System.out.println("Records created successfully");
    }
    
    /**
     * Metodo para buscar los usuarios agregados a la base de datos y sus respectivas contrasenias
     * @param nombre El nombre de usuario a buscar
     * @param contrasenia La contrasenia del usuario a buscar
     * @return Devuelve true si se encuentra el usuario con su contrasenia o false si no
     */
    public boolean buscar(String nombre, String contrasenia){
    	 Connection c = null; //Se crea un objeto de tipo coneccion para conectar a la base de datos
         Statement stmt = null; //Se crea un objeto de tipo statement, que se usara para enviarle la orden a la base de datos
         boolean encontro = false; //Variable que guardara el valor de retorno que se usara para determinar si el usuario y su contrasenia estan en la base de datos
         try {
        	Class.forName("org.postgresql.Driver"); //Driver de postgresql a utilizar
 			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ReciGuate", "postgres", "root"); //Se hace la conexión con el objeto c (instancia de "Connection") y la base de datos
 			c.setAutoCommit(false); //Se le quita el estado de AutoCommit a la conexión, para que se hagan todas las acciones nesesarias, y luego se envién todas juntas a la base de datos
 			//System.out.println("Opened database successfully");

 			stmt = c.createStatement(); //Se instancia el statement que se enviará a la base de datos
			ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" ); //Se crea un Resultset que extrae todos los datos de la base de datos USUARIOS
           while ( rs.next() ) { //Loop que recorre toda la tabla ResultSet de datos
              String  name = rs.getString("name");
              String pass = rs.getString("password");
              if (name.equals(nombre) && pass.equals(contrasenia)){
            	  encontro = true; //Cambia la variable "encontro" a true si se encuentra el nombre de usuario y la contrasenia (ingresados en los argumentos del metodo) en la base de datos
              }
              
           }
           rs.close(); //Se cierra el ResultSet
           stmt.close(); //Se cierra el statement
           c.close(); //Se cierra la conexion
         } catch ( Exception e ) {
           System.err.println( e.getClass().getName()+": "+ e.getMessage() ); //Se imprime la exception que tira
           System.exit(0);
         }
         //System.out.println("Operation done successfully");
         return encontro; //Se devuelve true si se encontro el usuario y su contrasenia o false si no
    }
    
}