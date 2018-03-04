package clasesBodega;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Recursos {
	
	
	
	
	//Escribir Fichero
	public void EscribirFichero(String fichero, Empresa emp) throws FileNotFoundException, IOException {
		FileOutputStream fos  = new FileOutputStream(fichero); //cargar archivo
		ObjectOutputStream oos =new ObjectOutputStream(fos);//utilizar archivo
		oos.writeObject(emp);
		oos.close();
	}
	//Leer fichero
		public void LeerFichero(String fichero)throws FileNotFoundException,IOException,ClassNotFoundException {
			FileInputStream fis = new FileInputStream(fichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Empresa e= (Empresa) ois.readObject();
			ois.close();	
		}
}
