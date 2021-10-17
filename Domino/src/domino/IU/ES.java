/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.IU;

import java.util.Scanner;

/**
 *
 * @author Rosalia
 */
public class ES
{
    public static Scanner leer = new Scanner(System.in);
    
    public static String pideCadena(String mensaje)
    {
         // Poner el mensaje
            System.out.print(mensaje);
               
             // Pedir
            return leer.nextLine();
               
    }
    
        
    public static int pideNumero(String mensaje)
    {
        
            System.out.print(mensaje);

            // Pedir
            return Integer.parseInt(leer.nextLine());
       
    }
}


