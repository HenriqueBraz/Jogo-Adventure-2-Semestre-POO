/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Senhas;

/**
 *
 * @author Henrique
 */
public class SenhasOpcoes {

    private static int senha;
    private static int opcao;

    public static void Senha(String senha) {

        if (" ".equals(senha)) {
            System.out.println("Não pode estar em branco\n");

        } else if ("01234".equals(senha)) {
            SenhasOpcoes.senha = 2;
        } else if ("56789".equals(senha)) {
            SenhasOpcoes.senha = 1;
        } else {
            SenhasOpcoes.senha = 3;
        }

    }

    public static void Opcao(String opcao) {

        if (" ".equals(opcao)) {
            System.out.println("Não pode estar em branco\n");

        } else if ("1".equals(opcao)) {
            SenhasOpcoes.opcao = 1;
        } else if ("2".equals(opcao)) {
            SenhasOpcoes.opcao = 2;
        } else if ("3".equals(opcao)) {
            SenhasOpcoes.opcao = 3;
        } else {
            System.out.println("Opção Inválida\n");
        }

    }

    public static int getSenha() {
        return senha;
    }

    public static int getOpcao() {
        return opcao;
    }
    

}
