package br.edu.sistematizacao;

import org.fusesource.jansi.Ansi;
import org.jetbrains.annotations.NotNull;
import static org.fusesource.jansi.Ansi.ansi;

import java.util.Scanner;

/**
 * Responsável pela interação do sistema com o usuário via terminal.
 *
 * <p>Esta classe utiliza a biblioteca Jansi para renderização
 * de textos coloridos e manipulação do console, proporcionando
 * uma experiência visual mais amigável em aplicações CLI.</p>
 */
public class MenuUI {

    private final Scanner _scanner;
    private static final String TITULO_MENU = "Menu Principal";

    public MenuUI(Scanner scanner) {
        this._scanner = scanner;
    }

    /**
     * Exibe o banner inicial da aplicação no console.
     * <p>
     * O banner apresenta o logo do sistema em ASCII art, utilizando cores
     * fornecidas pela biblioteca Jansi para destacar visualmente a interface
     * do terminal. Após a exibição, é mostrado um efeito de carregamento
     * simulando a inicialização do sistema.
     * </p>
     *
     * <p>Este método também realiza a inicialização visual do sistema IMC,
     * indicando ao usuário que a aplicação está sendo carregada.</p>
     */
    public void exibirBanner() {

        printColor("██╗███╗   ███╗ ██████╗", Ansi.Color.CYAN);
        printColor("██║████╗ ████║██╔════╝", Ansi.Color.CYAN);
        printColor("██║██╔████╔██║██║", Ansi.Color.CYAN);
        printColor("██║██║╚██╔╝██║██║", Ansi.Color.CYAN);
        printColor("██║██║ ╚═╝ ██║╚██████╗", Ansi.Color.CYAN);
        printColor("╚═╝╚═╝     ╚═╝ ╚═════╝", Ansi.Color.CYAN);
        System.out.println();
        printColor("⚡ Sistema de Cálculo de IMC ⚡", Ansi.Color.CYAN);

        System.out.print("Inicializando sistema");
        carregando();
    }

    /**
     * Exibe o menu principal da aplicação no console.
     * <p>
     * O menu apresenta todas as opções disponíveis para o usuário interagir com o sistema,
     * como cadastro de pessoas, cadastro de atletas, cálculo de IMC e exibição do histórico.
     * A interface é renderizada no terminal utilizando cores fornecidas pela biblioteca Jansi.
     * </p>
     *
     * <p>Este método também chama {@link #exibirCabecalho(String)} para limpar e preparar
     * a tela antes da exibição do menu.</p>
     *
     * <p>Após exibir as opções, o método aguarda a entrada do usuário.</p>
     */
    public void exibirMenu() {

        String[] opcoes = {
                "║  [1] Cadastrar Pessoa                            ║",
                "║  [2] Cadastrar Atleta                            ║",
                "║  [3] Calcular IMC (última pessoa cadastrada)     ║",
                "║  [4] Exibir Histórico                            ║",
                "║  [0] Encerrar Sistema                            ║"
        };

        exibirCabecalho("Menu Principal");

        for (String item : opcoes) {
            printColor(item, Ansi.Color.CYAN);
        }

        printColor("╠══════════════════════════════════════════════════╣", Ansi.Color.CYAN);
        printColor("║         Digite uma das opções disponíveis        ║", Ansi.Color.CYAN);
        printColor("╚══════════════════════════════════════════════════╝", Ansi.Color.CYAN);
        System.out.print(ansi().fg(Ansi.Color.GREEN).a("➜ Opção: ").reset());
    }

