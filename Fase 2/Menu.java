import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private JTextField txtNombre;
	private JPasswordField passwordField;
	private JTextField txtNombre2;
	private JTextField txtContrasea;
	private JButton btnIngresar;
	private JButton btnRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		JPanel Registro = new JPanel();
		Registro.setBorder(null);
		Registro.setBounds(180, 0, 821, 377);
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
		
		JLabel lblContraseña2 = new JLabel("Contrase\u00F1a");
		lblContraseña2.setBounds(80, 182, 75, 14);
		Registro.add(lblContraseña2);
		lblContraseña2.setVisible(false);
		
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
		
		
		JPanel Menu = new JPanel();
		Menu.setBorder(null);
		Menu.setBounds(180, 0, 821, 377);
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
				lblContraseña2.setVisible(false);
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
			lblContraseña2.setVisible(true);
			txtNombre2.setVisible(true);
			txtContrasea.setVisible(true);
			btnRegresar.setVisible(true);
			btnRegistrarse2.setVisible(true);
			}
		});
		
		
		
		
	}
}
