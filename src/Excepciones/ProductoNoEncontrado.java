package Excepciones;

import java.io.Serializable;

public class ProductoNoEncontrado extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6472354577714185971L;

	public ProductoNoEncontrado() {
		super("Producto no encontrado");
	}
}
