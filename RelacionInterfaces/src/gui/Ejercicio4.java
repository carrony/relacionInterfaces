package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio4 extends JFrame {

	private JPanel contentPane;
	private JButton btnIzquierda;
	private JButton btnCentral;
	private JButton btnDerecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 frame = new Ejercicio4();
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
	public Ejercicio4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnIzquierda = new JButton("Deshabilita Central");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCentral.setEnabled(false);
				btnIzquierda.setEnabled(false);
				btnDerecha.setEnabled(true);
			}
		});
		contentPane.add(btnIzquierda);
		
		btnCentral = new JButton("Central");
		contentPane.add(btnCentral);
		
		btnDerecha = new JButton("Habilita Central");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCentral.setEnabled(true);
				btnIzquierda.setEnabled(true);
				btnDerecha.setEnabled(false);
			}
		});
		btnDerecha.setEnabled(false);
		contentPane.add(btnDerecha);
	}

}
