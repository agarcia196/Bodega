package clasesBodega;

<<<<<<< HEAD

/**
 * The Class Persona.
 */
public abstract class Persona {
	
	/** The nombre. */
=======
import java.io.Serializable;

public abstract class Persona implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2555601808505230554L;
>>>>>>> 0bd637da95e6616658be632d6951c17166a85ef8
	protected String nombre;
	
	/** The apellido. */
	protected String apellido;
	
	/** The genero. */
	protected String genero;
	
	/** The correo. */
	protected String correo;
	
	/** The cc. */
	protected String cc;
	
	/** The tipo ID. */
	protected String tipoID;
	
	/**
	 * Instantiates a new persona.
	 *
	 * @param nombre the nombre
	 * @param apellido the apellido
	 * @param genero the genero
	 * @param correo the correo
	 * @param cc the cc
	 * @param tipoID the tipo ID
	 */
	public Persona(String nombre, String apellido, String genero, String correo, String cc, String tipoID) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.correo = correo;
		this.cc = cc;
		this.tipoID = tipoID;
	}
	
	/**
	 * Gets the correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Sets the correo.
	 *
	 * @param correo the new correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Gets the genero.
	 *
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	
	/**
	 * Gets the cc.
	 *
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}
	
	/**
	 * Gets the tipo ID.
	 *
	 * @return the tipo ID
	 */
	public String getTipoID() {
		return tipoID;
	}
	
	
	

}
