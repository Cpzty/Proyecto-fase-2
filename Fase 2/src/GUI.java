import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;



public class GUI {

	private JFrame frmMenuPrincipal;
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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panelMapa;
	private JRadioButton rdbtnUsuarioComun;
	private JRadioButton rdbtnEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMenuPrincipal.setVisible(true);
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
			
			frmMenuPrincipal = new JFrame();
			frmMenuPrincipal.setTitle("Menu Principal");
			frmMenuPrincipal.getContentPane().setBackground(new Color(255, 255, 255));
			frmMenuPrincipal.setBounds(100, 100, 838, 645);
			frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMenuPrincipal.setResizable(false);
        	
        	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        	tabbedPane.setVisible(false);
        	frmMenuPrincipal.getContentPane().setLayout(new CardLayout(0, 0));
        	frmMenuPrincipal.getContentPane().add(tabbedPane, "name_411968820848809");
        	
        	JPanel Buscar = new JPanel();
        	tabbedPane.addTab("Buscar", null, Buscar, null);
        	Buscar.setBackground(SystemColor.window);
        	Buscar.setForeground(new Color(0, 0, 0));
        	
        	lblMaterial = new JLabel("Material:");
        	lblMaterial.setBounds(25, 4, 215, 33);
        	lblMaterial.setFont(new Font("Sylfaen", Font.BOLD, 30));
        	
        	lblNombre = new JLabel("Nombre");
        	lblNombre.setBounds(334, 17, 469, 33);
        	lblNombre.setForeground(new Color(0, 0, 51));
        	lblNombre.setFont(new Font("Lucida Bright", Font.BOLD, 21));
        	
        	CBMaterial = new JComboBox<String>();
        	CBMaterial.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	CBMaterial.setBounds(70, 39, 236, 35);
        	CBMaterial.setBackground(new Color(255, 255, 255));
        	
        	lblDireccion = new JLabel("Direccion");
        	lblDireccion.setBounds(333, 61, 469, 24);
        	lblDireccion.setForeground(new Color(0, 0, 51));
        	lblDireccion.setFont(new Font("Lucida Bright", Font.BOLD, 21));
        	
        	lblZona = new JLabel("Zona: ");
        	lblZona.setBounds(40, 154, 200, 40);
        	lblZona.setForeground(new Color(0, 51, 0));
        	lblZona.setBackground(new Color(51, 204, 51));
        	lblZona.setFont(new Font("Sylfaen", Font.BOLD, 30));
        	
        	lblTelefono = new JLabel("Telefono");
        	lblTelefono.setBounds(336, 100, 466, 24);
        	lblTelefono.setForeground(new Color(0, 0, 51));
        	lblTelefono.setFont(new Font("Lucida Bright", Font.BOLD, 21));
        	
        	CBZona = new JComboBox<Integer>();
        	CBZona.setEnabled(false);
        	CBZona.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	CBZona.setBounds(70, 202, 238, 35);
        	CBZona.setBackground(new Color(255, 255, 255));
        	CBZona.setEnabled(false);
        	
        	lblPagina = new JLabel("Pagina Web");
        	lblPagina.setBounds(337, 141, 465, 24);
        	lblPagina.setForeground(new Color(0, 0, 51));
        	lblPagina.setFont(new Font("Lucida Bright", Font.BOLD, 21));
        	
        	btnBuscarEmpresa = new JButton("Buscar empresa");
        	btnBuscarEmpresa.setFont(new Font("Kristen ITC", Font.PLAIN, 24));
        	btnBuscarEmpresa.setBounds(26, 250, 309, 46);
        	btnBuscarEmpresa.setBackground(new Color(255, 255, 255));
        	btnBuscarEmpresa.addActionListener(new actionlistener());
        	
        	lblDatoCurioso = new JLabel("Dato curioso:");
        	lblDatoCurioso.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
        	lblDatoCurioso.setBounds(25, 534, 562, 33);
        	lblDatoCurioso.setForeground(new Color(0, 204, 51));
        	
        	comboBoxMunicipio = new JComboBox<Object>();
        	comboBoxMunicipio.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	comboBoxMunicipio.setBounds(70, 120, 236, 38);
        	comboBoxMunicipio.addActionListener(new actionlistener());
        	
