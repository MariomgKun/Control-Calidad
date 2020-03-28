/*
 * clase main en donde se ejecutan los metodos
 */
package program;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class main {
	
	public static void main(String[] args) {
		try {
			System.out.print("Escriba la ruta en donde estan sus archivos .java (no agregue el nombre del archivo, y la ruta termina en / ): ");
			
			InputStreamReader lectura = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(lectura);
			String ruta = br.readLine();
			
			boolean rutaCorrecta = ruta.endsWith("/");
			
			if(rutaCorrecta) {
				loc locn = new loc();
				int programa = locn.ContadorLineasLOC(ruta);
				
				System.out.println("\nTotal de lineas del proyecto: "+programa);
				System.out.println("\nEso es todo...");
			}
			else {
				System.out.println("\nLa ruta no es correcta, debe de terminar en \"/\" (ej. c:/ejemplo/ )...");
			}
		}
		catch(final Exception e){
			e.printStackTrace();
			System.out.println("exception");
		}
	}


}
