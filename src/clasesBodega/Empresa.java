/**
 * clasesBodega: Empresa.
 *
 * @author Alexis García Ramirez 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */
package clasesBodega;

import java.io.Serializable;
import java.util.Arrays;

import Excepciones.ProductoNoEncontrado;

// TODO: Auto-generated Javadoc
/**
 * The Class Empresa.
 */
public class Empresa implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -306383744197773352L;
	
	
	private Producto[] productos;
	private Bodega [] bodegas;
	/** The categoria. */
	private String [] categoria;
	private Persona [] usuarios;
	private String nombre;
	private String logo;
	
	/**
	 *  
	 * Constructor.
	 *
	 * @param nombre de la empresa
	 * @param logo ruta de acceso de el logo de la empresa
	 */
	
	public Empresa(String nombre,String logo) {
		super();
		this.nombre = nombre;
		this.logo=logo;
	}
	
	
	public Persona[] getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Persona[] usuarios) {
		this.usuarios = usuarios;
	}


	/**
	 * Instantiates a new empresa.
	 */
	public Empresa() {
		
	}
	
	/**
	 * Gets the bodegas.
	 *
	 * @return the bodegas
	 */
	public Bodega[] getBodegas() {
		return bodegas;
	}

	/**
	 * Sets the bodegas.
	 *
	 * @param bodegas the new bodegas
	 */
	public void setBodegas(Bodega[] bodegas) {
		this.bodegas = bodegas;
	}

	/**
<<<<<<< HEAD
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */


	/**
	 * Sets the usuarios.
	 *
	 * @param usuarios the new usuarios
	 */
	
	/**
=======
>>>>>>> 775aae149eb50f47990b589cd22ef9342d3a405b
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public String[] getCategoria() {
		return categoria;
	}
	
	/**
	 * Sets the categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(String[] categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the productos.
	 *
	 * @return the productos
	 */
	public Producto[] getProductos() {
		return productos;
	}
	
	/**
	 * Sets the productos.
	 *
	 * @param productos the new productos
	 */
	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	/**
	 * Adds the producto.
	 *
	 * @param categ the categ
	 * @return the string
	 * @throws CategoriaNoEncontrada the categoria no encontrada
	 */
	public void AddProducto(int cantidad_disponible, String referencia, String descripcion, String categoria, String marca,
			double volumen, double peso) {
		if(productos==null)
			productos=new Producto[1];
		else 
			productos=Arrays.copyOf(productos,productos.length+1);
		productos[productos.length-1]= new Producto(cantidad_disponible,referencia,descripcion,categoria, marca,volumen,peso);
	}
	
	/**
	 * Buscar producto.
	 *
	 * @param codigo the codigo
	 * @return the producto
	 * @throws ProductoNoEncontrado the producto no encontrado
	 */
	public Producto BuscarProducto(int codigo)throws ProductoNoEncontrado {
		int i=0;
		while (i<productos.length && productos[i].getSku()!=codigo) {
			i++;
		}
		if(i==productos.length)
			throw new ProductoNoEncontrado();
		else 
			return productos[i];
	}
	
	/**
	 * Adds the categoria.
	 *
	 * @param categ the categ
	 */
	public void AddCategoria(String categ) {
		if(categoria==null)
			categoria=new String[1];
		else 
			categoria=Arrays.copyOf(categoria,categoria.length+1);
		categoria[categoria.length-1]= categ;
	}
	
	/**
	 * Buscar categoria.
	 *
	 * @param categ the categ
	 * @return the string
	 * @throws CategoriaNoEncontrada the categoria no encontrada
	 */
	public String BuscarCategoria(String categ)throws CategoriaNoEncontrada {
		int i=0;
		while (i<categoria.length && categoria[i]!=categ) {
			i++;
		}
		if(i==categoria.length)
			throw new CategoriaNoEncontrada();
		else 
			return categoria[i];
	}
	

	/**
	 * Adds the bodega.
	 *
	 * @param IDBodega the ID bodega
	 * @param direccion the direccion
	 * @param ciudad the ciudad
	 * @param capMaxima the cap maxima
	 */
	//Agregar bodega	
	public void AddBodega(String IDBodega, String direccion, String ciudad, int capMaxima) {
		Bodega bodega1 = new Bodega(direccion, IDBodega, ciudad, capMaxima);
		if (bodegas==null)
			bodegas = new Bodega[1];
		else 
			bodegas = Arrays.copyOf(bodegas, bodegas.length+1);
		bodegas [bodegas.length-1]= bodega1;
	}

	/**
	 * Buscar bodega.
	 *
	 * @param IDBodega the ID bodega
	 * @return the bodega
	 * @throws BodegaNoExiste the bodega no existe
	 */
	//Buscar bodega
	public Bodega BuscarBodega(String IDBodega) throws BodegaNoExiste{
		int i=0;
		while (i<bodegas.length && bodegas[i].getIdBodega().compareTo(IDBodega)!=0) {
			i++;	
		}
		if (i==bodegas.length) {
			throw new BodegaNoExiste();
		}
		else return bodegas[i];
	}


	
	public void AddUser(Persona p) {
		if(usuarios==null)
			usuarios = new Persona[1];
		else
			usuarios= Arrays.copyOf(usuarios, usuarios.length+1);
		usuarios[usuarios.length-1]=p;
	}
	public void AddUser(String nombre,String apellido,String genero,String correo,String cc,String tipoid,String pwd,String cargo) {
		if(usuarios==null) {
			usuarios = new Persona[1];
		}else {
			usuarios= Arrays.copyOf(usuarios, usuarios.length+1);
		if(cargo.compareTo("G")==0) {
			Persona p=new Gerente(nombre,apellido,genero,correo,cc,tipoid,pwd);
			usuarios[usuarios.length-1]=p;
		}else {
			Persona p=new Bodeguero(nombre,apellido,genero,correo,cc,tipoid,pwd);
			usuarios[usuarios.length-1]=p;
			}
		}
	}
	
	/**
	 * Buscar user.
	 *
	 * @param user the user
	 * @return the user
	 * @throws UserNoExiste the user no existe
	 */
	//Buscar Usuario por User
	public Persona BuscarUser(String cc) {
		int i=0;
		while (i<usuarios.length && cc.compareTo(usuarios[i].getCc())!=0) {
			i++;
		}
		if (i==usuarios.length)
			return null;
		else 
			return usuarios[i];
	}	
	
	
	/**
	 * Gets the logo.
	 *
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}


	/**
	 * Sets the logo.
	 *
	 * @param logo the new logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	/**
	 * The Class BodegaNoExiste.
	 */
	public class BodegaNoExiste extends Exception{
		
		/**
		 * Instantiates a new bodega no existe.
		 */
		public BodegaNoExiste() {
			super ("ID incorrecto o bodega no existe. Verifique nuevamente");
		}
	}
	
	/**
	 * The Class UserNoExiste.
	 */
	public class UserNoExiste extends Exception{
		
		/**
		 * Instantiates a new user no existe.
		 */
		public UserNoExiste() {
			super("User incorrecto o no existe. Verifique nuevamente");
		}
	}
	
	/**
	 * The Class PwdIncorrecta.
	 */
	public class PwdIncorrecta extends Exception{
		
		/**
		 * Instantiates a new pwd incorrecta.
		 */
		public PwdIncorrecta() {
			super("Contraseña o usuario incorrectos, verifique nuevamente");
		}
	}
	
	/**
	 * The Class DatosInsuficientes.
	 */
	public class DatosInsuficientes extends Exception{
		
		/**
		 * Instantiates a new datos insuficientes.
		 */
		public DatosInsuficientes() {
			super("Datos incompletos");
		}
	}
	

	public class CategoriaNoEncontrada extends Exception{
		
		/**
		 * Instantiates a new categoria no encontrada.
		 */
		public CategoriaNoEncontrada() {
			super("Categoria no encontrada");
		}
	}

	public void Transferencia(String b1,String b2,int p,int cantidad)throws BodegaNoExiste,ProductoNoEncontrado{
		Bodega bb1= BuscarBodega(b1);
		Bodega bb2= BuscarBodega(b2);
		Producto producto = bb1.BuscarProducto(p);
		bb1.RemoveProducto(producto, cantidad);
		Producto producto2= bb2.BuscarProducto(p);
		if(producto2==null)
			bb2.addProducto(producto,cantidad);
		else
			bb2.addProducto(producto2.getSku(),cantidad);

	}
	
	
	
}

