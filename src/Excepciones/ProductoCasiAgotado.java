package Excepciones;

public class ProductoCasiAgotado extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3088054552667042875L;
	 public ProductoCasiAgotado() {
		 super("Se esta agotando su existencia");
	 }
}
