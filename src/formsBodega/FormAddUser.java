/**
 * clasesBodega: Recursos.
 *
 * @author Alexis García Ramirez 
 * @author Jeisson Harbey Barrera Sánchez
 * @version 16.3.2018
 * 
 */
package formsBodega;


import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Excepciones.ECamposVacios;
import Excepciones.EIgualdad;
import Excepciones.ELongitud;
import Excepciones.ETipoInconrrecto;
import clasesBodega.Empresa;
import clasesBodega.Persona;
import clasesBodega.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.io.Serializable;

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
	/**
	 * Create the frame.
	 */
	public FormAddUser(Empresa empresa,Persona persona) {
		setTitle("Crear Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icono-2png-130x130.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				
		JComboBox <String> cbGenero = new JComboBox<>();
		cbGenero.setForeground(Color.WHITE);
		cbGenero.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbGenero.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino", "Otro"}));
		cbGenero.setBounds(95, 102, 195, n);
		cbGenero.setBackground(Color.decode(color2));
		cbGenero.setBorder(new LineBorder(Color.decode(color2)));
		contentPane.add(cbGenero);
		
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
		
		JComboBox <String> cbTipo = new JComboBox<>();
		cbTipo.setForeground(Color.WHITE);
		cbTipo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Cédula", "Pasaporte","Nit"}));
		cbTipo.setBounds(95, 155, 195, n);
		cbTipo.setBackground(Color.decode(color2));
		cbTipo.setBorder(new LineBorder(Color.decode(color2)));
		contentPane.add(cbTipo);
		
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
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCargo.setBounds(15, 213, 90, 25);
		contentPane.add(lblCargo);
		
		JLabel lblmnimoCaracteres = new JLabel("*M\u00EDnimo 8 Caracteres");
		lblmnimoCaracteres.setFont(new Font("Century Gothic", Font.ITALIC, 10));
		lblmnimoCaracteres.setBounds(20, 367, 171, 14);
		contentPane.add(lblmnimoCaracteres);
		
		JComboBox<String> cbCargo = new JComboBox<String>();
		cbCargo.setModel(new DefaultComboBoxModel<String>(new String[] {"Gerente", "Bodeguero"}));
		cbCargo.setForeground(Color.WHITE);
		cbCargo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbCargo.setBorder(new LineBorder(Color.decode(color2)));
		cbCargo.setBackground(new Color(52, 58, 65));
		cbCargo.setBounds(95, 216, 195, 35);
		
		
		
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
					try {
						persona.AddUser(txtNombreU.getText(),txtApellidoU.getText(),cbGenero.getSelectedItem().toString(),
								txtCorreoU.getText(),txtCcU.getText(),cbTipo.getSelectedItem().toString(),
								String.valueOf(passwordField.getPassword()),String.valueOf(cpasswordField.getPassword()),
								cbCargo.getSelectedItem().toString(),empresa);
						Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
						dispose();
						JOptionPane.showMessageDialog(contentPane, "El Usuario fue creado exitosamente");
					} catch (ECamposVacios | ELongitud | EIgualdad | ETipoInconrrecto e) {
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
				}
			}
		});
		
		contentPane.add(cbCargo);
		btnAceptar.setBounds(244, 373, 90, 35);
		contentPane.add(btnAceptar);
	}
}
