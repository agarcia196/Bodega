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
import clasesBodega.Empresa;
import clasesBodega.Persona;
import clasesBodega.Recursos;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class FormEditarUser extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3576076963182560984L;
	private JPanel contentPane;
	private JPasswordField Nueva_passwordField;
	private JPasswordField Rep_passwordField_1;
	private JPasswordField Antigua_passwordField_2;
	private String color="#9FA5A5";
	

	/**
	 * Create the frame.
	 */
	public FormEditarUser(Persona persona, Empresa empresa) {
		setResizable(false);
		setTitle("Cambiar datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#57616D"));
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasea.setForeground(Color.WHITE);
		lblNuevaContrasea.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNuevaContrasea.setBounds(28, 13, 137, 24);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblRepitaContrasea = new JLabel("Repita contrase\u00F1a:");
		lblRepitaContrasea.setForeground(Color.WHITE);
		lblRepitaContrasea.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblRepitaContrasea.setBounds(28, 73, 149, 24);
		contentPane.add(lblRepitaContrasea);
		
		JLabel lblContraseaAntigua = new JLabel("Contrase\u00F1a antigua:");
		lblContraseaAntigua.setForeground(Color.WHITE);
		lblContraseaAntigua.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblContraseaAntigua.setBounds(28, 133, 149, 24);
		contentPane.add(lblContraseaAntigua);
		
		Nueva_passwordField = new JPasswordField();
		Nueva_passwordField.setBounds(211, 13, 268, 35);
		contentPane.add(Nueva_passwordField);
		Nueva_passwordField.setBackground(Color.decode(color));
		Nueva_passwordField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Rep_passwordField_1 = new JPasswordField();
		Rep_passwordField_1.setBounds(211, 73, 268, 35);
		contentPane.add(Rep_passwordField_1);
		Rep_passwordField_1.setBackground(Color.decode(color));
		Rep_passwordField_1.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Antigua_passwordField_2 = new JPasswordField();
		Antigua_passwordField_2.setBounds(211, 133, 268, 35);
		contentPane.add(Antigua_passwordField_2);
		Antigua_passwordField_2.setBackground(Color.decode(color));
		Antigua_passwordField_2.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valor = JOptionPane.showConfirmDialog(contentPane, "¿Está seguro de cambiar la contraseña?");
				if (valor == 0) {		//aceptar cambio
					if (persona.getPwd().compareTo(String.valueOf(Antigua_passwordField_2.getPassword())) == 0) {//contraseña antigua coincide
						if (String.valueOf(Nueva_passwordField.getPassword())							//comprobar que los campos esten llenos
								.compareTo(String.valueOf(Rep_passwordField_1.getPassword())) == 0 && 	//comprobar que las contraseñas nuevas
								String.valueOf(Nueva_passwordField.getPassword()).compareTo("")!=0  && 	//coincidan
								String.valueOf(Rep_passwordField_1.getPassword()).compareTo("")!=0) {
							persona.setPwd(String.valueOf(Nueva_passwordField.getPassword()));		//cambiar contraseña en la persona
							Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);//sobreescribir el archivo de la empresa
							dispose();
						}else {
							JOptionPane.showMessageDialog(contentPane, "No se puede verificar nueva contraseña, por favor ingrese de nuevo");
						}
					}else {
						JOptionPane.showMessageDialog(contentPane, "Clave de usuario incorrecta");
					}
				}
			}
		});
		btnAceptar.setBounds(213, 198, 97, 35);
		contentPane.add(btnAceptar);
		btnAceptar.setBackground(Color.decode("#27AFA3"));
	}
}
