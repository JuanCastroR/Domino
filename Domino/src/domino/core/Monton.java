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
public class Monton {
	private Ficha[] montonFichas;
	private int numFich; 
	
	public Monton()
	{
		montonFichas = new Ficha[28];
		numFich = 0;
		echarFichasMonton();
		
	}
	
	private void echarFichasMonton()
	{
		int indice = 0;
		for (int der = 0; der <= 6; der++)
			for (int izq = 0; izq <= der; izq++)
			{
				montonFichas[indice++] = new Ficha(izq,der);
				numFich++;
			}
				
	}
	
	public Ficha sacarFichaMonton(int i)
	{ 
		Ficha f = null;
		
		f = montonFichas[i];
		montonFichas[i] = montonFichas[numFich-1];
                montonFichas[numFich-1]=null;
		numFich --;
		return f;	
	}
	
	public int getNumFich()
	{
		return numFich;
	}

}

