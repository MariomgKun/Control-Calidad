/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artista;

import java.util.regex.Pattern;

public class Artista {

   String art;
   int [] posicion = new int[9];
    
   public static Boolean Empty(String array)
    {    
        if(array.isEmpty())
            throw new RuntimeException("Ingrese el numero del top...");
        else
            return false;
    }
    
    
    public static Boolean tam(String array)
    {
        String [] des;
        des = array.split(",");
        if(des.length > 10  && des.length <= 20 )
            return true;
        else
             throw new RuntimeException("Debe tener cinco posiciones al menos");
    }
    
    
    public static Boolean tNom(String nombre)
    {
        nombre = nombre.replace(" ", "");
        if(nombre.length() >= 1 && nombre.length() <= 50)
            return true;
        else
            throw new RuntimeException("El nombre debe ser de 1 a 50 caracteres...");
    }
   
    public static Boolean nombreIn(String array)
    {
    	 String [] des;
         des = array.split(",");
         char ne2 = des[0].charAt(1);
         //int  nes= descomp[0].length();
         if(tNom(des[0]) && Character.isDigit(ne2))
         {
             return true;
         }
         else
         {
             throw new RuntimeException("Primero se debe ingresar el nombre (debe ser alfanumerico)... ");
         }
    }
    
    
      public static Boolean num(String val)
    {
        val = val.replace(" ", "");
        try {
        	
                    Integer.parseInt(val);
                    return true;
            }
            catch(Exception e)
            {
                    return false;	
            }
    }
      
    
    public static Boolean top(String val)
    {
        if(Integer.parseInt(val)>= 1 && Integer.parseInt(val)<= 10)
            return true;
        else
             throw new RuntimeException("Esto es un top 10...");
    }
    
    
       public static Boolean t3(String [] t2)
    {
        int aux = Integer.MIN_VALUE;
        for(int i = 0; i < t2.length; i++)
        {
            if(aux > Integer.parseInt(t2[i]))
            {
                aux =  Integer.parseInt(t2[i]);
            }
            else
            {
                  throw new RuntimeException("El top se ingresa de forma descendente (del 10 al 1)...");
            }
        }
        return true;
    }
       
    Artista(String array)
    {
        array = array.replace(" ", "");
        if(!Empty(array) && tam(array) && nombreIn(array)){
             String [] n2;
             n2 = array.split(",");
             String [] t2 = new String[n2.length - 1];
             for(int i = 1; i < n2.length; i++)
             {
                 if(num(n2[i]) && top(n2[i]))
                 {
                    t2[i-1] = n2[i]; 
                 }
             }
             
             if(t3(t2))
             {
                 art = n2[0];
                 System.out.println("La posicion: " + n2[0] );
                 for(int w = 0; w < t2.length ; w++)
                 {
                     int n = w + 1;
                      System.out.println("-Artista "+ n +" es: "+t2[w]+" " );
                      posicion[w] = Integer.parseInt(t2[w]);
                 }
             }
        }
    }
    
}
