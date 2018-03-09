package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Empresa;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
/**
 * The Class FormLogin.
 */
public class FormLogin extends JFrame implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7508005990190033109L;
	
	/** The content pane. */
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Empresa Empresa;

	public Empresa getEmpresa() {
		return Empresa;
	}
	public JTextField getTextField() {
		return textField;
	}
	
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	public FormLogin(Empresa empresa) {
		this.Empresa=Empresa;
		setTitle("Ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBounds(118, 161, 158, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblUsuario.setBounds(10, 162, 79, 22);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(32, 12, 227, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblContrasea.setBounds(10, 219, 98, 26);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 219, 158, 29);
		contentPane.add(passwordField);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		btnIngresar.setBounds(79, 274, 117, 40);
		contentPane.add(btnIngresar);
	}
}
