/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salas;

import ClassesBasicas.Sala;
import Ferramentas.Lanterna;
import Ferramentas.PistolaLaser;

import java.util.Scanner;

/**
 *
 * @author Henrique
 */
public class HallEntrada extends Sala {

    public HallEntrada() {
        super("HallEntrada");
        Lanterna lanterna = new Lanterna();
        PistolaLaser pistolaLaser = new PistolaLaser();
        this.getFerramentas().put(lanterna.getDescricao(), lanterna);
        this.getFerramentas().put(pistolaLaser.getDescricao(), pistolaLaser);
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta no ").append(this.getNome()).append("\n");
        descricao.append("Parece uma sala completamente vazia. Há duas portas, uma a direita e outra a esquerda\n");
        descricao.append("se ainda não pegou, pegue a suas\n");
        descricao.append("PistolaLaser e sua Lanterna se ainda estiverem na nave\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }

    @Override
    public boolean usa(String ferramenta) {
        return false;
    }
    
     @Override
    public boolean pega(String nomeFerramenta) {
        boolean ok = super.pega(nomeFerramenta);
        if (ok) {
            this.getFerramentas().remove(nomeFerramenta);
            return true;
        }
        return false;
    }
    
    Scanner in = new Scanner(System.in);

}