        	Buscar.setLayout(null);
        	Buscar.add(lblMaterial);
        	Buscar.add(CBMaterial);
        	Buscar.add(lblNombre);
        	Buscar.add(lblDatoCurioso);
        	Buscar.add(btnBuscarEmpresa);
        	Buscar.add(lblZona);
        	Buscar.add(CBZona);
        	Buscar.add(comboBoxMunicipio);
        	Buscar.add(lblDireccion);
        	Buscar.add(lblPagina);
        	Buscar.add(lblTelefono);
        	
        	lblMunicipio = new JLabel("Area");
        	lblMunicipio.setForeground(new Color(0, 51, 0));
        	lblMunicipio.setFont(new Font("Sylfaen", Font.BOLD, 30));
        	lblMunicipio.setBackground(new Color(51, 204, 51));
        	lblMunicipio.setBounds(36, 79, 204, 40);
        	Buscar.add(lblMunicipio);
        	
        	panelMapa = new JPanel();
        	panelMapa.setBackground(Color.WHITE);
        	panelMapa.setBounds(370, 280, 433, 258);
        	Buscar.add(panelMapa);
        	GridBagLayout gbl_panel = new GridBagLayout();
        	gbl_panel.columnWidths = new int[]{31, 0};
        	gbl_panel.rowHeights = new int[]{16, 0};
        	gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        	gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        	panelMapa.setLayout(gbl_panel);
        	
        	
        	lblMapa = new JLabel("");
        	GridBagConstraints gbc_lblMapa = new GridBagConstraints();
        	gbc_lblMapa.fill = GridBagConstraints.BOTH;
        	gbc_lblMapa.gridx = 0;
        	gbc_lblMapa.gridy = 0;
        	panelMapa.add(lblMapa, gbc_lblMapa);
        	lblMapa.setForeground(new Color(0, 128, 0));
        	lblMapa.setVisible(false);
        	
        	lblNewLabel_3 = new JLabel("New label");
        	lblNewLabel_3.setIcon(new ImageIcon("fondo.png"));
        	lblNewLabel_3.setBounds(-206, -56, 1023, 594);
        	Buscar.add(lblNewLabel_3);
        	
        	JPanel Reciclar = new JPanel();
        	tabbedPane.addTab("Reciclar", null, Reciclar, null);
        	Reciclar.setBackground(new Color(255, 255, 255));
        	Reciclar.setLayout(null);
        	
        	JLabel lblSeleccioneElMaterial = new JLabel("Seleccione el material:");
        	lblSeleccioneElMaterial.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblSeleccioneElMaterial.setBounds(11, 25, 264, 31);
        	lblSeleccioneElMaterial.setForeground(new Color(0, 51, 51));
        	Reciclar.add(lblSeleccioneElMaterial);
        	
        	lblCalcularDineroAhorrado = new JLabel("Calcular cantidad reciclada:");
        	lblCalcularDineroAhorrado.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblCalcularDineroAhorrado.setBounds(302, 25, 244, 31);
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
        	lblIngreseLaCantidad.setBounds(11, 103, 220, 31);
        	lblIngreseLaCantidad.setForeground(new Color(0, 51, 51));
        	Reciclar.add(lblIngreseLaCantidad);
        	
        	lblResultado = new JLabel("Resultado:");
        	lblResultado.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblResultado.setBounds(326, 123, 489, 29);
        	lblResultado.setForeground(new Color(0, 51, 51));
        	Reciclar.add(lblResultado);
        	
        	txtCantidad = new JTextField();
        	txtCantidad.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	txtCantidad.setBounds(11, 143, 191, 22);
        	Reciclar.add(txtCantidad);
        	txtCantidad.setColumns(10);
        	
        	JLabel lblSeleccioneLaDimensional = new JLabel("Seleccione la dimensional:");
        	lblSeleccioneLaDimensional.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblSeleccioneLaDimensional.setBounds(11, 176, 220, 32);
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
        	lblDineroAhorrado.setBounds(326, 170, 489, 22);
        	Reciclar.add(lblDineroAhorrado);
        	
        	lblDineroRecibido = new JLabel("Cantidad de dinero que recibir\u00E1:");
        	lblDineroRecibido.setFont(new Font("Sylfaen", Font.PLAIN, 19));
        	lblDineroRecibido.setForeground(new Color(0, 51, 51));
        	lblDineroRecibido.setBounds(326, 225, 489, 26);
        	Reciclar.add(lblDineroRecibido);
        	
