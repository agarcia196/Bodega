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

import Excepciones.BodegaNoExiste;
import Excepciones.ECamposVacios;
import Excepciones.ELetrasEnCampoN;
import Excepciones.ELimiteDeAlmacenamiento;
import Excepciones.ProductoNoEncontrado;
import clasesBodega.Empresa;
import clasesBodega.Persona;
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

public class FormAddProductoCant extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6351524704096647185L;
	private JPanel contentPane;
	private JTextField Cant_textField;
	private JTextField Prod_textField;
	private JTextField Bodega_textField;
	private String color="#343A41";
	private String color2="#9FA5A5";
	private String color3="#27AFA3";

	/**
	 * Create the frame.
	 */
	public FormAddProductoCant(Persona persona, Empresa empresa) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("png\\forward-arrow.png"));
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
					try {
						persona.Ingreso(Bodega_textField.getText(), Prod_textField.getText(), Cant_textField.getText(), empresa);
						Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
						dispose();
						JOptionPane.showMessageDialog(contentPane, "Producto(s) ingresado(s) correctamente a la bodega "+Bodega_textField.getText());
					} catch (NumberFormatException | ProductoNoEncontrado | BodegaNoExiste | ECamposVacios
							| ELimiteDeAlmacenamiento e) {
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}catch (ELetrasEnCampoN e) {
						JOptionPane.showMessageDialog(contentPane, e.getMessage()+" en cantidad");
					}
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
