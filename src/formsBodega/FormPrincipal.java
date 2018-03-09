package formsBodega;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;

import clasesBodega.Gerente;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa em= new Empresa();
					Persona p = new Persona("Alexis", "Garcia", "mascu", "ddd", "ddd", "CC", "1234") {
					};
					FormPrincipal window = new FormPrincipal(em,p);
					window.frmBodegas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormPrincipal(Empresa empresa, Persona persona) {
		this.empresa= empresa;
		this.persona = persona;
		initialize();
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
		mnInicio.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ImageIcon iconInicio =new ImageIcon("png\\home-button.png");
		Icon iconoInicio = new ImageIcon(iconInicio.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		
		JLabel lblUsuario_1 = new JLabel("  Bienvenido  ");
		lblUsuario_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		menuBar.add(lblUsuario_1);
		
		JLabel lblUsuario = new JLabel(persona.getNombre()+" "+persona.getApellido());
		lblUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
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
		mntmCerrarSesion.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		ImageIcon iconexit =new ImageIcon("png\\exit-to-app-button.png");
		Icon iconosalir = new ImageIcon(iconexit.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		mntmCerrarSesion.setIcon(iconosalir);
		mnInicio.add(mntmCerrarSesion);
		
		//if(persona instanceof Gerente) {
		
		
		JMenu mnBodega = new JMenu("Bodega");
		mnBodega.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ImageIcon iconBodega =new ImageIcon("png\\bodega.png");
		Icon iconoBodega = new ImageIcon(iconBodega.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		mnBodega.setIcon(iconoBodega);
		menuBar.add(mnBodega);
		
		JMenuItem mntmAgregarBodega = new JMenuItem("Crear");
		mntmAgregarBodega.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		ImageIcon iconAgregarBodega =new ImageIcon("png\\add-plus-button.png");
		Icon iconoAgregarBodega = new ImageIcon(iconAgregarBodega.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		mntmAgregarBodega.setIcon(iconoAgregarBodega);
		mnBodega.add(mntmAgregarBodega);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		ImageIcon iconConsultar =new ImageIcon("png\\searching-magnifying-glass.png");
		Icon iconoConsultar = new ImageIcon(iconConsultar.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		mntmConsultar.setIcon(iconoConsultar);
		mnBodega.add(mntmConsultar);
		
		JMenu mnProducto = new JMenu("Producto");
		mnProducto.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ImageIcon iconProducto =new ImageIcon("png\\puzzle-piece-plugin.png");
		Icon iconoProducto = new ImageIcon(iconProducto.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		mnProducto.setIcon(iconoProducto);
		menuBar.add(mnProducto);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		mntmCrear.setIcon(iconoAgregarBodega);
		mnProducto.add(mntmCrear);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		mntmBuscar.setIcon(iconoConsultar);
		mnProducto.add(mntmBuscar);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mntmEditar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		ImageIcon iconEditar  =new ImageIcon("png\\edit.png");
		Icon iconoEditar  = new ImageIcon(iconEditar.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		mntmEditar.setIcon(iconoEditar);
		mnProducto.add(mntmEditar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ImageIcon iconUsuarios =new ImageIcon("png\\user-shape.png");
		Icon iconoUsuarios = new ImageIcon(iconUsuarios.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		mnUsuarios.setIcon(iconoUsuarios);
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmCrear_1 = new JMenuItem("Crear");
		mntmCrear_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		ImageIcon iconCrear_1 =new ImageIcon("png\\add-user-button.png");
		Icon iconoCrear_1 = new ImageIcon(iconCrear_1.getImage().getScaledInstance(15,15, Image.SCALE_DEFAULT));
		mntmCrear_1.setIcon(iconoCrear_1);
		mnUsuarios.add(mntmCrear_1);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		mntmConsultar_1.setIcon(iconoConsultar);
		mnUsuarios.add(mntmConsultar_1);
		
	}
}
