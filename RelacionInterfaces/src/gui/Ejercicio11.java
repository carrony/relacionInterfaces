package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Ejercicio11 extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnAceptar;
	private JRadioButton rdbtnNoAceptar;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][20.00][grow][][][]"));
		
		JLabel lblNewLabel = new JLabel("Aceptar las condiciones del Servicio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Acuerdo de licencia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 0 1");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 2,grow");
		
		JTextArea txtrEsUnaLicencia = new JTextArea();
		txtrEsUnaLicencia.setEditable(false);
		txtrEsUnaLicencia.setLineWrap(true);
		scrollPane.setViewportView(txtrEsUnaLicencia);
		txtrEsUnaLicencia.setText("Es una licencia de derechos de autor ampliamente usada en el mundo del software libre y c\u00F3digo abierto, lo que hace es permitir que los usuarios finales (personas, organizaciones, etc) tengan libertad de usar, estudiar, compartir (copiar) y modificar el software. Su objetivo es doble: recalcar que el software cubierto por esta licencia es libre y, por otro lado, protegerlo (mediante una pr\u00E1ctica conocida como copyleft) de intentos de apropiaci\u00F3n que restrinjan esas libertades a nuevos usuarios cada vez que la obra (software, plugin, template) es distribuida, modificada o mejorada.");
		
		rdbtnAceptar = new JRadioButton("Aceptar Condiciones del Servicio");
		buttonGroup.add(rdbtnAceptar);
		rdbtnAceptar.setSelected(true);
		contentPane.add(rdbtnAceptar, "cell 0 3");
		
		rdbtnNoAceptar = new JRadioButton("No aceptar");
		buttonGroup.add(rdbtnNoAceptar);
		contentPane.add(rdbtnNoAceptar, "cell 0 4");
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acuerdo();
			}
		});
		contentPane.add(btnNewButton, "cell 0 5,alignx center");
	}
	
	public void acuerdo() {
		if (rdbtnAceptar.isSelected()) {
			JOptionPane.showMessageDialog(null, "Pasa por caja");
		} else {
			int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro?","Pacto con el diablo", 
					JOptionPane.OK_CANCEL_OPTION);
			if (opcion==JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(null, "La próxima vez será");
			} else {
				JOptionPane.showMessageDialog(null, "Pasa por caja");
			}
		}
		System.exit(0);
	}

}
