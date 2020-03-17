package reales;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class main {
	
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
		        	for(int i=1 ; i<=num ; i++) {
		            System.out.println("\n"+i+"- Ingresa un numero: ");
		            text = scanner.next();
		            pw.write(text);
		            cont++;
		            pw.println();
		        	}
		        }
		        System.out.println("\n Se ha insertado correctamente...");
		        pw.close();
		        
		    }catch(Exception err) {
		    	System.out.println("No se pudo crear el archivo");
		    }
	}
	
	
	public static void Lectura() throws IOException{
		operaciones.formulas();
	}
	
	
	public static void main(String[]arg) throws IOException{
		main nuevo;
		Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int n; 
        
        while (!exit) {
		System.out.println("\n1. Escritura ");
		System.out.println("2. Lecutra ");
		System.out.println("3. Salida ");
		System.out.println("\nSelecciones una opcion: ");
		
		 try {
			 
             n = sn.nextInt();

             switch (n) {
                 case 1: Escritura();
                     break;
                 case 2: Lectura();
                     break;
                 case 3:
                	 System.out.println("Adios (°.°)/");
                     exit = true;
                     break;
                 	default:
                     
             }
         } catch (InputMismatchException e) {
             System.out.println("Opcion invalida, seleccione otra opcion...");
             sn.next();
         }
       }
		
	}

}
