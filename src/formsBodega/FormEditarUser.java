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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class FormEditarUser extends JFrame {

	private JPanel contentPane;
	private JTextField Correo_textField;
	private JPasswordField Nueva_passwordField;
	private JPasswordField Rep_passwordField_1;
	private JPasswordField Antigua_passwordField_2;
	private String color="#9FA5A5";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEditarUser frame = new FormEditarUser();
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
	public FormEditarUser(Persona persona, Empresa empresa) {
		setResizable(false);
		setTitle("Cambiar datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#57616D"));
		
		JLabel lblNuevoCorreo = new JLabel("Nuevo Correo:");
		lblNuevoCorreo.setForeground(Color.WHITE);
		lblNuevoCorreo.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNuevoCorreo.setBounds(22, 30, 113, 24);
		contentPane.add(lblNuevoCorreo);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasea.setForeground(Color.WHITE);
		lblNuevaContrasea.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblNuevaContrasea.setBounds(22, 90, 137, 24);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblRepitaContrasea = new JLabel("Repita contrase\u00F1a:");
		lblRepitaContrasea.setForeground(Color.WHITE);
		lblRepitaContrasea.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblRepitaContrasea.setBounds(22, 150, 149, 24);
		contentPane.add(lblRepitaContrasea);
		
		JLabel lblContraseaAntigua = new JLabel("Contrase\u00F1a antigua:");
		lblContraseaAntigua.setForeground(Color.WHITE);
		lblContraseaAntigua.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblContraseaAntigua.setBounds(22, 210, 149, 24);
		contentPane.add(lblContraseaAntigua);
		
		Correo_textField = new JTextField();
		Correo_textField.setBounds(205, 30, 268, 35);
		contentPane.add(Correo_textField);
		Correo_textField.setColumns(10);
		Correo_textField.setBackground(Color.decode(color));
		Correo_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Nueva_passwordField = new JPasswordField();
		Nueva_passwordField.setBounds(205, 90, 268, 35);
		contentPane.add(Nueva_passwordField);
		Nueva_passwordField.setBackground(Color.decode(color));
		Nueva_passwordField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Rep_passwordField_1 = new JPasswordField();
		Rep_passwordField_1.setBounds(205, 150, 268, 35);
		contentPane.add(Rep_passwordField_1);
		Rep_passwordField_1.setBackground(Color.decode(color));
		Rep_passwordField_1.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		Antigua_passwordField_2 = new JPasswordField();
		Antigua_passwordField_2.setBounds(205, 210, 268, 35);
		contentPane.add(Antigua_passwordField_2);
		Antigua_passwordField_2.setBackground(Color.decode(color));
		Antigua_passwordField_2.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valor = JOptionPane.showConfirmDialog(contentPane, "�Est� seguro de cambiar la contrase�a?");
				if (valor == 0) {		//aceptar cambio
					if (persona.getPwd().compareTo(String.valueOf(Antigua_passwordField_2.getPassword())) == 0) {//contrase�a antigua coincide
						if (String.valueOf(Nueva_passwordField.getPassword())							//comprobar que los campos esten llenos
								.compareTo(String.valueOf(Rep_passwordField_1.getPassword())) == 0 && 	//comprobar que las contrase�as nuevas
								String.valueOf(Nueva_passwordField.getPassword()).compareTo("")!=0  && 	//coincidan
								String.valueOf(Rep_passwordField_1.getPassword()).compareTo("")!=0 &&
								Correo_textField.getText().compareTo("")!=0) {
							persona.setPwd(String.valueOf(Nueva_passwordField.getPassword()));		//cambiar contrase�a en la persona
							persona.setCorreo(Correo_textField.getText());							//cambiar correo en la persona
							dispose();
						}else {
							JOptionPane.showMessageDialog(contentPane, "No se puede verificar nueva contrase�a, por favor ingrese de nuevo");
						}
					}else {
						JOptionPane.showMessageDialog(contentPane, "Clave de usuario incorrecta");
					}
				}
			}
		});
		btnAceptar.setBounds(207, 275, 97, 35);
		contentPane.add(btnAceptar);
		btnAceptar.setBackground(Color.decode("#27AFA3"));
	}
}