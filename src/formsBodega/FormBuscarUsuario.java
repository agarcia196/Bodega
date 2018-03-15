package formsBodega;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clasesBodega.Bodeguero;
import clasesBodega.Empresa;
import clasesBodega.Gerente;
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
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	public FormBuscarUsuario(Empresa empresa, Persona persona) {
		setResizable(false);
		this.empresa = empresa;
		this.persona = persona;
		setTitle("Buscador De Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage("png\\searching-magnifying-glass.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#57616D"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 121, 781, 524);
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
				String busqueda=Buscar_textField.getText();
				if(empresa.getUsuarios()==null) {			//no existe vector de usuarios
					JOptionPane.showMessageDialog(contentPane, "No existen usuarios");
				}else {
					int i=0;
					while(i<empresa.getUsuarios().length) {	//recorrer vector de usuarios
						if(empresa.getUsuarios()[i].getNombre().contains(busqueda) ||	//busqueda por nombre
								empresa.getUsuarios()[i].getApellido().contains(busqueda) ||	//busqueda por apellido
								empresa.getUsuarios()[i].getCc().contains(busqueda) ||	//busqueda por CC
								empresa.getUsuarios()[i] instanceof Gerente ||			//busqueda por cargo
								empresa.getUsuarios()[i] instanceof Bodeguero) {		//busqueda por cargo
							if (empresa.getUsuarios()[i] instanceof Gerente) {			//imprimir gerentes
								String [] model = {empresa.getUsuarios()[i].getNombre(),empresa.getUsuarios()[i].getApellido(),
										empresa.getUsuarios()[i].getCc(),"Gerente"};
								modelo.addRow(model);
							}else {				//imprimir bodequeros
								String [] model = {empresa.getUsuarios()[i].getNombre(),empresa.getUsuarios()[i].getApellido(),
										empresa.getUsuarios()[i].getCc(),"Bodeguero"};
								modelo.addRow(model);
							}
						}i++;
					}
					if(i<empresa.getUsuarios().length) {		//no hay coincidencias
						JOptionPane.showMessageDialog(contentPane, "No se puede encontrar, intente nuevamente");
					}
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
					JOptionPane.showMessageDialog(contentPane, "Seleccione una bodega para continuar");
				}else{		//abrir el form de editar usuario
					FormEditarUser formEditar= new FormEditarUser(persona, empresa);
					dispose();
					formEditar.setVisible(true);	
				}
			}
		});
		btnEditar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnEditar.setBounds(372, 658, 97, 35);
		contentPane.add(btnEditar);
		btnEditar.setBackground(Color.decode("#27AFA3"));
	}
}
