package clasesBodega;

public class Producto {
	private int sku,cantidad_disponible;
	private String referencia,descripcion,categoria;
	private double volumen,peso;
	
	public Producto(int cantidad_disponible, String referencia, String descripcion, String categoria,
			double volumen, double peso) {
		super();
		this.sku = sku;//codigo del producto
		this.cantidad_disponible = cantidad_disponible;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.volumen = volumen;
		this.peso = peso;
	}

	public int getCantidad_disponible() {
		return cantidad_disponible;
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
