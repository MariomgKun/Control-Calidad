/*
 * Autor: Mario Montes Gomez
 * clase main en donde se ejecutan los metodos
 */
/* Añadi la lectura de un archivo txt para comparar lineas modificadas, eliminadas, o agregadas
 * Añadi la escritura de un archivo txt para insertar el total del LOC y comparar
 * Tambien se mostrara el archivo txt, de ese muestra igual las lineas y metodos, 
 * pero no los cuenta para el LOC
 * 
 * puede ir a la linea 41 a 93 para ver lo que agregue
 * puede eliminar la linea 90 para comprobar que se elimino, 
 * despues la vuelve a agregar y comprobar que se agrego,
 * nuevamente compruebe y vera que sigue igual
 * */
package program;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


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
				System.out.println("////////////////////////////");
				String locS="";
		        locS= Integer.toString(programa);
				
		      //leemos el fichero LOC.txt para comparar las lineas
				String contS;
				int cS;
				try {
					FileInputStream fstream = new FileInputStream(ruta + "LOC1.txt");
					BufferedReader rr = new BufferedReader(new InputStreamReader(fstream));
			
					String Line;
					//Convertimos las lineas de texto en int
					while ((Line = rr.readLine()) != null)   {
					  cS= Integer.parseInt(Line);
					//Comparamos si se modificaron lineas
						if(cS == programa) {
							System.out.println("Lineas modificadas= 0");
						}
						//comparamos si se eliminaron lineas
						if(cS > programa) {
							int elim = cS - programa;
							System.out.println("Lineas eliminadas= "+elim);
						}
						else {
							System.out.println("Lineas eliminadas= 0");
						}
						//comparamos si se agregaronn lineas
						if(cS < programa) {
							int modi = programa - cS; 
							System.out.println("Lineas agregadas= "+modi);
						}else {
							System.out.println("Lineas agregadas= 0");
						}
					}
					
					
					//Close the input stream
					fstream.close();
				}catch(Exception err) {
			    	System.out.println("No se pudo encontrar el archivo para comparar, por lo que es nuevo el LOC");
			    	System.out.println("////////////////////////////");
			    }
		        
		        
				//Creamos un archivo para guardar el LOC
				try {
					FileWriter fw= new FileWriter(ruta+"LOC1.txt");
					fw.write(locS);
					System.out.println("Se ha creado un archivo nuevo...");
					//Esta linea la puede eliminar y volver a poner para probar el codigo
					//mostrara las lineas eliminadas, agregadas o modificadas.
					System.out.println("////////////////////////////");
					fw.close();
				}catch(Exception err) {
			    	System.out.println("No se pudo crear el archivo");
			    }
				
				
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
