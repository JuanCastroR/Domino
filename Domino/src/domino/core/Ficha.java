/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.core;

/**
 *
 * @author Rosalia
 */
public class Ficha {
	private int derecha;
	private int izquierda;
	
	public Ficha(int i, int d)
	{
		derecha = d;
		izquierda = i;
		
	}
	
	public int getDerecha()
	{
		return derecha;
	}
	
	public int getIzquierda()
	{
		return izquierda;
	}
        
        public void girar(){
            int aux = derecha;
            derecha = izquierda;
            izquierda=aux;
        }
	
        @Override
	public String toString()
	{
		return "["+izquierda+":"+derecha+"]";
	}
	
        @Override
	public boolean equals(Object f)
	{
            
		if (((Ficha)f).derecha == derecha && ((Ficha)f).izquierda == izquierda) return true;
		else return false;
	}

}

