package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio5 extends JFrame {

	private JPanel contentPane;
	private JCheckBox chkDeportes;
	private JTextArea textArea;
	private JCheckBox chkTecnologia;
	private JCheckBox chkJuegos;
	private JCheckBox chkCocina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 frame = new Ejercicio5();
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
	public Ejercicio5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow]", "[][grow][grow][grow][grow][]"));
		
		chkDeportes = new JCheckBox("Deportes");
//		chkDeportes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mostrarTexto();
//			}
//		});
		contentPane.add(chkDeportes, "cell 1 1");
		
		textArea = new JTextArea();
		contentPane.add(textArea, "cell 3 1 1 4,grow");
		
		chkTecnologia = new JCheckBox("Tecnología");
		contentPane.add(chkTecnologia, "cell 1 2");
		
		chkJuegos = new JCheckBox("Juegos");
		contentPane.add(chkJuegos, "cell 1 3");
		
		chkCocina = new JCheckBox("Cocina");
		contentPane.add(chkCocina, "cell 1 4");
		
		JButton botonAceptar = new JButton("Comprobar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarTexto();
			}
		});
		contentPane.add(botonAceptar, "cell 3 5");
	}

	protected void mostrarTexto() {
		textArea.setText("");
		if (chkDeportes.isSelected()) {
//			textArea.setText("Deportes");
			textArea.setText(textArea.getText()
				+chkDeportes.getActionCommand()+"\n");
		}
		if (chkTecnologia.isSelected()) {
			textArea.setText(textArea.getText()+
		                     "Tecnología"+"\n");
		}
		if (chkJuegos.isSelected()) {
			textArea.setText(textArea.getText()+
                    "Juegos"+"\n");
		}
		if (chkCocina.isSelected()) {
			textArea.setText(textArea.getText()+
                    "Cocina"+"\n");
		}
	}

}
