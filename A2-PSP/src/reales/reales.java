package reales;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class reales {
	public static void Escritura() throws IOException{
		Scanner leer = new Scanner(System.in);
		String cadena;
	    System.out.print("Ingrese el nombre del archivo: ");
	    cadena = leer.nextLine();
	    //String texto= "prueba";
	    
		    try {
		    	PrintWriter pw = new PrintWriter(cadena + ".txt");
		    	//pw.println(texto);
		    	System.out.println("\n Se ha creado el archivo...");
		    	
		    	Scanner input = new Scanner(System.in);
		        Scanner scanner = new Scanner(System.in);
		        System.out.println("\nCuantos numeros quiere insertar? ");
		        int num = input.nextInt();
		        int cont = 0;
		        String text = "" ;
		        	
		        while(cont<num){
		            System.out.println("\nIngresa un numero: ");
		            text = scanner.next();
		            pw.write(text);
		            cont++;
		            pw.println();
		        }
		        System.out.println("\n Se ha insertado correctamente...");
		        pw.close();
		        
		    }catch(Exception err) {
		    	System.out.println("No se pudo crear el archivo");
		    }
	}
	
	public static void Lectura() throws IOException{
		Scanner leer = new Scanner(System.in);
		String cadena;
	    System.out.print("Ingrese el nombre del archivo: ");
	    cadena = leer.nextLine();
	    
		try{
			FileInputStream fstream = new FileInputStream(cadena + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	
			String Line;
	
			while ((Line = br.readLine()) != null)   {
			  System.out.println (Line);
			}
			//Close the input stream
			fstream.close();
		}catch(Exception err) {
			System.out.println("No se encontro el archivo...");
		}
	}
	
	public static void main(String[]arg) throws IOException{
		reales nuevo;
		int n=0;
		Scanner scan = new Scanner (System.in);
		System.out.println("1. Lectura ");
		System.out.println("2. Escritura ");
		System.out.println("Selecciones una opcion: ");
		
		do {
	        switch (n= scan.nextInt()) {
	        case 1:
	        	reales.Lectura();
	          break;
	        case 2:
	        	reales.Escritura();
	        	break;
	        default:
                System.out.println("Opcion invalida...");
	      }
		}while (n!=2);
		
	}
	
	
    
}
