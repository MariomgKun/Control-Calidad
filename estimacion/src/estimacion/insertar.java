package estimacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class insertar {
	public static void Insertar(int num) throws IOException {	
		if(num > 0) {
			System.out.println("Correcto...");
			    //Creamos dos archivos para almacenar los LOC de XI y Yi
				    try {
				    	PrintWriter px = new PrintWriter("xi.txt");
				    	PrintWriter py = new PrintWriter("yi.txt");
				    	//pw.println(texto);
				    	System.out.println("\n Se han creado los archivos...");
				    	
				    	//Pregunatamos el total de programas a insertar 
				        Scanner scanner = new Scanner(System.in);
				        
				        String x = "" ;
				        String y = "" ;
				        int cont = 0, i = 1, a,b;
				        	
				        while(cont<num){
				        	//Insertamos los valores de Xi y Yi
				        		
					            System.out.println("\nPrograma "+i+"  Ingresa el LOC Xi: ");
					            x = scanner.next();
					            a = Integer.parseInt(x);
					            System.out.println("\nPrograma "+i+"  Ingresa el LOC Yi: ");
					            y = scanner.next();
					            b = Integer.parseInt(y);
					            
					            if(a > 0) {
					            	System.out.println("Corecto el valor de Xi");
						            
					            	if(b > 0) {
						            	System.out.println("Corecto el valor de Yi");
					            
							            px.write(x);
							            py.write(y);
							            cont++;
							            px.println();
							            py.println();
							            i++;
							            //Muestra el valor de Xi y Yi
							            System.out.println("|Xi: "+x+"| Yi: "+y+" |");
					            	}else {
						            	System.out.println("El valor de Yi debe ser un numero entero mayor a 0");
						            }
					            }else {
					            	System.out.println("El valor de Xi debe ser un numero entero mayor a 0");
					            }
					            
					        
				        	System.out.println("/////////////////////////");
				        	
				        }
				        System.out.println("\n Se ha insertado correctamente...");
				        
				        px.close();
			        	py.close();
				        
				    }catch(Exception err) {
				    	System.out.println("No se pudo crear el archivo");
				    }
		}else {
			System.out.println("Debe insertar un numero entero mayor a 0");
		}
		    
	}
}
