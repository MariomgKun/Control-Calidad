/*Autor: Mario Montes gomez
 * programa que calcula el rango de estimacion de un proyecto
 * Hora iniciada 7:00
 * hora terminada 2:36
 * */
package estimacion;

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
	

	public static void main(String[]arg) throws IOException {
		main nuevo;
		Scanner sn = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
        boolean exit = false;
        int n, num; 
        double xk, t1, t2;
        
        while (!exit) {
		System.out.println("\n1. Insertar datos ");
		System.out.println("2. Realizar operaciones ");
		System.out.println("3. Salida ");
		System.out.println("\nSelecciones una opcion: ");
		
		 try {
			 
             n = sn.nextInt();

             switch (n) {
                 case 1: 
                	 System.out.println("\nCuantos programas son? ");
                	 num = input.nextInt();
                	 insertar.Insertar(num);
                     break;
                 case 2: 
                	//Valor Xk 
                    System.out.println("\n Cual es el valor de Xk:");
                    xk = scanner.nextInt();
                    //Valor t70 y t90
         	        System.out.println(" Cual es el valor de t1:");
         	        t1 = scanner2.nextDouble();
         	        System.out.println(" Cual es el valor de t2:");
         	        t2 = scanner3.nextDouble();
                	 operaciones.Operacion(xk, t1, t2);
                     break;
                 case 3:
                	 System.out.println("Adios (°.°)/");
                     exit = true;
                     break;
                 	default:
                     break;
             }
         } catch (InputMismatchException e) {
             System.out.println("Opcion invalida, seleccione otra opcion...");
             sn.next();
         }
       }

	}
}
