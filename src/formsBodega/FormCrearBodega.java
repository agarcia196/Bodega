package formsBodega;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import clasesBodega.Empresa;
import clasesBodega.Persona;
import clasesBodega.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class FormCrearBodega extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2296770556119676835L;
	private JPanel contentPane;
	private JTextField ID_textField;
	private JTextField Ciudad_textField;
	private JTextField Direcc_textField;
	private JTextField CapMax_textField;
	private String color="#343A41";
	private String color2="#9FA5A5";
	private String color3="#27AFA3";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCrearBodega frame = new FormCrearBodega();
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
	public FormCrearBodega(Persona persona, Empresa empresa) {
		setTitle("Crear una nueva bodega");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode(color));

		JLabel lblDatosDeLa = new JLabel("Datos de la bodega");
		lblDatosDeLa.setForeground(Color.LIGHT_GRAY);
		lblDatosDeLa.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeLa.setBounds(103, 13, 258, 39);
		contentPane.add(lblDatosDeLa);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(Color.LIGHT_GRAY);
		lblDireccin.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblDireccin.setBounds(12, 190, 80, 16);
		contentPane.add(lblDireccin);

		JLabel lblIdBodega = new JLabel("ID bodega:");
		lblIdBodega.setForeground(Color.LIGHT_GRAY);
		lblIdBodega.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblIdBodega.setBounds(12, 70, 80, 23);
		contentPane.add(lblIdBodega);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setForeground(Color.LIGHT_GRAY);
		lblCiudad.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCiudad.setBounds(12, 130, 56, 16);
		contentPane.add(lblCiudad);

		JLabel lblCapacidadMxima = new JLabel("Capacidad m\u00E1xima:");
		lblCapacidadMxima.setForeground(Color.LIGHT_GRAY);
		lblCapacidadMxima.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCapacidadMxima.setBounds(12, 250, 149, 16);
		contentPane.add(lblCapacidadMxima);

		ID_textField = new JTextField();
		ID_textField.setBounds(173, 70, 258, 35);
		contentPane.add(ID_textField);
		ID_textField.setColumns(10);
		ID_textField.setBackground(Color.decode(color2));
		ID_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		Ciudad_textField = new JTextField();
		Ciudad_textField.setBounds(173, 130, 258, 35);
		contentPane.add(Ciudad_textField);
		Ciudad_textField.setColumns(10);
		Ciudad_textField.setBackground(Color.decode(color2));
		Ciudad_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		Direcc_textField = new JTextField();
		Direcc_textField.setBounds(173, 190, 258, 35);
		contentPane.add(Direcc_textField);
		Direcc_textField.setColumns(10);
		Direcc_textField.setBackground(Color.decode(color2));
		Direcc_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		CapMax_textField = new JTextField();
		CapMax_textField.setBounds(173, 250, 258, 35);
		contentPane.add(CapMax_textField);
		CapMax_textField.setColumns(10);
		CapMax_textField.setBackground(Color.decode(color2));
		CapMax_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		JButton btnAceptar = new JButton("Agregar");
		btnAceptar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alerta = JOptionPane.showConfirmDialog(contentPane, "¿Desea guardar?");//confirmar el guardado
				if (alerta==0) {
					if (ID_textField.getText().compareTo("")==0 
							|| Ciudad_textField.getText().compareTo("")==0 || Direcc_textField.getText().compareTo("")==0 
							|| CapMax_textField.getText().compareTo("")==0) {
						JOptionPane.showMessageDialog(contentPane, "Por favor llene todos los campos para continuar");
					}else {
						empresa.AddBodega(ID_textField.getText(), Direcc_textField.getText(),
								Ciudad_textField.getText(),
								Integer.parseInt(CapMax_textField.getText()));
						Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);//sobreescribir el archivo de la empresa
					}
					dispose();
				}
			}
		});
		btnAceptar.setBounds(184, 310, 97, 35);
		contentPane.add(btnAceptar);
		btnAceptar.setBackground(Color.decode(color3));
	}
}
