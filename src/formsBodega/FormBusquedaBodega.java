/**
 * formsBodega: Empresa.
 * 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */

package formsBodega;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import clasesBodega.Empresa;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class FormBusquedaBodega extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1015505282670549380L;
	private JPanel contentPane;
	//	private FormAddProductoCant form;
	private JTextField Busc_textField;
	private JTable table_1;
	


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBusquedaBodega frame = new FormBusquedaBodega();
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

	public FormBusquedaBodega(Empresa empresa, JTextField bodega_textField) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Estructuras\\Bodega\\png\\searching-magnifying-glass.png"));
		setTitle("Seleccionar bodega");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#343A41"));

		JLabel lblBuscarPorId = new JLabel("Buscar:");
		lblBuscarPorId.setForeground(Color.LIGHT_GRAY);
		lblBuscarPorId.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblBuscarPorId.setBounds(10, 65, 73, 16);
		contentPane.add(lblBuscarPorId);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 660, 453);
		contentPane.add(scrollPane);
		String [] titulos = {"ID Bodega", "Ciudad", "Dirección"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulos,0); //crear modelo con el vector de titulos
		table_1 = new JTable(modeloTable);							//cargar modelo en la tabla

		scrollPane.setViewportView(table_1);

		Busc_textField = new JTextField();
		Busc_textField.setBounds(95, 56, 350, 35);
		contentPane.add(Busc_textField);
		Busc_textField.setColumns(10);
		Busc_textField.setBackground(Color.decode("#9FA5A5"));
		Busc_textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numFilas = modeloTable.getRowCount();
				for (int i=numFilas-1; i>=0; i--) {
					modeloTable.removeRow(i);
				}
				String id=Busc_textField.getText();		//capturar datos del textfile
				if (empresa.getBodegas()==null) {		//comprobar que el vector de bodegas
					JOptionPane.showMessageDialog(contentPane, "No existen Bodegas");
				}else {		//si existe el vector
					int i=0;
					while(i<empresa.getBodegas().length) {	//recorrer el vector de bodegas para hacer la busqueda
						if(empresa.getBodegas()[i].getIdBodega().contains(id) || 	//buscar por ID
								empresa.getBodegas()[i].getCiudad().contains(id)) {	//buscar por ciudad
							String [] model = {empresa.getBodegas()[i].getIdBodega(),empresa.getBodegas()[i].getCiudad(),
									empresa.getBodegas()[i].getDireccion()}; //crear modelo para agregar filas
							modeloTable.addRow(model);		//agregar modelo a las filas de la tabla
						}
						i++;
					}
					if (i<empresa.getBodegas().length) {		//comprobar si encontro la bodega
						JOptionPane.showMessageDialog(contentPane, "No se puede encontrar, intente nuevamente");
					}
				}
			}
		});
		btnBuscar.setBounds(482, 56, 97, 35);
		contentPane.add(btnBuscar);
		btnBuscar.setBackground(Color.decode("#27AFA3"));


		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table_1.getSelectedRow()==-1) {		//comprobar si se selecciono una fila
					JOptionPane.showMessageDialog(contentPane, "Seleccione una bodega para continuar");
				}else{		//pasarle la ID de la bodega al textfile del form para agregar el producto
					bodega_textField.setText((String) table_1.getValueAt(table_1.getSelectedRow(),0));
					dispose();}
			}
		});
		btnAceptar.setBounds(272, 570, 97, 35);
		contentPane.add(btnAceptar);
		btnAceptar.setBackground(Color.decode("#27AFA3"));

		JLabel lblPuedeBuscarPor = new JLabel("Puede buscar por ID de bodega o por ciudad.");
		lblPuedeBuscarPor.setForeground(Color.LIGHT_GRAY);
		lblPuedeBuscarPor.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		lblPuedeBuscarPor.setBounds(10, 13, 423, 16);
		contentPane.add(lblPuedeBuscarPor);
	}
}
