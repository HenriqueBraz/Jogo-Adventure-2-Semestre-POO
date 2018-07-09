/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Sala;
import Ferramentas.JogoChaves;
import Ferramentas.Lanterna;
import ObjetosCriados.ChaoMovel;

/**
 *
 * @author Henrique
 */
public class SalaDireita extends Sala {

    private ChaoMovel chaoMovel;
    
    public SalaDireita() {
        super("SalaDireita");
        chaoMovel = new ChaoMovel();
        this.getObjetos().put("ChaoMovel", chaoMovel);
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta no ").append(this.getNome()).append("\n");
        descricao.append("você se encontra em uma sala bem iluminada, porém completamente vazia.\n");
        descricao.append(" No chão há uma espécie de controle com uma grande botão vermelho escrito\n");
        descricao.append("“Não aperte” no centro que parece estar quebrado...\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");

        if (chaoMovel.isAcaoOk() == true) {
            descricao.append("\n\n");
            descricao.append(" A porta do chão se abre sob seus pés, e você vê uma pequena passagem abaixo\n");
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

    @Override
    public boolean usa(String ferramenta) {
        Ferramenta f = this.getMochila().usar(ferramenta);
        if (f == null || !(f instanceof JogoChaves)) {
            return false;
        } else if (f instanceof JogoChaves) {
            (this.getObjetos().get("ChaoMovel")).setAcaoOk(true);
             return true;
        }

        return false;
    }

}
