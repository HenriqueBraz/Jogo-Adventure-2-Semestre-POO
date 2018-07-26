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
import Senhas.SenhasOpcoes;
import java.util.Scanner;

/**
 *
 * @author Henrique
 */
public class SalaEsquerda extends Sala {

    private static boolean escuro;
    private JogoChaves jogoChaves;

    public SalaEsquerda() {
        super("SalaEsquerda");
        jogoChaves = new JogoChaves();
        this.getFerramentas().put(jogoChaves.getDescricao(), jogoChaves);
        escuro = true;

    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Voce esta na ").append(this.getNome()).append("\n");
        if (escuro) {
            descricao.append("Esta escuro aqui e você não consegue ver nada\n");

        }
        if (!escuro) {
            descricao.append("você verifica um teclado numérico, e uma porta mais a frente.\n");
            descricao.append("Você pensa em digitar alguns algarismo, para ver\n");
            descricao.append("se consegue destravar a porta a sua frente, então você lembra\n");
            descricao.append("dos perigos que podem acontecer em um ambiente desconhecido.\n");
            descricao.append("Se quiser tentar a sorte, digite o comando DigitaSenha\n");

            if (super.getFerramentas().containsKey("JogoChaves") == true) {
                descricao.append("Você também acha um JogoChaves! Mais sorte do que juízo... \n");
            }
            descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");

        }

        if (!escuro && SenhasOpcoes.getSenha() == 1) {

            descricao.append("Você digita a senha 56789. A porta a sua frente abre \n");
            descricao.append(", e uma silhueta aparece a sua frente.Você não \n");
            descricao.append("consegue identificar devido a forte luz atrás de você, \n");
            descricao.append("mas claramente é uma silhueta feminina. Ela se  \n");
            descricao.append("aproxima de você e lhe abraça, mas neste momento \n");
            descricao.append("você nota algo errado: quarto braços envolvem você, \n");
            descricao.append(" e uma carantonha de um olho só o fita. \n");
            descricao.append(". Você então reconhece a princesa Sebóia, do  \n");
            descricao.append("planeta Pegajosus.Você tenta se livrar dos tentáculos, \n");
            descricao.append(" mas a princesa, na euforia do seu amor e  \n");
            descricao.append("pronunciando palavras de agradecimentos \n");
            descricao.append("que para você são indecifráveis, o abraça cada vez \n");
            descricao.append(" mais forte, por fim sufocando-o até a morte na \n");
            descricao.append("euforia do seu amor.\n");
            descricao.append("\n");
            descricao.append("Fim de Jogo\n\n");
            // throw new FimDeJogoException();
        }

        if (!escuro && SenhasOpcoes.getSenha() == 2) {
            descricao.append("\n");
            descricao.append(" Você digita a senha 01234 e a porta a frente se \n");
            descricao.append("abre, com a princesa Isthar a sua frente. Ela o \n");
            descricao.append("reconhece imediatamente e corre aos seus braços, \n");
            descricao.append("envolvendo-o com o seu corpo pequeno e perfumado, \n");
            descricao.append("fitando-o com os seus lindos olhos verdes, cheios \n");
            descricao.append("de lágrimas. Vocês voltam para nave e decolam para \n");
            descricao.append(" casa, deixando para trás o terrível DalhiNinguemScapus.\n");
            descricao.append("\n");
            descricao.append("Fim de Jogo\n\n");
            // throw new FimDeJogoException();
        }

        if (!escuro && SenhasOpcoes.getSenha() == 3) {
            descricao.append("\n");
            descricao.append("Você digita a senha, coma esperança de ter a \n");
            descricao.append("princesa Isthar em seus braços novamente...\n");
            descricao.append("mas algo dá errado! Sirenes começam a tocar, e \n");
            descricao.append("antes que você consiga reagir, já está cercado por \n");
            descricao.append("quatro enormes gigantes, que rapidamente o \n");
            descricao.append("imobilizam. Você acaba de se tornar mais um \n");
            descricao.append("prisioneiro do terrível...\n");
            descricao.append("\n");
            descricao.append("DalhiNinguemScapus!\n");
            descricao.append("\n");
            descricao.append("Fim de Jogo\n\n");
            //  throw new FimDeJogoException();

        }
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
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
        if (f == null) {
            return false;
        }
        if (f instanceof Lanterna) {
            escuro = false;
            return true;
        } else {
            return false;
        }
    }

    public static boolean getEscuro() {

        return SalaEsquerda.escuro;

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
