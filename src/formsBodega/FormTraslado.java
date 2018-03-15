package formsBodega;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasesBodega.Bodega;
import clasesBodega.Empresa;
import clasesBodega.Empresa.BodegaNoExiste;
import clasesBodega.Persona;
import clasesBodega.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.Arrays;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;

public class FormTraslado extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2987933687111238768L;
	private JPanel contentPane;
	private Empresa empresa;
	private Persona persona;
	private int n=14;
	private JTextField BodegaOrigen;
	private JTextField BodegaDestino;
	private JTextField txtproducto;
	private JTextField txtcantidad;
	private JTable table;
	private Producto [] productos;
	private Bodega bodega;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa empresa= new Empresa();
					Persona p = new Gerente("Alexis", "Garcia", "mascu", "ddd", "ddd", "CC", "1234");
					FormTraslado frame = new FormTraslado(empresa, p);
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
	public FormTraslado(Empresa empresa,Persona persona) {
		this.empresa=empresa;
		this.persona=persona;
		setIconImage(Toolkit.getDefaultToolkit().getImage("png\\traslado.png"));
		setTitle("Traslado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTraslado = new JLabel("Traslado");
		lblTraslado.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTraslado.setBounds(30, 11, 300, 30);
		contentPane.add(lblTraslado);
		
		JLabel lblBodegaDeOrigen = new JLabel("Bodega de origen :");
		lblBodegaDeOrigen.setFont(new Font("Century Gothic", Font.PLAIN, n));
		lblBodegaDeOrigen.setBounds(30, 52, 140, 25);
		contentPane.add(lblBodegaDeOrigen);
		
		JLabel lblBodegaDeDestino = new JLabel("Bodega destino     :");
		lblBodegaDeDestino.setFont(new Font("Century Gothic", Font.PLAIN, n));
		lblBodegaDeDestino.setBounds(30, 88, 140, 25);
		contentPane.add(lblBodegaDeDestino);
		
		BodegaOrigen = new JTextField();
		BodegaOrigen.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		BodegaOrigen.setBounds(165, 56, 130, 20);
		contentPane.add(BodegaOrigen);
		BodegaOrigen.setColumns(10);
		
		
		BodegaDestino = new JTextField();
		BodegaDestino.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		BodegaDestino.setBounds(165, 92, 130, 20);
		contentPane.add(BodegaDestino);
		BodegaDestino.setColumns(10);
		
		JButton btnBuscarO = new JButton("Buscar");
		btnBuscarO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(empresa.getBodegas()==null) {
					JOptionPane.showMessageDialog(contentPane, "Por favor crear bodega");
					FormCrearBodega crear = new FormCrearBodega(persona, empresa);
					crear.setVisible(true);
				}else {
				FormBusquedaBodega verFormbodega= new FormBusquedaBodega(empresa, BodegaOrigen );
				verFormbodega.setVisible(true);
				

				}
				}
			});
		btnBuscarO.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnBuscarO.setBounds(305, 55, 89, 23);
		contentPane.add(btnBuscarO);
		
		JButton btnBuscarD = new JButton("Buscar");
		btnBuscarD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(empresa.getBodegas()==null||empresa.getBodegas().length<2) {
					JOptionPane.showMessageDialog(contentPane, "No hay bodegas o son insuficientes");
					FormCrearBodega crear = new FormCrearBodega(persona, empresa);
					crear.setVisible(true);
				}else {
				FormBusquedaBodega verFormbodega= new FormBusquedaBodega(empresa, BodegaDestino );
				verFormbodega.setVisible(true);
			}}
		});
		btnBuscarD.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnBuscarD.setBounds(305, 91, 89, 23);
		contentPane.add(btnBuscarD);
		
		JLabel lblProductos = new JLabel("Producto");
		lblProductos.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblProductos.setBounds(30, 124, 130, 14);
		contentPane.add(lblProductos);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCantidad.setBounds(327, 125, 200, 14);
		contentPane.add(lblCantidad);
		
		txtproducto = new JTextField();
		txtproducto.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtproducto.setBounds(30, 149, 180, 20);
		contentPane.add(txtproducto);
		txtproducto.setColumns(10);
		
		txtcantidad = new JTextField();
		txtcantidad.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtcantidad.setBounds(327, 149, 100, 20);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 564, 370);
		contentPane.add(scrollPane);
		String [] titulo= {"SKU", "Marca", "Referencia", "Cantidad"};	//crear vector con titulos de la tabla
		DefaultTableModel modeloTable= new DefaultTableModel(titulo,0); //crear modelo con el vector de titulos
		table = new JTable(modeloTable);							//cargar modelo en la tabla	
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					if(BodegaOrigen.getText().compareTo("")==0) {
						JOptionPane.showMessageDialog(contentPane, "Seleccione la bodega de origen");
					}else {
						bodega = empresa.BuscarBodega(BodegaOrigen.getText());
						
						if(bodega.getLista_producto()==null) {
							int validar= JOptionPane.showConfirmDialog(contentPane,
									"Debe ingresar un producto para continua, ¿Desea hacerlo?");
							if(validar == 0) {
								FormAddProductoCant ingreso = new FormAddProductoCant(persona,empresa);
									ingreso.setVisible(true);}
							}					
						else {
							FormBusquedaProductoconBodega producto = new FormBusquedaProductoconBodega(bodega, txtproducto);
							producto.setVisible(true);}
					} 
				}catch (BodegaNoExiste e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane,"Bodega no encontrada");
				}}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {				
					int numFilas = modeloTable.getRowCount();
					for (int i=numFilas-1; i>=0; i--) {				//eliminar los datos de la tabla
						modeloTable.removeRow(i);
					}	
						bodega = empresa.BuscarBodega(BodegaOrigen.getText());
					
					if(txtcantidad.getText().compareTo("")==0) {
						JOptionPane.showMessageDialog(contentPane,"Ingrese la cantidad");
					}
					else {
					if(productos==null) {
						productos= new Producto[1];
					}
					else {
						productos= Arrays.copyOf(productos, productos.length+1);
					}
					Producto p= bodega.BuscarProducto(Integer.parseInt(txtproducto.getText()));
					p.setCantidad_disponible(Integer.valueOf(txtcantidad.getText()));
					productos[productos.length-1]=p;

					int i=0;
					while(i<productos.length) {	//recorrer el vector de bodegas para hacer la busqueda
						//{"SKU", "Marca", "Referencia", "Cantidad"};

						String [] model = {Integer.toString(productos[i].getSku()),productos[i].getMarca(),productos[i].getReferencia(),Integer.toString(productos[i].getCantidad_disponible())}; //crear modelo para agregar filas
						modeloTable.addRow(model);	//agregar modelo a las filas de la tabla
						i++;
					}}}catch (BodegaNoExiste e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane,"Bodega no encontrada");
					}
			}

		});
		btnAgregar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAgregar.setBounds(440, 148, 89, 23);
		contentPane.add(btnAgregar);
		btnBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnBuscar.setBounds(220, 149, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(BodegaOrigen.getText().compareTo("")==0 || BodegaDestino.getText().compareTo("")==0) {
					JOptionPane.showMessageDialog(contentPane, "Seleccione Origen y Destino");
				}
				else if(BodegaOrigen.getText().compareTo(BodegaDestino.getText())==0) {
					JOptionPane.showMessageDialog(contentPane, "No puede ser igual el Origen y Destino");
				}
				else if(productos==null) {
					JOptionPane.showMessageDialog(contentPane, "Seleccione productos");
				}
				else {
					int i =0;
					while(i<productos.length) {
						try {
							empresa.Transferencia(BodegaOrigen.getText(),BodegaDestino.getText(),productos[i].getSku(),productos[i].getCantidad_disponible());
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(contentPane, e.getMessage());
						} catch (BodegaNoExiste e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(contentPane, e.getMessage());
						} catch (Excepciones.ProductoNoEncontrado e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(contentPane, e.getMessage());
						}
						i++;
					}
					JOptionPane.showMessageDialog(contentPane, "Se ha Realizado correctamente");
					dispose();
				}
			}
		});
		btnAceptar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAceptar.setBounds(220, 561, 93, 23);
		contentPane.add(btnAceptar);
	}
}
