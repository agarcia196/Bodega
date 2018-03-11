package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clasesBodega.Empresa;
import clasesBodega.Persona;
import clasesBodega.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAddProductoCant extends JFrame {

	private JPanel contentPane;
	private JTextField Ref_textField;
	private JTextField Peso_textField;
	private Persona persona;
	private Empresa empresa;
	private JTextField Cant_textField;
	private JTextField Descrip_textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddProductoCant frame = new FormAddProductoCant();
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
	public FormAddProductoCant(Persona persona, Empresa empresa) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDeProducto = new JLabel("Datos de producto");
		lblDatosDeProducto.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblDatosDeProducto.setBounds(108, 13, 239, 55);
		contentPane.add(lblDatosDeProducto);
		
		JLabel lblBodega = new JLabel("Bodega:");
		lblBodega.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblBodega.setBounds(12, 83, 63, 19);
		contentPane.add(lblBodega);
		
		JLabel lblReferencia = new JLabel("Referencia:");
		lblReferencia.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblReferencia.setBounds(12, 140, 88, 16);
		contentPane.add(lblReferencia);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPeso.setBounds(12, 190, 56, 16);
		contentPane.add(lblPeso);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCategora.setBounds(12, 240, 88, 22);
		contentPane.add(lblCategora);
		
		JLabel lblCatidad = new JLabel("Cantidad:");
		lblCatidad.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblCatidad.setBounds(12, 290, 73, 16);
		contentPane.add(lblCatidad);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblDescripcin.setBounds(12, 340, 88, 16);
		contentPane.add(lblDescripcin);
		
		JComboBox Bodega_comboBox = new JComboBox();
		Bodega_comboBox.setBounds(108, 82, 264, 22);
		contentPane.add(Bodega_comboBox);
		DefaultComboBoxModel modelo=new DefaultComboBoxModel(empresa.getBodegas());
		Bodega_comboBox.setModel(modelo);
		
		Ref_textField = new JTextField();
		Ref_textField.setBounds(108, 138, 264, 22);
		contentPane.add(Ref_textField);
		Ref_textField.setColumns(10);
		
		Peso_textField = new JTextField();
		Peso_textField.setBounds(108, 188, 264, 22);
		contentPane.add(Peso_textField);
		Peso_textField.setColumns(10);
		
		JComboBox Cat_comboBox = new JComboBox();
		Cat_comboBox.setBounds(108, 241, 264, 22);
		contentPane.add(Cat_comboBox);
		DefaultComboBoxModel modeloCat=new DefaultComboBoxModel(empresa.getCategoria());
		Cat_comboBox.setModel(modelo);
		
		Cant_textField = new JTextField();
		Cant_textField.setBounds(108, 288, 264, 22);
		contentPane.add(Cant_textField);
		Cant_textField.setColumns(10);
		
		Descrip_textField = new JTextField();
		Descrip_textField.setBounds(108, 338, 311, 106);
		contentPane.add(Descrip_textField);
		Descrip_textField.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alerta=JOptionPane.showConfirmDialog(contentPane, "¿Desea guardar?");
				if (alerta==0) {
					if(Bodega_comboBox.getSelectedItem()==null || Cat_comboBox.getSelectedItem()==null ||
							Ref_textField.getText().compareTo("")==0 || Peso_textField.getText().compareTo("")==0 ||
							Cant_textField.getText().compareTo("")==0 || Descrip_textField.getText().compareTo("")==0)
						JOptionPane.showMessageDialog(contentPane, "Por favor llene todos los campos para continuar");
				}else {
					empresa.AddProducto(Integer.parseInt(Cant_textField.getText()), Ref_textField.getText(),
							Descrip_textField.getText(), Cat_comboBox.getSelectedItem().toString(),0,
							Double.parseDouble(Peso_textField.getText()));
					dispose();
				}
				Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
			}
		});
		btnAadir.setBounds(175, 483, 97, 25);
		contentPane.add(btnAadir);
	}
}
