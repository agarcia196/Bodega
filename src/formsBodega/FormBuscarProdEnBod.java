/**
 * formsBodega: Empresa.
 * 
 * @author Jorge Luis Soriano Cuevas
 * @author Alexis_García_Ramirez
 * @version 16.3.2018
 */

package formsBodega;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Excepciones.BodegaNoExiste;
import Excepciones.EBodegas;
import clasesBodega.Empresa;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

/**
 * The Class FormBuscarProdEnBod.
 */
public class FormBuscarProdEnBod extends JFrame implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3321516021996484216L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The Busc text field. */
	private JTextField Busc_textField;
	
	/** The table. */
	private JTable table;
	
	/**
	 * Creación de interfaz de búsqueda de productor en bodegas.
	 *
	 * @param empresa La empresa
	 */
	public FormBuscarProdEnBod(Empresa empresa) {
		setTitle("Buscar productos de bodega");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#343A41"));
		
		JLabel lblIngreseBodegaA = new JLabel("Ingrese bodega a buscar:");
		lblIngreseBodegaA.setForeground(Color.LIGHT_GRAY);
		lblIngreseBodegaA.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblIngreseBodegaA.setBounds(12, 26, 206, 30);
		contentPane.add(lblIngreseBodegaA);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 120, 850, 525);
		contentPane.add(scrollPane);
		
		String [] titulos= {"SKU", "Referencia", "Marca", "Volumen", "Peso", "Categoría", "cantidad"};
		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		Busc_textField = new JTextField();
		Busc_textField.setBounds(45, 69, 344, 35);
		contentPane.add(Busc_textField);
		Busc_textField.setColumns(10);
		Busc_textField.setBackground(Color.decode("#9FA5A5"));
		Busc_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numFilas = modelo.getRowCount();
				for (int i=numFilas-1; i>=0; i--) {
					modelo.removeRow(i);
				}
				if(Busc_textField.getText().compareTo("")==0) {
					FormBusquedaBodega buscarbo = new FormBusquedaBodega(empresa, Busc_textField);
					buscarbo.setVisible(true);
				}else {
					String[][] matriz;
					try {
						matriz = empresa.BuscarProductoEnBodega(Busc_textField.getText());
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
					} catch (EBodegas | BodegaNoExiste e) {
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
				}	
			}
		});
		btnBuscar.setBounds(462, 68, 97, 35);
		contentPane.add(btnBuscar);
		btnBuscar.setBackground(Color.decode("#27AFA3"));
	}
}
