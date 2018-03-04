/**
 * clasesBodega: Main.
 *
 * @author Alexis García Ramirez 
 * @version 4.3.2018
 */
package clasesBodega;

import java.io.File;

import formsBodega.FormLogin;
import formsBodega.FormPrincipal;

public class Main {

	/**
	 * El método main .
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("empresa.dat");
		if(file.exists()) {
			Empresa empresa = new Empresa();
			empresa = Recursos.ReadFileObjectEmpresa("empresa.dat");
			FormLogin inicio = new FormLogin(empresa);
			inicio.setVisible(true);
		}else {
			Empresa empresa = new Empresa();
			FormPrincipal principal = new FormPrincipal(empresa);
			principal.setVisible(true);
		}
	}

}
