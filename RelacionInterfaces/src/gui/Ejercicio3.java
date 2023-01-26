package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	
	private String usuario;
	private String password;
	private Ejercicio3 ventana;
	
	private int numIntentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 frame = new Ejercicio3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio3() {
		this.numIntentos=3;
		this.usuario="David";
		this.password="1234";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, "cell 1 1,alignx trailing");
		
		txtUsuario = new JTextField();
		contentPane.add(txtUsuario, "cell 2 1,growx");
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 1 3,alignx trailing");
		
		txtPassword = new JTextField();
		contentPane.add(txtPassword, "cell 2 3,growx");
		txtPassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
//				JOptionPane.showMessageDialog(ventana, 
//						"Error. Debe rellenar los dos campos", "Error", 
//						JOptionPane.ERROR_MESSAGE);
			}
		});
		contentPane.add(btnNewButton, "cell 2 6,alignx right");
		ventana=this;
	}

	protected void login() {
		
		
		String user= txtUsuario.getText();
		String pass= txtPassword.getText();
		
		if (user==null || user.isBlank() ||
			pass==null || pass.isBlank()) {
			JOptionPane.showMessageDialog(ventana, 
					"Error. Debe rellenar los dos campos", "Error", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (user.equals(this.usuario) && pass.equals(this.password)) {
			JOptionPane.showMessageDialog(ventana, 
					"Login correcto. Bienvenido", "Inicio de sesión correcto", 
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			numIntentos--;
			JOptionPane.showMessageDialog(ventana, 
					"Usuario/contraseña incorrecta\nTe quedan "
					+numIntentos+" intentos", 
					"Inicio de sesión incorrecto", 
					JOptionPane.ERROR_MESSAGE);
			
			if (numIntentos<=0) {
				System.exit(0);
			}
		}
	}

}
