/**
 * formsBodega: Empresa.
 * 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */

package formsBodega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;

public class FormBusquedaProducto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Busc_textField;
	private Empresa empresa;

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
		this.empresa=empresa;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Estructuras\\Bodega\\png\\searching-magnifying-glass.png"));
		setTitle("Seleccionar producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 80, 660, 453);
		contentPane.add(scrollPane);

		String[] titulos= {"SKU", "Referencia", "Categoría"};//crear vector de titulos 
		DefaultTableModel modeloTable = new DefaultTableModel(titulos, 0); //crear modelo con el vector de titulos para la tabla
		table = new JTable(modeloTable);		//cargar modelo en la tabla
		scrollPane.setViewportView(table);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblBuscar.setBounds(10, 47, 73, 16);
		contentPane.add(lblBuscar);

		JButton btnBuscar = new JButton("Buscar");
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
						if(Integer.toString(empresa.getProductos()[i].getSku()).contains(prod)|| //buscar por sku
								empresa.getProductos()[i].getReferencia().contains(prod)||		 //busccar por referencia
								empresa.getProductos()[i].getCategoria().contains(prod)) {		 //buscar por categoría
							String [] model= {Integer.toString(empresa.getProductos()[i].getSku()), //generar modelo para agregar filas
									empresa.getProductos()[i].getReferencia(), empresa.getProductos()[i].getCategoria()};
							modeloTable.addRow(model);			//ingresar modelo a la tabla en una nueva fila
						}
						i++;
					}
					if (i==empresa.getProductos().length) { //comprobar si logró encontrar coincidencias
						JOptionPane.showMessageDialog(contentPane, "No es posible encontrar producto, por favor verifique");
					}
				}
			}
		});

		Busc_textField = new JTextField();
		Busc_textField.setBounds(95, 45, 350, 22);
		contentPane.add(Busc_textField);
		Busc_textField.setColumns(10);
		btnBuscar.setBounds(482, 44, 97, 25);
		contentPane.add(btnBuscar);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {			//comprobar que se seleccione una fila
					JOptionPane.showMessageDialog(contentPane, "Porfavor seleccione un producto para continuar");
				}else {//si se selecciona fila pasar contenido del sku al textfile del form para agregar producto
					Prod_textField.setText((String) table.getValueAt(table.getSelectedRow(), 0));
					dispose();
				}
			}
		});
		btnAceptar.setBounds(272, 560, 97, 25);
		contentPane.add(btnAceptar);
	}
}
