package formsBodega;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import clasesBodega.Empresa;
import clasesBodega.Gerente;
import clasesBodega.Persona;
import clasesBodega.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

/**
 * The Class FormPrincipalLogin.
 */
public class FormPrincipalLogin extends JFrame implements Serializable, ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3676390529192396294L;
	
	/** The content pane. */
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNombreU;
	private JTextField txtApellidoU;
	private JTextField txtCorreoU;
	private JTextField txtCcU;
	private JPasswordField passwordField;
	private JPasswordField cpasswordField;
	private JTextField textlogo;
	private JLabel lblImagen;
	private String RutaImagen="icono-2png-130x130.png";
	private int n=35;
	private String color1="#27AFA3";
	private String color2="#343A41";
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
	public FormPrincipalLogin() {
		
		setTitle("Registro del sistema");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icono-2png-130x130.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema de bodegas");
		lblBienvenidoAlSistema.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblBienvenidoAlSistema.setBounds(10, 11, 665, 35);
		contentPane.add(lblBienvenidoAlSistema);
		
		JLabel lblPorfavorIngreseLa = new JLabel("Por favor ingrese la siguiente informaci\u00F3n para comenzar.");
		lblPorfavorIngreseLa.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPorfavorIngreseLa.setBounds(20, 46, 398, 20);
		contentPane.add(lblPorfavorIngreseLa);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la empresa");
		lblDatosDeLa.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblDatosDeLa.setBounds(20, 76, 398, 25);
		contentPane.add(lblDatosDeLa);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre.setBounds(20, 118, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblLogo.setBounds(20, 162, 65, 18);
		contentPane.add(lblLogo);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtNombre.setBounds(95, 110, 323, n);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBorder(new LineBorder(Color.decode(color1), 3, true));
		
		
		JLabel lblInformacionDelUser = new JLabel("Datos de super usuario");
		lblInformacionDelUser.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInformacionDelUser.setBounds(20, 202, 655, 25);
		contentPane.add(lblInformacionDelUser);
		
		JLabel lblNombreU = new JLabel("Nombre :");
		lblNombreU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombreU.setBounds(20, 246, 80, 14);
		contentPane.add(lblNombreU);
		
		txtNombreU = new JTextField();
		txtNombreU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtNombreU.setBounds(95, 238, 195, n);
		contentPane.add(txtNombreU);
		txtNombreU.setColumns(10);
		txtNombreU.setBackground(Color.WHITE);
		txtNombreU.setBorder(new LineBorder(Color.decode(color1), 3, true));
				
		JLabel lblApellidoU = new JLabel("Apellidos :");
		lblApellidoU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblApellidoU.setBounds(300, 246, 80, 14);
		contentPane.add(lblApellidoU);
		
		txtApellidoU = new JTextField();
		txtApellidoU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtApellidoU.setBounds(380, 238, 195, n);
		txtApellidoU.setBackground(Color.WHITE);
		txtApellidoU.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(txtApellidoU);
		txtApellidoU.setColumns(10);
		
		JLabel lblGeneroU = new JLabel("Genero :");
		lblGeneroU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblGeneroU.setBounds(20, 290, 80, 14);
		contentPane.add(lblGeneroU);
				
		JComboBox <String> comboBox = new JComboBox<>();
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino", "Otro"}));
		comboBox.setBounds(95, 284, 195, n);
		comboBox.setBackground(Color.decode(color2));
		comboBox.setBorder(new LineBorder(Color.decode(color2)));
		contentPane.add(comboBox);
		
		JLabel lblCorreoU = new JLabel("E-mail :");
		lblCorreoU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCorreoU.setBounds(300, 290, 80, 14);
		
		contentPane.add(lblCorreoU);
		
		txtCorreoU = new JTextField();
		txtCorreoU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtCorreoU.setBounds(380, 284, 195, n);
		txtCorreoU.setBackground(Color.WHITE);
		txtCorreoU.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(txtCorreoU);
		txtApellidoU.setColumns(10);
		
		JLabel lblTipoIDU = new JLabel("Tipo ID :");
		lblTipoIDU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblTipoIDU.setBounds(20, 350, 80, 18);
		contentPane.add(lblTipoIDU);
		
		JComboBox <String> cbTipoIDU = new JComboBox<>();
		cbTipoIDU.setForeground(Color.WHITE);
		cbTipoIDU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbTipoIDU.setModel(new DefaultComboBoxModel<String>(new String[] {"Cédula", "Pasaporte","Nit"}));
		cbTipoIDU.setBounds(95, 342, 195, n);
		cbTipoIDU.setBackground(Color.decode(color2));
		cbTipoIDU.setBorder(new LineBorder(Color.decode(color2)));
		contentPane.add(cbTipoIDU);
		
		JLabel lblCcU = new JLabel("Número :");
		lblCcU.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCcU.setBounds(300, 352, 80, 14);
		contentPane.add(lblCcU);
		
		txtCcU = new JTextField();
		txtCcU.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtCcU.setBounds(380, 344, 195, n);
		txtCcU.setBackground(Color.WHITE);
		txtCcU.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(txtCcU);
		txtApellidoU.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblContraseña.setBounds(15, 397, 560, 25);
		contentPane.add(lblContraseña);
		
		JLabel lblPwd = new JLabel("Ingrese una constraseña:");
		lblPwd.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblPwd.setBounds(31, 430, 200, 14);
		contentPane.add(lblPwd);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		passwordField.setBounds(20, 455, 230, n);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(passwordField);
		
		JLabel lblCPwd = new JLabel("Confirme la constraseña:");
		lblCPwd.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCPwd.setBounds(300, 430, 200, 14);
		contentPane.add(lblCPwd);
		
		cpasswordField = new JPasswordField();
		cpasswordField.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		cpasswordField.setBounds(284, 455, 230, n);
		cpasswordField.setBackground(Color.WHITE);
		cpasswordField.setBorder(new LineBorder(Color.decode(color1), 3, true));
		contentPane.add(cpasswordField);
		
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
				
					if (txtNombre.getText().compareTo("")==0 || txtNombreU.getText().compareTo("")==0 ||
						txtApellidoU.getText().compareTo("")==0 || txtCcU.getText().compareTo("")==0 || 
						txtCorreoU.getText().compareTo("")==0 ||
						String.valueOf(passwordField.getPassword()).compareTo("") == 0 ||
						String.valueOf(cpasswordField.getPassword()).compareTo("") == 0) {
						JOptionPane.showMessageDialog(contentPane, "Todos los campos deben rellenarse");
					}else if(String.valueOf(passwordField.getPassword()).length()<8) {
						JOptionPane.showMessageDialog(contentPane, "La contraseña debe tener minimo 8 carateres");
					}else if(String.valueOf(cpasswordField.getPassword()).compareTo(String.valueOf(passwordField.getPassword()))!=0) {
						JOptionPane.showMessageDialog(contentPane, "Las contraseñas no coinciden");
					}
					else {
						Empresa empresa = new Empresa(txtNombre.getText(),textlogo.getText());
						Persona p = new Gerente(txtNombreU.getText(), txtApellidoU.getText(), comboBox.getSelectedItem().toString(), txtCorreoU.getText(), txtCcU.getText(), cbTipoIDU.getSelectedItem().toString(), String.valueOf(passwordField.getPassword()));
						empresa.AddUser(p);
						try {
							Files.copy(FileSystems.getDefault().getPath(RutaImagen),
								       FileSystems.getDefault().getPath("Imagenes\\"+txtNombre.getText()+".jpg"),
								       StandardCopyOption.REPLACE_EXISTING);
							Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
							dispose();
							System.out.println(comboBox.getToolTipText());
							FormLogin login = new FormLogin(empresa);
							login.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(contentPane, e.getMessage());
						}
					}
				}
			}
		});
		
		textlogo = new JTextField();
		textlogo.setEditable(false);
		textlogo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textlogo.setColumns(10);
		textlogo.setBounds(95, 156, 205, 35);
		textlogo.setBackground(Color.WHITE);
		textlogo.setBorder(new LineBorder(Color.decode(color1), 3, true));
		
		contentPane.add(textlogo);
		btnAceptar.setBounds(223, 514, 90, 35);
		contentPane.add(btnAceptar);
		
		lblImagen = new JLabel("Logo");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblImagen.setIcon(new ImageIcon(RutaImagen));		
		lblImagen.setBounds(428, 76, 130, 130);
		contentPane.add(lblImagen);

		JButton btnNewButton = new JButton("Seleccionar...");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(this);
	   	btnNewButton.setBounds(310, 156, 108, n);
	   	btnNewButton.setBackground(Color.decode(color2));
	   	btnNewButton.setBorder(new LineBorder(Color.decode(color2)));
		contentPane.add(btnNewButton);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");    
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showOpenDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
            	textlogo.setText("...");
            } else {
            	textlogo.setText(fileName.getAbsolutePath());
            	RutaImagen=textlogo.getText();
            	lblImagen.setIcon(new ImageIcon(RutaImagen));
        		contentPane.add(lblImagen);
            }
        } 
	}
}
