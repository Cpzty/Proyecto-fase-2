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

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

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
	private JTabbedPane tabbedPane;

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
	 */
	public GUI() {
		initialize();
		//connection.conectar();
		ComboBox();
		Random();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
			guate= new CiudadVerde();
			connection = new Conector();
			
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(255, 255, 255));
			frame.setBounds(100, 100, 585, 522);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
        	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        	tabbedPane.setVisible(false);
        	
        	lblReciguate = new JLabel("RECIGUATE");
        	lblReciguate.setForeground(new Color(0, 204, 0));
        	lblReciguate.setFont(new Font("Arial", Font.PLAIN, 16));
        	lblReciguate.setVisible(false);
        	frame.getContentPane().setLayout(new CardLayout(0, 0));
        	frame.getContentPane().add(lblReciguate, "name_411968808218137");
        	frame.getContentPane().add(tabbedPane, "name_411968820848809");
        	
        	
        	JPanel Buscar = new JPanel();
        	tabbedPane.addTab("Buscar", null, Buscar, null);
        	Buscar.setBackground(new Color(204, 255, 153));
        	Buscar.setForeground(new Color(0, 0, 0));
        	GridBagLayout gbl_Buscar = new GridBagLayout();
        	gbl_Buscar.columnWidths = new int[]{211, 328, 0};
        	gbl_Buscar.rowHeights = new int[]{16, 27, 21, 27, 29, 14, 214, 14, 0};
        	gbl_Buscar.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        	gbl_Buscar.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        	Buscar.setLayout(gbl_Buscar);
        	
        	lblMaterial = new JLabel("Material:");
        	GridBagConstraints gbc_lblMaterial = new GridBagConstraints();
        	gbc_lblMaterial.anchor = GridBagConstraints.NORTHWEST;
        	gbc_lblMaterial.insets = new Insets(0, 0, 5, 5);
        	gbc_lblMaterial.gridx = 0;
        	gbc_lblMaterial.gridy = 0;
        	Buscar.add(lblMaterial, gbc_lblMaterial);
        	
        	lblNombre = new JLabel("Nombre");
        	lblNombre.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        	gbc_lblNombre.anchor = GridBagConstraints.NORTH;
        	gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
        	gbc_lblNombre.gridx = 1;
        	gbc_lblNombre.gridy = 0;
        	Buscar.add(lblNombre, gbc_lblNombre);
        	
        	CBMaterial = new JComboBox<String>();
        	CBMaterial.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_CBMaterial = new GridBagConstraints();
        	gbc_CBMaterial.fill = GridBagConstraints.BOTH;
        	gbc_CBMaterial.insets = new Insets(0, 0, 5, 5);
        	gbc_CBMaterial.gridx = 0;
        	gbc_CBMaterial.gridy = 1;
        	Buscar.add(CBMaterial, gbc_CBMaterial);
        	
        	lblDireccion = new JLabel("Direccion");
        	lblDireccion.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
        	gbc_lblDireccion.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblDireccion.insets = new Insets(0, 0, 5, 0);
        	gbc_lblDireccion.gridx = 1;
        	gbc_lblDireccion.gridy = 1;
        	Buscar.add(lblDireccion, gbc_lblDireccion);
        	
        	lblZona = new JLabel("Zona: ");
        	lblZona.setForeground(new Color(0, 102, 0));
        	lblZona.setBackground(new Color(51, 204, 51));
        	GridBagConstraints gbc_lblZona = new GridBagConstraints();
        	gbc_lblZona.anchor = GridBagConstraints.NORTHWEST;
        	gbc_lblZona.insets = new Insets(0, 0, 5, 5);
        	gbc_lblZona.gridx = 0;
        	gbc_lblZona.gridy = 2;
        	Buscar.add(lblZona, gbc_lblZona);
        	
        	lblTelefono = new JLabel("Telefono");
        	lblTelefono.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
        	gbc_lblTelefono.anchor = GridBagConstraints.SOUTH;
        	gbc_lblTelefono.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblTelefono.insets = new Insets(0, 0, 5, 0);
        	gbc_lblTelefono.gridx = 1;
        	gbc_lblTelefono.gridy = 2;
        	Buscar.add(lblTelefono, gbc_lblTelefono);
        	
        	CBZona = new JComboBox<Integer>();
        	CBZona.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_CBZona = new GridBagConstraints();
        	gbc_CBZona.fill = GridBagConstraints.BOTH;
        	gbc_CBZona.insets = new Insets(0, 0, 5, 5);
        	gbc_CBZona.gridx = 0;
        	gbc_CBZona.gridy = 3;
        	Buscar.add(CBZona, gbc_CBZona);
        	
        	lblPagina = new JLabel("Pagina Web");
        	lblPagina.setForeground(new Color(0, 102, 0));
        	GridBagConstraints gbc_lblPagina = new GridBagConstraints();
        	gbc_lblPagina.fill = GridBagConstraints.HORIZONTAL;
        	gbc_lblPagina.insets = new Insets(0, 0, 5, 0);
        	gbc_lblPagina.gridx = 1;
        	gbc_lblPagina.gridy = 3;
        	Buscar.add(lblPagina, gbc_lblPagina);
        	
        	btnBuscarEmpresa = new JButton("Buscar empresa");
        	btnBuscarEmpresa.setBackground(new Color(255, 255, 255));
        	GridBagConstraints gbc_btnBuscarEmpresa = new GridBagConstraints();
        	gbc_btnBuscarEmpresa.anchor = GridBagConstraints.WEST;
        	gbc_btnBuscarEmpresa.fill = GridBagConstraints.VERTICAL;
        	gbc_btnBuscarEmpresa.insets = new Insets(0, 0, 5, 5);
        	gbc_btnBuscarEmpresa.gridx = 0;
        	gbc_btnBuscarEmpresa.gridy = 4;
        	Buscar.add(btnBuscarEmpresa, gbc_btnBuscarEmpresa);
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
        	Buscar.add(lblMapa, gbc_lblMapa);
        	lblMapa.setVisible(false);
        	
        	lblDatoCurioso = new JLabel("Dato curioso:");
        	GridBagConstraints gbc_lblDatoCurioso = new GridBagConstraints();
        	gbc_lblDatoCurioso.fill = GridBagConstraints.BOTH;
        	gbc_lblDatoCurioso.gridwidth = 2;
        	gbc_lblDatoCurioso.gridx = 0;
        	gbc_lblDatoCurioso.gridy = 7;
        	Buscar.add(lblDatoCurioso, gbc_lblDatoCurioso);
        	lblDatoCurioso.setForeground(new Color(51, 204, 102));
        	
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
        	
        	lblRegistro = new JLabel("Registro");
        	lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 40));
        	lblRegistro.setVisible(false);
        	
        	btnRegresar = new JButton("Regresar");
        	btnRegresar.addActionListener(new menuListener());
        	btnRegresar.setVisible(false);
        	
        	lblNombre2 = new JLabel("Usuario");
        	lblNombre2.setVisible(false);
        	
        	txtNombre2 = new JTextField();
        	txtNombre2.setColumns(10);
        	
        	btnRegistrarse2 = new JButton("Registrarse");
        	btnRegistrarse2.setVisible(false);
        	btnRegistrarse2.addActionListener(new menuListener());
        	
        	lblContrasena2 = new JLabel("Contrase\u00F1a");
        	lblContrasena2.setVisible(false);
        	
        	txtContrasea = new JTextField();
        	txtContrasea.setColumns(10);
        	GroupLayout gl_Registro = new GroupLayout(Registro);
        	gl_Registro.setHorizontalGroup(
        		gl_Registro.createParallelGroup(Alignment.LEADING)
        			.addGroup(gl_Registro.createSequentialGroup()
        				.addGap(132)
        				.addComponent(lblRegistro))
        			.addGroup(gl_Registro.createSequentialGroup()
        				.addGap(84)
        				.addComponent(lblNombre2)
        				.addGap(35)
        				.addComponent(txtNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(gl_Registro.createSequentialGroup()
        				.addGap(92)
        				.addComponent(lblContrasena2)
        				.addGap(5)
        				.addComponent(txtContrasea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(gl_Registro.createSequentialGroup()
        				.addComponent(btnRegistrarse2, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        				.addGap(52)
        				.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
        	);
        	gl_Registro.setVerticalGroup(
        		gl_Registro.createParallelGroup(Alignment.LEADING)
        			.addGroup(gl_Registro.createSequentialGroup()
        				.addComponent(lblRegistro)
        				.addGap(88)
        				.addGroup(gl_Registro.createParallelGroup(Alignment.LEADING)
        					.addGroup(gl_Registro.createSequentialGroup()
        						.addGap(3)
        						.addComponent(lblNombre2))
        					.addComponent(txtNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGap(5)
        				.addGroup(gl_Registro.createParallelGroup(Alignment.LEADING)
        					.addGroup(gl_Registro.createSequentialGroup()
        						.addGap(3)
        						.addComponent(lblContrasena2))
        					.addComponent(txtContrasea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGap(60)
        				.addGroup(gl_Registro.createParallelGroup(Alignment.LEADING)
        					.addComponent(btnRegistrarse2)
        					.addComponent(btnRegresar)))
        	);
        	Registro.setLayout(gl_Registro);
        	
        	Menu = new JPanel();
        	Menu.setBorder(null);
        	frame.getContentPane().add(Menu, "name_411968872411943");
        	GridBagLayout gbl_Menu = new GridBagLayout();
        	gbl_Menu.columnWidths = new int[]{80, 70, 0};
        	gbl_Menu.rowHeights = new int[]{49, 20, 20, 24, 0};
        	gbl_Menu.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        	gbl_Menu.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        	Menu.setLayout(gbl_Menu);
        	Menu.setVisible(true);
        	       	
	       	JLabel lblMenu = new JLabel("Menu");
	       	GridBagConstraints gbc_lblMenu = new GridBagConstraints();
	       	gbc_lblMenu.anchor = GridBagConstraints.NORTH;
	       	gbc_lblMenu.insets = new Insets(0, 0, 5, 0);
	       	gbc_lblMenu.gridwidth = 2;
	       	gbc_lblMenu.gridx = 0;
	       	gbc_lblMenu.gridy = 0;
	       	Menu.add(lblMenu, gbc_lblMenu);
	       	lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 40));
	
	       
	       	lblNombre_1 = new JLabel("Usuario");
	       	GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
	       	gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
	       	gbc_lblNombre_1.gridx = 0;
	       	gbc_lblNombre_1.gridy = 1;
	       	Menu.add(lblNombre_1, gbc_lblNombre_1);
        	
        	
        	txtNombre = new JTextField();
        	txtNombre.setColumns(10);
        	GridBagConstraints gbc_txtNombre = new GridBagConstraints();
        	gbc_txtNombre.fill = GridBagConstraints.BOTH;
        	gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
        	gbc_txtNombre.gridx = 1;
        	gbc_txtNombre.gridy = 1;
        	Menu.add(txtNombre, gbc_txtNombre);
        	
        	
        	lblContrasea = new JLabel("Contrase\u00F1a");
        	GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
        	gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
        	gbc_lblContrasea.gridx = 0;
        	gbc_lblContrasea.gridy = 2;
        	Menu.add(lblContrasea, gbc_lblContrasea);
        	
        	btnIngresar = new JButton("Ingresar");
        	btnIngresar.addActionListener(new menuListener());
        	
        	passwordField = new JPasswordField();
        	GridBagConstraints gbc_passwordField = new GridBagConstraints();
        	gbc_passwordField.fill = GridBagConstraints.BOTH;
        	gbc_passwordField.insets = new Insets(0, 0, 5, 0);
        	gbc_passwordField.gridx = 1;
        	gbc_passwordField.gridy = 2;
        	Menu.add(passwordField, gbc_passwordField);
        	GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
        	gbc_btnIngresar.fill = GridBagConstraints.HORIZONTAL;
        	gbc_btnIngresar.insets = new Insets(0, 0, 0, 5);
        	gbc_btnIngresar.gridx = 0;
        	gbc_btnIngresar.gridy = 3;
        	Menu.add(btnIngresar, gbc_btnIngresar);
        	
        	btnRegistrarse = new JButton("Registrarse");
        	GridBagConstraints gbc_btnRegistrarse = new GridBagConstraints();
        	gbc_btnRegistrarse.fill = GridBagConstraints.HORIZONTAL;
        	gbc_btnRegistrarse.gridx = 1;
        	gbc_btnRegistrarse.gridy = 3;
        	Menu.add(btnRegistrarse, gbc_btnRegistrarse);
        	btnRegistrarse.addActionListener(new menuListener());
		
		
		
		
		
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
				String nombre = txtNombre.getText();
				char[] password = passwordField.getPassword();
				String contrasenia = "";
				for (int i = 0; i < password.length; i++){
					contrasenia = contrasenia + password[i];
				}
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
			}else if (event.getSource().equals(btnRegistrarse2)){
				String nombre = txtNombre2.getText();
				String contrasenia = txtContrasea.getText();
				String sql = "INSERT INTO USUARIOS (ID,NAME,PASSWORD) "
			               + "VALUES (2,'"+nombre+"', '"+contrasenia+"');";
				
				connection.agregar(sql);
			}
			
		}
		
	}
	
}
