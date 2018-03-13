package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Empresa;
import clasesBodega.Persona;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FormBuscarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Persona persona;
	private Empresa empresa;
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public Persona getPersona() {
		return persona;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBuscarUsuario frame = new FormBuscarUsuario();
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
	public FormBuscarUsuario() {
		this.empresa = empresa;
		this.persona = persona;
		setTitle("Buscador De Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage("png\\searching-magnifying-glass.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 45, 256, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(null);
		btnBuscar.setBounds(292, 44, 97, 25);
		contentPane.add(btnBuscar);
		
		JLabel lblIngreseCedulaDe = new JLabel("Ingrese cedula de un usuario para buscarlo");
		lblIngreseCedulaDe.setBounds(12, 16, 256, 16);
		contentPane.add(lblIngreseCedulaDe);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona auxp = empresa.BuscarUser(textField.getText());
				if(auxp==null) {
					JOptionPane.showMessageDialog(null, "Usuario No Encontrado");
				}else {
					JOptionPane.showMessageDialog(null, "Usuario Encontrado");
					//TODO: Agregar ventanas que muestren todos los atributos del usuario encontrado
					
		
					}
				}
		});
	}
}
