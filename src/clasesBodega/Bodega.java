/**
 * clasesBodega: Recursos.
 *
 * @author Jeisson Harvey Barrera Sanchez
 * @author Jorge Luis Soriano Cuevas
 * @version 9.3.2018
 * 
 */

package clasesBodega;

import java.io.Serializable;
import java.util.Arrays;

import Excepciones.ProductoNoEncontrado;

// TODO: Auto-generated Javadoc
/**
 * The Class Bodega.
 */
public class Bodega implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 58352670855964000L;

	/** The ciudad. */
	private String direccion, idBodega, ciudad;
	
	/** The lista producto. */
	private Producto [] lista_producto;
	
	/** The capacidad max. */
	private double capacidadMax;
	
	/** The seccion. */
	private String [] seccion;



	/**
	 * Instantiates a new bodega.
	 *
	 * @param direccion la direccion
	 * @param idBodega el id bodega
	 * @param ciudad la ciudad
	 * @param capacidadMax la capacidad max
	 */
	public Bodega(String direccion, String idBodega, String ciudad, int capacidadMax) {
		super();
		this.direccion = direccion;
		this.idBodega = idBodega;
		this.ciudad = ciudad;
		this.capacidadMax = capacidadMax;
		lista_producto = new Producto[0];
		seccion= new String[0];
	}



	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	
	



	/**
	 * Gets the id bodega.
	 *
	 * @return the id bodega
	 */
	public String getIdBodega() {
		return idBodega;
	}
	
	/**
	 * Gets the ciudad.
	 *
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	
	/**
	 * Gets the capacidad max.
	 *
	 * @return the capacidad max
	 */
	public double getCapacidadMax() {
		return capacidadMax;
	}
	
	public void setCapacidadMax(double d) {
		this.capacidadMax = d;
	}
	
	/**
	 * Gets the seccion.
	 *
	 * @return the seccion
	 */
	public String[] getSeccion() {
		return seccion;
	}
	
	/**
	 * Bucar seccion.
	 *
	 * @param numseccion the numseccion
	 * @return the string
	 */
	public String buscarSeccion(String numseccion) {//se Busca una sección por el número de sección
		int i=0;								   //especifico de esta
		while(i<seccion.length && seccion[i].compareTo(numseccion)!=0) {//condición de parada:
			i++;	//aumentar el contador								//-al recorrer el vector
		}																//-al encontrar la sección
		if(i==seccion.length) {						//condición de no encontrada
			return null;

		}else {										//se encontró la sección
			return seccion[i];
		}
	}
	
	/**
	 * Añadir una seccion.
	 */
	public void AddSeccion() {
		int i=1;
		if (seccion == null) {
			seccion = new String[1];
		} else {
			seccion = Arrays.copyOf(seccion, seccion.length + 1);
			String aux="A-0"+(i++);
			seccion[seccion.length - 1] = aux;
		}
	}
	public void RemoveProducto(Producto producto,int cantidad) {
		if(cantidad==producto.getCantidad_disponible()) {
			
		}else if(cantidad<producto.getCantidad_disponible()) {
			producto.setCantidad_disponible(producto.getCantidad_disponible()-cantidad);
		}
	}
	public void addProducto(int sku,int cantidad) throws ProductoNoEncontrado{
		Producto p= BuscarProducto(sku);
		if(p==null) 
			throw new ProductoNoEncontrado();
		else
		p.setCantidad_disponible(p.getCantidad_disponible()+cantidad);
	}
	public Producto BuscarProducto(int sku) {
		int i=0;
		while(i<lista_producto.length && lista_producto[i].getSku()==sku) {
			i++;
		}
		if(i==lista_producto.length) {
			return null;
		}
		else
			return lista_producto[i];
	}
	/**
	 * Añadir the producto.
	 *
	 * @param producto el producto
	 * @param cantidad la cantidad
	 */
	public void addProducto(Producto producto, int cantidad) {
		if (lista_producto==null) {							   //Si el arreglo de productos es vacio
			lista_producto=new Producto[1];					   //se inicializa en 1
		}else {
			lista_producto=Arrays.copyOf(lista_producto, lista_producto.length+1);//Aumentar tamaño arreglo												  
			//Producto deberia tener dos constructores, uno con cantidad = 0 
			//y otro con la cantidad pasada como atributo en este metodo
		}
		Producto prod= new Producto(cantidad, producto.getReferencia(), producto.getDescripcion(),//crear nuevo
				producto.getCategoria(), producto.getMarca(), producto.getVolumen(),			  //producto(clonar)
				producto.getPeso());
		lista_producto[lista_producto.length-1]= prod;//Añadir producto
	}
	
	/**
	 * Compradeproducto.
	 *
	 * @param sku el sku
	 * @param cantidad la cantidad
	 * @throws CantidadInsuficiente la cantidad es insuficiente
	 */
	public void compradeproducto(int sku,int cantidad)throws CantidadInsuficiente,ProductoNoExistente,ProductoCasiAgotado,SinProducto {
		int i=0;
		while(i<lista_producto.length && lista_producto[i].getSku() !=sku) {//recorre vector
			i++;																	  //de productos
		}
		if(i<lista_producto.length) {									//No existe un producto igual
			if(cantidad<=lista_producto[i].getCantidad_disponible()) {	//comprueba disponibilidad
				int aux=lista_producto[i].getCantidad_disponible() - cantidad;
				lista_producto[i].setCantidad_disponible(aux);			//quita cantidad comprada
			}else {
				throw new CantidadInsuficiente();
			}
		}else {
			throw new ProductoNoExistente();
		}
		/*if(lista_producto[i].getCantidad_disponible()<=lista_producto[i].getCantidad_minima()) {
			throw new ProductoCasiAgotado();
		}else */{
			if(lista_producto[i].getCantidad_disponible()==0) {
				throw new SinProducto();
			}
		}
		
	}
	
}
class SinProducto extends Exception{
	 public SinProducto() {
		 super("Se agotando el producto");
	 }	 
}
class ProductoCasiAgotado extends Exception{
	 public ProductoCasiAgotado() {
		 super("Se esta agotando su existencia");
	 }	 
}
 class CantidadInsuficiente extends Exception{
	 public CantidadInsuficiente() {
		 super("La cantidad de productos es insufucuiente");
	 }	 
 }
 class ProductoNoExistente extends Exception{
	 public ProductoNoExistente() {
		 super("Producto no Existente");
	 }
}
