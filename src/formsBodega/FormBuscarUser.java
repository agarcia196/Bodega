package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Empresa;
import clasesBodega.Persona;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBuscarUser extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTextField txtIngreseCedulaPara;
	private Persona persona;
	private Empresa empresa;
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTxtIngreseCedulaPara() {
		return txtIngreseCedulaPara;
	}

	public void setTxtIngreseCedulaPara(JTextField txtIngreseCedulaPara) {
		this.txtIngreseCedulaPara = txtIngreseCedulaPara;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBuscarUser frame = new FormBuscarUser();
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
	public FormBuscarUser() {
		this.empresa = empresa;
		this.persona = persona;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Documents\\GitHub\\Bodega\\png\\searching-magnifying-glass.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIngreseCedulaPara = new JTextField();
		txtIngreseCedulaPara.setBounds(91, 135, 277, 23);
		txtIngreseCedulaPara.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		txtIngreseCedulaPara.setText("Ingrese cedula para buscar usuario");
		contentPane.add(txtIngreseCedulaPara);
		txtIngreseCedulaPara.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona auxp = empresa.BuscarUser(txtIngreseCedulaPara.getText());
				if(auxp==null) {
					JOptionPane.showMessageDialog(null, "Usuario No Encontrado");
				}else {
					JOptionPane.showMessageDialog(null, "Usuario Encontrado");
					
		
					}
				}
		});
		
		btnBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnBuscar.setBounds(163, 188, 97, 25);
		contentPane.add(btnBuscar);
	}
}
