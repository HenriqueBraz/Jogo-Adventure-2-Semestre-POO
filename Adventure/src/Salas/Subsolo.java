/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import Ferramentas.BombaNeutrons;
import Ferramentas.Lanterna;
import Ferramentas.PistolaLaser;
import ObjetosCriados.Esqueleto;
import java.util.Scanner;

/**
 *
 * @author Henrique
 */
public class Subsolo extends Sala {

    private boolean escuro;
    private boolean examinado;
    private BombaNeutrons bombaNeutrons;
    private Esqueleto esqueleto;

    public Subsolo() {
        super("Subsolo");
        escuro = true;
        examinado = false;
        bombaNeutrons = new BombaNeutrons();
        this.getFerramentas().put(bombaNeutrons.getDescricao(), bombaNeutrons);
        esqueleto = new Esqueleto();
        this.getObjetos().put("Esqueleto", esqueleto);

    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta no ").append(this.getNome()).append("\n");

        if (escuro) {
            descricao.append("O ambiente está completamente úmido e escuro, ");
            descricao.append("sem a menor possibilidade de enxergar nada. \n");
        }

        if (!escuro && esqueleto.isAcaoOk() == false) {
            descricao.append("Você acende sua lanterna e a sala se ilumina, revelando que não há portas,\n");
            descricao.append("porém você nota uma grande janela no alto da sala, que não pode ser alcançada. \n");
            descricao.append("A sua direita você se depara com um esqueleto de um humanóide gigante,\n");
            descricao.append("morto há tempos para sua felicidade.\n");
            descricao.append("Ao examinar o humanóide, você encontra uma \n");
            descricao.append("BombaNeutrons escondida. Olha aí a sorte te ajudando de novo...\n");
            descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
            descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        }

        if (!escuro && esqueleto.isAcaoOk() == true) {
            descricao.append("\n\n");
            descricao.append("Você então usa a arma laser em direção ao esqueleto \n");
            descricao.append("transformando-o em uma pilha de ossos e \n");
            descricao.append("usando para subir e chegar até a janela.\n");
            descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
            descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
            descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
            return descricao.toString();
        }

        return descricao.toString();
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

    public boolean usa(String ferramenta) {

        // pode usar somente a lanterna e pistolaLaser
        Ferramenta f = this.getMochila().usar(ferramenta);
        if (f == null) { //|| !(f instanceof Lanterna || f instanceof PistolaLaser)) {
            return false;
        }
        if (f instanceof Lanterna) {
            escuro = false;
            return true;
        }
        //libera para nosso heroi passar de sala

        if (f instanceof PistolaLaser && escuro == false) {
            if (f instanceof PistolaLaser) {
                (this.getObjetos().get("Esqueleto")).setAcaoOk(true);
                return true;
            }
        }
        return false;

    }

    @Override
    public Sala sai(String sala) {
        Sala aux = super.sai(sala);
        if (aux != null) {
            escuro = true;
        }
        return aux;
    }
    
     Scanner in = new Scanner(System.in);

}
