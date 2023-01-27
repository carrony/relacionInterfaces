package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio8 extends JFrame {

	private JPanel contentPane;
	private JTextField txtPelicula;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio8 frame = new Ejercicio8();
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
	public Ejercicio8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Introduce una película:");
		contentPane.add(lblNewLabel, "cell 1 1");
		
		JLabel lblNewLabel_1 = new JLabel("Películas");
		contentPane.add(lblNewLabel_1, "cell 3 1");
		
		txtPelicula = new JTextField();
		contentPane.add(txtPelicula, "cell 1 2,growx");
		txtPelicula.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Avatar", "Quantum of solace"}));
		contentPane.add(comboBox, "cell 3 2,growx");
		
		JButton btnNueva = new JButton("Añadir");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaPelicula();
			}
		});
		contentPane.add(btnNueva, "cell 1 4");
	}

	protected void nuevaPelicula() {
		String pelicula = txtPelicula.getText();
		
		if (pelicula==null || pelicula.isBlank()) {
			JOptionPane.showMessageDialog(this,
				"DEbe introducir una película", 
				"Introduzca datos", 
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		comboBox.addItem(pelicula);
	
		
		
		
	}

}
