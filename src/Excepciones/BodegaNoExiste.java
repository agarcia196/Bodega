package Excepciones;

import java.io.Serializable;

public class BodegaNoExiste extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6145912383670872133L;

	public BodegaNoExiste() {
		super ("ID incorrecto o bodega no existe. Verifique nuevamente");
	}
}