    /**
     * Exibe o cabeçalho da aplicação no console.
     * <p>
     * Este método é responsável por limpar a tela e renderizar o cabeçalho
     * principal do sistema ou de uma seção específica, dependendo do título informado.
     * </p>
     *
     * <p>Quando o título é igual a "Menu Principal", é exibido um cabeçalho padrão
     * de inicialização do sistema. Caso contrário, é exibido um cabeçalho personalizado
     * contendo o título da seção solicitada.</p>
     *
     * <p>A renderização utiliza a biblioteca Jansi para aplicação de cores no terminal.</p>
     *
     * @param titulo título da seção a ser exibida no cabeçalho.
     *               Não pode ser {@code null}.
     */
    public void exibirCabecalho(@NotNull String titulo) {

        limparTela();

        if(titulo.equals(TITULO_MENU)) {
            printColor("╔══════════════════════════════════════════════════╗", Ansi.Color.CYAN);
            printColor("║                                                  ║", Ansi.Color.CYAN);
            printColor("║              ⚡ SISTEMA IMC 1.0 ⚡               ║", Ansi.Color.CYAN);
            printColor("║                                                  ║", Ansi.Color.CYAN);
            printColor("╠══════════════════════════════════════════════════╣", Ansi.Color.CYAN);
        } else {
            printColor("╔══════════════════════════════════════════════════╗", Ansi.Color.BLUE);
            printColor("║  ⚡ SISTEMA IMC 1.0 ⚡                           ║", Ansi.Color.BLUE);
            System.out.printf(
                    "║  %s%-48s%s║%n",
                    ansi().fg(Ansi.Color.BLUE),
                    titulo,
                    ansi().reset()
            );
            printColor("╚══════════════════════════════════════════════════╝", Ansi.Color.BLUE);
        }
    }

    /**
     * Exibe uma mensagem de erro no console e retorna ao fluxo principal do sistema.
     * <p>
     * A mensagem é apresentada em destaque utilizando a cor vermelha (Jansi),
     * indicando uma falha ou entrada inválida. Após a exibição do erro,
     * é exibido um efeito de carregamento simulando o retorno ao menu principal.
     * </p>
     *
     * @param mensagem mensagem de erro a ser exibida para o usuário.
     */
    public void mostrarErro(String mensagem) {
        printColor(mensagem, Ansi.Color.RED);
        System.out.print("Carregando menu principal");
        carregando();
    }

    /**
     * Exibe uma mensagem de sucesso no console e retorna ao fluxo principal do sistema.
     * <p>
     * A mensagem é apresentada em destaque utilizando a cor verde (Jansi),
     * indicando que a operação foi concluída com êxito. Após a exibição,
     * é mostrado um efeito de carregamento simulando o retorno ao menu principal.
     * </p>
     *
     * @param mensagem mensagem de sucesso a ser exibida para o usuário.
     */
    public void mostrarSucesso(String mensagem) {
        printColor(mensagem, Ansi.Color.GREEN);
        System.out.print("Carregando menu principal");
        carregando();
    }

    /**
     * Exibe uma mensagem de alerta no console.
     * <p>
     * A mensagem é apresentada utilizando a cor amarela (Jansi), indicando
     * uma situação de atenção ou aviso ao usuário. Após a exibição,
     * é exibido um efeito de carregamento para simular continuidade do fluxo.
     * </p>
     *
     * @param mensagem mensagem de alerta a ser exibida para o usuário.
     */
    public void mostrarAlerta(String mensagem) {
        printColor(mensagem, Ansi.Color.YELLOW);
        carregando();
    }

    /**
     * Lê uma entrada do tipo {@link String} fornecida pelo usuário via console.
     * <p>
     * O método exibe a mensagem de solicitação utilizando a cor verde (Jansi),
     * captura a entrada digitada pelo usuário e realiza validação básica.
     * </p>
     *
     * <p>Regras de validação:</p>
     * <ul>
     *   <li>A entrada não pode ser vazia</li>
     * </ul>
     *
     * <p>Caso a entrada seja inválida, uma {@link EntradaInvalidaException}
     * é lançada.</p>
     *
     * @param mensagem mensagem exibida ao usuário solicitando a entrada.
     * @return texto digitado pelo usuário.
     * @throws EntradaInvalidaException caso a entrada seja vazia.
     */
    protected String lerString(String mensagem) throws EntradaInvalidaException {
        printColor(mensagem, Ansi.Color.GREEN);
        String texto = _scanner.nextLine();

        if (texto.isEmpty()) {
            throw new EntradaInvalidaException(
                    "Texto não pode ser vazio!"
            );
        }
        return texto;
    }

