package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Empresa;
import clasesBodega.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The Class FormPrincipalLogin.
 */
public class FormPrincipalLogin extends JFrame implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3676390529192396294L;
	
	/** The content pane. */
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField textField;
	private JTextField txtNombreU;
	private JTextField txtApellidoU;
	private JTextField txtCorreoU;
	private JTextField txtCcU;
	private JPasswordField passwordField;
	private JPasswordField cpasswordField;
	/**
	 * Launch the application.
	 *
	 * @param empresa the empresa
	 */
	/*public static void main(String[] args) {
				FormPrincipalLogin frame = new FormPrincipalLogin();
					frame.setVisible(true);
				
	}*/

	/**
	 * Create the frame.
	 */
	public FormPrincipalLogin() {
		
		setTitle("Registro del sistema");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icono-2png-130x130.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema de bodegas");
		lblBienvenidoAlSistema.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblBienvenidoAlSistema.setBounds(10, 11, 665, 35);
		contentPane.add(lblBienvenidoAlSistema);
		
		JLabel lblPorfavorIngreseLa = new JLabel("Porfavor ingrese la siguiente informaci\u00F3n para comenzar.");
		lblPorfavorIngreseLa.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPorfavorIngreseLa.setBounds(20, 46, 398, 20);
		contentPane.add(lblPorfavorIngreseLa);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la empresa");
		lblDatosDeLa.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblDatosDeLa.setBounds(20, 76, 398, 25);
		contentPane.add(lblDatosDeLa);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(20, 110, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblLogo.setBounds(20, 135, 65, 18);
		contentPane.add(lblLogo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(95, 110, 323, 18);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 135, 323, 18);
		contentPane.add(textField);
		
		JLabel lblInformacionDelUser = new JLabel("Datos de super usuario");
		lblInformacionDelUser.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInformacionDelUser.setBounds(20, 160, 655, 25);
		contentPane.add(lblInformacionDelUser);
		
		JLabel lblNombreU = new JLabel("Nombre :");
		lblNombreU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombreU.setBounds(20, 190, 80, 14);
		contentPane.add(lblNombreU);
		
		txtNombreU = new JTextField();
		txtNombreU.setBounds(95, 190, 195, 18);
		contentPane.add(txtNombreU);
		txtNombreU.setColumns(10);
		
		JLabel lblApellidoU = new JLabel("Apellidos :");
		lblApellidoU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblApellidoU.setBounds(300, 190, 80, 14);
		contentPane.add(lblApellidoU);
		
		txtApellidoU = new JTextField();
		txtApellidoU.setBounds(380, 190, 195, 18);
		contentPane.add(txtApellidoU);
		txtApellidoU.setColumns(10);
		
		JLabel lblGeneroU = new JLabel("Genero :");
		lblGeneroU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblGeneroU.setBounds(20, 215, 80, 14);
		contentPane.add(lblGeneroU);
		
		
		JComboBox <String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino", "Otro"}));
		comboBox.setBounds(95, 215, 195, 18);
		contentPane.add(comboBox);
		
		JLabel lblCorreoU = new JLabel("E-mail :");
		lblCorreoU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCorreoU.setBounds(300, 215, 80, 14);
		contentPane.add(lblCorreoU);
		
		txtCorreoU = new JTextField();
		txtCorreoU.setBounds(380, 215, 195, 18);
		contentPane.add(txtCorreoU);
		txtApellidoU.setColumns(10);
		
		JLabel lblTipoIDU = new JLabel("Tipo ID :");
		lblTipoIDU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblTipoIDU.setBounds(20, 240, 80, 18);
		contentPane.add(lblTipoIDU);
		
		JComboBox <String> cbTipoIDU = new JComboBox<>();
		cbTipoIDU.setModel(new DefaultComboBoxModel<String>(new String[] {"Cédula", "Pasaporte","Nit"}));
		cbTipoIDU.setBounds(95, 240, 195, 18);
		contentPane.add(cbTipoIDU);
		
		JLabel lblCcU = new JLabel("Número :");
		lblCcU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCcU.setBounds(300, 240, 80, 14);
		contentPane.add(lblCcU);
		
		txtCcU = new JTextField();
		txtCcU.setBounds(380, 240, 195, 18);
		contentPane.add(txtCcU);
		txtApellidoU.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblContraseña.setBounds(20, 280, 560, 25);
		contentPane.add(lblContraseña);
		
		JLabel lblPwd = new JLabel("Ingrese una constraseña:");
		lblPwd.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblPwd.setBounds(20, 310, 200, 14);
		contentPane.add(lblPwd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 330, 195, 18);
		contentPane.add(passwordField);
		
		JLabel lblCPwd = new JLabel("Confirme la constraseña:");
		lblCPwd.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCPwd.setBounds(300, 310, 200, 14);
		contentPane.add(lblCPwd);
		
		cpasswordField = new JPasswordField();
		cpasswordField.setBounds(300, 330, 195, 18);
		contentPane.add(cpasswordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int validar = JOptionPane.showConfirmDialog(contentPane,
						"¿Está seguro de que la información es correcta?");
				if (validar == 0) {
				
					if (txtNombre.getText().compareTo("")==0 || txtNombreU.getText().compareTo("")==0 ||
						txtApellidoU.getText().compareTo("")==0 || txtCcU.getText().compareTo("")==0 || 
						textField.getText().compareTo("")==0  || txtCorreoU.getText().compareTo("")==0 ||
						String.valueOf(passwordField.getPassword()).compareTo("") == 0 ||
						String.valueOf(cpasswordField.getPassword()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(contentPane, "Todos los campos deben rellenarse");
					} else {
						Empresa empresa = new Empresa(txtNombre.getText(),textField.getText());
						//empresa.setUsuarios(usuarios);
						dispose();
						Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
						FormLogin login = new FormLogin(empresa);
						login.setVisible(true);
					}
				}
			}
		});
		btnAceptar.setBounds(220, 370, 90, 20);
		contentPane.add(btnAceptar);
		
		JLabel lblImagen = new JLabel("Logo");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblImagen.setIcon(new ImageIcon("icono-2png-130x130.png"));
		lblImagen.setBounds(429, 51, 130, 130);
		contentPane.add(lblImagen);
		
		
		
	}
}
