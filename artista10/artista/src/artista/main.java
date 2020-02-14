/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artista;
import java.util.Scanner;

/**
 *
 * @author moviles
 */
public class main {
    public static void main(String[] args) {
        String Nom;
        System.out.print("Ingresa el top 10 de Artistas: ");
        Scanner Scn = new Scanner(System.in);
        Nom = Scn.nextLine();
       Artista elartista = new Artista(Nom);
    }
    
}
