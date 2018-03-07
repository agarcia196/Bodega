package Mi_Parte;

public class User extends Persona{
	private String user;
	private String pwd;
	private String perfil;
	private String tipoferfil;
	
	public User(String nombre, String apellido, String genero, String correo, String cc, String tipoID, String user,
			String pwd, String perfil, String tipoferfil) {
		super(nombre, apellido, genero, correo, cc, tipoID);
		this.user = user;
		this.pwd = pwd;
		this.perfil = perfil;
		this.tipoferfil = tipoferfil;
	}
	
	
	public int acceder(String pwdingresada,String useringresado){
		if(user.compareTo(useringresado)==0 && pwd.compareTo(pwdingresada)==0){
			return 0;
		}else {
			return -1;
		}
	}
	
//	public static void main(String[] args) {
//		User a=new User("Jorge", "Gay", "Hembra", "2ASC@", "3652", "C.C", "YORYO", "2015jorge", "cliente", "cliente0");
//		System.out.println(a.acceder("2015jorge", "YORYO"));
//	}
	
	
}
