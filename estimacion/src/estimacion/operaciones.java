package estimacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class operaciones {
	
	public static void Operacion(double xk, double t1, double t2) throws IOException {	
		
			if(xk > 0) {
				System.out.print("\nCorrecto el valor de Xk...");
				if(t1 != 0) {
					System.out.print("\nCorrecto el valor de t1...");
					if(t1 != 0) {
						System.out.print("\nCorrecto el valor de t2...\n");	
					
					//variables
					double f1=0,f2=0,f3=0,f4=0,f5=0,f6=0,f7=0,f8=0,f9=0, f10=0;
					double f11=0,f12=0,f13=0,f14=0,f15=0,f16=0,f17=0,f18=0,f19=0;
					double  yk=0, B0=0, B1=0, desviEst=0, varianza=0, num=0;
					double   ran1=0, ran2=0, max1=0, min1=0, max2=0, min2=0;
					
					Scanner scanner = new Scanner(System.in);
					Scanner scanner2 = new Scanner(System.in);
					Scanner scanner3 = new Scanner(System.in);
					
					//Xk
			        
			        /*Leemos el archivo para seguir calculando*/
					String contS;
					int xi = 0, yi = 0;
					
					//Variables de SUM y AVERAGE
					double sumX = 0;
					double avgX = 0;
					double sumY = 0;
					double avgY = 0;
			        
			
				        /**************************************************/
						try {
							FileInputStream fstream1 = new FileInputStream("xi.txt");
							FileInputStream fstream2 = new FileInputStream("yi.txt");
							BufferedReader r1 = new BufferedReader(new InputStreamReader(fstream1));
							BufferedReader r2 = new BufferedReader(new InputStreamReader(fstream2));
					
							String Line1;
							String Line2;
							//Convertimos las lineas de texto en int
							while ((Line1 = r1.readLine()) != null)   {
							  xi= Integer.parseInt(Line1);
							  while ((Line2 = r2.readLine()) != null)   {
								  yi= Integer.parseInt(Line2);
								//Sacamos la SUM Y
									sumY += yi;
								}
				
							  //Sacamos la SUM X
							  sumX += xi;
							  num++;
							}
							//sacamos el valor de AVG X y Y
							avgX = sumX / 10;
							avgY = sumY / 10;
							
							//Calculamos -> NXavgYavg
							f1 = num * avgX * avgY;
							
							
							int x = 0 ;
							int y = 0;
							
							/**************************************************/
							try {
							//calculamos -> XiYi
							Scanner archivo = null;
							Scanner archivo2 = null;
							FileInputStream fstream3 = new FileInputStream("xi.txt");
							FileInputStream fstream4 = new FileInputStream("yi.txt");
							archivo = new Scanner(new File( "xi.txt"));
							archivo2 = new Scanner(new File("yi.txt"));
							
							while(archivo.hasNext()) {
								x= archivo.nextInt();
								while(archivo2.hasNext()) {
									y = archivo2.nextInt();
									f2 = x * y;
									//System.out.println(x+" * "+y+" f2 "+f2);
									//hacemos la sumatoria -> SUMXiYi
									f3 += f2;
									
									//calculamos -> SUMXi^2
									f6 += Math.pow(x, 2);
									
									//calculamos SUM(Yi - B0 - B1Xi)^2
									x = archivo.nextInt();
								}
				
							}
							fstream3.close();
							fstream4.close();
							}catch(Exception err) {
								//System.out.println("No se encontro el archivo...");
							}
							/**************************************************/
							
							//Calculamos -> SUMXiYi - NXavgYavg
							f4 = f3 - f1 ;
							
							//Calculamos -> NXavg^2
							f5 = num * (Math.pow(avgX, 2));
							
							//Calculamos -> SUMXi^2 - NXavg
							f7 = f6 - f5;
							
							//Calculamos -> 1 / n-2
							double a = num - 2 ;
							f8 = 1 / a;
							
							//Calculmaos B0, B1, Yk
							B1 =  f4 / f7;
							B0 = avgY - B1 * avgX;
							yk = B0 + B1 * xk;
							
							/**************************************************/
							try {
								//calculamos -> SUM(Yi - B0 - B1Xi)^2
								Scanner archivoa = null;
								Scanner archivob = null;
								FileInputStream fstreama = new FileInputStream("xi.txt");
								FileInputStream fstreamb = new FileInputStream("yi.txt");
								archivoa = new Scanner(new File( "xi.txt"));
								archivob = new Scanner(new File("yi.txt"));
								
								while(archivoa.hasNext()) {
									x= archivoa.nextInt();
									while(archivob.hasNext()) {
										y = archivob.nextInt();
										f9 += Math.pow( (y - B0 - (B1*x)) , 2);
										
										//calculamos SUM(XiXavg)^2
										f10 += Math.pow( (x - avgX) , 2);
										x = archivoa.nextInt();
									}
				
								}
								fstreama.close();
								fstreamb.close();
								}catch(Exception err) {
									//System.out.println("No se encontro el archivo...");
								}
							/**************************************************/
							
							//Calculamos la varianza y la desviacion estandar
							varianza = f8 * f9;
							desviEst = Math.sqrt(varianza);
							
							//Calculamos -> (xk - Xavg)^2
							f11 = Math.pow( (xk - avgX) , 2);
							
							//Calculamos 1 + 1 / n
							double b = 1 /num;
							f12 = 1 + b;
							
							//Calculamos 1 + 1/n + (Xk-Xavg)^2 / SUM(Xi-Xavg)^2
							f13 = f12 + (f11/f10);
							
							//Calculamos RAIZ( 1 + 1/n + (Xk-Xavg)^2 / SUM(Xi-Xavg)^2)
							f14 = Math.sqrt(f13);
							
							//t1 y t2
							
					        //Calculamos el rango 1 y rango 2
					        ran1 = t1 * desviEst * f14;
					        ran2 = t2 * desviEst * f14;
					        
					        //Calculamos maximos y minimos
					        max1 = yk + ran1;
					        min1 = yk - ran1;
					        max2 = yk + ran2;
					        min2 = yk - ran2;
							
							//Probamos los valores
							/*System.out.println("SUM X "+sumX);
							System.out.println("SUM Y "+sumY);
							System.out.println("AVG X "+avgX);
							System.out.println("AVG Y "+avgY);*/
					        //Mostramos los valores
					        System.out.println("/////////////////////////////////////////");
							System.out.println("rango 1: "+ran1);
							System.out.println("min: "+min1);
							System.out.println("max: "+max1);
							
							System.out.println("/////////////////////////////////////////");
							
							System.out.println("rango 2: "+ran2);
							System.out.println("min: "+min2);
							System.out.println("max: "+max2);
							System.out.println("/////////////////////////////////////////");
							
							//Close the input stream
							fstream1.close();
							fstream2.close();
							/**************************************************/
							
						}catch(Exception err) {
					    	System.out.println("No se encontraron los archivos");
					    	System.out.println("////////////////////////////");
					    }
						
					}else {
						System.out.print("El valor de t2 debe ser diferente de 0...");
					}
				}else {
					System.out.print("El valor de t1 debe ser diferente de 0...");
				}
			}else {
				System.out.println("El valor de Xk debe ser un valor entero mayor 0...");
			}
			
		}
}
