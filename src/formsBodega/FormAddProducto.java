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

public class FormAddProducto extends JFrame {

	private JPanel contentPane;
	private JTextField SKUtextField;
	private JTextField ReferenciatextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddProducto frame = new FormAddProducto();
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
	public FormAddProducto() {
		setTitle("A\u00F1adir producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarProducto = new JLabel("SKU:");
		lblSeleccionarProducto.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblSeleccionarProducto.setBounds(12, 70, 40, 26);
		contentPane.add(lblSeleccionarProducto);
		
		SKUtextField = new JTextField();
		SKUtextField.setBounds(107, 73, 159, 22);
		contentPane.add(SKUtextField);
		SKUtextField.setColumns(10);
		
		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(150, 13, 239, 44);
		contentPane.add(lblDatosDeProducto);
		
		JLabel lblNewLabel = new JLabel("Referencia:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNewLabel.setBounds(12, 126, 83, 16);
		contentPane.add(lblNewLabel);
		
		ReferenciatextField = new JTextField();
		ReferenciatextField.setBounds(107, 124, 159, 22);
		contentPane.add(ReferenciatextField);
		ReferenciatextField.setColumns(10);
	}
}
