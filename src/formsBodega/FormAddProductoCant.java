package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Bodega;
import clasesBodega.Empresa;
import clasesBodega.Persona;
import clasesBodega.Producto;
import clasesBodega.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FormAddProductoCant extends JFrame {

	private JPanel contentPane;
	private Persona persona;
	private Empresa empresa;
	private JTextField Cant_textField;
	private JTextField Prod_textField;
	private JTextField Bodega_textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public FormAddProductoCant(Persona persona, Empresa empresa) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Estructuras\\Bodega\\png\\forward-arrow.png"));
		setTitle("Ingresar producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(108, 13, 239, 55);
		contentPane.add(lblDatosDeProducto);
		
		JLabel lblBodega = new JLabel("Bodega:");
		lblBodega.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblBodega.setBounds(12, 83, 63, 19);
		contentPane.add(lblBodega);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblProducto.setBounds(12, 140, 88, 16);
		contentPane.add(lblProducto);
		
		JLabel lblCatidad = new JLabel("Cantidad:");
		lblCatidad.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCatidad.setBounds(12, 190, 73, 16);
		contentPane.add(lblCatidad);
		
		Cant_textField = new JTextField();
		Cant_textField.setBounds(108, 188, 264, 22);
		contentPane.add(Cant_textField);
		Cant_textField.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");//acción clic en el boton acepat
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alerta=JOptionPane.showConfirmDialog(contentPane, "¿Desea guardar?");
				if (alerta==0) {
					if(Bodega_textField.getText().compareTo("")==0 || Prod_textField.getText().compareTo("")==0 ||
							Cant_textField.getText().compareTo("")==0) //revisar si hay campos vacíos
						JOptionPane.showMessageDialog(contentPane, "Por favor llene todos los campos para continuar");
				}else {
					Bodega bod = empresa.BuscarBodega(Bodega_textField.getText()); //buscar bodega para ingresar el producto
					Producto prod=empresa.BuscarProducto(Prod_textField.getText()); //buscar el producto a ingresar
					bod.addProducto(prod,Integer.parseInt(Cant_textField.getText()));//añadir el producto a la bodega
					dispose();
				}
				Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);//sobreescribir el archivo de datos de la empresa
			}
		});
		btnAadir.setBounds(183, 236, 97, 25);
		contentPane.add(btnAadir);
		
		Prod_textField = new JTextField();
		Prod_textField.setBounds(108, 138, 264, 22);
		contentPane.add(Prod_textField);
		Prod_textField.setColumns(10);
		
		Bodega_textField = new JTextField();
		Bodega_textField.setBounds(108, 82, 264, 22);
		contentPane.add(Bodega_textField);
		Bodega_textField.setColumns(10);
	}
}
