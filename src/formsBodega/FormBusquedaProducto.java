/**
 * formsBodega: Empresa.
 * 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */

package formsBodega;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clasesBodega.Empresa;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class FormBusquedaProducto extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8557815956198767805L;
	private JPanel contentPane;
	private JTable table;
	private JTextField Busc_textField;
	private Empresa empresa;
	private JTextField Prod_textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromBusquedaProducto frame = new FromBusquedaProducto(empresa);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}/

	/**
	 * Create the frame.
	 */
	public FormBusquedaProducto(Empresa empresa, JTextField Prod_textField) {
		setResizable(false);
		this.Prod_textField=Prod_textField;
		this.empresa=empresa;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Estructuras\\Bodega\\png\\searching-magnifying-glass.png"));
		setTitle("Seleccionar producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#343A41"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 660, 453);
		contentPane.add(scrollPane);

		String[] titulos= {"SKU", "Referencia", "Categor�a"};//crear vector de titulos 
		DefaultTableModel modeloTable = new DefaultTableModel(titulos, 0); //crear modelo con el vector de titulos para la tabla
		table = new JTable(modeloTable);		//cargar modelo en la tabla
		scrollPane.setViewportView(table);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setForeground(Color.LIGHT_GRAY);
		lblBuscar.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblBuscar.setBounds(10, 65, 73, 16);
		contentPane.add(lblBuscar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numFilas = modeloTable.getRowCount();
				for (int i=numFilas-1; i>=0; i--) {				//eliminar los datos de la tabla
					modeloTable.removeRow(i);
				}
				String prod = Busc_textField.getText();			//capturar el tecto del textfile
				if (empresa.getProductos()==null) {				//comprobar si existe el vector de productos
					JOptionPane.showMessageDialog(contentPane, "No existen productos");//alerta de no existe vector de productos
				}else {
					int i=0;
					while(i<empresa.getProductos().length) {	//recorrer el vector de productos para buscar
						if(Integer.toString(empresa.getProductos()[i].getSku()).toLowerCase().contains(prod)|| //buscar por sku
								empresa.getProductos()[i].getReferencia().toLowerCase().contains(prod)||		 //busccar por referencia
								empresa.getProductos()[i].getCategoria().toLowerCase().contains(prod)) {		 //buscar por categor�a
							String [] model= {Integer.toString(empresa.getProductos()[i].getSku()), //generar modelo para agregar filas
									empresa.getProductos()[i].getReferencia(), empresa.getProductos()[i].getCategoria()};
							modeloTable.addRow(model);			//ingresar modelo a la tabla en una nueva fila
						}
						i++;
					}
					if (i<empresa.getProductos().length) { //comprobar si logr� encontrar coincidencias
						JOptionPane.showMessageDialog(contentPane, "No es posible encontrar producto, por favor verifique");
					}
				}
			}
		});

		Busc_textField = new JTextField();
		Busc_textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Busc_textField.setBounds(95, 56, 350, 35);
		contentPane.add(Busc_textField);
		Busc_textField.setColumns(10);
		Busc_textField.setBackground(Color.decode("#9FA5A5"));
		Busc_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		btnBuscar.setBounds(482, 56, 97, 35);
		contentPane.add(btnBuscar);
		btnBuscar.setBackground(Color.decode("#27AFA3"));

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {			//comprobar que se seleccione una fila
					JOptionPane.showMessageDialog(contentPane, "Porfavor seleccione un producto para continuar");
					dispose();
				}else {//si se selecciona fila pasar contenido del sku al textfile del form para agregar producto
					Prod_textField.setText((String) table.getValueAt(table.getSelectedRow(), 0));
					dispose();
				}
			}
		});
		btnAceptar.setBounds(272, 570, 97, 35);
		contentPane.add(btnAceptar);
		btnAceptar.setBackground(Color.decode("#27AFA3"));
		
		JLabel lblIngreseCategoraO = new JLabel("Ingrese categor\u00EDa, referencia o SKU");
		lblIngreseCategoraO.setForeground(Color.LIGHT_GRAY);
		lblIngreseCategoraO.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblIngreseCategoraO.setBounds(10, 13, 263, 30);
		contentPane.add(lblIngreseCategoraO);
	}
}
