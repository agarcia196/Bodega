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
	public static Empresa ReadFileObjectEmpresa(String archivo) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		Empresa empresa = new Empresa();
		try {
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				Empresa emp = (Empresa) ois.readObject();
				empresa= emp;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problemas con la ruta para leer el fichero");
		} catch (IOException e) {
			System.out.println("El fichero tiene problemas para ser leido");
		} catch (ClassNotFoundException e) {
			System.out.println("Problema al leer fichero");
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				System.out.println("El fichero tiene problemas al leerlo");
			}
		}
		if (empresa==null) {
			return null;
		} else {
			return empresa;
		}
	}
	
}
