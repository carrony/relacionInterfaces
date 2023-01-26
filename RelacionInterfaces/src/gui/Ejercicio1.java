package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Has pulsado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);
		
		lblResultado = new JLabel("");
		lblResultado.setPreferredSize(new Dimension(100, 20));
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblResultado);
		
		JButton btnNewButton = new JButton("Botón 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escribirACcion(e.getActionCommand());
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Botón 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escribirACcion(e.getActionCommand());
			}
		});
		contentPane.add(btnNewButton_1);
	}

	protected void escribirACcion(String actionCommand) {
		lblResultado.setText(actionCommand);
	}


}
