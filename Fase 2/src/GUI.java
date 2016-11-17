import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.SystemColor;



public class GUI {

	private JFrame frame;
	private JTextField txtNombre;
	private JPasswordField passwordField;
	private JTextField txtNombre2;
	private JTextField txtContrasea;
	private JButton btnIngresar;
	private JButton btnRegistrarse;
	Random  rnd = new Random();
	private JButton btnBuscarEmpresa, btnCalcular;
	private JComboBox<String> CBMaterial;
	private JComboBox<Integer> CBZona;
	private JLabel lblNombre,lblDireccion, lblTelefono, lblPagina;
	private CiudadVerde guate;
	private Conector connection;
	private JComboBox<String> cbxMateriales;
	private JComboBox<String> cbxDimensional;
	private JTextField txtCantidad;
	private JLabel lblDatoCurioso;
	private JLabel lblCalcularDineroAhorrado;
    private ControladorConversiones c=new ControladorConversiones();
    private JLabel lblResultado;
    DecimalFormat decimales = new DecimalFormat("0.0000");
    private JLabel lblZona;
    private JLabel lblMaterial, lblMapa;
    private JComboBox<String> comboBoxNombres;
	private JButton btnVerInformacion;
	private JLabel lblInfoWeb;
	private JLabel lblInfoTel;
	private JLabel lblInfoDireccion;
	private JLabel lblInfoNombre;
	private JLabel lblNombre_1;
	private JLabel lblContrasea;
	private JPanel Menu;
	private JPanel Registro;
	private JLabel lblRegistro;
	private JLabel lblNombre2;
	private JLabel lblContrasena2;
	private JButton btnRegistrarse2;
	private JButton btnRegresar;
	private JTabbedPane tabbedPane;
	private JLabel lblMunicipio, lblDineroAhorrado;
	private JComboBox<Object> comboBoxMunicipio;
	private JLabel lblDineroRecibido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * Se conecta a la  base de datos
	 */
	public GUI() {
		initialize();
		ComboBox();
		Random();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		/**
		 * inicializa la clase de conector donde se encuentran los metodos para guardar y obtener datos de la base de datos
		 * Se inicia ciudad verde
		 * Se inician componentes de la GUI
		 */
		
			guate= new CiudadVerde();
			connection = new Conector();
			
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(255, 255, 255));
			frame.setBounds(100, 100, 838, 618);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
        	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        	tabbedPane.setVisible(false);
        	frame.getContentPane().setLayout(new CardLayout(0, 0));
        	frame.getContentPane().add(tabbedPane, "name_411968820848809");
        	
        	JPanel Buscar = new JPanel();
        	tabbedPane.addTab("Buscar", null, Buscar, null);
        	Buscar.setBackground(new Color(204, 255, 153));
        	Buscar.setForeground(new Color(0, 0, 0));
        	
        	lblMaterial = new JLabel("Material:");
        	lblMaterial.setBounds(25, 4, 114, 33);
        	lblMaterial.setFont(new Font("Sylfaen", Font.PLAIN, 30));
        	
        	lblNombre = new JLabel("Nombre");
        	lblNombre.setBounds(334, 17, 328, 33);
        	lblNombre.setForeground(new Color(0, 102, 0));
        	lblNombre.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
        	
        	CBMaterial = new JComboBox<String>();
        	CBMaterial.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	CBMaterial.setBounds(70, 39, 236, 35);
        	CBMaterial.setBackground(new Color(255, 255, 255));
        	
        	lblDireccion = new JLabel("Direccion");
        	lblDireccion.setBounds(333, 61, 328, 24);
        	lblDireccion.setForeground(new Color(0, 102, 0));
        	lblDireccion.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
        	
        	lblZona = new JLabel("Zona: ");
        	lblZona.setBounds(40, 154, 80, 40);
        	lblZona.setForeground(new Color(0, 102, 0));
        	lblZona.setBackground(new Color(51, 204, 51));
        	lblZona.setFont(new Font("Sylfaen", Font.PLAIN, 30));
        	
        	lblTelefono = new JLabel("Telefono");
        	lblTelefono.setBounds(336, 100, 328, 24);
        	lblTelefono.setForeground(new Color(0, 102, 0));
        	lblTelefono.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
        	
