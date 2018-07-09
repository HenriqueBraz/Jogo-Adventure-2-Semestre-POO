/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import Ferramentas.JogoChaves;
import ObjetosCriados.DisplayGigante;

/**
 *
 * @author Henrique
 */
public class MesaninoHolografico extends Sala {

    private boolean displayConsertado;

    public MesaninoHolografico() {
        super("MesaninoHolografico");

        displayConsertado = false;
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta no ").append(this.getNome()).append("\n");
        descricao.append("Ao entrar na sala, você verifica que não há nada na sala,\n");
        descricao.append("a não ser três botões grandes e uma tela enorme, do\n");
        descricao.append("tamanho de 1/4 de 1/6 de 1/8 de um estádio de futebol\n");
        descricao.append("que parecem estar estragados ou oxidados pelo tempo.\n");
        descricao.append("O que você faz?\n");

        if (displayConsertado == true) {

            descricao.append("Ao apertar os botões, uma imagem aparece na tela \n");
            descricao.append("dentre os vários caracteres estranhos que se formam,\n");
            descricao.append("você consegue identificar dois códigos:\n");
            descricao.append("\n");
            descricao.append("01234\n");
            descricao.append("\n");
            descricao.append("56789\n");
            descricao.append("\n");
            descricao.append("Uma porta se abre a sua frente, e você consegue identificar");
            descricao.append("O Hall de Entrada\n");
            descricao.append("\n");
            descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
            return descricao.toString();//Aqui nosso herói deve volar com as senhas
            //Para o Hall de entrada, porta de esquerda  e tentar a sorte com
            // a senhas
        }
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        
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

    @Override
    public boolean usa(String ferramenta) {
        Ferramenta f = this.getMochila().usar(ferramenta);
        if (f == null || !(f instanceof JogoChaves)) {
            return false;
        }

          if (f instanceof JogoChaves) {
            displayConsertado = true;
            return true;
        } else {
            return false;
        }

    }
}
