package formsBodega;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;

import clasesBodega.Gerente;
import clasesBodega.Bodeguero;
import clasesBodega.Empresa;
import clasesBodega.Persona;
import clasesBodega.Recursos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7122512140857515626L;
	private JFrame frmBodegas;
	private Empresa empresa;
	private Persona persona;
	private int n=16; //Tamaño iconos
	private int n2= 15; //Tamaño Titulos barra de menú
	private int n3= 14; //Tampo de Subtitulos barra de menu
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa em= new Empresa();
					Persona p = new Gerente("Alexis", "Garcia", "mascu", "ddd", "ddd", "CC", "1234") {
					};
					FormPrincipal window = new FormPrincipal(em,p);
					window.frmBodegas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public FormPrincipal(Empresa empresa, Persona persona) {
		this.empresa= empresa;
		this.persona = persona;
		initialize();
	}
	

	public JFrame getFrmBodegas() {
		return frmBodegas;
	}

	public void setFrmBodegas(JFrame frmBodegas) {
		this.frmBodegas = frmBodegas;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBodegas = new JFrame();
		frmBodegas.getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 12));
		frmBodegas.setTitle("Bodegas");
		frmBodegas.setBounds(100, 100, 650, 500);
		frmBodegas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBodegas.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmBodegas.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.setFont(new Font("Century Gothic", Font.PLAIN, n2));
		ImageIcon iconInicio =new ImageIcon("png\\home-button.png");
		Icon iconoInicio = new ImageIcon(iconInicio.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		
		JLabel lblUsuario_1 = new JLabel("  Bienvenido  ");
		lblUsuario_1.setFont(new Font("Century Gothic", Font.PLAIN, n2));
		menuBar.add(lblUsuario_1);
		
		JLabel lblUsuario = new JLabel(persona.getNombre()+" "+persona.getApellido());
		lblUsuario.setFont(new Font("Century Gothic", Font.PLAIN, n2));
		menuBar.add(lblUsuario);
		mnInicio.setIcon(iconoInicio);
		menuBar.add(mnInicio);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recursos.WriteFileObjectEmpresa("empresa.dat", empresa);
				frmBodegas.setVisible(false);
				FormLogin login = new FormLogin(empresa);
				login.setVisible(true);
			}
		});
		mntmCerrarSesion.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		ImageIcon iconexit =new ImageIcon("png\\exit-to-app-button.png");
		Icon iconosalir = new ImageIcon(iconexit.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mntmCerrarSesion.setIcon(iconosalir);
		mnInicio.add(mntmCerrarSesion);
		
		
		ImageIcon iconConsultar =new ImageIcon("png\\searching-magnifying-glass.png");
		Icon iconoConsultar = new ImageIcon(iconConsultar.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		
		ImageIcon iconAgregarBodega =new ImageIcon("png\\add-plus-button.png");
		Icon iconoAgregarBodega = new ImageIcon(iconAgregarBodega.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		
		// Condición de usuario Gerente
		//if(persona instanceof Gerente) {
		
		
		JMenu mnBodega = new JMenu("Bodega");
		mnBodega.setFont(new Font("Century Gothic", Font.PLAIN, n2));
		ImageIcon iconBodega =new ImageIcon("png\\bodega.png");
		Icon iconoBodega = new ImageIcon(iconBodega.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mnBodega.setIcon(iconoBodega);
		menuBar.add(mnBodega);
		
		JMenuItem mntmAgregarBodega = new JMenuItem("Crear");
		mntmAgregarBodega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormCrearBodega crear=new FormCrearBodega(persona,empresa);
				crear.setVisible(true);
			}
		});
		mntmAgregarBodega.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		
		mntmAgregarBodega.setIcon(iconoAgregarBodega);
		mnBodega.add(mntmAgregarBodega);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormBusquedaBodega bbodega =new FormBusquedaBodega(empresa, null);
				bbodega.setVisible(true);
			}
		});
		mntmConsultar.setFont(new Font("Century Gothic", Font.PLAIN, n3));

		mntmConsultar.setIcon(iconoConsultar);
		mnBodega.add(mntmConsultar);
		
		JMenu mnActividad = new JMenu("Actividad");
		mnActividad.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		ImageIcon iconActividad =new ImageIcon("png\\lista.png");
		Icon iconoActividad = new ImageIcon(iconActividad.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mnActividad.setIcon(iconoActividad);
		mnBodega.add(mnActividad);
		
		JMenuItem mntmIngreso = new JMenuItem("Ingreso");
		mntmIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAddProductoCant ingreso = new FormAddProductoCant(persona,empresa);
				ingreso.setVisible(true);
			}
		});
		mntmIngreso.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		ImageIcon iconIngreso  =new ImageIcon("png\\ingreso.png");
		Icon iconoIngreso  = new ImageIcon(iconIngreso.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mntmIngreso.setIcon(iconoIngreso);
		mnActividad.add(mntmIngreso);
		
		JMenuItem mntmTraslado = new JMenuItem("Traslado");
		mntmTraslado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormTraslado traslado = new FormTraslado(empresa, persona);
				traslado.setVisible(true);
			}
		});
		mntmTraslado.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		ImageIcon iconTraslado  =new ImageIcon("png\\traslado.png");
		Icon iconoTraslado  = new ImageIcon(iconTraslado.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mntmTraslado.setIcon(iconoTraslado);
		mnActividad.add(mntmTraslado);
		  		
		JMenu mnProducto = new JMenu("Producto");
		mnProducto.setFont(new Font("Century Gothic", Font.PLAIN, n2));
	    ImageIcon iconProducto =new ImageIcon("png\\puzzle-piece-plugin.png");
		Icon iconoProducto = new ImageIcon(iconProducto.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mnProducto.setIcon(iconoProducto);
		menuBar.add(mnProducto);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (empresa.getCategoria()==null) {
					JOptionPane.showMessageDialog(frmBodegas, "No existen categorías, por favor agregue una");
					FormAgregarCategoria formcat = new FormAgregarCategoria(persona, empresa);
					formcat.setVisible(true);
				}else {
				FormAddProducto crear_producto = new FormAddProducto(persona,empresa);
				
				crear_producto.setVisible(true);}
			}
		});
		mntmCrear.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		mntmCrear.setIcon(iconoAgregarBodega);
		mnProducto.add(mntmCrear);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mntmBuscar.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		mntmBuscar.setIcon(iconoConsultar);
		mnProducto.add(mntmBuscar);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mntmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mntmEditar.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		ImageIcon iconEditar  =new ImageIcon("png\\edit.png");
		Icon iconoEditar  = new ImageIcon(iconEditar.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mntmEditar.setIcon(iconoEditar);
		mnProducto.add(mntmEditar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setFont(new Font("Century Gothic", Font.PLAIN, n2));
		ImageIcon iconUsuarios =new ImageIcon("png\\user-shape.png");
		Icon iconoUsuarios = new ImageIcon(iconUsuarios.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mnUsuarios.setIcon(iconoUsuarios);
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmCrear_1 = new JMenuItem("Crear");
		mntmCrear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				FormAddUser agregar_usuario = new FormAddUser(empresa, persona);
//				agregar_usuario.setVisible(true);
			}
		});
		mntmCrear_1.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		ImageIcon iconCrear_1 =new ImageIcon("png\\add-user-button.png");
		Icon iconoCrear_1 = new ImageIcon(iconCrear_1.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
		mntmCrear_1.setIcon(iconoCrear_1);
		mnUsuarios.add(mntmCrear_1);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mntmConsultar_1.setFont(new Font("Century Gothic", Font.PLAIN, n3));
		mntmConsultar_1.setIcon(iconoConsultar);
		mnUsuarios.add(mntmConsultar_1);
		}/*
		if(persona instanceof Bodeguero) {
			JMenu mnBodega = new JMenu("Bodega");
			mnBodega.setFont(new Font("Century Gothic", Font.PLAIN, n2));
			ImageIcon iconBodega =new ImageIcon("png\\bodega.png");
			Icon iconoBodega = new ImageIcon(iconBodega.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
			mnBodega.setIcon(iconoBodega);
			menuBar.add(mnBodega);
			
			JMenu mnActividad = new JMenu("Actividad");
			mnActividad.setFont(new Font("Century Gothic", Font.PLAIN, n3));
			ImageIcon iconActividad =new ImageIcon("png\\lista.png");
			Icon iconoActividad = new ImageIcon(iconActividad.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
			mnActividad.setIcon(iconoActividad);
			mnBodega.add(mnActividad);
			
			JMenuItem mntmIngreso = new JMenuItem("Ingreso");
			mntmIngreso.setFont(new Font("Century Gothic", Font.PLAIN, n3));
			ImageIcon iconIngreso  =new ImageIcon("png\\ingreso.png");
			Icon iconoIngreso  = new ImageIcon(iconIngreso.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
			mntmIngreso.setIcon(iconoIngreso);
			mnActividad.add(mntmIngreso);
			
			JMenuItem mntmTraslado = new JMenuItem("Traslado");
			mntmTraslado.setFont(new Font("Century Gothic", Font.PLAIN, n3));
			ImageIcon iconTraslado  =new ImageIcon("png\\traslado.png");
			Icon iconoTraslado  = new ImageIcon(iconTraslado.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
			mntmTraslado.setIcon(iconoTraslado);
			mnActividad.add(mntmTraslado);
			
		   		
			JMenu mnProducto = new JMenu("Producto");
			mnProducto.setFont(new Font("Century Gothic", Font.PLAIN, n2));
		    ImageIcon iconProducto =new ImageIcon("png\\puzzle-piece-plugin.png");
			Icon iconoProducto = new ImageIcon(iconProducto.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
			mnProducto.setIcon(iconoProducto);
			menuBar.add(mnProducto);
			
			JMenuItem mntmCrear = new JMenuItem("Crear");
			mntmCrear.setFont(new Font("Century Gothic", Font.PLAIN, n3));
			mntmCrear.setIcon(iconoAgregarBodega);
			mnProducto.add(mntmCrear);
			
			JMenuItem mntmBuscar = new JMenuItem("Buscar");
			mntmBuscar.setFont(new Font("Century Gothic", Font.PLAIN, n3));
			mntmBuscar.setIcon(iconoConsultar);
			mnProducto.add(mntmBuscar);
			
			JMenuItem mntmEditar = new JMenuItem("Editar");
			mntmEditar.setFont(new Font("Century Gothic", Font.PLAIN, n3));
			ImageIcon iconEditar  =new ImageIcon("png\\edit.png");
			Icon iconoEditar  = new ImageIcon(iconEditar.getImage().getScaledInstance(n,n, Image.SCALE_DEFAULT));
			mntmEditar.setIcon(iconoEditar);
			mnProducto.add(mntmEditar);
			
		}*/
		
	}

