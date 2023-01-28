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

public class Ejercicio10 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup grupoMonedas1 = new ButtonGroup();
	private JRadioButton rdbtnDolares2;
	private JRadioButton rdbtnEuros2;
	private JRadioButton rdbtnYenes2;
	private JLabel lblResultado;
	private JRadioButton rdbtnDolares1;
	private JRadioButton rdbtnEuros1;
	private JRadioButton rdbtnYenes1;
	private final ButtonGroup grupoMonedas2 = new ButtonGroup();
	

	
	private double matrizCotizaciones [][]= {
			{1, 0.92, 129.88},
			{1.09, 1, 141.22},
			{0.0077, 0.0071, 1}
	};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio10 frame = new Ejercicio10();
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
	public Ejercicio10() {
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
		panel.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("De:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNewLabel_1, "cell 0 0,alignx right");
		
		rdbtnDolares1 = new JRadioButton("D\u00F3lares");
		rdbtnDolares1.setActionCommand("0");
		rdbtnDolares1.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnDolares1.setSelected(true);
		grupoMonedas1.add(rdbtnDolares1);
		panel.add(rdbtnDolares1, "cell 1 0");
		
		rdbtnEuros1 = new JRadioButton("Euros");
		rdbtnEuros1.setActionCommand("1");
		rdbtnEuros1.setFont(new Font("Dialog", Font.PLAIN, 12));
		grupoMonedas1.add(rdbtnEuros1);
		panel.add(rdbtnEuros1, "cell 2 0");
		
		rdbtnYenes1 = new JRadioButton("Yenes");
		rdbtnYenes1.setActionCommand("2");
		rdbtnYenes1.setFont(new Font("Dialog", Font.PLAIN, 12));
		grupoMonedas1.add(rdbtnYenes1);
		panel.add(rdbtnYenes1, "cell 3 0,alignx left");
		
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
		panel.add(lblNewLabel_3, "cell 0 5,alignx right");
		
		rdbtnDolares2 = new JRadioButton("D\u00F3lares");
		rdbtnDolares2.setActionCommand("0");
		grupoMonedas2.add(rdbtnDolares2);
		rdbtnDolares2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(rdbtnDolares2, "cell 1 5");
		
		rdbtnEuros2 = new JRadioButton("Euros");
		rdbtnEuros2.setSelected(true);
		rdbtnEuros2.setActionCommand("1");
		grupoMonedas2.add(rdbtnEuros2);
		rdbtnEuros2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(rdbtnEuros2, "cell 2 5");
		
		rdbtnYenes2 = new JRadioButton("Yenes");
		rdbtnYenes2.setActionCommand("2");
		grupoMonedas2.add(rdbtnYenes2);
		rdbtnYenes2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(rdbtnYenes2, "cell 3 5");
		
		JLabel lblNewLabel_4 = new JLabel("Resultado:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNewLabel_4, "cell 1 6,alignx left,aligny baseline");
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblResultado, "cell 2 6 2 1");
	}

	public void convertir() {
		try {
			double dato = Double.parseDouble(textField.getText()); 
			
			int i = Integer.parseInt(grupoMonedas1.getSelection().getActionCommand());
			int j = Integer.parseInt(grupoMonedas2.getSelection().getActionCommand());
			
			lblResultado.setText(String.format("%.2f", dato*matrizCotizaciones[i][j] ));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe introducir un número correcto");
		}
	}
}
