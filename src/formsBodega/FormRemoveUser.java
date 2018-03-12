package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class FormRemoveUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	public FormRemoveUser() {
		setTitle("Eliminar Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 53, 226, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Eliminar\r\n");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnNewButton.setBounds(250, 52, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblIngreseLaCedula = new JLabel("Ingrese la cedula del usuario a eliminar");
		lblIngreseLaCedula.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblIngreseLaCedula.setBounds(12, 24, 267, 16);
		contentPane.add(lblIngreseLaCedula);
		
		//TODO al darle eliminar, se sale un confirmdialog que tenfa todos los datos del parcero que va a borrar
	}
}