        	CBZona = new JComboBox<Integer>();
        	CBZona.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	CBZona.setBounds(70, 202, 238, 35);
        	CBZona.setBackground(new Color(255, 255, 255));
        	
        	lblPagina = new JLabel("Pagina Web");
        	lblPagina.setBounds(337, 141, 328, 24);
        	lblPagina.setForeground(new Color(0, 102, 0));
        	lblPagina.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
        	
        	btnBuscarEmpresa = new JButton("Buscar empresa");
        	btnBuscarEmpresa.setFont(new Font("Kristen ITC", Font.PLAIN, 24));
        	btnBuscarEmpresa.setBounds(26, 250, 309, 46);
        	btnBuscarEmpresa.setBackground(new Color(255, 255, 255));
        	btnBuscarEmpresa.addActionListener(new actionlistener());
        	
        	lblMapa = new JLabel("");
        	lblMapa.setBounds(405, 274, 347, 186);
        	lblMapa.setForeground(new Color(0, 128, 0));
        	lblMapa.setVisible(false);
        	
        	lblDatoCurioso = new JLabel("Dato curioso:");
        	lblDatoCurioso.setBounds(0, 471, 562, 16);
        	lblDatoCurioso.setForeground(new Color(51, 204, 102));
        	
        	comboBoxMunicipio = new JComboBox<Object>();
        	comboBoxMunicipio.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	comboBoxMunicipio.setBounds(70, 120, 236, 38);
        	
        	Buscar.setLayout(null);
        	Buscar.add(lblMaterial);
        	Buscar.add(CBMaterial);
        	Buscar.add(lblNombre);
        	Buscar.add(lblDatoCurioso);
        	Buscar.add(lblMapa);
        	Buscar.add(btnBuscarEmpresa);
        	Buscar.add(lblZona);
        	Buscar.add(CBZona);
        	Buscar.add(comboBoxMunicipio);
        	Buscar.add(lblDireccion);
        	Buscar.add(lblPagina);
        	Buscar.add(lblTelefono);
        	
        	lblMunicipio = new JLabel("Area");
        	lblMunicipio.setForeground(new Color(0, 102, 0));
        	lblMunicipio.setFont(new Font("Sylfaen", Font.PLAIN, 30));
        	lblMunicipio.setBackground(new Color(51, 204, 51));
        	lblMunicipio.setBounds(36, 79, 146, 40);
        	Buscar.add(lblMunicipio);
        	
        	JPanel VerRecicladoras = new JPanel();
        	VerRecicladoras.setBackground(new Color(204, 255, 153));
        	tabbedPane.addTab("Ver Todas las Recicladoras", null, VerRecicladoras, null);
        	VerRecicladoras.setLayout(null);
        	
        	JLabel lblSeleccioneElNombre = new JLabel("Seleccione el Nombre de la Empresa:");
        	lblSeleccioneElNombre.setBounds(0, 0, 215, 20);
        	VerRecicladoras.add(lblSeleccioneElNombre);
        	
        	comboBoxNombres = new JComboBox<String>();
        	comboBoxNombres.setBounds(0, 25, 31, 22);
        	VerRecicladoras.add(comboBoxNombres);
        	
        	btnVerInformacion = new JButton("Ver Informacion");
        	btnVerInformacion.setBounds(0, 52, 125, 25);
        	VerRecicladoras.add(btnVerInformacion);
        	btnVerInformacion.addActionListener(new actionlistener());
        	
        	lblInfoNombre = new JLabel("Nombre");
        	lblInfoNombre.setBounds(0, 82, 469, 16);
        	lblInfoNombre.setForeground(new Color(0, 102, 0));
        	VerRecicladoras.add(lblInfoNombre);
        	
        	lblInfoDireccion = new JLabel("Direccion");
        	lblInfoDireccion.setBounds(0, 103, 469, 16);
        	lblInfoDireccion.setForeground(new Color(0, 102, 0));
        	VerRecicladoras.add(lblInfoDireccion);
        	
        	lblInfoTel = new JLabel("Telefono");
        	lblInfoTel.setBounds(0, 124, 469, 16);
        	lblInfoTel.setForeground(new Color(0, 102, 0));
        	VerRecicladoras.add(lblInfoTel);
        	
