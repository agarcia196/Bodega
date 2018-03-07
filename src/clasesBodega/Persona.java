package Mi_Parte;

public abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected String genero;
	protected String correo;
	protected String cc;
	protected String tipoID;
	public Persona(String nombre, String apellido, String genero, String correo, String cc, String tipoID) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.correo = correo;
		this.cc = cc;
		this.tipoID = tipoID;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
