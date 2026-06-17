package br.edu.sistematizacao;

import org.fusesource.jansi.AnsiConsole;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuUI ui = new MenuUI(scanner);
        SistemaIMC sistema = new SistemaIMC();
        Pessoa ultimaPessoa = null;
        boolean executando = true;

        AnsiConsole.systemInstall();
        ui.exibirBanner();

        while (executando) {
            try {
                ui.exibirMenu();
                int opcao = ui.lerInt("", "opcaoMenu");

                switch (opcao) {
                    case 1:
                        ultimaPessoa = cadastrarPessoa(ui);
                        break;
                    case 2:
                        ultimaPessoa = cadastrarAtleta(ui);
                        break;
                    case 3:
                        calcularIMC(ui, sistema, ultimaPessoa);
                        break;
                    case 4:
                        exibirHistorico(ui, sistema);
                        break;
                    case 0:
                        executando = false;
                        break;
                    default:
                        ui.mostrarErro("Opção inválida.");
                }
            } catch (EntradaInvalidaException e) {
                ui.mostrarErro(e.getMessage());
            }
        }
        scanner.close();
        AnsiConsole.systemUninstall();
    }

    /**
     * Realiza o cadastro de uma pessoa.
     * <p>
     * Solicita ao usuário os dados necessários para criação de uma pessoa:
     * nome, idade, peso e altura.
     * Após a validação dos dados, retorna uma nova instância de {@link Pessoa}.
     * </p>
     *
     * @param ui interface responsável pela interação com o usuário.
     *           Não pode ser {@code null}.
     * @return uma instância de {@link Pessoa} contendo os dados informados.
     * @throws EntradaInvalidaException caso algum dado informado seja inválido
     *                                  ou não atenda às regras de validação.
     */
    private static Pessoa cadastrarPessoa(@NotNull MenuUI ui) throws EntradaInvalidaException {

        ui.exibirCabecalho("CADASTRO PESSOA");

        String nome = ui.lerString("➜ Nome: ");
        int idade = ui.lerInt("➜ Idade: ", "Idade");
        double peso = ui.lerDouble("➜ Peso (kg): ", "Peso");
        double altura = ui.lerDouble("➜ Altura (m): ", "Altura");

        ui.mostrarSucesso("Pessoa cadastrada com sucesso!");
        return new Pessoa(nome, idade, peso, altura);
    }

    /**
     * Realiza o cadastro de um atleta.
     * <p>
     * Solicita ao usuário os dados necessários para criação de um atleta:
     * nome, idade, peso, altura e modalidade esportiva.
     * Após a validação dos dados, retorna uma nova instância de {@link Atleta}.
     * </p>
     *
     * @param ui interface responsável pela interação com o usuário.
     *           Não pode ser {@code null}.
     * @return uma instância de {@link Atleta} contendo os dados informados.
     * @throws EntradaInvalidaException caso algum dado informado seja inválido
     *                                  ou não atenda às regras de validação.
     */
    private static Pessoa cadastrarAtleta(@NotNull MenuUI ui) throws EntradaInvalidaException {
        ui.exibirCabecalho("CADASTRO ATLETA");

        String nome = ui.lerString("➜ Nome: ");
        int idade = ui.lerInt("➜ Idade: ", "Idade");
        double peso = ui.lerDouble("➜ Peso (kg): ", "Peso");
        double altura = ui.lerDouble("➜ Altura (m): ", "Altura");
        String modalidade = ui.lerString("➜ Modalidade: ");

        ui.mostrarSucesso("Atleta cadastrado com sucesso!");
        return new Atleta(nome, idade, peso, altura, modalidade);
    }

    /**
     * Realiza o processamento do IMC da pessoa informada.
     * <p>
     * Exibe mensagens de status durante a execução e delega o cálculo
     * e o armazenamento do resultado ao {@link SistemaIMC}. Caso nenhuma
     * pessoa tenha sido cadastrada, o processamento é interrompido e uma
     * mensagem de erro é exibida ao usuário.
     * </p>
     *
     * @param ui interface responsável pela interação com o usuário.
     *           Não pode ser {@code null}.
     * @param sistema sistema responsável pelo processamento e armazenamento
     *                do histórico de cálculos de IMC. Não pode ser {@code null}.
     * @param pessoa pessoa que terá o seu IMC calculado. Pode ser {@code null},
     *               caso ainda não exista um registro disponível.
     */
    private static void calcularIMC(@NotNull MenuUI ui,@NotNull SistemaIMC sistema, @Nullable Pessoa pessoa) {

        ui.exibirCabecalho("CÁLCULO DE IMC");
        if (pessoa == null) {
            ui.mostrarErro("Nenhum registro a ser processado!");
            return;
        }
        ui.mostrarAlerta("Processando ultimo registro encontrado. Aguarde!");
        sistema.processar(pessoa);
        ui.mostrarSucesso("Processamento concluído com sucesso!");
    }

    /**
     * Exibe o histórico de cálculos de IMC realizados durante a execução
     * da aplicação.
     * <p>
     * O método apresenta mensagens de status ao usuário e delega a
     * recuperação e exibição dos registros ao {@link SistemaIMC}.
     * </p>
     *
     * @param ui interface responsável pela interação com o usuário.
     *           Não pode ser {@code null}.
     * @param sistema sistema responsável por armazenar e exibir o histórico
     *                dos cálculos de IMC. Não pode ser {@code null}.
     */
    private static void exibirHistorico(@NotNull MenuUI ui, @NotNull SistemaIMC sistema) {

        ui.exibirCabecalho("HISTÓRICO");
        ui.mostrarAlerta("Carregando histórico!");
        sistema.exibirHistorico();
        ui.mostrarSucesso("Dados carregados com sucesso!");
    }
}
