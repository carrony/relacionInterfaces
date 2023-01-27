package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio6 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup grupoColores = new ButtonGroup();
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 frame = new Ejercicio6();
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
	public Ejercicio6() {
		setTitle("Habilitar/Deshabilitar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Selecciona un color");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel, "cell 1 1 2 1");
		
		JRadioButton rdbAzul = new JRadioButton("Azul");
		rdbAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiaColor(Color.BLUE);
			}
		});
		rdbAzul.setSelected(true);
		grupoColores.add(rdbAzul);
		contentPane.add(rdbAzul, "cell 1 2");
		
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		contentPane.add(panel, "cell 2 2 1 4,grow");
		
		JRadioButton rdbRojo = new JRadioButton("Rojo");
		rdbRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiaColor(Color.RED);
			}
		});
		grupoColores.add(rdbRojo);
		contentPane.add(rdbRojo, "cell 1 3");
		
		JRadioButton rdbVerde = new JRadioButton("Verde");
		rdbVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiaColor(Color.GREEN);
			}
		});
		grupoColores.add(rdbVerde);
		contentPane.add(rdbVerde, "cell 1 4");
		
		JRadioButton rdbMagenta = new JRadioButton("Magenta");
		rdbMagenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiaColor(Color.MAGENTA);
			}
		});
		grupoColores.add(rdbMagenta);
		contentPane.add(rdbMagenta, "cell 1 5");
	}

	protected void cambiaColor(Color color) {
		panel.setBackground(color);
	}

}
