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
import clasesBodega.Persona;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormBuscarProdEnBod extends JFrame {

	private JPanel contentPane;
	private JTextField Busc_textField;
	private JTable table;
	private Empresa empresa;
	private Persona persona;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBuscarProdEnBod frame = new FormBuscarProdEnBod();
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
	public FormBuscarProdEnBod(Persona persona, Empresa empresa) {
		this.persona=persona;
		this.empresa=empresa;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 729);
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
		scrollPane.setBounds(12, 134, 848, 535);
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
				String busqueda= Busc_textField.getText();
				if(empresa.getBodegas()==null) {
					JOptionPane.showMessageDialog(contentPane, "No existen bodegas");
				}else {
					int i=0;
					while (i<empresa.getBodegas().length) {
						if(empresa.getBodegas()[i].getIdBodega().compareTo(busqueda)==0||
								empresa.getBodegas()[i].getCiudad().compareTo(busqueda)==0) {
							int j=0;
							while(j<empresa.getBodegas()[i].getLista_producto().length) {
								String[]model= {Integer.toString(empresa.getBodegas()[i].getLista_producto()[j].getSku()),
										empresa.getBodegas()[i].getLista_producto()[j].getReferencia(),
										empresa.getBodegas()[i].getLista_producto()[j].getMarca(),
										Double.toString(empresa.getBodegas()[i].getLista_producto()[j].getVolumen()),
										Double.toString(empresa.getBodegas()[i].getLista_producto()[j].getPeso()),
										empresa.getBodegas()[i].getLista_producto()[j].getCategoria(),
										empresa.getBodegas()[i].getLista_producto()[j].getCategoria()};
								modelo.addRow(model);
							}
						}i++;
					}
					if(i<empresa.getBodegas().length) {
						JOptionPane.showMessageDialog(contentPane, "No se puede encontrar, intente nuevamenrte");
					}
				}
			}
		});
		btnBuscar.setBounds(462, 68, 97, 35);
		contentPane.add(btnBuscar);
		btnBuscar.setBackground(Color.decode("#27AFA3"));
	}
}
