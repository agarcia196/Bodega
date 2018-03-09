package clasesBodega;

import java.util.Arrays;

public class Bodega {

	private String direccion, idBodega, ciudad;
	private Producto [] lista_producto;
	private int capacidadMax;
	private String [] seccion;



	public Bodega(String direccion, String idBodega, String ciudad, int capacidadMax) {
		super();
		this.direccion = direccion;
		this.idBodega = idBodega;
		this.ciudad = ciudad;
		this.capacidadMax = capacidadMax;
		lista_producto = new Producto[0];
		seccion= new String[0];
	}



	public String getDireccion() {
		return direccion;
	}
	public String getIdBodega() {
		return idBodega;
	}
	public String getCiudad() {
		return ciudad;
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	public String[] getSeccion() {
		return seccion;
	}
	
	public String bucarSeccion(String numseccion) {
		int i=0;
		while(i<seccion.length && seccion[i].compareTo(numseccion)!=0) {
			i++;
		}
		if(i==seccion.length) {
			return null;

		}else {
			return seccion[i];
		}
	}
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

	public void addProducto(Producto producto, int cantidad) {
		if (lista_producto==null) {
			lista_producto=new Producto[1];
		}else {
			lista_producto=Arrays.copyOf(lista_producto, lista_producto.length+1);
			//Producto deberia tener dos constructores, uno con cantidad = 0 y otro con la cantidad pasada como atributo en este metodo
			lista_producto[lista_producto.length-1]= new Producto(producto, cantidad);
		}
	}
	
	public void compradeproducto(int sku,int cantidad)throws CantidadInsuficiente {
		int i=0;
		while(i<lista_producto.length && lista_producto[i].getSku.compareTo(sku)!=0) {
			i++;
		}
		if(i<lista_producto.length) {
			if(cantidad<=lista_producto[i].getCantidad_disponible) {
				int aux=lista_producto[i].getCantidad_disponible - cantidad;
				lista_producto[i].setCantidad_disponible(aux);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Bodega a=new Bodega("calle 25", "id01", "Yopal", 6);
		a.AddSeccion();
		a.AddSeccion();
		String aux=a.getSeccion()[0];
		String aux2=a.getSeccion()[1];
		System.out.println(aux);
		System.out.println(aux2);
	}
	
}
 class CantidadInsuficiente extends Exception{
	 public CantidadInsuficiente() {
		 super("La cantidad de productos es insufucuiente");
	 }
	 
 }
 