        	lblInfoWeb = new JLabel("Pagina Web");
        	lblInfoWeb.setBounds(0, 145, 469, 16);
        	lblInfoWeb.setForeground(new Color(0, 102, 0));
        	VerRecicladoras.add(lblInfoWeb);
        	
        	JPanel Reciclar = new JPanel();
        	tabbedPane.addTab("Reciclar", null, Reciclar, null);
        	Reciclar.setBackground(new Color(204, 255, 153));
        	Reciclar.setLayout(null);
        	
        	JLabel lblSeleccioneElMaterial = new JLabel("Seleccione el material:");
        	lblSeleccioneElMaterial.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblSeleccioneElMaterial.setBounds(11, 40, 264, 16);
        	lblSeleccioneElMaterial.setForeground(new Color(0, 51, 51));
        	Reciclar.add(lblSeleccioneElMaterial);
        	
        	lblCalcularDineroAhorrado = new JLabel("Calcular cantidad reciclada:");
        	lblCalcularDineroAhorrado.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblCalcularDineroAhorrado.setBounds(302, 25, 244, 16);
        	lblCalcularDineroAhorrado.setForeground(new Color(0, 51, 51));
        	Reciclar.add(lblCalcularDineroAhorrado);
        	
        	cbxMateriales = new JComboBox<String>();
        	cbxMateriales.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
        	cbxMateriales.setBounds(11, 67, 152, 22);
        	cbxMateriales.setBackground(new Color(255, 255, 255));
        	Reciclar.add(cbxMateriales);
        	
        	btnCalcular = new JButton("Calcular");
        	btnCalcular.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        	btnCalcular.setForeground(SystemColor.textText);
        	btnCalcular.setBounds(302, 61, 288, 42);
        	btnCalcular.setBackground(new Color(255, 255, 255));
        	Reciclar.add(btnCalcular);
        	btnCalcular.addActionListener(new actionlistener());
        	
        	JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad: ");
        	lblIngreseLaCantidad.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblIngreseLaCantidad.setBounds(11, 103, 220, 16);
        	lblIngreseLaCantidad.setForeground(new Color(0, 51, 51));
        	Reciclar.add(lblIngreseLaCantidad);
        	
        	lblResultado = new JLabel("Resultado:");
        	lblResultado.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblResultado.setBounds(326, 123, 352, 16);
        	lblResultado.setForeground(new Color(0, 51, 51));
        	Reciclar.add(lblResultado);
        	
        	txtCantidad = new JTextField();
        	txtCantidad.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	txtCantidad.setBounds(11, 130, 191, 22);
        	Reciclar.add(txtCantidad);
        	txtCantidad.setColumns(10);
        	
        	JLabel lblSeleccioneLaDimensional = new JLabel("Seleccione la dimensional:");
        	lblSeleccioneLaDimensional.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblSeleccioneLaDimensional.setBounds(10, 176, 220, 16);
        	lblSeleccioneLaDimensional.setForeground(new Color(0, 51, 51));
        	Reciclar.add(lblSeleccioneLaDimensional);
        	
        	cbxDimensional = new JComboBox<String>();
        	cbxDimensional.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
        	cbxDimensional.setBounds(11, 219, 152, 22);
        	cbxDimensional.setBackground(new Color(255, 255, 255));
        	Reciclar.add(cbxDimensional);
        	
        	lblDineroAhorrado = new JLabel("Dinero ahorrado:");
        	lblDineroAhorrado.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblDineroAhorrado.setForeground(new Color(0, 51, 51));
        	lblDineroAhorrado.setBounds(326, 170, 352, 16);
        	Reciclar.add(lblDineroAhorrado);
        	
        	lblDineroRecibido = new JLabel("Cantidad de dinero que recibir\u00E1:");
        	lblDineroRecibido.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblDineroRecibido.setForeground(new Color(0, 51, 51));
        	lblDineroRecibido.setBounds(326, 225, 366, 16);
        	Reciclar.add(lblDineroRecibido);
        	
        	JLabel lblNewLabel = new JLabel("New label");
        	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MECHES\\Documents\\Universidad Del Valle de Guatemala\\Primer A\u00F1o\\Segundo Semestre\\Imagenes_Progra\\reciclando.jpg"));
        	lblNewLabel.setBounds(-10, 341, 848, 273);
        	Reciclar.add(lblNewLabel);
        	
