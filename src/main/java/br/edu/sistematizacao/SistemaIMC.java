package br.edu.sistematizacao;

import org.jetbrains.annotations.NotNull;

/**
 * Classe responsável por coordenar o processamento de cálculos de IMC no sistema.
 * <p>
 * Esta classe atua como uma camada de serviço, centralizando a execução do cálculo
 * de IMC, classificação e registro no histórico.
 * </p>
 *
 * <p>Também demonstra o uso de <strong>polimorfismo</strong>, já que o método
 * {@link Pessoa#classificarIMC(double)} pode ter comportamentos diferentes
 * dependendo do tipo concreto da pessoa (ex: {@link Atleta}).</p>
 */
public class SistemaIMC {
    private Historico historico = new Historico();

    /**
     * Processa o cálculo de IMC para uma pessoa.
     * <p>
     * O método realiza as seguintes etapas:
     * <ul>
     *   <li>Calcula o IMC da pessoa</li>
     *   <li>Classifica o IMC utilizando polimorfismo</li>
     *   <li>Gera uma linha de resultado formatada</li>
     *   <li>Armazena o resultado no histórico</li>
     *   <li>Exibe o resultado no console</li>
     * </ul>
     * </p>
     *
     * @param pessoa objeto {@link Pessoa} que será processado
     */
    public void processar(@NotNull Pessoa pessoa) {
        double imc   = pessoa.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
        String classe = pessoa.classificarIMC(imc); // polimorfismo aqui!
        String linha  = pessoa.getNome() + " → IMC: " +
                String.format("%.2f", imc) + " (" + classe + ")";
        historico.adicionar(linha);
        System.out.println(linha);
    }

    /**
     * Exibe todo o histórico de cálculos de IMC realizados na sessão.
     */
    public void exibirHistorico() { historico.exibir(); }
}
