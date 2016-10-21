/**
 * 
 * @author Luis Diego Fernández
 * @author Rodrigo Urrutia
 * @author Helmuth Nisal
 * @author Gadhi Rodriguez
 * @author Cristian Perez
 * @author Mercedes Retolaza
 * @version 30.09.2016
 *
 */
public class Recicladora {
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String pagina;
	private int zona;
	private boolean papel;
	private boolean plastico;
	private boolean metal;
	private boolean vidrio;
	
	public Recicladora(){
		id = 0;
		nombre = "";
		direccion = "";
		telefono = "";
		pagina = "";
		zona = 0;
		papel = false;
		plastico = false;
		metal = false;
		vidrio = false;
	}
	/**
	*Metodo que devuelve el valor del atributo id de la recicladora.
	* @return Devuelve el id
	*/
	public int getId() {
		return id;
	}
	/**
	*Metodo que cambia el valor del atributo id de la recicladora.
	* @param id El id de la Recicladora
	*/
	public void setId(int id) {
		this.id = id;
	}
	/**
	*Metodo que devuelve el valor del atributo nombre de la recicladora.
	* @return Devuelve el nombre
	*/
	public String getNombre() {
		return nombre;
	}
	/**
	*Metodo que cambia el valor del atributo nombre de la recicladora.
	* @param nombre El nombre de la recicladora
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	*Metodo que devuelve el valor del atributo direccion de la recicladora.
	* @return Devuelve la direccion de la recicladora
	*/
	public String getDireccion() {
		return direccion;
	}
	/**
	*Metodo que cambia el valor del atributo direccion de la recicladora.
	* @param direccion La direccion de la recicladora
	*/
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	*Metodo que devuelve el valor del atributo telefono de la recicladora.
	* @return Devuelve el telefono de la recicladora
	*/
	public String getTelefono() {
		return telefono;
	}
	/**
	*Metodo que cambia el valor del atributo telefono de la recicladora.
	* @param telefono El nomero telefonico de la recicladora
	*/
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	*Metodo que devuelve el valor del atributo pagina de la recicladora.
	* @return Devuelve la pagina web de la recicladora
	*/
	public String getPagina() {
		return pagina;
	}
	/**
	*Metodo que cambia el valor del atributo pagina de la recicladora.
	* @param La pagina web de la recicladora
	*/
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	/**
	*Metodo que devuelve el valor del atributo zona de la recicladora.
	* @return Devuelve la zona de la recicladora
	*/
	public int getZona() {
		return zona;
	}
	/**
	*Metodo que cambia el valor del atributo id de la recicladora.
	* @param zona La zona de la recicladora
	*/
	public void setZona(int zona) {
		this.zona = zona;
	}
	/**
	*Metodo que devuelve true si la recicladora recicla papel o false si no.
	* @return Devuelve true o false
	*/
	public boolean isPapel() {
		return papel;
	}
	/**
	*Metodo que cambia el valor del atributo papel de la recicladora.
	* @param papel True o False
	*/
	public void setPapel(boolean papel) {
		this.papel = papel;
	}
	/**
	*Metodo que devuelve true si la recicladora recicla papel o false si no.
	* @return Devuelve true o false
	*/
	public boolean isPlastico() {
		return plastico;
	}
	/**
	*Metodo que cambia el valor del atributo plastico de la recicladora.
	* @param plastico True o False
	*/
	public void setPlastico(boolean plastico) {
		this.plastico = plastico;
	}
	/**
	*Metodo que devuelve true si la recicladora recicla papel o false si no.
	* @return Devuelve true o false
	*/
	public boolean isMetal() {
		return metal;
	}
	/**
	*Metodo que cambia el valor del atributo metal de la recicladora.
	* @param metal True o False
	*/
	public void setMetal(boolean metal) {
		this.metal = metal;
	}
	/**
	*Metodo que devuelve true si la recicladora recicla papel o false si no.
	* @return Devuelve true o false
	*/
	public boolean isVidrio() {
		return vidrio;
	}
	/**
	*Metodo que cambia el valor del atributo vidrio de la recicladora.
	* @param vidrio True o False
	*/
	public void setVidrio(boolean vidrio) {
		this.vidrio = vidrio;
	}

	/**
	 * @param regresar String especificando el dato que se quiere que se retorne una cadena con su informacion.
	 * @return cadena con la informacion del dato especificado en la variable regresar.
	 */
	public String toString(String regresar) {
		boolean[] bMateriales = {papel, plastico, metal, vidrio};
		String [] sMateriales = {"Papel", "Plastico", "Metal", "Vidrio"};
		String cadena = "";
		
		if (regresar == "id")
			cadena = Integer.toString(getId());
		
		if (regresar == "nombre")
			cadena = getNombre();
		
		if (regresar == "direccion")
			cadena = getDireccion();
		
		if (regresar == "telefono")
			cadena = getTelefono();
		
		if (regresar == "pagina")
			cadena = getPagina();
		
		if (regresar == "materiales"){
			cadena ="";
			for (int i = 0; i < 4; i++){
				if (bMateriales[i] == true){
					cadena = cadena + sMateriales[i] + ", ";
				}
			}
			cadena = cadena.substring(0, cadena.length() - 2);
		}
		
		return cadena;
	}
	
	
	
}

