package reales;

import reales.lista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class operaciones {
	static double MediaF;
    static double VarianzaF;
    static double DesviacionF;
    
	public static void formulas() {
		
		Scanner leer = new Scanner(System.in);
		Scanner archivo = null;
		Scanner archivo2 = null;
		String cadena;
	    System.out.print("Ingrese el nombre del archivo: ");
	    cadena = leer.nextLine();
	    
		try{
			FileInputStream fstream = new FileInputStream(cadena + ".txt");
			archivo = new Scanner(new File(cadena + ".txt"));
			archivo2 = new Scanner(new File(cadena + ".txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	
			String Line;
	
			while ((Line = br.readLine()) != null)   {
				System.out.println (Line);
			}
			
			double num= 0;
			double num2= 0;
			double sum= 0;
			double sum2= 0;
			double count=0;
			double x=0;
			double media;
			double varianza;
			while(archivo.hasNext()) {
				num= archivo.nextInt();
				sum += num;
				count ++;
			}
			media= sum / count;
			
			while(archivo2.hasNext()) {
				num2= archivo2.nextInt();
				x= Math.pow((num2 - media),2);
				sum2 += x;
				//count ++;
			}
			varianza = sum2 / count;
			
			System.out.println("La media es: "+ media);
			System.out.println("La varianza es: "+ varianza);
			//Close the input stream
			fstream.close();
		}catch(Exception err) {
			System.out.println("No se encontro el archivo...");
		}
	
		
	}
}
