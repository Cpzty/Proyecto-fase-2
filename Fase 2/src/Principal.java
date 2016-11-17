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
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

//DB

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
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Principal {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	Connection conector = null;
	private JLabel lblMunicipio;
	public Principal() {
		initialize();
		//conector = Conector.ConnectDB();
		ComboBox();
		Random();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			
			guate= new CiudadVerde();
			ImageIcon fondo = new ImageIcon("reciclaje.jpg");
			
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
        	CBZona.setBounds(68, 124, 238, 35);
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
        	lblMapa.setBounds(363, 334, 347, 186);
        	lblMapa.setForeground(new Color(0, 128, 0));
        	lblMapa.setVisible(false);
        	
        	lblDatoCurioso = new JLabel("Dato curioso:");
        	lblDatoCurioso.setBounds(0, 471, 562, 16);
        	lblDatoCurioso.setForeground(new Color(51, 204, 102));
        	
        	JComboBox comboBox = new JComboBox();
        	comboBox.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        	comboBox.setBounds(70, 193, 236, 38);
        	Buscar.setLayout(null);
        	Buscar.add(lblMaterial);
        	Buscar.add(CBMaterial);
        	Buscar.add(lblNombre);
        	Buscar.add(lblDatoCurioso);
        	Buscar.add(lblMapa);
        	Buscar.add(btnBuscarEmpresa);
        	Buscar.add(lblZona);
        	Buscar.add(CBZona);
        	Buscar.add(comboBox);
        	Buscar.add(lblDireccion);
        	Buscar.add(lblPagina);
        	Buscar.add(lblTelefono);
        	
        	lblMunicipio = new JLabel("Municipio");
        	lblMunicipio.setForeground(new Color(0, 102, 0));
        	lblMunicipio.setFont(new Font("Sylfaen", Font.PLAIN, 30));
        	lblMunicipio.setBackground(new Color(51, 204, 51));
        	lblMunicipio.setBounds(36, 79, 146, 40);
        	Buscar.add(lblMunicipio);
        	
        	JPanel Reciclar = new JPanel();
        	tabbedPane.addTab("Reciclar", null, Reciclar, null);
        	Reciclar.setBackground(new Color(204, 255, 153));
        	GridBagLayout gbl_Reciclar = new GridBagLayout();
        	gbl_Reciclar.columnWidths = new int[]{151, 296, 0};
        	gbl_Reciclar.rowHeights = new int[]{14, 23, 24, 20, 14, 20, 0};
        	gbl_Reciclar.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        	gbl_Reciclar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        	Reciclar.setLayout(gbl_Reciclar);
        	
        	JLabel lblSeleccioneElMaterial = new JLabel("Seleccione el material:");
        	lblSeleccioneElMaterial.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblSeleccioneElMaterial = new GridBagConstraints();
        	gbc_lblSeleccioneElMaterial.fill = GridBagConstraints.BOTH;
        	gbc_lblSeleccioneElMaterial.insets = new Insets(0, 0, 5, 5);
        	gbc_lblSeleccioneElMaterial.gridx = 0;
        	gbc_lblSeleccioneElMaterial.gridy = 0;
        	Reciclar.add(lblSeleccioneElMaterial, gbc_lblSeleccioneElMaterial);
        	
        	lblCalcularDineroAhorrado = new JLabel("Calcular cantidad reciclada:");
        	lblCalcularDineroAhorrado.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblCalcularDineroAhorrado = new GridBagConstraints();
        	gbc_lblCalcularDineroAhorrado.anchor = GridBagConstraints.WEST;
        	gbc_lblCalcularDineroAhorrado.fill = GridBagConstraints.VERTICAL;
        	gbc_lblCalcularDineroAhorrado.insets = new Insets(0, 0, 5, 0);
        	gbc_lblCalcularDineroAhorrado.gridx = 1;
        	gbc_lblCalcularDineroAhorrado.gridy = 0;
        	Reciclar.add(lblCalcularDineroAhorrado, gbc_lblCalcularDineroAhorrado);
        	
        	cbxMateriales = new JComboBox<String>();
        	cbxMateriales.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_cbxMateriales = new GridBagConstraints();
        	gbc_cbxMateriales.anchor = GridBagConstraints.NORTH;
        	gbc_cbxMateriales.fill = GridBagConstraints.HORIZONTAL;
        	gbc_cbxMateriales.insets = new Insets(0, 0, 5, 5);
        	gbc_cbxMateriales.gridx = 0;
        	gbc_cbxMateriales.gridy = 1;
        	Reciclar.add(cbxMateriales, gbc_cbxMateriales);
        	
        	btnCalcular = new JButton("Calcular");
        	btnCalcular.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
        	gbc_btnCalcular.anchor = GridBagConstraints.WEST;
        	gbc_btnCalcular.fill = GridBagConstraints.VERTICAL;
        	gbc_btnCalcular.insets = new Insets(0, 0, 5, 0);
        	gbc_btnCalcular.gridx = 1;
        	gbc_btnCalcular.gridy = 1;
        	Reciclar.add(btnCalcular, gbc_btnCalcular);
        	btnCalcular.addActionListener(new actionlistener());
        	
        	JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad: ");
        	lblIngreseLaCantidad.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblIngreseLaCantidad = new GridBagConstraints();
        	gbc_lblIngreseLaCantidad.anchor = GridBagConstraints.NORTH;
        	gbc_lblIngreseLaCantidad.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblIngreseLaCantidad.insets = new Insets(0, 0, 5, 5);
        	gbc_lblIngreseLaCantidad.gridx = 0;
        	gbc_lblIngreseLaCantidad.gridy = 2;
        	Reciclar.add(lblIngreseLaCantidad, gbc_lblIngreseLaCantidad);
        	
        	lblResultado = new JLabel("Resultado:");
        	lblResultado.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblResultado = new GridBagConstraints();
        	gbc_lblResultado.anchor = GridBagConstraints.SOUTH;
        	gbc_lblResultado.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblResultado.insets = new Insets(0, 0, 5, 0);
        	gbc_lblResultado.gridx = 1;
        	gbc_lblResultado.gridy = 2;
        	Reciclar.add(lblResultado, gbc_lblResultado);
        	
        	txtCantidad = new JTextField();
        	GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
        	gbc_txtCantidad.anchor = GridBagConstraints.WEST;
        	gbc_txtCantidad.fill = GridBagConstraints.VERTICAL;
        	gbc_txtCantidad.insets = new Insets(0, 0, 5, 5);
        	gbc_txtCantidad.gridx = 0;
        	gbc_txtCantidad.gridy = 3;
        	Reciclar.add(txtCantidad, gbc_txtCantidad);
        	txtCantidad.setColumns(10);
        	
        	JLabel lblSeleccioneLaDimensional = new JLabel("Seleccione la dimensional:");
        	lblSeleccioneLaDimensional.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblSeleccioneLaDimensional = new GridBagConstraints();
        	gbc_lblSeleccioneLaDimensional.fill = GridBagConstraints.BOTH;
        	gbc_lblSeleccioneLaDimensional.insets = new Insets(0, 0, 5, 5);
        	gbc_lblSeleccioneLaDimensional.gridx = 0;
        	gbc_lblSeleccioneLaDimensional.gridy = 4;
        	Reciclar.add(lblSeleccioneLaDimensional, gbc_lblSeleccioneLaDimensional);
        	
        	cbxDimensional = new JComboBox<String>();
        	cbxDimensional.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_cbxDimensional = new GridBagConstraints();
        	gbc_cbxDimensional.fill = GridBagConstraints.BOTH;
        	gbc_cbxDimensional.insets = new Insets(0, 0, 0, 5);
        	gbc_cbxDimensional.gridx = 0;
        	gbc_cbxDimensional.gridy = 5;
        	Reciclar.add(cbxDimensional, gbc_cbxDimensional);
        	
        	JPanel VerRecicladoras = new JPanel();
        	VerRecicladoras.setBackground(new Color(204, 255, 153));
        	tabbedPane.addTab("Ver Todas las Recicladoras", null, VerRecicladoras, null);
        	GridBagLayout gbl_VerRecicladoras = new GridBagLayout();
        	gbl_VerRecicladoras.columnWidths = new int[]{469, 0};
        	gbl_VerRecicladoras.rowHeights = new int[]{25, 25, 23, 16, 16, 16, 16, 0};
        	gbl_VerRecicladoras.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        	gbl_VerRecicladoras.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        	VerRecicladoras.setLayout(gbl_VerRecicladoras);
        	
        	JLabel lblSeleccioneElNombre = new JLabel("Seleccione el Nombre de la Empresa:");
        	GridBagConstraints gbc_lblSeleccioneElNombre = new GridBagConstraints();
        	gbc_lblSeleccioneElNombre.anchor = GridBagConstraints.WEST;
        	gbc_lblSeleccioneElNombre.fill = GridBagConstraints.VERTICAL;
        	gbc_lblSeleccioneElNombre.insets = new Insets(0, 0, 5, 0);
        	gbc_lblSeleccioneElNombre.gridx = 0;
        	gbc_lblSeleccioneElNombre.gridy = 0;
        	VerRecicladoras.add(lblSeleccioneElNombre, gbc_lblSeleccioneElNombre);
        	
        	comboBoxNombres = new JComboBox<String>();
        	GridBagConstraints gbc_comboBoxNombres = new GridBagConstraints();
        	gbc_comboBoxNombres.anchor = GridBagConstraints.WEST;
        	gbc_comboBoxNombres.fill = GridBagConstraints.VERTICAL;
        	gbc_comboBoxNombres.insets = new Insets(0, 0, 5, 0);
        	gbc_comboBoxNombres.gridx = 0;
        	gbc_comboBoxNombres.gridy = 1;
        	VerRecicladoras.add(comboBoxNombres, gbc_comboBoxNombres);
        	
        	btnVerInformacion = new JButton("Ver Informacion");
        	GridBagConstraints gbc_btnVerInformacion = new GridBagConstraints();
        	gbc_btnVerInformacion.anchor = GridBagConstraints.WEST;
        	gbc_btnVerInformacion.fill = GridBagConstraints.VERTICAL;
        	gbc_btnVerInformacion.insets = new Insets(0, 0, 5, 0);
        	gbc_btnVerInformacion.gridx = 0;
        	gbc_btnVerInformacion.gridy = 2;
        	VerRecicladoras.add(btnVerInformacion, gbc_btnVerInformacion);
        	btnVerInformacion.addActionListener(new actionlistener());
        	
        	lblInfoNombre = new JLabel("Nombre");
        	lblInfoNombre.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblInfoNombre = new GridBagConstraints();
        	gbc_lblInfoNombre.anchor = GridBagConstraints.NORTH;
        	gbc_lblInfoNombre.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblInfoNombre.insets = new Insets(0, 0, 5, 0);
        	gbc_lblInfoNombre.gridx = 0;
        	gbc_lblInfoNombre.gridy = 3;
        	VerRecicladoras.add(lblInfoNombre, gbc_lblInfoNombre);
        	
        	lblInfoDireccion = new JLabel("Direccion");
        	lblInfoDireccion.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblInfoDireccion = new GridBagConstraints();
        	gbc_lblInfoDireccion.anchor = GridBagConstraints.NORTH;
        	gbc_lblInfoDireccion.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblInfoDireccion.insets = new Insets(0, 0, 5, 0);
        	gbc_lblInfoDireccion.gridx = 0;
        	gbc_lblInfoDireccion.gridy = 4;
        	VerRecicladoras.add(lblInfoDireccion, gbc_lblInfoDireccion);
        	
        	lblInfoTel = new JLabel("Telefono");
        	lblInfoTel.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblInfoTel = new GridBagConstraints();
        	gbc_lblInfoTel.anchor = GridBagConstraints.NORTH;
        	gbc_lblInfoTel.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblInfoTel.insets = new Insets(0, 0, 5, 0);
        	gbc_lblInfoTel.gridx = 0;
        	gbc_lblInfoTel.gridy = 5;
        	VerRecicladoras.add(lblInfoTel, gbc_lblInfoTel);
        	
        	lblInfoWeb = new JLabel("Pagina Web");
        	lblInfoWeb.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblInfoWeb = new GridBagConstraints();
        	gbc_lblInfoWeb.anchor = GridBagConstraints.NORTH;
        	gbc_lblInfoWeb.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblInfoWeb.gridx = 0;
        	gbc_lblInfoWeb.gridy = 6;
        	VerRecicladoras.add(lblInfoWeb, gbc_lblInfoWeb);
        	
        	// el panel de registro sirve para que el usuario cree su usuario, esta oculto al inicio
        	
        	Registro = new JPanel();
        	Registro.setBorder(null);
        	frame.getContentPane().add(Registro, "name_411968859242604");
        	Registro.setVisible(false);
        	GridBagLayout gbl_Registro = new GridBagLayout();
        	gbl_Registro.columnWidths = new int[]{127, 0, 0};
        	gbl_Registro.rowHeights = new int[]{49, 22, 22, 60, 25, 0};
        	gbl_Registro.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        	gbl_Registro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        	Registro.setLayout(gbl_Registro);
        	
        	lblNombre2 = new JLabel("Usuario");
        	lblNombre2.setVisible(false);
        	
        	lblRegistro = new JLabel("Registro");
        	lblRegistro.setVisible(false);
        	GridBagConstraints gbc_lblRegistro = new GridBagConstraints();
        	gbc_lblRegistro.gridwidth = 2;
        	gbc_lblRegistro.anchor = GridBagConstraints.NORTH;
        	gbc_lblRegistro.insets = new Insets(0, 0, 5, 5);
        	gbc_lblRegistro.gridx = 0;
        	gbc_lblRegistro.gridy = 0;
        	Registro.add(lblRegistro, gbc_lblRegistro);
        	lblRegistro.setFont(new Font("Curlz MT", Font.BOLD, 72));
        	GridBagConstraints gbc_lblNombre2 = new GridBagConstraints();
        	gbc_lblNombre2.anchor = GridBagConstraints.EAST;
        	gbc_lblNombre2.insets = new Insets(0, 0, 5, 5);
        	gbc_lblNombre2.gridx = 0;
        	gbc_lblNombre2.gridy = 1;
        	Registro.add(lblNombre2, gbc_lblNombre2);
        	
        	lblContrasena2 = new JLabel("Contrase\u00F1a");
        	lblContrasena2.setVisible(false);
        	
        	txtNombre2 = new JTextField();
        	txtNombre2.setColumns(10);
        	GridBagConstraints gbc_txtNombre2 = new GridBagConstraints();
        	gbc_txtNombre2.anchor = GridBagConstraints.NORTHWEST;
        	gbc_txtNombre2.insets = new Insets(0, 0, 5, 0);
        	gbc_txtNombre2.gridx = 1;
        	gbc_txtNombre2.gridy = 1;
        	Registro.add(txtNombre2, gbc_txtNombre2);
        	GridBagConstraints gbc_lblContrasena2 = new GridBagConstraints();
        	gbc_lblContrasena2.anchor = GridBagConstraints.EAST;
        	gbc_lblContrasena2.insets = new Insets(0, 0, 5, 5);
        	gbc_lblContrasena2.gridx = 0;
        	gbc_lblContrasena2.gridy = 2;
        	Registro.add(lblContrasena2, gbc_lblContrasena2);
        	
        	btnRegistrarse2 = new JButton("Registrarse");
        	btnRegistrarse2.setVisible(false);
        	
        	txtContrasea = new JTextField();
        	txtContrasea.setColumns(10);
        	GridBagConstraints gbc_txtContrasea = new GridBagConstraints();
        	gbc_txtContrasea.anchor = GridBagConstraints.NORTHWEST;
        	gbc_txtContrasea.insets = new Insets(0, 0, 5, 0);
        	gbc_txtContrasea.gridx = 1;
        	gbc_txtContrasea.gridy = 2;
        	Registro.add(txtContrasea, gbc_txtContrasea);
        	GridBagConstraints gbc_btnRegistrarse2 = new GridBagConstraints();
        	gbc_btnRegistrarse2.anchor = GridBagConstraints.NORTH;
        	gbc_btnRegistrarse2.fill = GridBagConstraints.HORIZONTAL;
        	gbc_btnRegistrarse2.insets = new Insets(0, 0, 0, 5);
        	gbc_btnRegistrarse2.gridx = 0;
        	gbc_btnRegistrarse2.gridy = 4;
        	Registro.add(btnRegistrarse2, gbc_btnRegistrarse2);
        	
        	btnRegresar = new JButton("Regresar");
        	btnRegresar.addActionListener(new menuListener());
        	btnRegresar.setVisible(false);
        	GridBagConstraints gbc_btnRegresar = new GridBagConstraints();
        	gbc_btnRegresar.anchor = GridBagConstraints.NORTH;
        	gbc_btnRegresar.fill = GridBagConstraints.HORIZONTAL;
        	gbc_btnRegresar.gridx = 1;
        	gbc_btnRegresar.gridy = 4;
        	Registro.add(btnRegresar, gbc_btnRegresar);
        	
        	Menu = new JPanel();
        	Menu.setBackground(Color.ORANGE);
        	Menu.setBorder(null);
        	frame.getContentPane().add(Menu, "name_411968872411943");
        	Menu.setVisible(true);
        	//Menu.bac
        	       	
	       	JLabel lblMenu = new JLabel("Menu");
	       	lblMenu.setFont(new Font("Curlz MT", Font.BOLD, 72));
	
	       
	       	lblNombre_1 = new JLabel("Usuario");
	       	lblNombre_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	
        	
        	txtNombre = new JTextField();
        	txtNombre.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	txtNombre.setColumns(10);
        	
        	
        	lblContrasea = new JLabel("Contrase\u00F1a");
        	lblContrasea.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	
        	btnIngresar = new JButton("Ingresar");
        	btnIngresar.addActionListener(new menuListener());
        	btnIngresar.setFont(new Font("Kristen ITC", Font.BOLD, 24));
        	
        	passwordField = new JPasswordField();
        	passwordField.setFont(new Font("Perpetua", Font.PLAIN, 30));
        	
        	btnRegistrarse = new JButton("Registrarse");
        	btnRegistrarse.addActionListener(new menuListener());
        	btnRegistrarse.setFont(new Font("Kristen ITC", Font.BOLD, 24));
        	GroupLayout gl_Menu = new GroupLayout(Menu);
        	gl_Menu.setHorizontalGroup(
        		gl_Menu.createParallelGroup(Alignment.LEADING)
        			.addGroup(Alignment.TRAILING, gl_Menu.createSequentialGroup()
        				.addGap(83)
        				.addGroup(gl_Menu.createParallelGroup(Alignment.LEADING)
        					.addGroup(gl_Menu.createSequentialGroup()
        						.addGap(124)
        						.addComponent(lblMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addGap(111))
        					.addGroup(gl_Menu.createSequentialGroup()
        						.addGroup(gl_Menu.createParallelGroup(Alignment.LEADING)
        							.addGroup(gl_Menu.createSequentialGroup()
        								.addComponent(lblNombre_1, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        								.addGap(40))
        							.addGroup(gl_Menu.createSequentialGroup()
        								.addComponent(lblContrasea, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        								.addGap(27))
        							.addComponent(btnIngresar, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
        						.addGap(25)
        						.addGroup(gl_Menu.createParallelGroup(Alignment.TRAILING)
        							.addGroup(gl_Menu.createSequentialGroup()
        								.addGap(51)
        								.addComponent(btnRegistrarse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addGroup(gl_Menu.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(passwordField, Alignment.TRAILING)
        								.addComponent(txtNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
        				.addGap(72))
        	);
        	gl_Menu.setVerticalGroup(
        		gl_Menu.createParallelGroup(Alignment.LEADING)
        			.addGroup(gl_Menu.createSequentialGroup()
        				.addGap(91)
        				.addComponent(lblMenu, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
        				.addGap(5)
        				.addGroup(gl_Menu.createParallelGroup(Alignment.BASELINE)
        					.addGroup(gl_Menu.createSequentialGroup()
        						.addGap(6)
        						.addComponent(lblNombre_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addComponent(txtNombre))
        				.addPreferredGap(ComponentPlacement.UNRELATED)
        				.addGroup(gl_Menu.createParallelGroup(Alignment.BASELINE)
        					.addGroup(gl_Menu.createSequentialGroup()
        						.addGap(6)
        						.addComponent(lblContrasea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addComponent(passwordField))
        				.addGap(18)
        				.addGroup(gl_Menu.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnIngresar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnRegistrarse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGap(129))
        	);
        	Menu.setLayout(gl_Menu);
		
		
		
		
		
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
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
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
			}else if (event.getSource().equals(btnIngresar)){
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
			}
			
		}
		
	}
}
