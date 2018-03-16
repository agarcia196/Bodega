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
import Excepciones.ECamposVacios;
import Excepciones.EIgualdad;
import Excepciones.ELongitud;
import Excepciones.ETipoInconrrecto;

/**
 * The Class Gerente.
 */
public class Gerente extends Persona implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4139486137342560459L;

	/**
	 * Instancia de un nuevo gerente.
	 *
	 * @param nombre Nombre
	 * @param apellido Apellido
	 * @param genero Genero
	 * @param correo Correo
	 * @param cc Cédula
	 * @param tipoID Tipo de documento
	 * @param pwd Contraseña
	 */
	public Gerente(String nombre, String apellido, String genero, String correo, String cc, String tipoID, String pwd) {
		super(nombre, apellido, genero, correo, cc, tipoID, pwd);
	}
	
	/* (non-Javadoc)
	 * @see clasesBodega.Persona#AddUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, clasesBodega.Empresa)
	 */
	
	@Override
	public void AddUser(String nombre,String apellido,String genero,String correo,String cc,String tipoid,String pwd,String cpwd,String cargo
			,Empresa empresa) throws ECamposVacios,ELongitud,EIgualdad,ETipoInconrrecto {
		if (nombre.compareTo("")==0 ||apellido.compareTo("")==0 || cc.compareTo("")==0 || tipoid.compareTo("")==0 
				|| pwd.compareTo("") == 0 ||cpwd.compareTo("") == 0) {
			throw new ECamposVacios();
		}else if(pwd.length()<8) {
			throw new ELongitud();
		}else if(pwd.compareTo(cpwd)!=0) {
			throw new EIgualdad();
		}else {
			switch (cargo) {
			case "Gerente":
				empresa.AddUser(new Gerente(nombre,apellido,genero,correo,cc,tipoid,pwd));
				break;
			case "Bodeguero":
				
				empresa.AddUser(new Bodeguero(nombre,apellido,genero,correo,cc,tipoid,pwd));
				break;
			default:
				throw new ETipoInconrrecto();
			}
		}

	}
}
