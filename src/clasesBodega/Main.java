/**
 * clasesBodega: Main.
 *
 * @author Alexis García Ramirez 
 * @version 4.3.2018
 */
package clasesBodega;

import java.io.File;
import java.io.Serializable;

import formsBodega.FormLogin;
import formsBodega.FormPrincipalLogin;

public class Main implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2011284214684701444L;

	/**
	 * El método main .
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		File file = new File("empresa.dat");
		if(file.exists()) {
			Empresa empresa = new Empresa();
			empresa = Recursos.ReadFileObjectEmpresa("empresa.dat");
			FormLogin inicio = new FormLogin(empresa);
			inicio.setVisible(true);
		}else {
			Empresa empresa = new Empresa();
			FormPrincipalLogin principal = new FormPrincipalLogin();
			principal.setVisible(true);
		}
	}

}
