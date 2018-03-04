/**
 * clasesBodega: Empresa.
 *
 * @author Alexis García Ramirez 
 * @author Jorge Luis Soriano Cuevas
 * @version 2.3.2018
 */
package clasesBodega;

import java.util.Arrays;

public class Empresa {
	private Producto[] productos;
	private Bodega [] bodegas;
	private User [] usuarios;
	private String [] categoria;
	private String nombre;
	private String logo;
	
	/** 
	 * Constructor
	 * @param nombre de la empresa
	 * @param logo ruta de acceso de el logo de la empresa
	 */
	
	public Empresa(String nombre,String logo) {
		super();
		this.productos = new Producto[0];
		this.bodegas = new Bodega [0];
		this.usuarios = new User [0];
		this.categoria = new String [0];
		this.nombre = nombre;
		this.logo=logo;
	}
	
	public Empresa() {
		
	}
	
	public Bodega[] getBodegas() {
		return bodegas;
	}

	public void setBodegas(Bodega[] bodegas) {
		this.bodegas = bodegas;
	}

	public User[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(User[] usuarios) {
		this.usuarios = usuarios;
	}
	public String[] getCategoria() {
		return categoria;
	}
	public void setCategoria(String[] categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Producto[] getProductos() {
		return productos;
	}
	public void AddProducto(int sku,String referencia, double volumen, double peso, String descripcion,String catego) {
		if(productos==null)
			productos=new Producto[1];
		else 
			productos=Arrays.copyOf(productos,productos.length+1);
		productos[productos.length-1]= new Producto(sku, referencia, volumen, peso,descripcion,catego,0);
	}
	public Producto BuscarProducto(int codigo)throws ProductoNoEncontrado {
		int i=0;
		while (i<productos.length && productos[i].getSku()!=codigo) {
			i++;
		}
		if(i==productos.length)
			throw new ProductoNoEncontrado();
		else 
			return productos[i];
	}
	public void AddCategoria(String categ) {
		if(categoria==null)
			categoria=new String[1];
		else 
			categoria=Arrays.copyOf(categoria,categoria.length+1);
		categoria[categoria.length-1]= categ;
	}
	public String BuscarCategoria(String categ)throws CategoriaNoEncontrada {
		int i=0;
		while (i<categoria.length && categoria[i]!=categ) {
			i++;
		}
		if(i==categoria.length)
			throw new CategoriaNoEncontrada();
		else 
			return categoria[i];
	}
	public void  Ingreso (String bodega, int sku, int cantidad) {
		Bodega b = BuscarBodega(bodega);
		Producto p = BuscarProducto(sku);
		if(b==null || p==null || cantidad<0) {
			throw new DatosInsuficientes();
		}else {
			b.AddProducto(p,cantidad);		
		}
	}
	//Agregar bodega	
	public void AddBodega(String IDBodega, String direccion, String ciudad, int capMaxima) {
		Bodega bodega1 = Bodega();
		if (bodegas==null)
			bodegas = new bodegas[1];
		else 
			bodegas = Arrays.copyOf(bodegas, bodegas.length+1);
		bodegas [bodegas.length-1]= bodega1;
	}

	//Buscar bodega
	public Bodega BuscarBodega(String IDBodega) throws BodegaNoExiste{
		int i=0;
		while (i<bodegas.length && bodegas[i].getIDBodega().compareTo(IDBodega)!=0) {
			i++;	
		}
		if (i==bodegas.length) {
			throw new BodegaNoExiste();
		}
		else return bodegas[i];
	}

	//Agregar Usuario
	public void AddUser(String nombre, String apellido, String genero, String correo, String CC, String tipoID,
			String user, String pwd, String perfil, String tipoPerfil) {
		User usuario1=new User(nombre,apellido,genero,correo,CC,tipoID,user,pwd,perfil,tipoPerfil);
		if(usuarios==null)
			usuarios = new usuarios[1];
		else
			usuarios= Arrays.copyOf(usuarios, usuarios.Length+1);
		usuarios[usuarios.Length-1]=usuario1;
	}
	//Buscar Usuario por User
	public User BuscarUser(String user) throws UserNoExiste{
		int i=0;
		while (i<usuarios.Length && usuarios[i].getUser().compareTo(user)!=0) {
			i++;
		}
		if (i==usuarios.Length-1)
			throw new UserNoExiste();
		else return usuarios[i];
	}	
	//Validar Usuario
	public void ValidarUser(String user, String pwd) throws PwdIncorrecta {
		if (BuscarUser(user).Acceder(user, pwd)==(-1)) {
			throw new PwdIncorrecta();
		}
		else
			System.out.println("ingresando...");
	}
	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}
	public class BodegaNoExiste extends Exception{
		public BodegaNoExiste() {
			super ("ID incorrecto o bodega no existe. Verifique nuevamente");
		}
	}
	public class UserNoExiste extends Exception{
		public UserNoExiste() {
			super("User incorrecto o no existe. Verifique nuevamente");
		}
	}
	public class PwdIncorrecta extends Exception{
		public PwdIncorrecta() {
			super("Contraseña o usuario incorrectos, verifique nuevamente");
		}
	}
	public class DatosInsuficientes extends Exception{
		public DatosInsuficientes() {
			super("Datos incompletos");
		}
	}
	public class ProductoNoEncontrado extends Exception{
		public ProductoNoEncontrado() {
			super("Producto no encontrado");
		}
	}
	public class CategoriaNoEncontrada extends Exception{
		public CategoriaNoEncontrada() {
			super("Categoria no encontrada");
		}
	}
}

