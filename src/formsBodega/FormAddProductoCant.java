package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FormAddProductoCant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddProductoCant frame = new FormAddProductoCant();
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
	public FormAddProductoCant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(158, 13, 239, 55);
		contentPane.add(lblDatosDeProducto);
		
		JLabel lblBodega = new JLabel("Bodega:");
		lblBodega.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblBodega.setBounds(12, 83, 63, 19);
		contentPane.add(lblBodega);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(98, 82, 189, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Referencia:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNewLabel.setBounds(12, 140, 88, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(108, 138, 179, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPeso.setBounds(12, 190, 56, 16);
		contentPane.add(lblPeso);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 188, 179, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