        	/**
    		 * el panel de registro sirve para que una persona cree su usuario, esta oculto al inicio 
    		 * Posee un boton de registro y uno para regresar al menu principal
    		 */
        	
        	Registro = new JPanel();
        	Registro.setBorder(null);
        	frame.getContentPane().add(Registro, "name_411968859242604");
        	Registro.setVisible(false);
        	
        	lblNombre2 = new JLabel("Usuario");
        	lblNombre2.setBounds(367, 104, 43, 16);
        	lblNombre2.setVisible(false);
        	
        	lblRegistro = new JLabel("Registro");
        	lblRegistro.setBounds(278, 0, 258, 96);
        	lblRegistro.setVisible(false);
        	Registro.setLayout(null);
        	Registro.add(lblRegistro);
        	lblRegistro.setFont(new Font("Curlz MT", Font.BOLD, 72));
        	Registro.add(lblNombre2);
        	
        	lblContrasena2 = new JLabel("Contrase\u00F1a");
        	lblContrasena2.setBounds(345, 131, 65, 16);
        	lblContrasena2.setVisible(false);
        	
        	txtNombre2 = new JTextField();
        	txtNombre2.setBounds(415, 101, 116, 22);
        	txtNombre2.setColumns(10);
        	Registro.add(txtNombre2);
        	Registro.add(lblContrasena2);
        	
        	btnRegistrarse2 = new JButton("Registrarse");
        	btnRegistrarse2.setBounds(0, 215, 410, 25);
        	btnRegistrarse2.setVisible(false);
        	btnRegistrarse2.addActionListener(new menuListener());
        	
        	txtContrasea = new JTextField();
        	txtContrasea.setBounds(415, 128, 116, 22);
        	txtContrasea.setColumns(10);
        	Registro.add(txtContrasea);
        	Registro.add(btnRegistrarse2);
        	
        	btnRegresar = new JButton("Regresar");
        	btnRegresar.setBounds(415, 215, 404, 25);
        	btnRegresar.addActionListener(new menuListener());
        	btnRegresar.setVisible(false);
        	Registro.add(btnRegresar);
        	
        	/**
        	 * el menu principal es el panel que esta visible cuando se inicia el programa
        	 * Contiene un boton de ingreso y un boton que vuelve visible el panel de registro y el menu deja de ser visible
        	 * En caso el ingreso fuera exitoso, muestra el "segundo" gui que contiene el programa principal
        	 */
        	
        	Menu = new JPanel();
        	Menu.setBackground(Color.ORANGE);
        	Menu.setBorder(null);
        	frame.getContentPane().add(Menu, "name_411968872411943");
        	Menu.setVisible(true);
        	       	
	       	JLabel lblMenu = new JLabel("Menu");
	       	lblMenu.setBounds(207, 91, 430, 128);
	       	lblMenu.setFont(new Font("Curlz MT", Font.BOLD, 72));
	
	       	lblNombre_1 = new JLabel("Usuario");
	       	lblNombre_1.setBounds(83, 230, 248, 67);
	       	lblNombre_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	
        	txtNombre = new JTextField();
        	txtNombre.setBounds(539, 224, 209, 41);
        	txtNombre.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	txtNombre.setColumns(10);
        	
        	lblContrasea = new JLabel("Contrase\u00F1a");
        	lblContrasea.setBounds(83, 316, 261, 67);
        	lblContrasea.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	
        	btnIngresar = new JButton("Ingresar");
        	btnIngresar.setBounds(83, 401, 288, 41);
        	btnIngresar.addActionListener(new menuListener());
        	btnIngresar.setFont(new Font("Kristen ITC", Font.BOLD, 24));
        	
        	passwordField = new JPasswordField();
        	passwordField.setBounds(539, 310, 209, 41);
        	passwordField.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	
        	btnRegistrarse = new JButton("Registrarse");
        	btnRegistrarse.setBounds(447, 401, 301, 41);
        	btnRegistrarse.addActionListener(new menuListener());
        	btnRegistrarse.setFont(new Font("Kristen ITC", Font.BOLD, 24));
        	
