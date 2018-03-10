package clasesBodega;

import java.io.*;

public class Gerente extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4139486137342560459L;

	public Gerente(String nombre, String apellido, String genero, String correo, String cc, String tipoID, String pwd) {
		super(nombre, apellido, genero, correo, cc, tipoID, pwd);
	}
	

}
