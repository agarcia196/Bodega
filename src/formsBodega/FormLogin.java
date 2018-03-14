package formsBodega;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import clasesBodega.Empresa;
import clasesBodega.Persona;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
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
	private Empresa empresa;
	private String color="#27AFA3";

	public Empresa getEmpresa() {
		return empresa;
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
		this.empresa=empresa;
		setTitle("Ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(32, 12, 227, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblUsuario.setBounds(23, 162, 79, 22);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.decode(color), 3, true));
		textField.setBounds(118, 161, 158, 29);
		contentPane.add(textField);
		textField.setColumns(10);	
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblContrasea.setBounds(23, 218, 85, 26);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(Color.decode(color), 3, true));
		passwordField.setBounds(118, 219, 158, 29);
		contentPane.add(passwordField);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona auxp = empresa.BuscarUser(textField.getText());
				if(auxp==null) {
					JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
				}else {
				if(textField.getText().compareTo(auxp.getCc())==0) {
					if (String.valueOf(passwordField.getPassword())
							.compareTo(auxp.getPwd())==0) {
						FormPrincipal ventana = new FormPrincipal(empresa,auxp);
						dispose();
						ventana.getFrmBodegas().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
					}
				}
			}
			}
		});
		
		btnIngresar.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		btnIngresar.setBounds(79, 274, 117, 40);
		contentPane.add(btnIngresar);
		
		JLabel label = new JLabel(".");
		label.setBounds(105, 62, 80, 80);
		ImageIcon iconexit =new ImageIcon("png\\round-account-button-with-user-inside.png");
		Icon iconosalir = new ImageIcon(iconexit.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(iconosalir);
		contentPane.add(label);
	}
}
