package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

	private JPanel contentPane;
	protected int cont;
	protected int cont2;
	private JLabel lblContador1;
	private JLabel lblContador2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
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
	public Ejercicio2() {
		cont=0;
		cont2=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("Botón 1:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, "cell 1 1");
		
		lblContador1 = new JLabel("");
		lblContador1.setPreferredSize(new Dimension(80, 20));
		lblContador1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblContador1, "cell 2 1");
		
		JLabel lblBotn = new JLabel("Botón 2:");
		lblBotn.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblBotn, "cell 3 1");
		
		lblContador2 = new JLabel("");
		lblContador2.setPreferredSize(new Dimension(80, 20));
		lblContador2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblContador2, "cell 4 1");
		
		JButton btnNewButton = new JButton("Botón 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementarYMostrar(e.getActionCommand());
//				cont++;		
//				lblContador1.setText(cont+" veces");
			}
		});
		contentPane.add(btnNewButton, "cell 1 2 2 1");
		
		JButton btnNewButton_1 = new JButton("Botón 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementarYMostrar(e.getActionCommand());
//				cont2++;
//				lblContador2.setText(cont2+" veces");
			}
		});
		contentPane.add(btnNewButton_1, "cell 3 2 2 1");
	}

	protected void incrementarYMostrar(String actionCommand) {
		if (actionCommand.equals("Botón 1")) {
			cont++;
			lblContador1.setText(cont+" veces");
		} else {
			cont2++;
			lblContador2.setText(cont2+" veces");
		}
		
	}

}
