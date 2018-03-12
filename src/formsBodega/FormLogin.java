package formsBodega;
//@Autor:Jeisson Harvey Barrera Sanchez

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
import java.awt.Toolkit;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(empresa.getLogo()));
		this.empresa=empresa;
		setTitle("Ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(32, 12, 227, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblUsuario.setBounds(21, 162, 79, 22);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(118, 161, 158, 29);
		textField.setBorder(new LineBorder(new Color(39, 175, 163), 3, true));
		contentPane.add(textField);
		textField.setColumns(10);	
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblContrasea.setBounds(21, 218, 85, 26);
		contentPane.add(lblContrasea);		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 219, 158, 29);
		passwordField.setBorder(new LineBorder(new Color(39, 175, 163), 3, true));
		contentPane.add(passwordField);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(Color.WHITE);
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
		btnIngresar.setBorder(new LineBorder(new Color(52, 58, 65)));
		btnIngresar.setBackground(Color.decode("#343A41"));		
		btnIngresar.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		btnIngresar.setBounds(79, 274, 117, 35);
		contentPane.add(btnIngresar);
		
		JLabel label = new JLabel(".");
		label.setBounds(105, 62, 80, 80);
		ImageIcon iconexit =new ImageIcon("png\\user-shape.png");
		Icon iconosalir = new ImageIcon(iconexit.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(iconosalir);
		contentPane.add(label);
	}
}
