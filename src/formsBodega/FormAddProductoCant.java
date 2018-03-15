/**
 * formsBodega: Empresa.
 * 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */

package formsBodega;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Excepciones.ProductoNoEncontrado;
import clasesBodega.Bodega;
import clasesBodega.Empresa;
import clasesBodega.Empresa.BodegaNoExiste;
import clasesBodega.Persona;
import clasesBodega.Producto;
import clasesBodega.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class FormAddProductoCant extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6351524704096647185L;
	private JPanel contentPane;
	private Persona persona;
	private Empresa empresa;
	private JTextField Cant_textField;
	private JTextField Prod_textField;
	private JTextField Bodega_textField;
	private String color="#343A41";
	private String color2="#9FA5A5";
	private String color3="#27AFA3";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Persona per=new Persona();
					Empresa empresa=new Empresa();
					Bodega bodega1= new Bodega("bodega1", "1234", "df",0);
					Bodega bodega2=new Bodega("Bodega2", "123", "sdf",0);
					Bodega [] bode= {bodega1,bodega2};
					empresa.setBodegas(bode);
					FormAddProductoCant frame = new FormAddProductoCant( empresa);
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

	public FormAddProductoCant(Persona persona, Empresa empresa) {
		setResizable(false);
		this.empresa= empresa;
		this.persona = persona;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Estructuras\\Bodega\\png\\forward-arrow.png"));
		setTitle("Ingresar producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode(color));


		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setForeground(Color.LIGHT_GRAY);
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(108, 13, 239, 55);
		contentPane.add(lblDatosDeProducto);

		JLabel lblBodega = new JLabel("Bodega:");
		lblBodega.setForeground(Color.LIGHT_GRAY);
		lblBodega.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblBodega.setBounds(12, 80, 63, 19);
		contentPane.add(lblBodega);

		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setForeground(Color.LIGHT_GRAY);
		lblProducto.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblProducto.setBounds(12, 140, 88, 16);
		contentPane.add(lblProducto);

		JLabel lblCatidad = new JLabel("Cantidad:");
		lblCatidad.setForeground(Color.LIGHT_GRAY);
		lblCatidad.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCatidad.setBounds(12, 200, 73, 16);
		contentPane.add(lblCatidad);

		Bodega_textField = new JTextField();
		Bodega_textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Bodega_textField.setBounds(97, 80, 250, 35);
		contentPane.add(Bodega_textField);
		Bodega_textField.setColumns(10);
		Bodega_textField.setBackground(Color.decode(color2));
		Bodega_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		Prod_textField = new JTextField();
		Prod_textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Prod_textField.setBounds(97, 140, 250, 35);
		contentPane.add(Prod_textField);
		Prod_textField.setColumns(10);
		Prod_textField.setBackground(Color.decode(color2));
		Prod_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		Cant_textField = new JTextField();
		Cant_textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Cant_textField.setBounds(97, 200, 250, 35);
		contentPane.add(Cant_textField);
		Cant_textField.setColumns(10);
		Cant_textField.setBackground(Color.decode(color2));
		Cant_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		JButton BuscBod_btn = new JButton("Buscar");
		BuscBod_btn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		BuscBod_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormBusquedaBodega verFormbodega= new FormBusquedaBodega(empresa, Bodega_textField );
				verFormbodega.setVisible(true);
			}
		});
		BuscBod_btn.setBounds(369, 80, 88, 35);
		contentPane.add(BuscBod_btn);

		JButton BuscProd_btn = new JButton("Buscar");
		BuscProd_btn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		BuscProd_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormBusquedaProducto verFormProducto= new FormBusquedaProducto(empresa,Prod_textField);
				verFormProducto.setVisible(true);
			}
		});
		BuscProd_btn.setBounds(369, 140, 88, 35);
		contentPane.add(BuscProd_btn);
		BuscBod_btn.setBackground(Color.decode(color3));
		BuscProd_btn.setBackground(Color.decode(color3));

		JButton btnAadir = new JButton("A\u00F1adir");//acción clic en el boton aceptar
		btnAadir.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alerta=JOptionPane.showConfirmDialog(contentPane, "¿Desea guardar?");
				if (alerta==0) {
					if(Bodega_textField.getText().compareTo("")==0 || Prod_textField.getText().compareTo("")==0 ||
							Cant_textField.getText().compareTo("")==0) {//revisar si hay campos vacíos
						JOptionPane.showMessageDialog(contentPane, "Por favor llene todos los campos para continuar");
				}else {
					try {
					Bodega bod = empresa.BuscarBodega(Bodega_textField.getText()); //buscar bodega para ingresar el producto
					Producto prod=empresa.BuscarProducto(Integer.valueOf(Prod_textField.getText())); //buscar el producto a ingresar
					bod.addProducto(prod,Integer.parseInt(Cant_textField.getText()));//añadir el producto a la bodega
					System.out.println(bod.getLista_producto()[0].getMarca());
					//sobreescribir el archivo de datos de la empresa
					if (bod.getCapacidadMax()<(Double.parseDouble(Cant_textField.getText()))*prod.getVolumen()) {
						JOptionPane.showMessageDialog(contentPane, "No se puede ingresar la cantidad de productos, la capacidad de la bodega no soporta.");
					}else if(Recursos.isNumeric(Cant_textField.getText())==false) {	//comprobar que se ingresen números donde corresponda
						JOptionPane.showMessageDialog(contentPane, "Por favor ingrese solo números en cantidad");
					}
					else {
						bod.setCapacidadMax(bod.getCapacidadMax()-Double.parseDouble(Cant_textField.getText())
								*prod.getVolumen());//restar capMax de modega
					}
					
					Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
				}catch (BodegaNoExiste e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}catch (ProductoNoEncontrado e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
				}
				dispose();
				}
			}
		});
		btnAadir.setBounds(187, 264, 97, 35);
		contentPane.add(btnAadir);
		btnAadir.setBackground(Color.decode(color3));
	}

	public JTextField getBodega_textField() {
		return Bodega_textField;
	}

	public void setBodega_textField(JTextField bodega_textField) {
		Bodega_textField = bodega_textField;
	}
}
