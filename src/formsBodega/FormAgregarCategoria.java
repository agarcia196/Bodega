/**
 * formsBodega: Empresa.
 * 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */

package formsBodega;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import clasesBodega.Empresa;
import clasesBodega.Persona;
import clasesBodega.Recursos;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAgregarCategoria extends JFrame {

	private Empresa empresa;
	private JPanel contentPane;
	private JTextField nombre_textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa empresa=new Empresa();
					FormAgregarCategoria frame = new FormAgregarCategoria(empresa);
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
	public FormAgregarCategoria(Persona persona, Empresa empresa) {
		setResizable(false);
		setTitle("Agregar categoria");
		this.empresa= empresa;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#343A41"));
		
		nombre_textField = new JTextField();
		nombre_textField.setBounds(46, 66, 270, 35);
		contentPane.add(nombre_textField);
		nombre_textField.setColumns(10);nombre_textField.setBackground(Color.decode("#9FA5A5"));
		nombre_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nombre_textField.getText().compareTo("")==0) {
					JOptionPane.showMessageDialog(contentPane, "Debe ingresar un nombre para continuar");
				}else {
					empresa.AddCategoria(nombre_textField.getText());
					FormAddProducto formProduct = new FormAddProducto(persona, empresa);
					formProduct.setVisible(true);
					dispose();
				}
				Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);//sobreescribir el archivo de la empresa
			}
		});
		btnAceptar.setBounds(134, 131, 97, 35);
		contentPane.add(btnAceptar);
		btnAceptar.setBackground(Color.decode("#27AFA3"));
		
		JLabel lblPorFavorIngrese = new JLabel("Por favor ingrese el nombre de la categor\u00EDa");
		lblPorFavorIngrese.setForeground(Color.LIGHT_GRAY);
		lblPorFavorIngrese.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPorFavorIngrese.setBounds(35, 13, 307, 28);
		contentPane.add(lblPorFavorIngrese);
	}
}
