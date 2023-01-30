package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ejercicio11 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup grupoMonedas1 = new ButtonGroup();
	private JLabel lblResultado;
	private final ButtonGroup grupoMonedas2 = new ButtonGroup();
	
	private double matrizCotizaciones [][]= {
			{1, 0.8989, 115.66, 0,000027},
			{1.1131, 1, 128.75, 0,000030},
			{0.08645, 0.00777, 1, 0,00000023},
			{37045.92,33189.29,434782608.70,1}
	};
	
	private String listaMonedas [] = {"D�lares", "Euros", "Yenes", "Bitcoin"};
	private JComboBox comboMoneda1;
	private JComboBox comboMoneda2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio11 frame = new Ejercicio11();
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
	public Ejercicio11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Conversi\u00F3n de monedas");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("De:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNewLabel_1, "cell 0 0,alignx trailing");
		
		comboMoneda1 = new JComboBox();
		comboMoneda1.setModel(new DefaultComboBoxModel(listaMonedas));
		panel.add(comboMoneda1, "cell 1 0 3 1,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNewLabel_2, "cell 0 1");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 1 3 1,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertir();
			}
		});
		panel.add(btnNewButton, "cell 0 3 4 1,alignx center,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("A:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNewLabel_3, "cell 0 5,alignx trailing");
		
		comboMoneda2 = new JComboBox();
		comboMoneda2.setModel(new DefaultComboBoxModel(listaMonedas));
		panel.add(comboMoneda2, "cell 1 5 3 1,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Resultado:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNewLabel_4, "cell 1 6,alignx left,aligny baseline");
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblResultado, "cell 2 6 2 1");
	}

	public void convertir() {

		double dato = Double.parseDouble(textField.getText()); 
		
		int i = comboMoneda1.getSelectedIndex();
		int j = comboMoneda2.getSelectedIndex();
		
		lblResultado.setText(String.format("%.5f", dato*matrizCotizaciones[i][j] ));
	}
}
