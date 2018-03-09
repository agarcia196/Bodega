/**
 * clasesBodega: Empresa.
 * 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */
package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Producto;
import clasesBodega.Recursos;
import clasesBodega.Empresa;
import clasesBodega.Main;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormAddProducto extends JFrame {

	private JPanel contentPane;
	private JTextField Ref_textField;
	private JTextField Vol_textField;
	private JTextField Peso_textField;
	private JTextField Cat_textField;
	private JTextField Descrip_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa empresa = new Empresa();
					FormAddProducto frame = new FormAddProducto(empresa);
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
	public FormAddProducto(Empresa empresa) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Estructuras\\Bodega\\png\\vender-producto.png"));
		setTitle("A\u00F1adir producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(107, 13, 239, 44);
		contentPane.add(lblDatosDeProducto);
		
		JLabel lblNewLabel = new JLabel("Referencia:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNewLabel.setBounds(12, 126, 83, 16);
		contentPane.add(lblNewLabel);
		
		Ref_textField = new JTextField();
		Ref_textField.setBounds(107, 124, 239, 22);
		contentPane.add(Ref_textField);
		Ref_textField.setColumns(10);
		
		JLabel lblVolumen = new JLabel("Volumen:");
		lblVolumen.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblVolumen.setBounds(12, 178, 70, 16);
		contentPane.add(lblVolumen);
		
		Vol_textField = new JTextField();
		Vol_textField.setBounds(107, 176, 239, 22);
		contentPane.add(Vol_textField);
		Vol_textField.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPeso.setBounds(12, 230, 56, 16);
		contentPane.add(lblPeso);
		
		Peso_textField = new JTextField();
		Peso_textField.setBounds(107, 228, 239, 22);
		contentPane.add(Peso_textField);
		Peso_textField.setColumns(10);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCategora.setBounds(12, 282, 83, 16);
		contentPane.add(lblCategora);
		
		Cat_textField = new JTextField();
		Cat_textField.setBounds(107, 280, 239, 22);
		contentPane.add(Cat_textField);
		Cat_textField.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblDescripcin.setBounds(12, 334, 120, 16);
		contentPane.add(lblDescripcin);
		
		Descrip_textField = new JTextField();
		Descrip_textField.setBounds(107, 332, 307, 103);
		contentPane.add(Descrip_textField);
		Descrip_textField.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alerta = JOptionPane.showConfirmDialog(contentPane, "¿Desea guardar?");//confirmar el guardado
				if (alerta==0) {		//acepta guardado
					if (Ref_textField.getText().compareTo("")==0
							||Vol_textField.getText().compareTo("")==0||Peso_textField.getText().compareTo("")==0
							||Cat_textField.getText().compareTo("")==0||		//comparar datos vacíos
							Descrip_textField.getText().compareTo("")==0) {
						JOptionPane.showMessageDialog(contentPane, "Por favor llene todos los campos para continuarf");
					}
					else {
						empresa.AddProducto(0,Ref_textField.getText(),Descrip_textField.getText(),
								Cat_textField.getText(),Double.parseDouble(Peso_textField.getText()),
								Double.parseDouble(Vol_textField.getText()));
						dispose();
					}
					
					Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
				}
			}
		});
		btnAadir.setBounds(375, 175, 83, 25);
		contentPane.add(btnAadir);
		
		JLabel lblIngreseTodosLos = new JLabel("Por favor ingrese todos los datos del producto");
		lblIngreseTodosLos.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblIngreseTodosLos.setBounds(70, 70, 327, 30);
		contentPane.add(lblIngreseTodosLos);
	}
}
