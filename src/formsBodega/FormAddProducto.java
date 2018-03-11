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


public class FormAddProducto extends JFrame {

	private JPanel contentPane;
	private JTextField Ref_textField;
	private JTextField Peso_textField;
	private JTextField Descrip_textField;
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
	}*/

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
		
		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(107, 13, 239, 44);
		contentPane.add(lblDatosDeProducto);
		
		JLabel lblNewLabel = new JLabel("Referencia:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNewLabel.setBounds(12, 126, 83, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPeso.setBounds(12, 185, 56, 16);
		contentPane.add(lblPeso);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCategora.setBounds(12, 247, 83, 20);
		contentPane.add(lblCategora);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblDescripcin.setBounds(12, 334, 120, 16);
		contentPane.add(lblDescripcin);
		
		Ref_textField = new JTextField();
		Ref_textField.setBounds(107, 124, 288, 22);
		contentPane.add(Ref_textField);
		Ref_textField.setColumns(10);
		
		Peso_textField = new JTextField();
		Peso_textField.setBounds(107, 183, 288, 22);
		contentPane.add(Peso_textField);
		Peso_textField.setColumns(10);
		
		Descrip_textField = new JTextField();
		Descrip_textField.setBounds(107, 332, 336, 103);
		contentPane.add(Descrip_textField);
		Descrip_textField.setColumns(10);
		
		JComboBox Cat_comboBox = new JComboBox();
		Cat_comboBox.setBounds(107, 247, 288, 22);
		contentPane.add(Cat_comboBox);
		/*String [] b= {"jorge"};
		empresa.setCategoria(b);
		for(String a:empresa.getCategoria()) {
			Cat_comboBox.addItem(a);
		}*/
		DefaultComboBoxModel modelo = new DefaultComboBoxModel(empresa.getCategoria());
		Cat_comboBox.setModel(modelo);
		
		JLabel lblIngreseTodosLos = new JLabel("Por favor ingrese todos los datos del producto");
		lblIngreseTodosLos.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblIngreseTodosLos.setBounds(70, 70, 327, 30);
		contentPane.add(lblIngreseTodosLos);
		
		JButton btnAadir = new JButton("A\u00F1adir");
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
					else {
						empresa.AddProducto(0,Ref_textField.getText(),Descrip_textField.getText(),
								Cat_comboBox.getSelectedItem().toString(),0,Double.parseDouble(Peso_textField.getText()));
						dispose();
					}
					Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
				}
			}
		});
		btnAadir.setBounds(196, 462, 83, 25);
		contentPane.add(btnAadir);
	}
}