    /**
     * Lê uma entrada numérica do tipo {@code double} fornecida pelo usuário via console.
     * <p>
     * O método exibe a mensagem de solicitação utilizando a cor verde (Jansi),
     * captura a entrada digitada e tenta convertê-la para um valor decimal.
     * </p>
     *
     * <p>Regras de validação:</p>
     * <ul>
     *   <li>O valor deve ser numérico válido</li>
     *   <li>O valor deve ser maior que zero</li>
     * </ul>
     *
     * <p>Caso a entrada seja inválida ou não atenda às regras, uma
     * {@link EntradaInvalidaException} é lançada.</p>
     *
     * @param mensagem mensagem exibida ao usuário solicitando o valor.
     * @param campo nome do campo utilizado na validação para personalização da mensagem de erro.
     * @return valor decimal informado pelo usuário.
     * @throws EntradaInvalidaException caso o valor seja inválido ou menor ou igual a zero.
     */
    protected double lerDouble(String mensagem, String campo) throws EntradaInvalidaException {
        try {
            printColor(mensagem, Ansi.Color.GREEN);
            double valor = Double.parseDouble(_scanner.nextLine());
            if(valor <= 0)
                throw new EntradaInvalidaException(campo + " deve ser maior que zero!");
            return valor;
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException(
                    "Valor decimal inválido!"
            );
        }
    }

    /**
     * Lê uma entrada numérica do tipo {@code int} fornecida pelo usuário via console.
     * <p>
     * O método exibe a mensagem de solicitação utilizando a cor verde (Jansi),
     * captura a entrada digitada e tenta convertê-la para um valor inteiro.
     * </p>
     *
     * <p>Regras de validação:</p>
     * <ul>
     *   <li>A entrada deve ser um número inteiro válido</li>
     *   <li>Valores devem ser maiores que zero, exceto quando o campo for "opcaoMenu"</li>
     * </ul>
     *
     * <p>Caso a entrada seja inválida ou não atenda às regras, uma
     * {@link EntradaInvalidaException} é lançada.</p>
     *
     * @param mensagem mensagem exibida ao usuário solicitando o valor.
     * @param campo nome do campo utilizado para validação e personalização da regra de negócio.
     *               O valor especial {@code "opcaoMenu"} desativa a restrição de valor mínimo.
     * @return valor inteiro informado pelo usuário.
     * @throws EntradaInvalidaException caso o valor seja inválido ou viole as regras definidas.
     */
    protected int lerInt(String mensagem, @NotNull String campo) throws EntradaInvalidaException {
        try {
            printColor(mensagem, Ansi.Color.GREEN);
            int valor =  Integer.parseInt(_scanner.nextLine());
            if(!campo.equals("opcaoMenu") && valor <= 0) {
                throw new EntradaInvalidaException(campo + " deve ser maior que zero!");
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException(
                    "Valor inteiro inválido!"
            );
        }
    }

    /**
     * Imprime um texto no console utilizando uma cor específica.
     * <p>
     * Este método utiliza a biblioteca Jansi para aplicar cores ANSI ao texto,
     * facilitando a criação de uma interface de linha de comando mais legível
     * e organizada.
     * </p>
     *
     * <p>Após a impressão, o estilo do terminal é resetado automaticamente
     * para evitar que a cor afete as próximas saídas.</p>
     *
     * @param text texto a ser exibido no console.
     * @param color cor ANSI a ser aplicada ao texto.
     */
    private void printColor(String text, Ansi.Color color) {
        System.out.println(ansi().fg(color).a(text).reset());
    }

    /**
     * Limpa a tela do console e reposiciona o cursor no canto superior esquerdo.
     * <p>
     * Este método utiliza a biblioteca Jansi para executar a limpeza da tela
     * de forma portátil, evitando o uso de comandos específicos do sistema operacional
     * como {@code clear} (Linux/macOS) ou {@code cls} (Windows).
     * </p>
     *
     * <p>Após limpar a tela, o cursor é reposicionado na posição inicial (0,0),
     * garantindo que a próxima saída seja exibida no topo do terminal.</p>
     */
    private void limparTela() {
        System.out.print(
                ansi()
                .eraseScreen()
                .cursor(0, 0));
    }

    /**
     * Exibe uma animação simples de carregamento no console.
     * <p>
     * Este método simula um processo de carregamento imprimindo pontos
     * sequenciais com um pequeno intervalo de tempo entre eles,
     * criando uma sensação de processamento em andamento.
     * </p>
     *
     * <p>Em caso de interrupção da thread, uma mensagem de erro é exibida
     * no console utilizando a cor vermelha (Jansi).</p>
     *
     * @implNote O método utiliza {@link Thread#sleep(long)} para simular
     * atraso artificial entre as etapas da animação.
     */
    private void carregando() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(900);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            printColor("Erro no carregamento.", Ansi.Color.RED);
        }
        System.out.println("\n");
    }
}