/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import ClassesBasicas.Mochila;
import ClassesBasicas.Sala;
import Salas.SalaEsquerda;
import Salas.SalaIntermediaria;
import Salas.Subsolo;
import Salas.HallEntrada;
import Salas.MesaninoHolografico;
import Salas.SalaDireita;

import java.util.Scanner;

public class Engine {

    private Scanner in;
    private Sala salaIncial;
    private Mochila mochila;
    private Sala salaCorrente;
    private boolean fim;

    public Engine() {
        in = new Scanner(System.in);
        mochila = new Mochila();
        criaLabirinto();
        salaIncial.entra(mochila);
        salaCorrente = salaIncial;
        fim = false;
    }

    public void criaLabirinto() {
        Sala hallEntrada = new HallEntrada();
        Sala mesaninoHolografico = new MesaninoHolografico();
        Sala salaDireita = new SalaDireita();
        Sala salaEsquerda = new SalaEsquerda();
        Sala salaIntermediaria = new SalaIntermediaria();
        Sala subsolo = new Subsolo();

        //portas pro hall de entrada
        hallEntrada.getPortas().put(salaDireita.getNome(), salaDireita);
        hallEntrada.getPortas().put(salaEsquerda.getNome(), salaEsquerda);

        // portas pra salaEsquerda
        salaEsquerda.getPortas().put(hallEntrada.getNome(), hallEntrada);

        // portas pra salaDireita
        salaDireita.getPortas().put(hallEntrada.getNome(), hallEntrada);
        salaDireita.getPortas().put(subsolo.getNome(), subsolo);

        //portas pro Subsolo
        subsolo.getPortas().put(salaDireita.getNome(), salaDireita);
        subsolo.getPortas().put(salaIntermediaria.getNome(), salaIntermediaria);

        // portas pra salaIntermediaria
        salaIntermediaria.getPortas().put(subsolo.getNome(), subsolo);
        salaIntermediaria.getPortas().put(mesaninoHolografico.getNome(), mesaninoHolografico);

        // portas pro MesaninoHolografico
        mesaninoHolografico.getPortas().put(hallEntrada.getNome(), hallEntrada);
        mesaninoHolografico.getPortas().put(salaIntermediaria.getNome(), salaIntermediaria);

        salaIncial = hallEntrada;
    }

    public void joga() {
        while (!fim) {
            System.out.println("---------");
            System.out.println(salaCorrente.textoDescricao());
            System.out.println("O que voce deseja fazer? ");
            String acao = in.nextLine();
            String[] tokens = acao.split(" ");
            switch (tokens[0]) {
                case "fim":
                    fim = true;
                    break;
                case "pega":
                    if (salaCorrente.pega(tokens[1])) {
                        System.out.println("Ok! " + tokens[1] + " na mochila!");
                    } else {
                        System.out.println("Objeto " + tokens[1] + " não encontrado.");
                    }
                    break;
                case "inventario":
                    System.out.println("Conteudo da mochila: " + mochila.inventario());
                    break;
                case "usa":
                    if (salaCorrente.usa(tokens[1])) {
                        System.out.println("Feito !!");
                    } else {
                        System.out.println("Não é possível usar " + tokens[1] + " nesta sala");
                    }
                    break;

                case "DigitaSenha":
                    if (Salas.SalaEsquerda.getEscuro() == true) {
                        break;
                    } else {
                        System.out.println("\n");
                        String senha = in.nextLine();
                        Senhas.SenhasOpcoes.Senha(senha);
                        break;
                    }
                case "DigitaOpcao":
                    if (Salas.SalaIntermediaria.getBomba() == false) {
                        break;
                    } else {
                        System.out.println("\n");
                        String opcao = in.next();
                        Senhas.SenhasOpcoes.Opcao(opcao);
                        break;
                    }
                case "sai":
                    Sala novaSala = salaCorrente.sai(tokens[1]);
                    if (novaSala == null) {
                        System.out.println("Sala desconhecida ...");
                    } else {
                        novaSala.entra(mochila);
                        salaCorrente = novaSala;
                    }
                    break;
                default:
                    System.out.println("Comando desconhecido: " + tokens[0]);
                    break;
            }
        }
        System.out.println("Fim de jogo !! Você conseguiu salvar a princesa !!");
    }

}
