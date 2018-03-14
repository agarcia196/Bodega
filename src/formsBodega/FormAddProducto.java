/**
 * formsBodega: Empresa.
 * 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */
package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import clasesBodega.Producto;
import clasesBodega.Recursos;
import clasesBodega.Empresa;
import clasesBodega.Main;
import clasesBodega.Persona;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.SystemColor;


public class FormAddProducto extends JFrame {

	private JPanel contentPane;
	private JTextField Ref_textField;
	private JTextField Peso_textField;
	private JEditorPane Descrip_textField;
	private Empresa empresa;
	private Persona persona;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	public FormAddProducto(Persona persona,Empresa empresa) {
		this.empresa= empresa;
		this.persona = persona;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Estructuras\\Bodega\\png\\vender-producto.png"));
		setTitle("A\u00F1adir producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#343A41"));
		
		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setForeground(SystemColor.menu);
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(107, 13, 239, 44);
		contentPane.add(lblDatosDeProducto);
		
		JLabel lblNewLabel = new JLabel("Referencia:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNewLabel.setBounds(12, 126, 83, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setForeground(Color.LIGHT_GRAY);
		lblPeso.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPeso.setBounds(12, 185, 56, 16);
		contentPane.add(lblPeso);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setForeground(Color.LIGHT_GRAY);
		lblCategora.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCategora.setBounds(12, 247, 83, 20);
		contentPane.add(lblCategora);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setForeground(Color.LIGHT_GRAY);
		lblDescripcin.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblDescripcin.setBounds(12, 334, 120, 16);
		contentPane.add(lblDescripcin);
		
		JLabel lblIngreseTodosLos = new JLabel("Por favor ingrese todos los datos del producto");
		lblIngreseTodosLos.setForeground(Color.LIGHT_GRAY);
		lblIngreseTodosLos.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblIngreseTodosLos.setBounds(70, 70, 327, 30);
		contentPane.add(lblIngreseTodosLos);
		
		Ref_textField = new JTextField();
		Ref_textField.setBounds(121, 118, 291, 35);
		contentPane.add(Ref_textField);
		Ref_textField.setColumns(10);
		Ref_textField.setBackground(Color.decode("#9FA5A5"));
		Ref_textField.setBorder(new LineBorder(Color.decode("#EDEDED"),2 , true));
		
		Peso_textField = new JTextField();
		Peso_textField.setBounds(121, 145, 291, 35);
		contentPane.add(Peso_textField);
		Peso_textField.setColumns(10);
		Peso_textField.setBackground(Color.decode("#9FA5A5"));
		
		Descrip_textField = new JEditorPane();
		Descrip_textField.setBounds(107, 332, 336, 103);
		contentPane.add(Descrip_textField);
		Descrip_textField.setBackground(Color.decode("#9FA5A5"));
		
		
		JComboBox Cat_comboBox = new JComboBox();
		Cat_comboBox.setBounds(107, 247, 239, 22);
		contentPane.add(Cat_comboBox);
		Cat_comboBox.setBackground(Color.decode("#57616D"));
		DefaultComboBoxModel modelo = new DefaultComboBoxModel(empresa.getCategoria());//crear modelo para el comnbobox de categoria
		Cat_comboBox.setModel(modelo);//ingresar el modelo creado en el combobox categoria
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBackground(Color.decode("#27AFA3"));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alerta = JOptionPane.showConfirmDialog(contentPane, "¿Desea guardar?");//confirmar el guardado
				if (alerta==0) {		//acepta guardado
					if (Ref_textField.getText().compareTo("")==0
							||Peso_textField.getText().compareTo("")==0
							|| Cat_comboBox.getSelectedItem().toString().compareTo("")==0||		//comparar datos vacíos
							Descrip_textField.getText().compareTo("")==0 || Cat_comboBox.getSelectedItem()==null) {
						JOptionPane.showMessageDialog(contentPane, "Por favor llene todos los campos para continuar");
					}
					else {//agregar el producto al array de la empresa
						empresa.AddProducto(0,Ref_textField.getText(),Descrip_textField.getText(),
								Cat_comboBox.getSelectedItem().toString(),0,Double.parseDouble(Peso_textField.getText()));
						dispose();
					}
					Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);//sobreescribir el archivo de la empresa
				}
			}
		});
		btnAadir.setBounds(196, 462, 83, 25);
		contentPane.add(btnAadir);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAgregarCategoria formCat= new FormAgregarCategoria(persona, empresa);
				formCat.setVisible(true);
			}
		});
		btnAgregar.setBounds(358, 246, 97, 25);
		contentPane.add(btnAgregar);
		btnAgregar.setBackground(Color.decode("#27AFA3"));
	}
}
