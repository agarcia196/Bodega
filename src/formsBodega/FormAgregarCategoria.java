package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Empresa;
import clasesBodega.Persona;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAgregarCategoria extends JFrame {

	private Empresa empresa;
	private JPanel contentPane;
	private JTextField nombre_textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa empresa=new Empresa();
					FormAgregarCategoria frame = new FormAgregarCategoria(empresa);
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
	public FormAgregarCategoria(Persona persona, Empresa empresa) {
		this.empresa= empresa;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombre_textField = new JTextField();
		nombre_textField.setBounds(46, 54, 253, 22);
		contentPane.add(nombre_textField);
		nombre_textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nombre_textField.getText().compareTo("")==0) {
					JOptionPane.showMessageDialog(contentPane, "Debe ingresar un nombre para continuar");
				}else {
					empresa.AddCategoria(nombre_textField.getText());
					dispose();
				}
			}
		});
		btnAceptar.setBounds(133, 114, 97, 25);
		contentPane.add(btnAceptar);
		
		JLabel lblPorFavorIngrese = new JLabel("Por favor ingrese el nombre de la categor\u00EDa");
		lblPorFavorIngrese.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPorFavorIngrese.setBounds(24, 13, 314, 28);
		contentPane.add(lblPorFavorIngrese);
	}
}
