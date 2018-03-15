package formsBodega;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import clasesBodega.Empresa;
import clasesBodega.Gerente;
import clasesBodega.Persona;
import clasesBodega.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FormAddUser extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7999787811931911821L;
	/** The content pane. */
	private JPanel contentPane;
	private JTextField txtNombreU;
	private JTextField txtApellidoU;
	private JTextField txtCorreoU;
	private JTextField txtCcU;
	private JPasswordField passwordField;
	private JPasswordField cpasswordField;
	private int n=35;
	private String color1="#27AFA3";
	private String color2="#343A41";
	private JTextField textField;
	/**
	 * Launch the application.
	 *
	 * @param empresa the empresa
	 */
	public static void main(String[] args) {
				FormPrincipalLogin frame = new FormPrincipalLogin();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public FormAddUser(Empresa empresa) {
		
		setTitle("Crear Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icono-2png-130x130.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		
		JLabel lblInformacionDelUser = new JLabel("Datos del usuario");
		lblInformacionDelUser.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInformacionDelUser.setBounds(20, 11, 568, 25);
		contentPane.add(lblInformacionDelUser);
		
		JLabel lblNombreU = new JLabel("Nombre :");
		lblNombreU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombreU.setBounds(15, 65, 80, 14);
		contentPane.add(lblNombreU);
		
		txtNombreU = new JTextField();
		txtNombreU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtNombreU.setBounds(95, 56, 195, n);
		contentPane.add(txtNombreU);
		txtNombreU.setColumns(10);
		txtNombreU.setBackground(Color.WHITE);
		txtNombreU.setBorder(new LineBorder(Color.decode(color1), 3, true));
				
		JLabel lblApellidoU = new JLabel("Apellidos :");
		lblApellidoU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblApellidoU.setBounds(329, 65, 80, 14);
		contentPane.add(lblApellidoU);
		
		txtApellidoU = new JTextField();
		txtApellidoU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtApellidoU.setBounds(409, 56, 195, n);
		txtApellidoU.setBackground(Color.WHITE);
		txtApellidoU.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(txtApellidoU);
		txtApellidoU.setColumns(10);
		
		JLabel lblGeneroU = new JLabel("Genero :");
		lblGeneroU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblGeneroU.setBounds(15, 113, 80, 14);
		contentPane.add(lblGeneroU);
				
		JComboBox <String> comboBox = new JComboBox<>();
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino", "Otro"}));
		comboBox.setBounds(95, 102, 195, n);
		comboBox.setBackground(Color.decode(color2));
		comboBox.setBorder(new LineBorder(Color.decode(color2)));
		contentPane.add(comboBox);
		
		JLabel lblCorreoU = new JLabel("E-mail :");
		lblCorreoU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCorreoU.setBounds(329, 113, 80, 14);
		
		contentPane.add(lblCorreoU);
		
		txtCorreoU = new JTextField();
		txtCorreoU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtCorreoU.setBounds(409, 102, 195, n);
		txtCorreoU.setBackground(Color.WHITE);
		txtCorreoU.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(txtCorreoU);
		txtApellidoU.setColumns(10);
		
		JLabel lblTipoIDU = new JLabel("Tipo ID :");
		lblTipoIDU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblTipoIDU.setBounds(15, 163, 80, 18);
		contentPane.add(lblTipoIDU);
		
		JComboBox <String> cbTipoIDU = new JComboBox<>();
		cbTipoIDU.setForeground(Color.WHITE);
		cbTipoIDU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbTipoIDU.setModel(new DefaultComboBoxModel<String>(new String[] {"Cédula", "Pasaporte","Nit"}));
		cbTipoIDU.setBounds(95, 155, 195, n);
		cbTipoIDU.setBackground(Color.decode(color2));
		cbTipoIDU.setBorder(new LineBorder(Color.decode(color2)));
		contentPane.add(cbTipoIDU);
		
		JLabel lblCcU = new JLabel("Número :");
		lblCcU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCcU.setBounds(329, 165, 80, 14);
		contentPane.add(lblCcU);
		
		txtCcU = new JTextField();
		txtCcU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtCcU.setBounds(409, 156, 195, n);
		txtCcU.setBackground(Color.WHITE);
		txtCcU.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(txtCcU);
		txtApellidoU.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblContraseña.setBounds(20, 266, 560, 25);
		contentPane.add(lblContraseña);
		
		JLabel lblPwd = new JLabel("Ingrese una constraseña:");
		lblPwd.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblPwd.setBounds(20, 302, 200, 14);
		contentPane.add(lblPwd);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		passwordField.setBounds(20, 327, 230, n);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(passwordField);
		
		JLabel lblCPwd = new JLabel("Confirme la constraseña:");
		lblCPwd.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCPwd.setBounds(314, 302, 200, 14);
		contentPane.add(lblCPwd);
		
		cpasswordField = new JPasswordField();
		cpasswordField.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		cpasswordField.setBounds(314, 327, 230, n);
		cpasswordField.setBackground(Color.WHITE);
		cpasswordField.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(cpasswordField);
		
		JLabel lblCargo = new JLabel("Cargo G \u00F3 B:");
		lblCargo.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCargo.setBounds(15, 213, 90, 25);
		contentPane.add(lblCargo);
		
		JLabel lblmnimoCaracteres = new JLabel("*M\u00EDnimo 8 Caracteres");
		lblmnimoCaracteres.setFont(new Font("Century Gothic", Font.ITALIC, 10));
		lblmnimoCaracteres.setBounds(20, 367, 171, 14);
		contentPane.add(lblmnimoCaracteres);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnAceptar.setBackground(Color.decode(color2));
		btnAceptar.setBorder(new LineBorder(Color.decode(color2)));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int validar = JOptionPane.showConfirmDialog(contentPane,
						"¿Está seguro de que la información es correcta?");
				if (validar == 0) {
				
					if (txtNombreU.getText().compareTo("")==0 ||txtApellidoU.getText().compareTo("")==0 || txtCcU.getText().compareTo("")==0 || 
						txtCorreoU.getText().compareTo("")==0 ||String.valueOf(passwordField.getPassword()).compareTo("") == 0 ||
						String.valueOf(cpasswordField.getPassword()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(contentPane, "Todos los campos deben rellenarse");
					}else if(String.valueOf(passwordField.getPassword()).length()<8) {
						JOptionPane.showMessageDialog(contentPane, "La contraseña debe tener minimo 8 carateres");
					}else if(String.valueOf(cpasswordField.getPassword()).compareTo(String.valueOf(passwordField.getPassword()))!=0) {
						JOptionPane.showMessageDialog(contentPane, "Las contraseñas no coinciden");
					}
					else {
						empresa.AddUser(txtNombreU.getText(), txtApellidoU.getText(), comboBox.getToolTipText(), txtCorreoU.getText(), 
								txtCcU.getText(), cbTipoIDU.getToolTipText(), String.valueOf(passwordField.getPassword()),btnAceptar.getText());
					}
				}
			}
		});
		btnAceptar.setBounds(244, 373, 90, 35);
		contentPane.add(btnAceptar);		
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textField.setBounds(115, 215, 195, n);
		textField.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(textField);
		textField.setColumns(10);
		
	}
}
