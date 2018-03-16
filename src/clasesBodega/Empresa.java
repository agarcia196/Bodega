/**
 * clasesBodega: Empresa.
 *
 * @author Alexis García Ramirez 
 * @author Jorge Luis Soriano Cuevas
 * @version 16.3.2018
 */
package clasesBodega;

import java.io.Serializable;
import java.util.Arrays;

import Excepciones.BodegaNoExiste;
import Excepciones.CategoriaNoEncontrada;
import Excepciones.EBodegas;
import Excepciones.ECamposVacios;
import Excepciones.ProductoNoEncontrado;

/**
 * The Class Empresa.
 */
public class Empresa implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -306383744197773352L;
	
	
	/** The productos. */
	private Producto[] productos;
	
	/** The bodegas. */
	private Bodega [] bodegas;
	
	/** The categoría. */
	private String [] categoria;
	
	/** The usuarios. */
	private Persona [] usuarios;
	
	/** The nombre. */
	private String nombre;
	
	/** The logo. */
	private String logo;
	
	/**
	 *  
	 * Instancia de nueva empresa.
	 *
	 * @param nombre de la empresa
	 * @param logo ruta de acceso de el logo de la empresa
	 */
	
	public Empresa(String nombre,String logo) {
		super();
		this.nombre = nombre;
		this.logo=logo;
		this.usuarios= new Persona[0];
	}
	
	/**
	 * Instancia de nueva empresa.
	 */
	public Empresa() {
	}

	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	public Persona[] getUsuarios() {
		return usuarios;
	}


	/**
	 * Sets the usuarios.
	 *
	 * @param usuarios the new usuarios
	 */
	public void setUsuarios(Persona[] usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 * Gets Bodegas.
	 *
	 * @return Array Bodegas
	 */
	public Bodega[] getBodegas() {
		return bodegas;
	}

	/**
	 * Sets Bodegas.
	 *
	 * @param bodegas nueva bodega
	 */
	public void setBodegas(Bodega[] bodegas) {
		this.bodegas = bodegas;
	}
	
	/**
	 * Gets Categoría.
	 *
	 * @return Array categoría
	 */
	public String[] getCategoria() {
		return categoria;
	}
	
	/**
	 * Sets Categoría.
	 *
	 * @param categoria nueva categoría
	 */
	public void setCategoria(String[] categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Gets Nombre.
	 *
	 * @return  Nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets Nombre.
	 *
	 * @param nombre nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets Producto.
	 *
	 * @return Array Productos
	 */
	public Producto[] getProductos() {
		return productos;
	}
	
	/**
	 * Sets Producto.
	 *
	 * @param productos Nuevo producto
	 */
	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	
	/**
	 * Agregar producto.
	 *
	 * @param cantidad_disponible La cantidad disponible
	 * @param referencia Referencia
	 * @param descripcion Descripción
	 * @param categoria Categoría
	 * @param marca Marca
	 * @param volumen Volumen
	 * @param peso Peso
	 */
	public void AddProducto(Producto p) {
		if(productos==null)
			productos=new Producto[1];
		else 
			productos=Arrays.copyOf(productos,productos.length+1);
		productos[productos.length-1]= p;
	}
	
	/**
	 * Buscar producto.
	 *
	 * @param codigo SKU del producto
	 * @return Producto
	 * @throws ProductoNoEncontrado Producto no encontrado
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
	 * Agregar categoría
	 *
	 * @param categ Categoría
	 * @throws ECamposVacios 
	 */
	public void AddCategoria(String categ) throws ECamposVacios {
		if(categ.compareTo("")==0) {
			throw new ECamposVacios();
		}
		if(categoria==null)
			categoria=new String[1];
		else 
			categoria=Arrays.copyOf(categoria,categoria.length+1);
		categoria[categoria.length-1]= categ;
	}
	
	/**
	 * Buscar categoría.
	 *
	 * @param categ Categoría
	 * @return the string
	 * @throws CategoriaNoEncontrada the categoría no encontrada
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
	 * Agregar bodega.
	 *
	 * @param IDBodega Nombre
	 * @param direccion dirección
	 * @param ciudad Ciudad
	 * @param capMaxima Capacidad Maxima
	 */	
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
	 * @param IDBodega Nombre de la bodega
	 * @return Objeto Bodega
	 * @throws BodegaNoExiste ID incorrecto o bodega no existe
	 */
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


	
	
	/**
	 * Buscar usuario por número de documento.
	 *
	 * @param cc Cédula
	 * @return El Usuario
	 */
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
	
	public String[][] BuscarProductoEnBodega(String Bodega) throws EBodegas, BodegaNoExiste {
		
		if(bodegas==null) {
			throw new EBodegas("No hay bodegas registradas");
		}else {
			Bodega b = BuscarBodega(Bodega);
			String[][]model=new String[b.getLista_producto().length][7];
			int i=0;
			while(i<b.getLista_producto().length) {	//recorrer arreglo de productos dentro de bodega
				model[i][0]=Integer.toString(b.getLista_producto()[i].getSku());
				model[i][1]=b.getLista_producto()[i].getReferencia();
				model[i][2]=b.getLista_producto()[i].getMarca();
				model[i][3]=Double.toString(b.getLista_producto()[i].getVolumen());
				model[i][4]=Double.toString(b.getLista_producto()[i].getPeso());
				model[i][5]=b.getLista_producto()[i].getCategoria();
				model[i][6]=Integer.toString(b.getLista_producto()[i].getCantidad_disponible());
				i++;
			}
			return model;
		}
	}
	
	
	/**
	 * Gets logo.
	 *
	 * @return ruta relativa de logo
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
	
	
	 /*
	 * @param b1 Bodega Origen
	 * @param b2 Bodega Destino
	 * @param p  Producto
	 * @param cantidad Cantidad de producto
	 * @throws BodegaNoExiste ID incorrecto o bodega no existe
	 * @throws ProductoNoEncontrado Producto no encontrado
	 */
	
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
	
	/**
	 * Agregar Usuario a el array usuarios.
	 *
	 * @param p Persona
	 */
	public void AddUser(Persona p) {
		if(usuarios==null) {
			usuarios = new Persona[1];
		}
		else {
			usuarios= Arrays.copyOf(usuarios, usuarios.length+1);
			usuarios[usuarios.length-1]=p;
		}
	}
	
}

