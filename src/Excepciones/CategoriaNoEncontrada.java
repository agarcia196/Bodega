package Excepciones;

import java.io.Serializable;

public class CategoriaNoEncontrada extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3990817016400906315L;
	public CategoriaNoEncontrada() {
		super("Categoria no encontrada");
	}
}
