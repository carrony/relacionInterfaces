package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio4 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JLabel lblPromedio;
	private JLabel lblResultado;

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
		setTitle("CáLCULO DE PROMEDIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][grow][grow][][grow]", "[36.00][][][][][][][][]"));
		
		JLabel lblNewLabel_8 = new JLabel("CALCULAR PROMEDIO");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(Color.BLACK);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_8, "cell 0 0 7 1,grow");
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		contentPane.add(lblNewLabel, "cell 1 2,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 2 2 5 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nota 1:");
		contentPane.add(lblNewLabel_1, "cell 1 4,alignx trailing");
		
		txtNota1 = new JTextField();
		contentPane.add(txtNota1, "cell 2 4,growx");
		txtNota1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nota 2:");
		contentPane.add(lblNewLabel_2, "cell 3 4,alignx trailing");
		
		txtNota2 = new JTextField();
		contentPane.add(txtNota2, "cell 4 4,growx");
		txtNota2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nota 3:");
		contentPane.add(lblNewLabel_3, "cell 5 4,alignx trailing");
		
		txtNota3 = new JTextField();
		contentPane.add(txtNota3, "cell 6 4,growx,aligny baseline");
		txtNota3.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		contentPane.add(btnNewButton, "cell 5 6 2 1,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Promedio:");
		contentPane.add(lblNewLabel_4, "cell 1 7");
		
		lblPromedio = new JLabel("");
		contentPane.add(lblPromedio, "cell 2 7 5 1");
		
		JLabel lblNewLabel_6 = new JLabel("Resultado:");
		contentPane.add(lblNewLabel_6, "cell 1 8");
		
		lblResultado = new JLabel("");
		contentPane.add(lblResultado, "cell 2 8 5 1");
	}

	protected void calcular() {
		
		String nombre = txtNombre.getText();
		try {
			double nota1 = Double.parseDouble(txtNota1.getText());
			double nota2 = Double.parseDouble(txtNota2.getText());
			double nota3 = Double.parseDouble(txtNota3.getText());
			
			if (nombre==null || nombre.isBlank()) {
				JOptionPane.showMessageDialog(this, 
						"Debes introducir el nombre del alumno", 
						"Error al introdicr datos", 						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (nota1<0 || nota1 >10 || nota2<0 || nota2 >10 ||
				nota3<0 || nota3 >10) {
				JOptionPane.showMessageDialog(this, 
						"Las notas deben estar entre 1 y 10", 
						"Error al introducir datos", 						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			double media = (nota1+nota2+nota3)/3;
			lblPromedio.setText(String.format("%.2f",  media));
			if (media>=5) {
				lblResultado.setForeground(Color.BLACK);
				lblResultado.setText("Ha aprobado la asignatura");
			} else {
				lblResultado.setForeground(Color.RED);
				lblResultado.setText("Toca Recuperar");
			}
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, 
					"Debes introducir un número válido", 
					"Error al introdicr datos", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
	}

}
