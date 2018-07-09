/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ferramentas;

import ClassesBasicas.Ferramenta;

/**
 *
 * @author 17120069
 */
public class BombaNeutrons extends Ferramenta {
    
    private boolean usada;
    
    public BombaNeutrons(){
        
            super("BombaNeutrons");
	    this.usada = false;
    
        }
    
    @Override
	public boolean usar() {
		if (!usada) {
			usada = true;
		}
		return !usada;
	}
    
}



