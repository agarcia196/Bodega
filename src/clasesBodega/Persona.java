/**
 * clasesBodega: Recursos.
 *
 * @author Alexis García Ramirez 
 * @author Jeisson Harvey Barrera Sanchez
 * @version 9.3.2018
 * 
 */
package clasesBodega;

public abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected String genero;
	protected String correo;
	protected String cc;
	protected String tipoID;
	protected String pwd;
	
	/**
	 * Instantiates a new persona.
	 *
	 * @param nombre Nombre de la persona
	 * @param apellido el apellido
	 * @param genero el genero
	 * @param correo el correo
	 * @param cc Numero de cedula
	 * @param tipoID el tipo cedula
	 * @param pwd la contraseña
	 */
	public Persona(String nombre, String apellido, String genero, String correo, String cc, String tipoID, String pwd) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.correo = correo;
		this.cc = cc;
		this.tipoID = tipoID;
		this.pwd = pwd;
	}
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getGenero() {
		return genero;
	}
	public String getCc() {
		return cc;
	}
	public String getTipoID() {
		return tipoID;
	}	
	
}
