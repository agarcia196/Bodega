package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Bodeguero;
import clasesBodega.Empresa;
import clasesBodega.Persona;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class FormAddUser extends JFrame {

	private JPanel contentPane;
	private Empresa empresa;
	private Persona persona;
	private JTextField textFieldApellido;
	private JTextField textFieldGenero;
	private JTextField textFieldCorreo;
	private JTextField textFieldCedula;
	private JTextField textFieldTipoID;
	private JTextField textFieldNombre;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddUser frame = new FormAddUser();
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
	public FormAddUser(Empresa empresa, Persona persona) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("png\\add-plus-button.png"));
		this.empresa = empresa;
		this.persona = persona;
		setTitle("Eliminar Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Agregar\r\n\r\n");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (passwordField.getText() == passwordField_1.getText()) {
				Persona people = new Bodeguero(textFieldNombre.getText(), textFieldApellido.getText(), 
						textFieldGenero.getText(), textFieldCorreo.getText(), textFieldCedula.getText(), 
						textFieldTipoID.getText(), passwordField.getText());
				empresa.AddUser(people);
				JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
				}
				else 
					JOptionPane.showMessageDialog(null, "Validacion de contraseña fallida: Estas no coinciden");
			}
		});
		btnNewButton.setBounds(291, 20, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblIngreseLaCedula = new JLabel("Ingrese la cedula del usuario a eliminar");
		lblIngreseLaCedula.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblIngreseLaCedula.setBounds(12, 24, 267, 16);
		contentPane.add(lblIngreseLaCedula);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(369, 56, 116, 22);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setBounds(105, 91, 116, 22);
		contentPane.add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(369, 91, 116, 22);
		contentPane.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(105, 126, 116, 22);
		contentPane.add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label.setBounds(12, 57, 56, 16);
		contentPane.add(label);
		
		textFieldTipoID = new JTextField();
		textFieldTipoID.setBounds(369, 126, 116, 22);
		contentPane.add(textFieldTipoID);
		textFieldTipoID.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(105, 56, 116, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNombre.setBounds(12, 59, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblApellido.setBounds(291, 59, 56, 16);
		contentPane.add(lblApellido);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCedula.setBounds(12, 129, 56, 16);
		contentPane.add(lblCedula);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblGenero.setBounds(12, 94, 56, 16);
		contentPane.add(lblGenero);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCorreo.setBounds(291, 94, 56, 16);
		contentPane.add(lblCorreo);
		
		JLabel lblTipoId = new JLabel("Tipo ID");
		lblTipoId.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblTipoId.setBounds(291, 132, 56, 16);
		contentPane.add(lblTipoId);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblContrasea.setBounds(12, 163, 81, 16);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 161, 116, 19);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(175, 193, 116, 19);
		contentPane.add(passwordField_1);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContrasea.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblConfirmarContrasea.setBounds(12, 193, 151, 16);
		contentPane.add(lblConfirmarContrasea);
		
		//TODO al darle eliminar, se sale un confirmdialog que tenfa todos los datos del parcero que va a borrar
	}
}
