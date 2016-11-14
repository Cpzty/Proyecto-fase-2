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
import javax.swing.border.LineBorder;


import javafx.scene.control.PasswordField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class main {

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
	private JComboBox<String> cbxMateriales;
	private JComboBox<String> cbxDimensional;
	private JTextField txtCantidad;
	private JLabel lblDatoCurioso;
	private JLabel lblCalcularDineroAhorrado;
    private ControladorConversiones c=new ControladorConversiones();
    private JLabel lblResultado;
    DecimalFormat decimales = new DecimalFormat("0.0000");
    private JLabel lblReciguate;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
		ComboBox();
		Random();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		 frame = new JFrame();
			frame.getContentPane().setBackground(new Color(255, 255, 255));
			frame.setBounds(100, 100, 585, 522);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		guate= new CiudadVerde();
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{569, 0};
        gridBagLayout.rowHeights = new int[]{23, 453, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);
        	
        	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        	tabbedPane.setVisible(false);
        	
        	lblReciguate = new JLabel("RECIGUATE");
        	lblReciguate.setForeground(new Color(0, 204, 0));
        	lblReciguate.setFont(new Font("Arial", Font.PLAIN, 16));
        	lblReciguate.setVisible(false);
        	GridBagConstraints gbc_lblReciguate = new GridBagConstraints();
        	gbc_lblReciguate.fill = GridBagConstraints.VERTICAL;
        	gbc_lblReciguate.insets = new Insets(0, 0, 5, 0);
        	gbc_lblReciguate.gridx = 0;
        	gbc_lblReciguate.gridy = 0;
        	frame.getContentPane().add(lblReciguate, gbc_lblReciguate);
        	GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
        	gbc_tabbedPane.fill = GridBagConstraints.BOTH;
        	gbc_tabbedPane.gridx = 0;
        	gbc_tabbedPane.gridy = 1;
        	frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
        	
        	
        	JPanel Reciclar = new JPanel();
        	tabbedPane.addTab("Buscar", null, Reciclar, null);
        	Reciclar.setBackground(new Color(204, 255, 153));
        	Reciclar.setForeground(new Color(0, 0, 0));
        	GridBagLayout gbl_Reciclar = new GridBagLayout();
        	gbl_Reciclar.columnWidths = new int[]{211, 328, 0};
        	gbl_Reciclar.rowHeights = new int[]{16, 27, 21, 27, 29, 14, 214, 14, 0};
        	gbl_Reciclar.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        	gbl_Reciclar.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        	Reciclar.setLayout(gbl_Reciclar);
        	
        	lblMaterial = new JLabel("Material:");
        	GridBagConstraints gbc_lblMaterial = new GridBagConstraints();
        	gbc_lblMaterial.anchor = GridBagConstraints.NORTHWEST;
        	gbc_lblMaterial.insets = new Insets(0, 0, 5, 5);
        	gbc_lblMaterial.gridx = 0;
        	gbc_lblMaterial.gridy = 0;
        	Reciclar.add(lblMaterial, gbc_lblMaterial);
        	
        	lblNombre = new JLabel("Nombre");
        	lblNombre.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        	gbc_lblNombre.anchor = GridBagConstraints.NORTH;
        	gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
        	gbc_lblNombre.gridx = 1;
        	gbc_lblNombre.gridy = 0;
        	Reciclar.add(lblNombre, gbc_lblNombre);
        	
        	CBMaterial = new JComboBox<String>();
        	CBMaterial.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_CBMaterial = new GridBagConstraints();
        	gbc_CBMaterial.fill = GridBagConstraints.BOTH;
        	gbc_CBMaterial.insets = new Insets(0, 0, 5, 5);
        	gbc_CBMaterial.gridx = 0;
        	gbc_CBMaterial.gridy = 1;
        	Reciclar.add(CBMaterial, gbc_CBMaterial);
        	
        	lblDireccion = new JLabel("Direccion");
        	lblDireccion.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
        	gbc_lblDireccion.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblDireccion.insets = new Insets(0, 0, 5, 0);
        	gbc_lblDireccion.gridx = 1;
        	gbc_lblDireccion.gridy = 1;
        	Reciclar.add(lblDireccion, gbc_lblDireccion);
        	
        	lblZona = new JLabel("Zona: ");
        	lblZona.setForeground(new Color(0, 102, 0));
        	lblZona.setBackground(new Color(51, 204, 51));
        	GridBagConstraints gbc_lblZona = new GridBagConstraints();
        	gbc_lblZona.anchor = GridBagConstraints.NORTHWEST;
        	gbc_lblZona.insets = new Insets(0, 0, 5, 5);
        	gbc_lblZona.gridx = 0;
        	gbc_lblZona.gridy = 2;
        	Reciclar.add(lblZona, gbc_lblZona);
        	
        	lblTelefono = new JLabel("Telefono");
        	lblTelefono.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
        	gbc_lblTelefono.anchor = GridBagConstraints.SOUTH;
        	gbc_lblTelefono.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblTelefono.insets = new Insets(0, 0, 5, 0);
        	gbc_lblTelefono.gridx = 1;
        	gbc_lblTelefono.gridy = 2;
        	Reciclar.add(lblTelefono, gbc_lblTelefono);
        	
        	CBZona = new JComboBox<Integer>();
        	CBZona.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_CBZona = new GridBagConstraints();
        	gbc_CBZona.fill = GridBagConstraints.BOTH;
        	gbc_CBZona.insets = new Insets(0, 0, 5, 5);
        	gbc_CBZona.gridx = 0;
        	gbc_CBZona.gridy = 3;
        	Reciclar.add(CBZona, gbc_CBZona);
        	
        	lblPagina = new JLabel("Pagina Web");
        	lblPagina.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblPagina = new GridBagConstraints();
        	gbc_lblPagina.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblPagina.insets = new Insets(0, 0, 5, 0);
        	gbc_lblPagina.gridx = 1;
        	gbc_lblPagina.gridy = 3;
        	Reciclar.add(lblPagina, gbc_lblPagina);
        	
        	btnBuscarEmpresa = new JButton("Buscar empresa");
        	btnBuscarEmpresa.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_btnBuscarEmpresa = new GridBagConstraints();
        	gbc_btnBuscarEmpresa.anchor = GridBagConstraints.WEST;
        	gbc_btnBuscarEmpresa.fill = GridBagConstraints.VERTICAL;
        	gbc_btnBuscarEmpresa.insets = new Insets(0, 0, 5, 5);
        	gbc_btnBuscarEmpresa.gridx = 0;
        	gbc_btnBuscarEmpresa.gridy = 4;
        	Reciclar.add(btnBuscarEmpresa, gbc_btnBuscarEmpresa);
        	btnBuscarEmpresa.addActionListener(new actionlistener());
        	
        	lblMapa = new JLabel("Mapa:");
        	lblMapa.setForeground(new Color(0, 128, 0));
        	GridBagConstraints gbc_lblMapa = new GridBagConstraints();
        	gbc_lblMapa.gridheight = 2;
        	gbc_lblMapa.gridwidth = 2;
        	gbc_lblMapa.fill = GridBagConstraints.BOTH;
        	gbc_lblMapa.insets = new Insets(0, 0, 5, 5);
        	gbc_lblMapa.gridx = 0;
        	gbc_lblMapa.gridy = 5;
        	Reciclar.add(lblMapa, gbc_lblMapa);
        	lblMapa.setVisible(false);
        	
        	lblDatoCurioso = new JLabel("Dato curioso:");
        	GridBagConstraints gbc_lblDatoCurioso = new GridBagConstraints();
        	gbc_lblDatoCurioso.fill = GridBagConstraints.BOTH;
        	gbc_lblDatoCurioso.gridwidth = 2;
        	gbc_lblDatoCurioso.gridx = 0;
        	gbc_lblDatoCurioso.gridy = 7;
        	Reciclar.add(lblDatoCurioso, gbc_lblDatoCurioso);
        	lblDatoCurioso.setForeground(new Color(51, 204, 102));
        	
        	JPanel Buscar = new JPanel();
        	tabbedPane.addTab("Reciclar", null, Buscar, null);
        	Buscar.setBackground(new Color(204, 255, 153));
        	Buscar.setLayout(null);
        	
        	JLabel lblSeleccioneElMaterial = new JLabel("Seleccione el material:");
        	lblSeleccioneElMaterial.setForeground(new Color(0, 102, 0));
        	lblSeleccioneElMaterial.setBounds(10, 11, 151, 14);
        	Buscar.add(lblSeleccioneElMaterial);
        	
        	cbxMateriales = new JComboBox<String>();
        	cbxMateriales.setBackground(new Color(255, 255, 255));
        	cbxMateriales.setBounds(10, 36, 92, 20);
        	Buscar.add(cbxMateriales);
        	
        	JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad: ");
        	lblIngreseLaCantidad.setForeground(new Color(0, 102, 0));
        	lblIngreseLaCantidad.setBounds(10, 67, 151, 14);
        	Buscar.add(lblIngreseLaCantidad);
        	
        	lblCalcularDineroAhorrado = new JLabel("Calcular cantidad reciclada:");
        	lblCalcularDineroAhorrado.setForeground(new Color(0, 102, 0));
        	lblCalcularDineroAhorrado.setBounds(189, 11, 186, 14);
        	Buscar.add(lblCalcularDineroAhorrado);
        	
        	btnCalcular = new JButton("Calcular");
        	btnCalcular.setBackground(new Color(255, 255, 255));
        	btnCalcular.setBounds(188, 35, 86, 23);
        	Buscar.add(btnCalcular);
        	btnCalcular.addActionListener(new actionlistener());
        	
        	txtCantidad = new JTextField();
        	txtCantidad.setBounds(10, 92, 86, 20);
        	Buscar.add(txtCantidad);
        	txtCantidad.setColumns(10);
        	
        	JLabel lblSeleccioneLaDimensional = new JLabel("Seleccione la dimensional:");
        	lblSeleccioneLaDimensional.setForeground(new Color(0, 102, 0));
        	lblSeleccioneLaDimensional.setBounds(10, 123, 151, 14);
        	Buscar.add(lblSeleccioneLaDimensional);
        	
        	cbxDimensional = new JComboBox<String>();
        	cbxDimensional.setBackground(new Color(255, 255, 255));
        	cbxDimensional.setBounds(10, 148, 92, 20);
        	Buscar.add(cbxDimensional);
        	
        	lblResultado = new JLabel("Resultado:");
        	lblResultado.setForeground(new Color(0, 102, 0));
        	lblResultado.setBounds(188, 77, 296, 14);
        	Buscar.add(lblResultado);
        	
        	JPanel VerRecicladoras = new JPanel();
        	VerRecicladoras.setBackground(new Color(204, 255, 153));
        	tabbedPane.addTab("Ver Todas las Recicladoras", null, VerRecicladoras, null);
        	VerRecicladoras.setLayout(null);
        	
        	comboBoxNombres = new JComboBox<String>();
        	comboBoxNombres.setBounds(10, 29, 219, 25);
        	VerRecicladoras.add(comboBoxNombres);
        	
        	JLabel lblSeleccioneElNombre = new JLabel("Seleccione el Nombre de la Empresa:");
        	lblSeleccioneElNombre.setBounds(10, 4, 219, 25);
        	VerRecicladoras.add(lblSeleccioneElNombre);
        	
        	lblInfoWeb = new JLabel("Pagina Web");
        	lblInfoWeb.setForeground(new Color(0, 102, 0));
        	lblInfoWeb.setBounds(10, 185, 469, 16);
        	VerRecicladoras.add(lblInfoWeb);
        	
        	lblInfoTel = new JLabel("Telefono");
        	lblInfoTel.setForeground(new Color(0, 102, 0));
        	lblInfoTel.setBounds(10, 160, 469, 16);
        	VerRecicladoras.add(lblInfoTel);
        	
        	lblInfoDireccion = new JLabel("Direccion");
        	lblInfoDireccion.setForeground(new Color(0, 102, 0));
        	lblInfoDireccion.setBounds(10, 133, 469, 16);
        	VerRecicladoras.add(lblInfoDireccion);
        	
        	lblInfoNombre = new JLabel("Nombre");
        	lblInfoNombre.setForeground(new Color(0, 102, 0));
        	lblInfoNombre.setBounds(10, 109, 469, 16);
        	VerRecicladoras.add(lblInfoNombre);
        	
        	btnVerInformacion = new JButton("Ver Informacion");
        	btnVerInformacion.setBounds(10, 65, 219, 23);
        	VerRecicladoras.add(btnVerInformacion);
        	btnVerInformacion.addActionListener(new actionlistener());
        	
        	// el panel de registro sirve para que el usuario cree su usuario, esta oculto al inicio
        	
        	Registro = new JPanel();
        	Registro.setBorder(null);
        	GridBagConstraints gbc_Registro = new GridBagConstraints();
        	gbc_Registro.fill = GridBagConstraints.BOTH;
        	gbc_Registro.gridx = 0;
        	gbc_Registro.gridy = 1;
        	frame.getContentPane().add(Registro, gbc_Registro);
        	Registro.setLayout(null);
        	Registro.setVisible(false);
        	
        	lblRegistro = new JLabel("Registro");
        	lblRegistro.setBounds(151, 6, 144, 49);
        	lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 40));
        	Registro.add(lblRegistro);
        	lblRegistro.setVisible(false);
        	
        	lblNombre2 = new JLabel("Usuario");
        	lblNombre2.setBounds(96, 141, 46, 14);
        	Registro.add(lblNombre2);
        	lblNombre2.setVisible(false);
        	
        	lblContrasena2 = new JLabel("Contrase\u00F1a");
        	lblContrasena2.setBounds(80, 182, 75, 14);
        	Registro.add(lblContrasena2);
        	lblContrasena2.setVisible(false);
        	
        	txtNombre2 = new JTextField();
        	txtNombre2.setBounds(165, 138, 86, 20);
        	Registro.add(txtNombre2);
        	txtNombre2.setColumns(10);
        	
        	txtContrasea = new JTextField();
        	txtContrasea.setBounds(165, 179, 86, 20);
        	Registro.add(txtContrasea);
        	txtContrasea.setColumns(10);
        	
        	btnRegistrarse2 = new JButton("Registrarse");
        	btnRegistrarse2.setBounds(10, 254, 161, 23);
        	btnRegistrarse2.setVisible(false);
        	Registro.add(btnRegistrarse2);
        	
        	btnRegresar = new JButton("Regresar");
        	btnRegresar.addActionListener(new menuListener());
        	btnRegresar.setBounds(218, 254, 161, 23);
        	btnRegresar.setVisible(false);
        	Registro.add(btnRegresar);
 
        
        	lblNombre_1 = new JLabel("Usuario");
        	lblNombre_1.setBounds(96, 141, 46, 14);
        	
        	
        	lblContrasea = new JLabel("Contrase\u00F1a");
        	lblContrasea.setBounds(80, 182, 70, 14);
        	
        	
        	txtNombre = new JTextField();
        	txtNombre.setBounds(165, 138, 86, 20);
        	txtNombre.setColumns(10);
        	
        	passwordField = new JPasswordField();
        	passwordField.setBounds(165, 179, 86, 20);
        	
        	
        	btnIngresar = new JButton("Ingresar");
        	btnIngresar.setBounds(80, 228, 89, 23);
        	
        	// el menu es la pantalla principal donde el usuario puede ingresar 
        	
        	Menu = new JPanel();
        	Menu.setBorder(null);
        	GridBagConstraints gbc_Menu = new GridBagConstraints();
        	gbc_Menu.fill = GridBagConstraints.BOTH;
        	gbc_Menu.gridx = 0;
        	gbc_Menu.gridy = 1;
        	frame.getContentPane().add(Menu, gbc_Menu);
        	Menu.setLayout(null);
        	
        	JLabel lblMenu = new JLabel("Menu");
        	lblMenu.setBounds(151, 6, 144, 49);
        	Menu.add(lblMenu);
        	lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 40));
        	
        	
        	
        	
        	btnRegistrarse = new JButton("Registrarse");
        	btnRegistrarse.setBounds(200, 229, 119, 23);
        	Menu.add(btnRegistrarse);
        	Menu.add(lblNombre_1);
        	Menu.add(txtNombre);
        	Menu.add(lblContrasea);
        	Menu.add(passwordField);
        	Menu.add(btnIngresar);
        	
        	
        	// al apachar el boton de registro cambia la visibilidad del panel para que el usuario la pueda ver
	
        	btnRegistrarse.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
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
        		}
        	});
        	
        	btnIngresar.addActionListener(new ActionListener(){
        		public void actionPerformed(ActionEvent e){
        		
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
        	});
		
		
		
		
		
	}
	
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
		 for (int i=1;i<21;i++){
				if(i !=20)
					CBZona.addItem(i);
			}
		 
		 for (int i = 0; i < guate.ciudad.length;i++){
			 comboBoxNombres.addItem(guate.ciudad[i].getNombre());
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
			if (e.getSource()==btnBuscarEmpresa){
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
			if (e.getSource()==btnCalcular){
				String material=cbxMateriales.getSelectedItem().toString();
				double cantidad= Double.parseDouble(txtCantidad.getText());
				String dimensional=cbxDimensional.getSelectedItem().toString();
				
				if (txtCantidad.getText().length()==0){
					JOptionPane.showMessageDialog(frame,"La caja de texto no contiene n�meros.","Inane warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					//si presiona el boton hay programacion defensiva y se ejecutan las instrucciones correspondientes
					String cadena1="";
					String cadena2="";
					if (material.equals("Papel")){
						cadena1="Ha reciclado ";
						cadena2=" �rboles.";
					}
					if (material.equals("Vidrio")){
						cadena1="Ha reciclado ";
						cadena2="% de la pir�mide de Louvre.";
					}
					if (material.equals("Metal")){
						cadena1="Ha reciclado ";
						cadena2="% de la torre Eiffel.";
					}
					if (material.equals("Plastico")){
						cadena1="Ha reciclado ";
						cadena2=" mu�ecas barbies.";
					}
					try{
						lblResultado.setText(cadena1+decimales.format(c.convertir(cantidad,dimensional,material))+cadena2);
					}
					catch (Exception e3){
						JOptionPane.showMessageDialog(frame,"Ingrese un n�mero.","Inane warning",JOptionPane.WARNING_MESSAGE);
					}
					
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
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
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
		}
		
	}
	
}
