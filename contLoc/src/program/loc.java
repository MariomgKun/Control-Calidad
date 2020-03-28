/*
 * Este es un programa que cuenta las lineas de codigo java
 * Mostrara los archivos java dentro de la ruta especificada y el total de lineas
 * Autor: Mario Montes Gomez
 */
package program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loc {
	
	
	/*
	 * Se recibe la ruta en donde se encuentran los archivos .java
	 * Se calculan la lineas de codigo
	 */
	public int ContadorLineasLOC(String ruta) {
		/*Creo el directorio donde se encuentran las clases y un array con sus nombre*/
		File directorio = new File(ruta);
		String [] archivos = directorio.list();
		
		int tamañoPrograma = 0;
		int cantidadArchivos = archivos.length;
		
		for(int i=0; i < cantidadArchivos; i++) {
			try {
				/*
				 * Creo el FileReader para leer la lineas
				 */
				FileReader fr = new FileReader(ruta + archivos[i]);
				BufferedReader br = new BufferedReader(fr);
				
				int contadorLineas = 0;
				int contadorMetodos = 0;
				
				String linea = br.readLine();
				while(linea != null) {
					linea = linea.trim();
					
					/*condiicones a ignorar*/
					boolean con1 = linea.startsWith("/*"); 
					boolean con2 = linea.startsWith("*");
					boolean con3 = linea.startsWith("*/");
					boolean linVacia = (linea.length() == 0);
					
					if(!(con1 || con2 || con3 || linVacia)) {
						contadorLineas++;
						
						/*identificamos como inician los metodos*/
						Pattern patron = Pattern.compile("^((public|private)?( )?(static)?( )?\\w+ \\w+\\()");
						Matcher matcher = patron.matcher(linea);
	
						boolean metodo = matcher.find();
				        if(metodo) {
				        	contadorMetodos++;
				        }
					}
					
					linea = br.readLine();
				}
				System.out.println("\nNombre del archivo: " + archivos[i]);
				System.out.println("Total de lineas: "+contadorLineas);
				
				tamañoPrograma = tamañoPrograma + contadorLineas;
				br.close();
			}
			catch (IOException e) {
		        e.printStackTrace();
		        System.out.println("exception");
		    }
		}
		return tamañoPrograma;
	}

}
