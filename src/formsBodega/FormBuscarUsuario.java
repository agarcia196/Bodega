package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Bodeguero;
import clasesBodega.Empresa;
import clasesBodega.Empresa.EArregloNoInicializado;
import clasesBodega.Persona;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class FormBuscarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Persona persona;
	private Empresa empresa;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Empresa juan = new Empresa("juan", "dank.jpg");
		
		Persona dank = new Bodeguero("parce", "rito", "hombreson", "yo@email", "cccccccc", "bodeguerin", "juan");
		juan.AddUser(dank);	
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					FormBuscarUsuario frame = new FormBuscarUsuario(juan, dank);
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
	public FormBuscarUsuario(Empresa empresa, Persona persona) {
		setFont(new Font("Century Gothic", Font.PLAIN, 12));
		this.empresa = empresa;
		this.persona = persona;
		setTitle("Buscador De Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage("png\\searching-magnifying-glass.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 45, 256, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Persona auxp = null;
				try {
					auxp = empresa.BuscarUser(textField.getText());
				} catch (EArregloNoInicializado e1) {
					// TOD
					e1.printStackTrace();
				}
				
				if(auxp==null) {
			
					JOptionPane.showMessageDialog(null, "Usuario No Encontrado");
				}else {
					JOptionPane.showMessageDialog(null, "Usuario Encontrado");
	
					textField_1.setText(auxp.getNombre());
					textField_2.setText(auxp.getApellido());
					textField_3.setText(auxp.getGenero());
					textField_4.setText(auxp.getCorreo());
					textField_5.setText(auxp.getCc());
					textField_6.setText(auxp.getTipoID());
					}
				}
			
		});
		btnBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnBuscar.setIcon(null);
		btnBuscar.setBounds(292, 44, 97, 25);
		contentPane.add(btnBuscar);

		
		
		JLabel lblIngreseCedulaDe = new JLabel("Ingrese cedula de un usuario para buscarlo");
		lblIngreseCedulaDe.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblIngreseCedulaDe.setBounds(12, 16, 288, 16);
		contentPane.add(lblIngreseCedulaDe);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(90, 87, 155, 16);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNombre.setBounds(12, 87, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblApellido.setBounds(12, 116, 56, 16);
		contentPane.add(lblApellido);
		
		JLabel lblNewLabel = new JLabel("Genero\r\n");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setBounds(12, 145, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCorreo.setBounds(12, 174, 56, 16);
		contentPane.add(lblCorreo);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCedula.setBounds(12, 203, 56, 16);
		contentPane.add(lblCedula);
		
		JLabel lblTipoId = new JLabel("Tipo ID");
		lblTipoId.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblTipoId.setBounds(12, 232, 56, 16);
		contentPane.add(lblTipoId);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(90, 116, 155, 16);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(90, 145, 155, 16);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(90, 174, 155, 16);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(90, 203, 155, 16);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(90, 232, 155, 16);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		

	}
}

class EDank extends Exception{
	public EDank() {
		super("La empresa no tiene usuarios");
	}
}
