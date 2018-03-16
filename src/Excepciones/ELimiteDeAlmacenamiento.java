package Excepciones;

public class ELimiteDeAlmacenamiento extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2849648115127615856L;

	public ELimiteDeAlmacenamiento() {
		super("No se puede ingresar la cantidad de producto(s), supera la cantidad soportada por la bodega.");
		
	}

}
