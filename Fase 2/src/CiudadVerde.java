/**
 * 
 * @author Luis Diego Fern�ndez
 * @author Rodrigo Urrutia
 * @author Helmuth Nisal
 * @author Gadhi Rodriguez
 * @author Cristian Perez
 * @author Mercedes Retolaza
 * @version 30.09.2016
 *
 */
public class CiudadVerde {
	Recicladora vical = new Recicladora();
	Recicladora diso = new Recicladora();
	Recicladora recipa = new Recicladora();
	Recicladora clapsa = new Recicladora();
	Recicladora redecologica = new Recicladora();
	Recicladora interfisa = new Recicladora();
	Recicladora reciclemos = new Recicladora();
	Recicladora lajoya = new Recicladora();
	Recicladora abempaques = new Recicladora();
	Recicladora sidegua = new Recicladora();
	Recicladora ingrup = new Recicladora();
	Recicladora selmet = new Recicladora();
	Recicladora exprore = new Recicladora();
	Recicladora sanjose = new Recicladora();
	Recicladora biogeneraciones = new Recicladora();
	Recicladora comercartonpapel = new Recicladora();
	Recicladora amigosNaturaleza = new Recicladora();
	Recicladora globoplast = new Recicladora();
	Recicladora villaNueva = new Recicladora();
	Recicladora reciOccidnete = new Recicladora();
	Recicladora centroReciclaje = new Recicladora();
	Recicladora antigua = new Recicladora();
	Recicladora lasTresMarias = new Recicladora();
	Recicladora btb = new Recicladora();
	
	Recicladora[] ciudad = {globoplast,vical,diso,recipa,clapsa,
						redecologica,interfisa,reciclemos,lajoya,abempaques,sidegua,
						ingrup,selmet,exprore,sanjose,biogeneraciones,comercartonpapel};
	
	Recicladora[] exterior = {amigosNaturaleza, globoplast, villaNueva, reciOccidnete,
						centroReciclaje, centroReciclaje, antigua, lasTresMarias, btb};
	
	//Array bidimensional siendo la primera dimension la posicion del segundo array segun la zona,
	//y el segundo array contiene int con las zonas mas cercanas para reciclar, en este orde:
	//papel, plastico, vidrio y metal.
	int[][] arrZonas = {{1, 1, 1, 1}, {1, 1, 1, 1}, {3, 3, 1, 1}, {9, 9, 9, 9},
						{1, 1, 1, 1}, {1, 1, 1, 1}, {11, 3, 8, 8}, {8, 8, 8, 8},
						{9, 9, 9, 9}, {9, 9, 9, 9}, {11, 8, 12, 8}, {11, 8, 12, 8},
						{13, 13, 13, 13}, {14, 14, 14, 14}, {1, 1, 1, 1}, {1, 1, 1, 1},
						{17, 1, 1, 1}, {17, 1, 1, 1}, {11, 8, 8, 8}};
	
