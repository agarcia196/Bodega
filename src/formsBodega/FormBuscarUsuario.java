package formsBodega;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Excepciones.EUsuarios;
import clasesBodega.Empresa;
import clasesBodega.Persona;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class FormBuscarUsuario extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 533744064017327166L;
	private JPanel contentPane;
	private Persona persona;
	private Empresa empresa;
	private JTextField Buscar_textField;
	private JTable table;
	private JButton btnEditar;
	private JLabel lblSeleccioneUnUsuario;

	public Empresa getEmpresa() {
		return empresa;
	}

	public Persona getPersona() {
		return persona;
	}

	
	/**
	 * Create the frame.
	 */
	public FormBuscarUsuario(Empresa empresa, Persona persona) {
		setResizable(false);
		this.empresa = empresa;
		this.persona = persona;
		setTitle("Buscador De Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage("png\\searching-magnifying-glass.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#57616D"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 115, 850, 450);
		contentPane.add(scrollPane);
		String [] titulos = {"Nombre","Apellido","Tipo ID", "ID", "Cargo", "Genero", "Correo"};
		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
				JLabel lblIngreseNombreApellido = new JLabel("Ingrese nombre, apellido, ID o cargo para buscar usuario:");
				lblIngreseNombreApellido.setForeground(Color.WHITE);
				lblIngreseNombreApellido.setFont(new Font("Century Gothic", Font.ITALIC, 14));
				lblIngreseNombreApellido.setBounds(30, 13, 416, 32);
				contentPane.add(lblIngreseNombreApellido);
		
		lblSeleccioneUnUsuario = new JLabel("Seleccione un usuario para editar");
		lblSeleccioneUnUsuario.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblSeleccioneUnUsuario.setForeground(Color.WHITE);
		lblSeleccioneUnUsuario.setBounds(22, 663, 316, 25);
		contentPane.add(lblSeleccioneUnUsuario);

		Buscar_textField = new JTextField();
		Buscar_textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Buscar_textField.setBounds(30, 58, 416, 35);
		contentPane.add(Buscar_textField);
		Buscar_textField.setColumns(10);
		Buscar_textField.setBackground(Color.decode("#9FA5A5"));
		Buscar_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numFilas = modelo.getRowCount();
				for (int i=numFilas-1; i>=0; i--) {
					modelo.removeRow(i);
				}
     			String[][] matriz;
     			try {
     				matriz = empresa.BuscarUsuario(Buscar_textField.getText());
     				String[] model = new String[matriz[0].length];
     				int i=0;
     				while(i<matriz.length) {
     					int j=0;
     					while(j<matriz[i].length) {																	
     						model[j] = matriz[i][j];
     						j++;								    
     					}
     					modelo.addRow(model);
     					i++;
     				}
     			} catch (EUsuarios e) {
     				JOptionPane.showMessageDialog(contentPane, e.getMessage());
     			}

			}
		});
		btnBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnBuscar.setBounds(474, 58, 97, 35);
		contentPane.add(btnBuscar);
		btnBuscar.setBackground(Color.decode("#27AFA3"));
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()==-1) {		//comprobar si se selecciono una fila
					JOptionPane.showMessageDialog(contentPane, "Seleccione un usuario para continuar");
				}else{		//abrir el form de editar usuario
					FormEditarUser formEditar= new FormEditarUser(persona, empresa);
					dispose();
					formEditar.setVisible(true);	
				}
			}
		});
		btnEditar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnEditar.setBounds(350, 600, 100, 35);
		contentPane.add(btnEditar);
		btnEditar.setBackground(Color.decode("#27AFA3"));
	}
}