        	Menu.setLayout(null);
        	Menu.add(lblMenu);
        	Menu.add(lblNombre_1);
        	Menu.add(lblContrasea);
        	Menu.add(btnIngresar);
        	Menu.add(btnRegistrarse);
        	Menu.add(passwordField);
        	Menu.add(txtNombre);
		
		
		
		
		
	}
	/**
	 * El combobox tiene varios materiales que el usuario selecciona y la manera como los quiere ingresar tambien.
	 */
	
	public void ComboBox() {
		//se llenan los combobox
		 cbxMateriales.addItem("Papel");
		 cbxMateriales.addItem("Plastico");
		 cbxMateriales.addItem("Vidrio");
		 cbxMateriales.addItem("Metal");
		 cbxDimensional.addItem("kg");
		 cbxDimensional.addItem("lb");
		 CBMaterial.addItem("Papel");
			CBMaterial.addItem("Vidrio");
			CBMaterial.addItem("Plastico");
			CBMaterial.addItem("Metal");
			CBMaterial.addItem("papel y plastico");
			CBMaterial.addItem("papel y vidrio");
			CBMaterial.addItem("papel y metal");
			CBMaterial.addItem("plastico y vidrio");
			CBMaterial.addItem("plastico y metal");
			CBMaterial.addItem("vidrio y metal");
			comboBoxMunicipio.addItem("Ciudad de Guatemala");
			comboBoxMunicipio.addItem("Mixco");
			comboBoxMunicipio.addItem("Villa Nueva");
			comboBoxMunicipio.addItem("Xela");
			comboBoxMunicipio.addItem("Carretera Paramericana");
			comboBoxMunicipio.addItem("Antigua");
			comboBoxMunicipio.addItem("Villa Hermosa");
			comboBoxMunicipio.addItem("Santa Rosa");
			
		 for (int i=1;i<21;i++){
				if(i !=20)
					CBZona.addItem(i);
			}
		 
		 for (int i = 0; i < guate.ciudad.length;i++){
			 comboBoxNombres.addItem(guate.ciudad[i].getNombre());
		 }

         for (int i = 0; i < guate.exterior.length;i++){
             comboBoxNombres.addItem(guate.exterior[i].getNombre());
             
         }
  }
	
	public void Random(){
		int m = rnd.nextInt(9);
		String cadena="";
		switch (m) {
		//metodo que genera al azar datos curiosos
	    case 0:
	        cadena= "El papel se puede reciclar hasta 11 veces.";
	        break;
	    case 1:
	        cadena= "1 litro de aceite puede contaminar 1,000 litros de agua.";
	        break;
	    case 2:
	        cadena= "Para producir 1 tonelada de papel se cortan 17 arboles grandes.";
	        break;
	    case 3:
	        cadena= "Reciclar 900kg de plastico puede salvar 7570 litros de gasolina.";
	        break;
	    case 4:
	        cadena= "La ropa tambien se puede reciclar.";
	        break;
	    case 5:
	        cadena= "Al reciclar vidrio este debe ser separado por color.";
	        break;
	    case 6:
	        cadena= "El 90% del precio que pagas por el agua embotellada es el costo de la botella.";
	        break;
	    case 7:
	        cadena= "En Europa apenas se recicla el 2.5% de la botellas de plastico que utilizan.";
	        break;
	    case 8:
	        cadena= "Embotellar el agua es el metodo energeticamente menos eficiente.";
	        break;
	
	}
		lblDatoCurioso.setText("Dato curioso: "+cadena);
	}

	private class actionlistener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/** 
			 * muestra la informacion de la recicladora
			 */
			if (e.getSource()==btnBuscarEmpresa && comboBoxMunicipio.getSelectedItem().equals("Ciudad de Guatemala")){
				//muestra los resultados en labels de la informacion pedida
				
				lblNombre.setText("Nombre: "+guate.buscarRecicladora((String)CBMaterial.getSelectedItem(),(int)CBZona.getSelectedItem(),"nombre"));
				lblDireccion.setText("Direccion: "+guate.buscarRecicladora((String)CBMaterial.getSelectedItem(),(int)CBZona.getSelectedItem(),"direccion"));
				lblTelefono.setText("Telefono: "+guate.buscarRecicladora((String)CBMaterial.getSelectedItem(),(int)CBZona.getSelectedItem(),"telefono"));
				lblPagina.setText("Pagina Web: "+guate.buscarRecicladora((String)CBMaterial.getSelectedItem(),(int)CBZona.getSelectedItem(),"pagina"));
				
				String cadena;
				cadena=guate.buscarRecicladora((String)CBMaterial.getSelectedItem(),(int)CBZona.getSelectedItem(),"id");
				int id=0;
				id=Integer.parseInt(cadena);
				
				lblMapa.setVisible(true);
				ImageIcon i=new ImageIcon("Mapa"+id+".jpg"); 
			    lblMapa.setIcon(i); 
			    lblMapa.setBounds(55, 160, 407, 256);
			    

			}

            if (e.getSource()==btnBuscarEmpresa && comboBoxMunicipio.getSelectedItem().equals("Ciudad de Guatemala") == false){
                int zona = 0;
                if (comboBoxMunicipio.getSelectedItem().equals("Mixco"))
                    zona = 100;
                else if (comboBoxMunicipio.getSelectedItem().equals("Villa Nueva"))
                    zona = 101;
                else if (comboBoxMunicipio.getSelectedItem().equals("Xela"))
                    zona = 102;
                else if (comboBoxMunicipio.getSelectedItem().equals("Carretera Paramericana"))
                    zona = 103;
                else if (comboBoxMunicipio.getSelectedItem().equals("Antigua"))
                    zona = 104;
                else if (comboBoxMunicipio.getSelectedItem().equals("Villa Hermosa"))
                    zona = 105;
                else if (comboBoxMunicipio.getSelectedItem().equals("Santa Rosa"))
                    zona = 106;
                
                lblNombre.setText("Nombre: "+guate.buscarFueraCiudad((String)CBMaterial.getSelectedItem(), zona, "nombre"));
                lblDireccion.setText("Direccion: "+guate.buscarFueraCiudad((String)CBMaterial.getSelectedItem(), zona, "direccion"));
                lblTelefono.setText("Telefono: "+guate.buscarFueraCiudad((String)CBMaterial.getSelectedItem(), zona, "telefono"));
                lblPagina.setText("Pagina Web: "+guate.buscarFueraCiudad((String)CBMaterial.getSelectedItem(), zona, "pagina"));
                
                String cadena;
                cadena=guate.buscarFueraCiudad((String)CBMaterial.getSelectedItem(),zona,"id");
                int id=0;
                id=Integer.parseInt(cadena);
                
                lblMapa.setVisible(true);
                ImageIcon i=new ImageIcon("Mapa"+id+".png"); 
                lblMapa.setIcon(i); 
                lblMapa.setBounds(55, 160, 407, 256);
            }
            
			if (e.getSource()==btnCalcular){
				String material=cbxMateriales.getSelectedItem().toString();
				
				String dimensional=cbxDimensional.getSelectedItem().toString();
				try{
					double cantidad= Double.parseDouble(txtCantidad.getText());
					if (txtCantidad.getText().length()==0){
						JOptionPane.showMessageDialog(frame,"La caja de texto no contiene nï¿½meros.","Inane warning",JOptionPane.WARNING_MESSAGE);
					}
					else{
						//si presiona el boton hay programacion defensiva y se ejecutan las instrucciones correspondientes
						String cadena1="Esto implica reciclar ";
						String cadena2="";
						if (material.equals("Papel")){
							cadena2=" libros.";
						}
						if (material.equals("Vidrio")){
							cadena2="% de la pirï¿½mide de Louvre.";
						}
						if (material.equals("Metal")){
							cadena2="% de la torre Eiffel.";
						}
						if (material.equals("Plastico")){
							cadena2=" muï¿½ecas barbies.";
						}
						try{
							lblResultado.setText(cadena1+decimales.format(c.convertir(cantidad,dimensional,material))+cadena2);
							lblDineroAhorrado.setText("Si recicla esa cantidad, habrá ahorrado Q"+c.NuevoMateriales(cantidad,dimensional,material)+" a la industria.");
							lblDineroRecibido.setText("Además, recibirá Q"+c.RecicladoMateriales(cantidad,dimensional,material)+" de parte de la recicladora.");
						}
						catch (Exception e3){
							JOptionPane.showMessageDialog(frame,"Ingrese un nï¿½mero.","Inane warning",JOptionPane.WARNING_MESSAGE);
						}
					}
				}catch (Exception e4){
					JOptionPane.showMessageDialog(frame,"Ingrese un nï¿½mero.","Inane warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			if (e.getSource().equals(btnVerInformacion)){
				lblInfoNombre.setText("Nombre: "+guate.mostrarInfo(comboBoxNombres.getSelectedItem().toString(), "nombre"));
				lblInfoDireccion.setText("Direccion: "+guate.mostrarInfo(comboBoxNombres.getSelectedItem().toString(), "direccion"));
				lblInfoTel.setText("Telefono: "+guate.mostrarInfo(comboBoxNombres.getSelectedItem().toString(), "telefono"));
				lblInfoWeb.setText("Pagina Web: "+guate.mostrarInfo(comboBoxNombres.getSelectedItem().toString(), "web"));
				
			}
		
		}
	}
	
	private class menuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			/**
			 * Hace que el menu y sus componentes se vuelvan visibles viniendo del panel registro hacia el panel menu
			 */
			if (event.getSource().equals(btnRegresar)){
				Menu.setVisible(true);
				lblNombre_1.setVisible(true);
				txtNombre.setVisible(true);
				lblContrasea.setVisible(true);
				passwordField.setVisible(true);
				btnIngresar.setVisible(true);
				Registro.setVisible(false);
				lblRegistro.setVisible(false);
				lblNombre2.setVisible(false);
				lblContrasena2.setVisible(false);
				txtNombre2.setVisible(false);
				txtContrasea.setVisible(false);
				btnRegresar.setVisible(false);
				btnRegistrarse2.setVisible(true);
				
				/**
				 * Busca en la base de datos si existe un usuario como el que fue ingresado y una contrasena
				 * Deben ser iguales a lo que se guardo para que muestre el mensaje de exito y en tal caso cambia el menu a no visible
				 * y el programa se vuelve visible
				 */
			}else if (event.getSource().equals(btnIngresar)){
				String nombre = txtNombre.getText();
				char[] password = passwordField.getPassword();
				String contrasenia = "";
				for (int i = 0; i < password.length; i++){
					contrasenia = contrasenia + password[i];
				}
				
				/**
				 * revisa si el usuario y contrasena son correctos y vuelve el menu invisible y permite ver el programa principal(tabs)
				 */
				boolean login = connection.buscar(nombre, contrasenia);

					if(login){
						JOptionPane.showMessageDialog(null, "username and password is correct");
						Menu.setVisible(false);
						lblNombre_1.setVisible(false);
						txtNombre.setVisible(false);
						lblContrasea.setVisible(false);
						passwordField.setVisible(false);
						btnIngresar.setVisible(false);
						Registro.setVisible(false);
						lblRegistro.setVisible(false);
						lblNombre2.setVisible(false);
						lblContrasena2.setVisible(false);
						txtNombre2.setVisible(false);
						txtContrasea.setVisible(false);
						btnRegresar.setVisible(false);
						btnRegistrarse2.setVisible(false);
						lblRegistro.setVisible(true);
						tabbedPane.setVisible(true);
					}				
					else{
						JOptionPane.showMessageDialog(null, "username or password is not correct");
					}
			     
				
					/**
					 * si se presiona el boton de registrarse, menu se vuelve invisible y el panel de registro se vuelve visible
					 */
			} else if (event.getSource().equals(btnRegistrarse)){
				Menu.setVisible(false);
        		lblNombre_1.setVisible(false);
        		txtNombre.setVisible(false);
        		lblContrasea.setVisible(false);
        		passwordField.setVisible(false);
        		btnIngresar.setVisible(false);
        		Registro.setVisible(true);
        		lblRegistro.setVisible(true);
        		lblNombre2.setVisible(true);
        		lblContrasena2.setVisible(true);
        		txtNombre2.setVisible(true);
        		txtContrasea.setVisible(true);
        		btnRegresar.setVisible(true);
        		btnRegistrarse2.setVisible(true);
        		
        		/**
    			 * Sirve para que el usuario se registre y lo agrega a la base de datos
    			 */
			}else if (event.getSource().equals(btnRegistrarse2)){
				
				String nombre = txtNombre2.getText();
				String contrasenia = txtContrasea.getText();
				connection.agregar(nombre, contrasenia);
			}
			
		}
		
	}
}