	/**
	 * Constructor		
	 */
	public CiudadVerde(){
		
		vical.setId(2);
		vical.setNombre("Vical");
		vical.setDireccion("Avenida Petapa 48-01 zona 12");
		vical.setTelefono("2422-6400");
		vical.setPagina("www.grupovical.com");
		vical.setVidrio(true);
		vical.setZona(12);
		
		diso.setId(3);
		diso.setNombre("Diso S.A.");
		diso.setDireccion("21 C 1-33 zona 1");
		diso.setTelefono("2221-1372");
		diso.setPagina("www.recicladoradiso.com");
		diso.setPlastico(true);
		diso.setMetal(true);
		diso.setPapel(true);
		diso.setVidrio(true);
		diso.setZona(1);
		
		recipa.setId(4);
		recipa.setNombre("Recipa");
		recipa.setDireccion("2 calle 2-72 zona 9");
		recipa.setTelefono("2361-1555");
		recipa.setPagina("www.recipa.net");
		recipa.setPlastico(true);
		recipa.setMetal(true);
		recipa.setPapel(true);
		recipa.setVidrio(true);
		recipa.setZona(9);
		
		clapsa.setId(5);
		clapsa.setNombre("Clapsa");
		clapsa.setDireccion("15 ave. 42-19 zona 8");
		clapsa.setTelefono("5030-9546");
		clapsa.setPagina("www.clapsa.com");
		clapsa.setPlastico(true);
		clapsa.setMetal(true);
		clapsa.setPapel(true);
		clapsa.setVidrio(true);
		clapsa.setZona(8);
		
		redecologica.setId(6);
		redecologica.setNombre("Red Ecologica S.A.");
		redecologica.setDireccion("KM 10, Carretera al Atlantico, Z-17, Apto. D");
		redecologica.setTelefono("2427-1360");
		redecologica.setPagina("www.redecologica.com.gt");
		redecologica.setPlastico(false);
		redecologica.setMetal(false);
		redecologica.setPapel(true);
		redecologica.setVidrio(false);
		redecologica.setZona(17);
		
		interfisa.setId(7);
		interfisa.setNombre("Interfisa");
		interfisa.setDireccion("7 ave. 39-26 zona 3");
		interfisa.setTelefono("2440-9800");
		interfisa.setPagina("www.interfisa.com.gt");
		interfisa.setPlastico(true);
		interfisa.setMetal(false);
		interfisa.setPapel(true);
		interfisa.setVidrio(false);
		interfisa.setZona(3);
		
		reciclemos.setId(8);
		reciclemos.setNombre("Reciclemos");
		reciclemos.setDireccion("1 ave. 4-30 Z-2, Boca del Monte, Villa Canales");
		reciclemos.setTelefono("5651-8188");
		reciclemos.setPagina("www.reciclemosguatemala.com");
		reciclemos.setPlastico(true);
		reciclemos.setMetal(true);
		reciclemos.setPapel(true);
		reciclemos.setVidrio(true);
		reciclemos.setZona(0);
		
		lajoya.setId(9);
		lajoya.setNombre("Recicladora la Joya S.A.");
		lajoya.setDireccion("1 calle 1-85 zona 6, Col. Alamos, San Miguel Petapa");
		lajoya.setTelefono("2448-1286");
		lajoya.setPagina("www.recicladoralajoya.com");
		lajoya.setPlastico(true);
		lajoya.setMetal(true);
		lajoya.setPapel(true);
		lajoya.setVidrio(true);
		lajoya.setZona(6);
		
		abempaques.setId(10);
		abempaques.setNombre("A.B. Empaques");
		abempaques.setDireccion("35 ave. 24-71 zona 5, Apto. 1, Colonia Vivibien");
		abempaques.setTelefono("2331-4843");
		abempaques.setPagina("www.abempaques.com");
		abempaques.setPlastico(false);
		abempaques.setMetal(false);
		abempaques.setPapel(true);
		abempaques.setVidrio(false);
		abempaques.setZona(10);
		
		sidegua.setId(11);
		sidegua.setNombre("Sidegua S.A.");
		sidegua.setDireccion("Ave. Las Americas 18-81 zona 13, Edif. Columbus Center, Niv. 14");
		sidegua.setTelefono("2363-1834");
		sidegua.setPagina("www.acerosdeguatemala.com");
		sidegua.setPlastico(true);
		sidegua.setMetal(true);
		sidegua.setPapel(true);
		sidegua.setVidrio(true);
		sidegua.setZona(13);
		ingrup.setId(12);
		ingrup.setNombre("Ingrup");
		ingrup.setDireccion("Diagonal 19, Ave. Petapa 8-95 zona 21");
		ingrup.setTelefono("2326-5700");
		ingrup.setPagina("www.ingruplatam.com");
		ingrup.setPlastico(true);
		ingrup.setMetal(true);
		ingrup.setPapel(true);
		ingrup.setVidrio(true);
		ingrup.setZona(21);
		
		selmet.setId(13);
		selmet.setNombre("Selmet Guatemala S.A");
		selmet.setDireccion("5 ave. 5-55 zona 14, Edif. Europlaza, Torre 1, Niv. 2");
		selmet.setTelefono("2386-9999");
		selmet.setPagina("www.selmetguatemala.com");
		selmet.setPlastico(true);
		selmet.setMetal(true);
		selmet.setPapel(false);
		selmet.setVidrio(false);
		selmet.setZona(14);

		exprore.setId(14);
		exprore.setNombre("Exprore S.A.");
		exprore.setDireccion("18 ave. 1-14 zona 14");
		exprore.setTelefono("2428-7300");
		exprore.setPagina("www.facebook.com/Exprorersa/info");
		exprore.setPlastico(true);
		exprore.setMetal(true);
		exprore.setPapel(false);
		exprore.setVidrio(false);
		exprore.setZona(14);

		sanjose.setId(15);
		sanjose.setNombre("Recicladora San Jose");
		sanjose.setDireccion("4 ave. 1-73 zona 9");
		sanjose.setTelefono("5523-9166");
		sanjose.setPagina("recicladorasanjose.com");
		sanjose.setPlastico(true);
		sanjose.setMetal(true);
		sanjose.setPapel(true);
		sanjose.setVidrio(true);
		sanjose.setZona(9);

		biogeneraciones.setId(16);
		biogeneraciones.setNombre("Biogeneraciones S.A.");
		biogeneraciones.setDireccion("5 ave. 5-55 zona 14, Edif. Europlaza, Torre 2, Niv. 5");
		biogeneraciones.setTelefono("2366-2190");
		biogeneraciones.setPagina("N/A");
		biogeneraciones.setPlastico(true);
		biogeneraciones.setMetal(true);
		biogeneraciones.setPapel(true);
		biogeneraciones.setVidrio(true);
		biogeneraciones.setZona(14);
		
		comercartonpapel.setId(17);
		comercartonpapel.setNombre("Comercializadora de Carton y Papel S.A.");
		comercartonpapel.setDireccion("26 calle 7-19B zona 11");
		comercartonpapel.setTelefono("5606-1827");
		comercartonpapel.setPagina("recoveryocc.com/guatemala.html");
		comercartonpapel.setPlastico(false);
		comercartonpapel.setMetal(false);
		comercartonpapel.setPapel(true);
		comercartonpapel.setVidrio(false);
		comercartonpapel.setZona(11);
		
		//Todas las recicladoras con Ids mayores a 18 son de recicladoras fuera de la ciudad.
		
		//Mixco
		amigosNaturaleza.setId(18);
		amigosNaturaleza.setNombre("Amigos De La Naturaleza");
		amigosNaturaleza.setDireccion("9 calle 13-82, zona 8 de Mixco");
		amigosNaturaleza.setTelefono("2476-9884");
		amigosNaturaleza.setPagina("http://www.amigosdelanaturaleza.net");
		amigosNaturaleza.setPapel(true);
		amigosNaturaleza.setZona(100);
		
		globoplast.setId(19);
		globoplast.setNombre("Globoplast");
		globoplast.setDireccion("4 ave. 4-21 zona 8, Mixco, Ciudad San Cristobal");
		globoplast.setTelefono("2244-0500");
		globoplast.setPagina("www.paisa.com.gt");
		globoplast.setPlastico(true); 
		globoplast.setMetal(true);
		globoplast.setVidrio(true);
		globoplast.setZona(100);
		
		//Villa Nueva
		villaNueva.setId(20);
		villaNueva.setNombre("ComPlast Manufacturing");
		villaNueva.setDireccion("Km 21 Antigua Carretera a Guatemala");
		villaNueva.setTelefono("6644-2400");
		villaNueva.setPagina("N/A");
		villaNueva.setPlastico(true);
		villaNueva.setMetal(true);
		villaNueva.setPapel(true);
		villaNueva.setVidrio(true);
		villaNueva.setZona(101);
		
		//Xela
		reciOccidnete.setId(21);
		reciOccidnete.setNombre("Reciclados De Occidente (Xela)");
		reciOccidnete.setDireccion("7a. avenida 15-40 zona 5, Las Rosas, Quetzaltenango");
		reciOccidnete.setTelefono("5317-8901");
		reciOccidnete.setPagina("N/A");
		reciOccidnete.setPlastico(true);
		reciOccidnete.setMetal(true);
		reciOccidnete.setPapel(true);
		reciOccidnete.setVidrio(true);
		reciOccidnete.setZona(102);
		
		//Carretera Paramericana
		centroReciclaje.setId(22);
		centroReciclaje.setNombre("Centro de Reciclaje");
		centroReciclaje.setDireccion("km. 224.2 Carretera Panamericana, Canton Chichiguitan zona 5, Quetzaltenango");
		centroReciclaje.setTelefono("5317-8901");
		centroReciclaje.setPagina("N/A");
		centroReciclaje.setPlastico(true);
		centroReciclaje.setMetal(true);
		centroReciclaje.setPapel(true);
		centroReciclaje.setVidrio(true);
		centroReciclaje.setZona(103);
		
		//Antigua
		antigua.setId(23);
		antigua.setNombre("Guatemala Verde");
		antigua.setDireccion("El servicio es adomicilio, (Solo para Antigua Guatemala)");
		antigua.setPagina("recycle@viaventure.org");
		antigua.setTelefono("5104-8447 o 5778-4009");
		antigua.setPlastico(true);
		antigua.setMetal(true);
		antigua.setPapel(true);
		antigua.setVidrio(true);
		antigua.setZona(104);
		
		//Villa Hermosa
		lasTresMarias.setId(24);
		lasTresMarias.setNombre("Recicladora Las Tres Marias");
		lasTresMarias.setDireccion("km. 14.5 Carretera a Villa Nueva");
		lasTresMarias.setTelefono("5719-5995");
		lasTresMarias.setPagina("recicladoralastresmarias.com");
		lasTresMarias.setPlastico(true);
		lasTresMarias.setMetal(true);
		lasTresMarias.setPapel(true);
		lasTresMarias.setVidrio(true);
		lasTresMarias.setZona(105);
		
		//Santa Rosa
		btb.setId(25);
		btb.setNombre("Botella Botella");
		btb.setDireccion("km. 44.5 Carretera a Pueblo Nuevo Vinas, Santa Rosa");
		btb.setTelefono("5719-5995");
		btb.setPagina("N/A");
		btb.setPlastico(true);
		btb.setPapel(true);
		btb.setMetal(true);
		btb.setVidrio(true);
		btb.setZona(106);
	}
	
