package test;

public class ConnaitreLeType {

	public static void main(String[] args) {
		String chaine = new String();
		Integer nombre = 32;
		
		Object classe = chaine.getClass().getSimpleName();
		System.out.println(classe);
		
		Object type_du_nombre = nombre.getClass().getSimpleName();
		System.out.println(type_du_nombre);
		
		if(chaine instanceof String) {
			System.out.println("C'est une chaine");
		}
	
	
		
	}
}
