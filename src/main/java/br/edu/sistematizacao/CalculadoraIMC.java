package br.edu.sistematizacao;

/**
 * Interface responsável por definir o contrato de cálculo e classificação de IMC.
 * <p>
 * Classes que implementam esta interface devem fornecer a lógica de cálculo
 * do Índice de Massa Corporal (IMC) e sua respectiva classificação com base
 * no valor calculado.
 * </p>
 *
 * <p>Este contrato permite diferentes implementações de cálculo e classificação,
 * possibilitando variações como critérios para atletas ou pessoas comuns
 * (polimorfismo).</p>
 */
public interface CalculadoraIMC {

    /**
     * Calcula o Índice de Massa Corporal (IMC) com base no peso e altura informados.
     *
     * @param peso peso da pessoa em quilogramas (kg)
     * @param altura altura da pessoa em metros (m)
     * @return valor do IMC calculado
     */
    double calcularIMC(double peso, double altura);

    /**
     * Classifica o valor do IMC de acordo com faixas definidas pela implementação.
     *
     * @param imc valor do índice de massa corporal já calculado
     * @return descrição textual da classificação do IMC
     */
    String classificarIMC(double imc);
}
