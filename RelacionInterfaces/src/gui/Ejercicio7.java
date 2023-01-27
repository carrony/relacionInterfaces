package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ejercicio7 extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio7 frame = new Ejercicio7();
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
	public Ejercicio7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Ciudad:");
		contentPane.add(lblNewLabel, "cell 1 1,alignx trailing");
	
		comboBox = new JComboBox<String>();

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarResultado();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Adamuz", "Montilla", "Montalban",
						"Lucena", "Puente Genil"}));
		contentPane.add(comboBox, "cell 2 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Has seleccionado: ");
		contentPane.add(lblNewLabel_1, "cell 1 3");
		
		lblResultado = new JLabel("");
		contentPane.add(lblResultado, "cell 2 3");
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarResultado();
			}
		});
		contentPane.add(btnNewButton, "cell 2 5");
	}

	protected void mostrarResultado() {
		String ciudad = (String) comboBox.getSelectedItem();
		
		lblResultado.setText(ciudad);
		
	}

}