	/**
	 * Metodo para buscar recicladoras fuera de la ciudad segun la zona ingresada.
	 * @param material1 String con el material que de reciclaje.
	 * @param zona int devuelta segun el lugar fuera de la ciudad que se encuentre el usuario (esta zonas no son las mismas que la ciudad)
	 * @param regresar String especificando el dato que se quiere que se retorne una cadena con su informacion. 
	 * @return cadena con la informacion del dato especificado en la variable regresar de la recicladora mas cercana a la ubicacion del usuario.
	 */
	public String buscarFueraCiudad(String material1, int zona, String regresar){
		String cadena = "Revisar datos";
		material1.toLowerCase();
		
		if (zona == 100){
			if (material1.equals("Papel")){
				cadena = amigosNaturaleza.toString(regresar);
			}
			else{
				cadena = globoplast.toString(regresar);
			}
		}
		else{
			for (int i = 0; i < exterior.length; i++){
				if (exterior[i].getZona() == zona){
					cadena = exterior[i].toString(regresar);
				}
			}
		}
		return cadena;
	}
	
	/**
	 * Metodo para retornar los datos de una recicladora en especifico dependiendo de la zona ingresada.
	 * @param material String con el material que de reciclaje.
	 * @param zona int con la zona que se encuentra el usuario.
	 * @param regresar String especificando el dato que se quiere que se retorne una cadena con su informacion.
	 * @return cadena con la informacion del dato especificado en la variable regresar de la recicladora mas cercana a la ubicacion del usuario.
	 */
	public String buscarRecicladora(String material1, int zona, String regresar){
		String cadena = "Revisar datos";
		int e = zona - 1;
		int f1=0, f2=0;
		boolean papel=false;//papel
		boolean plastico=false;//plastico
		boolean vidrio=false;//vidrio
		boolean metal=false;//metal
		
		material1 = material1.toLowerCase();

		if(material1.equals("papel")){
			papel = true;
		}
		if(material1.equals("plastico")){
			plastico = true;
			f1=1;
		}
		if(material1.equals("vidrio")){
			vidrio = true;
			f1=2;
		}
		if(material1.equals("metal")){
			metal = true;
			f1=3;
		}
		if(material1.equals("papel y plastico")){
			papel = true;
			plastico =true;
			f2=1;
		}
		if(material1.equals("papel y vidrio")){
			papel = true;
			vidrio =true;
			f2=2;
		}
		if(material1.equals("papel y metal")){
			papel=true;
			metal = true;
			f2=2;
		}
		if(material1.equals("plastico y vidrio")){
			plastico = true;
			vidrio= true;
			f1=1;
			f2=2;
		}
		if(material1.equals("plastico y metal")){
			plastico =true;
			metal = true;
			f1=1;
			f2=3;
		}
		if(material1.equals("vidrio y metal")){
			vidrio=true;
			metal = true;
			f1=2;
			f2=3;
		}
		
		zona = arrZonas[e][f1];
	
		for (int i = 0; i < 17; i++){
			if (ciudad[i].getZona() == zona){
				if((papel && plastico)&&(ciudad[i].isPapel()&&ciudad[i].isPlastico())){			//reciclar papel y plastico
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((papel && vidrio)&&(ciudad[i].isPapel()&&ciudad[i].isVidrio())){		//reciclar papel y vidrio
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((papel && metal)&&(ciudad[i].isPapel()&&ciudad[i].isMetal())){			//reciclar papel y metal
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((plastico && vidrio)&&(ciudad[i].isPlastico()&&ciudad[i].isVidrio())){	//reciclar plastico y vidrio
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((plastico && metal)&&(ciudad[i].isPlastico()&&ciudad[i].isMetal())){	//reciclar plastico y metal
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((vidrio && metal)&&(ciudad[i].isVidrio()&&ciudad[i].isMetal())){		//reciclar vidrio y metal
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if (papel && ciudad[i].isPapel()){										//reciclar papel 
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}
				else if (plastico && ciudad[i].isPlastico()){									//reciclar plastico
					cadena = ciudad[i].toString(regresar);
					i = 17;
				}
				else if (vidrio&& ciudad[i].isVidrio()){										//reciclar vidrio
					cadena = ciudad[i].toString(regresar);
					i = 17;
				}	
				else if (metal && ciudad[i].isMetal()){											//reciclar metal
					cadena = ciudad[i].toString(regresar);
					i = 17;
				}
			}
		}
		if (cadena.equals("Revisar datos")){
			zona =arrZonas[e][f2];
			for (int i = 0; i < 17; i++){
			if (ciudad[i].getZona() == zona){
				if((papel && plastico)&&(ciudad[i].isPapel()&&ciudad[i].isPlastico())){			//reciclar papel y plastico
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((papel && vidrio)&&(ciudad[i].isPapel()&&ciudad[i].isVidrio())){		//reciclar papel y vidrio
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((papel && metal)&&(ciudad[i].isPapel()&&ciudad[i].isMetal())){			//reciclar papel y metal
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((plastico && vidrio)&&(ciudad[i].isPlastico()&&ciudad[i].isVidrio())){	//reciclar plastico y vidrio
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((plastico && metal)&&(ciudad[i].isPlastico()&&ciudad[i].isMetal())){	//reciclar plastico y metal
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if((vidrio && metal)&&(ciudad[i].isVidrio()&&ciudad[i].isMetal())){		//reciclar vidrio y metal
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}else if (papel && ciudad[i].isPapel()){										//reciclar papel 
					cadena = ciudad[i].toString(regresar);
					i = 17;	
				}
				else if (plastico && ciudad[i].isPlastico()){									//reciclar plastico
					cadena = ciudad[i].toString(regresar);
					i = 17;
				}
				else if (vidrio&& ciudad[i].isVidrio()){										//reciclar vidrio
					cadena = ciudad[i].toString(regresar);
					i = 17;
				}	
				else if (metal && ciudad[i].isMetal()){											//reciclar metal
					cadena = ciudad[i].toString(regresar);
					i = 17;
				}
			}
		}
			
		
		}
		return cadena;
	}
	
	public String mostrarInfo(String nombre, String regresar){
		String cadena = "";
		Recicladora temp = new Recicladora();
		for (int i = 0; i < ciudad.length; i++){
			if (ciudad[i].getNombre().equals(nombre)){
				temp = ciudad[i];
			}
		}
		if(regresar.equals("nombre")){
			cadena = temp.getNombre();
		}else if(regresar.equals("direccion")){
			cadena = temp.getDireccion();
		}else if(regresar.equals("telefono")){
			cadena = temp.getTelefono();
		}else if(regresar.equals("web")){
			cadena = temp.getPagina();
		}
		
		return cadena;
	}
	
}