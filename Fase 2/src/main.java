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
        
        lblReciguate = new JLabel("RECIGUATE");
        lblReciguate.setBounds(232, 2, 147, 23);
        lblReciguate.setForeground(new Color(0, 204, 0));
        lblReciguate.setFont(new Font("Arial", Font.PLAIN, 16));
        lblReciguate.setVisible(false);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(lblReciguate);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 30, 569, 453);
        tabbedPane.setVisible(false);
        frame.getContentPane().add(tabbedPane);
        
        
        JPanel Reciclar = new JPanel();
        tabbedPane.addTab("Buscar", null, Reciclar, null);
        Reciclar.setBackground(new Color(204, 255, 153));
        Reciclar.setForeground(new Color(0, 0, 0));
        Reciclar.setLayout(null);
        
        CBMaterial = new JComboBox<String>();
        CBMaterial.setBackground(new Color(255, 255, 255));
        CBMaterial.setBounds(10, 35, 211, 27);
        Reciclar.add(CBMaterial);
        
        CBZona = new JComboBox<Integer>();
        CBZona.setBackground(new Color(255, 255, 255));
        CBZona.setBounds(10, 87, 211, 27);
        Reciclar.add(CBZona);
        
        btnBuscarEmpresa = new JButton("Buscar empresa");
        btnBuscarEmpresa.setBackground(new Color(255, 255, 255));
        btnBuscarEmpresa.setBounds(10, 116, 152, 29);
        Reciclar.add(btnBuscarEmpresa);
        btnBuscarEmpresa.addActionListener(new actionlistener());
        
        lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(new Color(0, 102, 0));
        lblNombre.setBounds(231, 16, 281, 16);
        Reciclar.add(lblNombre);
        
        lblDireccion = new JLabel("Direccion");
        lblDireccion.setForeground(new Color(0, 102, 0));
        lblDireccion.setBounds(231, 40, 281, 16);
        Reciclar.add(lblDireccion);
        
        lblTelefono = new JLabel("Telefono");
        lblTelefono.setForeground(new Color(0, 102, 0));
        lblTelefono.setBounds(231, 67, 281, 16);
        Reciclar.add(lblTelefono);
        
        lblPagina = new JLabel("Pagina Web");
        lblPagina.setForeground(new Color(0, 102, 0));
        lblPagina.setBounds(231, 92, 281, 16);
        Reciclar.add(lblPagina);
        
        lblZona = new JLabel("Zona: ");
        lblZona.setForeground(new Color(0, 102, 0));
        lblZona.setBackground(new Color(51, 204, 51));
        lblZona.setBounds(10, 62, 79, 14);
        Reciclar.add(lblZona);
        
        lblMaterial = new JLabel("Material:");
        lblMaterial.setBounds(10, 17, 93, 14);
        Reciclar.add(lblMaterial);
        
        lblMapa = new JLabel("Mapa:");
        lblMapa.setForeground(new Color(0, 128, 0));
        lblMapa.setBounds(10, 156, 193, 14);
        Reciclar.add(lblMapa);
        
        lblDatoCurioso = new JLabel("Dato curioso:");
        lblDatoCurioso.setBounds(10, 384, 549, 14);
        Reciclar.add(lblDatoCurioso);
        lblDatoCurioso.setForeground(new Color(51, 204, 102));
        lblMapa.setVisible(false);
        
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
	
		
		
	   //Esto es del menu y lo anterior es de el programa
        
       
		
		JLabel lblNombre = new JLabel("Usuario");
		lblNombre.setBounds(96, 141, 46, 14);
		
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(80, 182, 70, 14);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(165, 138, 86, 20);
		txtNombre.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 179, 86, 20);
		
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(80, 228, 89, 23);
		
		// el panel de registro sirve para que el usuario cree su usuario, esta oculto al inicio
		
		JPanel Registro = new JPanel();
		Registro.setBounds(0, 30, 569, 453);
		Registro.setBorder(null);
		frame.getContentPane().add(Registro);
		Registro.setLayout(null);
		Registro.setVisible(false);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setBounds(151, 6, 144, 49);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 40));
		Registro.add(lblRegistro);
		lblRegistro.setVisible(false);
		
		JLabel lblNombre2 = new JLabel("Usuario");
		lblNombre2.setBounds(96, 141, 46, 14);
		Registro.add(lblNombre2);
		lblNombre2.setVisible(false);
		
		JLabel lblContrasena2 = new JLabel("Contrase\u00F1a");
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
		
		JButton btnRegistrarse2 = new JButton("Registrarse");
		btnRegistrarse2.setBounds(10, 254, 161, 23);
		btnRegistrarse2.setVisible(false);
		Registro.add(btnRegistrarse2);
		
		// el menu es la pantalla principal donde el usuario puede ingresar 
		
		JPanel Menu = new JPanel();
		Menu.setBounds(0, 30, 569, 453);
		Menu.setBorder(null);
		frame.getContentPane().add(Menu);
		Menu.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(151, 6, 144, 49);
		Menu.add(lblMenu);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu.setVisible(true);
				lblNombre.setVisible(true);
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
		});
		btnRegresar.setBounds(218, 254, 161, 23);
		btnRegresar.setVisible(false);
		Registro.add(btnRegresar);
		
		
		
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(200, 229, 119, 23);
		Menu.add(btnRegistrarse);
		Menu.add(lblNombre);
		Menu.add(txtNombre);
		Menu.add(lblContrasea);
		Menu.add(passwordField);
		Menu.add(btnIngresar);
		
		
		// al apachar el boton de registro cambia la visibilidad del panel para que el usuario la pueda ver
	
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Menu.setVisible(false);
			lblNombre.setVisible(false);
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
				lblNombre.setVisible(false);
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
	        cadena= "Para producir 1 tonelada de papel se cortan 17 �rboles grandes.";
	        break;
	    case 3:
	        cadena= "Reciclar 900kg de pl�stico puede salvar 7570 litros de gasolina.";
	        break;
	    case 4:
	        cadena= "La ropa tambi�n se puede reciclar.";
	        break;
	    case 5:
	        cadena= "Al reciclar vidrio este debe ser separado por color.";
	        break;
	    case 6:
	        cadena= "El 90% del precio que pagas por el agua embotellada es el costo de la botella.";
	        break;
	    case 7:
	        cadena= "En Europa apenas se recicla el 2.5% de la botellas de pl�stico que utilizan.";
	        break;
	    case 8:
	        cadena= "Embotellar el agua es el m�todo energ�ticamente menos eficiente.";
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
	}}
