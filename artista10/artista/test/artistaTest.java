/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import artista.Artista;


public class artistaTest {
    
    @Rule       
    public ExpectedException thrown = ExpectedException.none();
    
    //ingresar
    @Test
    public void NotEmptyString() { 
        assertFalse(Artista.Empty("1,Queen"));
        
    }
    
    //Minimo de datos
    @Test
    public void tamMin() 
    {
        assertTrue(Artista.tam("Queen,10,Doors,9,Nirvana,8,Metalica,7,otro,6,,yotro,5"));
    
    }
    
    //10 datos
    @Test
    public void tamMax() 
    {
        assertTrue(Artista.tam("Queen,10,Doors,9,Nirvana,8,Metalica,7,Ashes,6,Starset,5,flow, 4,lisa, 3, aimer, 2, otro,1"));
    }
    
    //Sin nombre
    @Test(expected=RuntimeException.class) 
    public void sinNombre()
    {
    	Artista.tam("1,");
    }
    
    //Mas de 10 datos
    @Test(expected=RuntimeException.class) 
    public void maxNomb()
    {
    	Artista.tam("Doors, 9,Nirvana,8,MEtalica,7,Ashes,6,Starset,5,flow, 4, lisa, 3, aimer, 2, otro, 1, otromas, 0, xdxdxd");
    }
    
    //1 caracter
    @Test
    public void minNombre() 
    {
        assertTrue(Artista.tNom("X"));
    }
    
    //49 caracteres
    
    @Test
    public void maxNom()
    {
        assertTrue(Artista.tNom("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

    //mas de 50 caracteres
    }
   @Test(expected=RuntimeException.class)
    public void maxNom2()
    {
        Artista.tNom("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


    }
    
    //Nombre con numeros
    @Test
    public void numNom() 
    {
        assertTrue(Artista.tNom("Maroon 5"));
        
    }
    
    //menos de 1 ccaracter
    @Test(expected=RuntimeException.class)
    public void minNomc() 
    {
    	Artista.tNom(" ");
    }
    
    //Numeros con caracter
    @Test(expected=RuntimeException.class)
    public void numCaro() 
    {
        Artista.nombreIn("1N");
  
    }
    
    //Numero con espacios
     @Test
    public void EsNumero()
    {
        assertTrue(Artista.num("10"));
        assertTrue(Artista.num(" 9"));
        assertTrue(Artista.num("   9"));
        assertTrue(Artista.num("1 0"));
    }
    
     //Numero entero
     @Test(expected=RuntimeException.class)
     public void numEnt() 
     {
         Artista.nombreIn("1.5");
   
     }
     
     
     //top de mas de 10
     @Test(expected=RuntimeException.class)
     public void top11() 
    {
       Artista.top("11");
       Artista.top("40");

    }
     
    
     //top con menos de 0
     @Test(expected=RuntimeException.class)
     public void numNega() 
    {
       Artista.top("-1");
    }
     
   //el nombre primero
     @Test(expected=RuntimeException.class)
     public void NomEmpty() 
     {
     	Artista.nombreIn("1,Nirvana,2,3");
     }
     
     //orden de numeros
     public void orden() 
     {
        assertTrue(Artista.tam("10,9,8"));
     }
     
     //numeros no ordenados
     @Test(expected=RuntimeException.class)
     public void noOrden() 
     {
    	 Artista.tam("9,10,6");
     }
     //separar comas
     @Test(expected=RuntimeException.class)
     public void coma() 
     {
        Artista.tam("Queen.10");
     }
     //Espacios
     
      public void spacio() 
    {
        assertTrue(Artista.nombreIn("  Queen"));
    
    }
    //Otros caracteres
      @Test(expected=RuntimeException.class)
      public void otroCar() 
      {
          Artista.nombreIn("Qu&e$e/n");
      
      }
}
