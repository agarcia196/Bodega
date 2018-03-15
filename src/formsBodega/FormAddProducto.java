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
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.SystemColor;


public class FormAddProducto extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -115008695315998652L;
	private JPanel contentPane;
	private JTextField Ref_textField;
	private JTextField Peso_textField;
	private JEditorPane Descrip_textField;
	private Empresa empresa;
	private Persona persona;
	private JTextField Vol_textField;
	private JTextField Marca_textField;
	private String color= "#9FA5A5";

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
		setResizable(false);
		this.empresa= empresa;
		this.persona = persona;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Estructuras\\Bodega\\png\\vender-producto.png"));
		setTitle("A\u00F1adir producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 503, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#343A41"));
		
		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setForeground(SystemColor.menu);
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(121, 13, 239, 44);
		contentPane.add(lblDatosDeProducto);
		
		JLabel lblNewLabel = new JLabel("Referencia:");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNewLabel.setBounds(12, 200, 83, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setForeground(Color.LIGHT_GRAY);
		lblPeso.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPeso.setBounds(12, 260, 56, 16);
		contentPane.add(lblPeso);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setForeground(Color.LIGHT_GRAY);
		lblCategora.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCategora.setBounds(12, 138, 83, 20);
		contentPane.add(lblCategora);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setForeground(Color.LIGHT_GRAY);
		lblDescripcin.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblDescripcin.setBounds(12, 440, 120, 16);
		contentPane.add(lblDescripcin);
		
		JLabel lblIngreseTodosLos = new JLabel("Por favor ingrese todos los datos del producto");
		lblIngreseTodosLos.setForeground(Color.LIGHT_GRAY);
		lblIngreseTodosLos.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblIngreseTodosLos.setBounds(76, 70, 327, 30);
		contentPane.add(lblIngreseTodosLos);
		
		if (empresa.getCategoria()==null) { //comprobar si existen categorias en la empresa
			JOptionPane.showMessageDialog(contentPane, "No existen categorías, por favor ingrese una");
			FormAgregarCategoria addCat = new FormAgregarCategoria(persona, empresa);	//enviar a la ventana de crear categoria
			dispose();
			addCat.setVisible(true);
		}
		
		JLabel lblVolumen = new JLabel("Volumen:");
		lblVolumen.setForeground(Color.LIGHT_GRAY);
		lblVolumen.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblVolumen.setBounds(12, 320, 72, 16);
		contentPane.add(lblVolumen);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblMarca.setForeground(Color.LIGHT_GRAY);
		lblMarca.setBounds(12, 380, 56, 16);
		contentPane.add(lblMarca);
		JComboBox Cat_comboBox = new JComboBox();
		Cat_comboBox.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		Cat_comboBox.setBounds(121, 134, 239, 30);
		contentPane.add(Cat_comboBox);
		Cat_comboBox.setBackground(Color.decode("#57616D"));
		DefaultComboBoxModel modelo = new DefaultComboBoxModel(empresa.getCategoria());//crear modelo para el comnbobox de categoria
		Cat_comboBox.setModel(modelo);//ingresar el modelo creado en el combobox categoria
		
		Ref_textField = new JTextField();
		Ref_textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Ref_textField.setBounds(121, 190, 336, 35);
		contentPane.add(Ref_textField);
		Ref_textField.setColumns(10);
		Ref_textField.setBackground(Color.decode(color));
		Ref_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Peso_textField = new JTextField();
		Peso_textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Peso_textField.setBounds(121, 250, 336, 35);
		contentPane.add(Peso_textField);
		Peso_textField.setColumns(10);
		Peso_textField.setBackground(Color.decode(color));
		Peso_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Vol_textField = new JTextField();
		Vol_textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Vol_textField.setBounds(121, 310, 336, 35);
		contentPane.add(Vol_textField);
		Vol_textField.setColumns(10);
		Vol_textField.setBackground(Color.decode(color));
		Vol_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Marca_textField = new JTextField();
		Marca_textField.setBounds(121, 380, 336, 35);
		contentPane.add(Marca_textField);
		Marca_textField.setColumns(10);
		Marca_textField.setBackground(Color.decode(color));
		Marca_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Descrip_textField = new JEditorPane();
		Descrip_textField.setBounds(121, 440, 336, 100);
		contentPane.add(Descrip_textField);
		Descrip_textField.setBackground(Color.decode(color));
		Descrip_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAadir.setBackground(Color.decode("#27AFA3"));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alerta = JOptionPane.showConfirmDialog(contentPane, "¿Desea guardar?");//confirmar el guardado
				if (alerta==0) {		//acepta guardado
					if (Ref_textField.getText().compareTo("")==0
							||Peso_textField.getText().compareTo("")==0
							|| Cat_comboBox.getSelectedItem().toString().compareTo("")==0||		//comparar datos vacíos
							Descrip_textField.getText().compareTo("")==0 || Cat_comboBox.getSelectedItem()==null
							|| Marca_textField.getText().compareTo("")==0) {
						JOptionPane.showMessageDialog(contentPane, "Por favor llene todos los campos para continuar");
					}else if(Recursos.isNumeric(Peso_textField.getText())==false || //comprobar que se ingresen números donde corresponde
							Recursos.isNumeric(Vol_textField.getText())==false) {
						JOptionPane.showMessageDialog(contentPane, "Ingrese solo números en peso y volumen");
					}
					else {//agregar el producto al array de la empresa
						empresa.AddProducto(0,Ref_textField.getText(),Descrip_textField.getText(),
								Cat_comboBox.getSelectedItem().toString(),Marca_textField.getText(),
								Double.parseDouble(Vol_textField.getText()),
								Double.parseDouble(Peso_textField.getText()));
						Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);//sobreescribir el archivo de la empresa
						dispose();
					}	
				}
			}
		});
		btnAadir.setBounds(199, 559, 83, 35);
		contentPane.add(btnAadir);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FormAgregarCategoria formCat= new FormAgregarCategoria(persona, empresa);
				formCat.setVisible(true);
			}
		});
		btnAgregar.setBounds(372, 132, 97, 35);
		contentPane.add(btnAgregar);
		btnAgregar.setBackground(Color.decode("#27AFA3"));
	}
}
