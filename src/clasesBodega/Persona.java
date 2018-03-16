/**
 * clasesBodega: Recursos.
 *
 * @author Alexis García Ramirez 
 * @author Jeisson Harbey Barrera Sánchez
 * @version 16.3.2018
 * 
 */
package clasesBodega;

import java.io.Serializable;

import Excepciones.BodegaNoExiste;
import Excepciones.ECamposVacios;
import Excepciones.EIgualdad;
import Excepciones.ELetrasEnCampoN;
import Excepciones.ELimiteDeAlmacenamiento;
import Excepciones.ELongitud;
import Excepciones.ETipoInconrrecto;
import Excepciones.ProductoNoEncontrado;

public abstract class Persona implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2555601808505230554L;
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
	public Persona() {}
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
	
	/**
	 * Agregar usuario.
	 *
	 * @param nombre Nombre
	 * @param apellido Apellido 
	 * @param genero Genero 
	 * @param correo Correo 
	 * @param cc the Cédula 
	 * @param tipoid Tipo de documento 
	 * @param pwd Contraseña 
	 * @param cpwd Confirmación de Contraseña
	 * @param cargo Cargo en el sistema
	 * @param empresa Empresa a la que se le realizará el ingreso del usuario
	 * @throws ECamposVacios Todos los campos deben rellenarse
	 * @throws ELongitud La contraseña debe tener mínimo 8 caracteres
	 * @throws EIgualdad Las contraseñas no coinciden
	 * @throws ETipoInconrrecto Tipo de Cuenta no valido
	 */
	public void AddUser(String nombre, String apellido, String genero, String correo, String cc, String tipoid,
			String pwd, String cpwd, String cargo, Empresa empresa) throws ECamposVacios, ELongitud, EIgualdad,ETipoInconrrecto {
	}	
	public void AddProducto(String referencia, String descripcion, String categoria, String marca,
			String volumen, String peso, Empresa empresa)throws ELetrasEnCampoN,ECamposVacios {
		if (referencia.compareTo("")==0 || descripcion.compareTo("")==0 || categoria.compareTo("")==0 
				|| marca.compareTo("") == 0 ||volumen.compareTo("") == 0 || peso.compareTo("")==0) {
			throw new ECamposVacios();
		}else if(Recursos.isNumeric(peso)==false || //comprobar que se ingresen números donde corresponde
				Recursos.isNumeric(volumen)==false) {
			throw new ELetrasEnCampoN();
		}
		else {
			empresa.AddProducto(new Producto(0,referencia,descripcion,categoria, marca,Double.parseDouble(volumen),Double.parseDouble(peso)));
		}
	}
	public void Ingreso(String bodega, String producto, String cantidad ,Empresa empresa) throws NumberFormatException, ProductoNoEncontrado, BodegaNoExiste, ECamposVacios, ELetrasEnCampoN, ELimiteDeAlmacenamiento {
		Bodega bodega_encontrada= empresa.BuscarBodega(bodega);
		Producto producto_encontrado = empresa.BuscarProducto(Integer.valueOf(producto));
		if(bodega.compareTo("")==0 || producto.compareTo("")==0 || cantidad.compareTo("")==0) {
			throw new ECamposVacios();
		}
		else if(Recursos.isNumeric(cantidad)==false) {
			throw new ELetrasEnCampoN();
		}
		else if(bodega_encontrada.getCapacidadMax()<(Integer.valueOf(cantidad))*producto_encontrado.getVolumen()) {
			throw new ELimiteDeAlmacenamiento();
		}
		else {
		bodega_encontrada.addProducto(producto_encontrado, Integer.valueOf(cantidad));
		bodega_encontrada.setCapacidadMax(bodega_encontrada.getCapacidadMax()-Integer.valueOf(cantidad)*producto_encontrado.getVolumen());
		}
	}
}
