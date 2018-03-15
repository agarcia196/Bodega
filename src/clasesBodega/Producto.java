/**
 * clasesBodega: Empresa.
 *
 * @author Youlvis 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */
package clasesBodega;

import java.io.Serializable;

public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1703039357847833245L;
	private int sku,cantidad_disponible;
	private String referencia,descripcion,categoria, marca;
	private double volumen,peso;
	private static int count=0;
	
	public Producto(int sku,int cantidad_disponible, String referencia, String descripcion, String categoria, String marca,
			double volumen, double peso) {
		super();
		this.marca=marca;
		this.cantidad_disponible = cantidad_disponible;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.volumen = volumen;
		this.peso = peso;
		this.sku= sku;
	
	}
	public Producto(int cantidad_disponible, String referencia, String descripcion, String categoria, String marca,
			double volumen, double peso) {
		super();
		this.marca=marca;
		this.cantidad_disponible = cantidad_disponible;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.volumen = volumen;
		this.peso = peso;
		this.sku= count;
		count++;
	}

	public int getCantidad_disponible() {
		return cantidad_disponible;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getSku() {
		return sku;
	}

	public String getReferencia() {
		return referencia;
	}

	public String getCategoria() {
		return categoria;
	}

	public double getVolumen() {
		return volumen;
	}

	public double getPeso() {
		return peso;
	}
	

}