        	JLabel lblNewLabel = new JLabel("");
        	lblNewLabel.setBackground(new Color(255, 255, 255));
        	lblNewLabel.setIcon(new ImageIcon("fondo.png"));
        	lblNewLabel.setBounds(-365, 11, 1300, 673);
        	Reciclar.add(lblNewLabel);
        	
        	JPanel VerRecicladoras = new JPanel();
        	VerRecicladoras.setBackground(new Color(255, 255, 255));
        	tabbedPane.addTab("Ver Todas las Recicladoras", null, VerRecicladoras, null);
        	VerRecicladoras.setLayout(null);
        	
        	JLabel lblSeleccioneElNombre = new JLabel("Seleccione el Nombre de la Empresa:");
        	lblSeleccioneElNombre.setFont(new Font("Sylfaen", Font.PLAIN, 22));
        	lblSeleccioneElNombre.setBounds(226, 8, 372, 20);
        	VerRecicladoras.add(lblSeleccioneElNombre);
        	
        	comboBoxNombres = new JComboBox<String>();
        	comboBoxNombres.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 17));
        	comboBoxNombres.setBounds(283, 52, 230, 22);
        	VerRecicladoras.add(comboBoxNombres);
        	
        	btnVerInformacion = new JButton("Ver Informacion");
        	btnVerInformacion.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        	btnVerInformacion.setBounds(283, 99, 238, 25);
        	VerRecicladoras.add(btnVerInformacion);
        	btnVerInformacion.addActionListener(new actionlistener());
        	
        	lblInfoNombre = new JLabel("Nombre");
        	lblInfoNombre.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
        	lblInfoNombre.setBounds(53, 174, 744, 30);
        	lblInfoNombre.setForeground(new Color(0, 0, 51));
        	VerRecicladoras.add(lblInfoNombre);
        	
        	lblInfoDireccion = new JLabel("Direccion");
        	lblInfoDireccion.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
        	lblInfoDireccion.setBounds(51, 215, 746, 25);
        	lblInfoDireccion.setForeground(new Color(0, 0, 51));
        	VerRecicladoras.add(lblInfoDireccion);
        	
        	lblInfoTel = new JLabel("Telefono");
        	lblInfoTel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
        	lblInfoTel.setBounds(53, 257, 744, 31);
        	lblInfoTel.setForeground(new Color(0, 0, 51));
        	VerRecicladoras.add(lblInfoTel);
        	
        	lblInfoWeb = new JLabel("Pagina Web");
        	lblInfoWeb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
        	lblInfoWeb.setBounds(51, 310, 746, 31);
        	lblInfoWeb.setForeground(new Color(0, 0, 51));
        	VerRecicladoras.add(lblInfoWeb);
        	
        	lblNewLabel_4 = new JLabel("New label");
        	lblNewLabel_4.setIcon(new ImageIcon("fondo.png"));
        	lblNewLabel_4.setBounds(-277, 0, 1094, 578);
        	VerRecicladoras.add(lblNewLabel_4);
        	
        	/**
    		 * el panel de registro sirve para que una persona cree su usuario, esta oculto al inicio 
    		 * Posee un boton de registro y uno para regresar al menu principal
    		 */
        	
        	Registro = new JPanel();
        	Registro.setBackground(SystemColor.textHighlightText);
        	Registro.setBorder(null);
        	frmMenuPrincipal.getContentPane().add(Registro, "name_411968859242604");
        	Registro.setVisible(false);
        	
        	lblNombre2 = new JLabel("Usuario");
        	lblNombre2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
        	lblNombre2.setBounds(271, 166, 88, 16);
        	lblNombre2.setVisible(false);
        	
        	lblRegistro = new JLabel("Registro");
        	lblRegistro.setBounds(277, 11, 265, 96);
        	lblRegistro.setVisible(false);
        	Registro.setLayout(null);
        	Registro.add(lblRegistro);
        	lblRegistro.setFont(new Font("Curlz MT", Font.BOLD, 72));
        	Registro.add(lblNombre2);
        	
        	lblContrasena2 = new JLabel("Contrase\u00F1a");
        	lblContrasena2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
        	lblContrasena2.setBounds(250, 201, 109, 16);
        	lblContrasena2.setVisible(false);
        	
        	txtNombre2 = new JTextField();
        	txtNombre2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
        	txtNombre2.setBounds(364, 163, 161, 22);
        	txtNombre2.setColumns(10);
        	Registro.add(txtNombre2);
        	Registro.add(lblContrasena2);
        	
        	btnRegistrarse2 = new JButton("Registrarse");
        	btnRegistrarse2.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        	btnRegistrarse2.setBounds(257, 269, 285, 37);
        	btnRegistrarse2.setVisible(false);
        	btnRegistrarse2.addActionListener(new menuListener());
        	
        	txtContrasea = new JTextField();
        	txtContrasea.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
        	txtContrasea.setBounds(364, 198, 161, 22);
        	txtContrasea.setColumns(10);
        	Registro.add(txtContrasea);
        	Registro.add(btnRegistrarse2);
        	
        	btnRegresar = new JButton("Regresar");
        	btnRegresar.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
        	btnRegresar.setBounds(292, 324, 234, 25);
        	btnRegresar.addActionListener(new menuListener());
        	btnRegresar.setVisible(false);
        	Registro.add(btnRegresar);
        	
        	rdbtnUsuarioComun = new JRadioButton("Usuario Comun");
        	rdbtnUsuarioComun.setSelected(true);
        	rdbtnUsuarioComun.setBackground(Color.WHITE);
        	rdbtnUsuarioComun.setBounds(292, 235, 127, 25);
        	Registro.add(rdbtnUsuarioComun);
        	
        	rdbtnEmpresa = new JRadioButton("Empresa");
        	rdbtnEmpresa.setBackground(Color.WHITE);
        	rdbtnEmpresa.setBounds(435, 235, 127, 25);
        	Registro.add(rdbtnEmpresa);
        	
        	ButtonGroup tipoUser = new ButtonGroup();
        	tipoUser.add(rdbtnUsuarioComun);
        	tipoUser.add(rdbtnEmpresa);
        	
        	lblNewLabel_2 = new JLabel("");
        	lblNewLabel_2.setIcon(new ImageIcon("logo.png"));
        	lblNewLabel_2.setBounds(71, -63, 812, 635);
        	Registro.add(lblNewLabel_2);
        	
        	/**
        	 * el menu principal es el panel que esta visible cuando se inicia el programa
        	 * Contiene un boton de ingreso y un boton que vuelve visible el panel de registro y el menu deja de ser visible
        	 * En caso el ingreso fuera exitoso, muestra el "segundo" gui que contiene el programa principal
        	 */
        	
        	Menu = new JPanel();
        	Menu.setBackground(SystemColor.window);
        	Menu.setBorder(null);
        	frmMenuPrincipal.getContentPane().add(Menu, "name_411968872411943");
        	Menu.setVisible(true);
        	       	
	       	JLabel lblMenu = new JLabel("Menu");
	       	lblMenu.setBounds(321, 51, 192, 128);
	       	lblMenu.setFont(new Font("Curlz MT", Font.BOLD, 72));
	
	       	lblNombre_1 = new JLabel("Usuario");
	       	lblNombre_1.setForeground(SystemColor.infoText);
	       	lblNombre_1.setBounds(166, 224, 248, 67);
	       	lblNombre_1.setFont(new Font("Perpetua", Font.BOLD, 30));
        	
        	txtNombre = new JTextField();
        	txtNombre.setBounds(458, 237, 209, 41);
        	txtNombre.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	txtNombre.setColumns(10);
        	
        	lblContrasea = new JLabel("Contrase\u00F1a");
        	lblContrasea.setBounds(164, 310, 261, 67);
        	lblContrasea.setFont(new Font("Perpetua", Font.BOLD, 30));
        	
        	btnIngresar = new JButton("Ingresar");
        	btnIngresar.setBounds(83, 416, 288, 41);
        	btnIngresar.addActionListener(new menuListener());
        	btnIngresar.setFont(new Font("Kristen ITC", Font.BOLD, 24));
        	
        	passwordField = new JPasswordField();
        	passwordField.setBounds(458, 323, 209, 41);
        	passwordField.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	
        	btnRegistrarse = new JButton("Registrarse");
        	btnRegistrarse.setBounds(447, 416, 301, 41);
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
        	
        	lblNewLabel_1 = new JLabel("");
        	lblNewLabel_1.setIcon(new ImageIcon("imagen.jpg"));
        	lblNewLabel_1.setBounds(-114, 0, 1046, 660);
        	Menu.add(lblNewLabel_1);
     	
		
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
                if (comboBoxMunicipio.getSelectedItem().equals("Mixco")){
                    zona = 100;
                }else if (comboBoxMunicipio.getSelectedItem().equals("Villa Nueva")){
                    zona = 101;}
            
                else if (comboBoxMunicipio.getSelectedItem().equals("Xela")){
                    zona = 102;}
                else if (comboBoxMunicipio.getSelectedItem().equals("Carretera Paramericana")){
                    zona = 103;}
                else if (comboBoxMunicipio.getSelectedItem().equals("Antigua")){
                    zona = 104;}
                else if (comboBoxMunicipio.getSelectedItem().equals("Villa Hermosa")){
                    zona = 105;}
                else if (comboBoxMunicipio.getSelectedItem().equals("Santa Rosa")){
                    zona = 106;}
                
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
						JOptionPane.showMessageDialog(frmMenuPrincipal,"La caja de texto no contiene numeros.","Advertencia",JOptionPane.WARNING_MESSAGE);
					}
					else{
						//si presiona el boton hay programacion defensiva y se ejecutan las instrucciones correspondientes
						String cadena1="Esto implica reciclar ";
						String cadena2="";
						if (material.equals("Papel")){
							cadena2=" libros.";
						}
						if (material.equals("Vidrio")){
							cadena2="% de la piramide de Louvre.";
						}
						if (material.equals("Metal")){
							cadena2="% de la torre Eiffel.";
						}
						if (material.equals("Plastico")){
							cadena2=" muniecas barbies.";
						}
						try{
							lblResultado.setText(cadena1+decimales.format(c.convertir(cantidad,dimensional,material))+cadena2);
							lblDineroAhorrado.setText("Si recicla esa cantidad, habra ahorrado Q"+c.NuevoMateriales(cantidad,dimensional,material)+" a la industria.");
							lblDineroRecibido.setText("Ademas, recibira Q"+c.RecicladoMateriales(cantidad,dimensional,material)+" de parte de la recicladora.");
						}
						catch (Exception e3){
							JOptionPane.showMessageDialog(frmMenuPrincipal,"Ingrese un numero!","Advertencia",JOptionPane.WARNING_MESSAGE);
						}
					}
				}catch (Exception e4){
					JOptionPane.showMessageDialog(frmMenuPrincipal,"Ingrese un numero.","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			if (e.getSource().equals(btnVerInformacion)){
				lblInfoNombre.setText("Nombre: "+guate.mostrarInfo(comboBoxNombres.getSelectedItem().toString(), "nombre"));
				lblInfoDireccion.setText("Direccion: "+guate.mostrarInfo(comboBoxNombres.getSelectedItem().toString(), "direccion"));
				lblInfoTel.setText("Telefono: "+guate.mostrarInfo(comboBoxNombres.getSelectedItem().toString(), "telefono"));
				lblInfoWeb.setText("Pagina Web: "+guate.mostrarInfo(comboBoxNombres.getSelectedItem().toString(), "web"));
				
			}
			
			if (e.getSource().equals(comboBoxMunicipio)){
				if(comboBoxMunicipio.getSelectedItem().equals("Ciudad de Guatemala")){
					CBZona.setEnabled(true);
				}else{
					CBZona.setEnabled(false);
				}
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

					if(login == true){
						JOptionPane.showMessageDialog(frmMenuPrincipal, "Bienvenido a Reciguate!", "Bienvenido",JOptionPane.PLAIN_MESSAGE);
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
						JOptionPane.showMessageDialog(frmMenuPrincipal, "Nombre de Usuario o Contrasenia Incorrecta!","Error", JOptionPane.ERROR_MESSAGE);
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
				try{
					String nombre = txtNombre2.getText();
					String contrasenia = txtContrasea.getText();
					String empresa;
					if(rdbtnEmpresa.isSelected()){
						empresa = "TRUE";
					}else{
						empresa = "FALSE";
					}
					connection.agregar(nombre, contrasenia, empresa);
					JOptionPane.showMessageDialog(frmMenuPrincipal, "Usuario creado con exito. Por favor inicie sesion con sus datos.", "Info",JOptionPane.INFORMATION_MESSAGE);
					
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
				}catch (Exception e){
					JOptionPane.showMessageDialog(frmMenuPrincipal, "No se ha iniciado la base de datos!","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
	}
}
