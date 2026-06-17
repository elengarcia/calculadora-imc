package br.edu.sistematizacao;

/**
 * Representa um atleta no sistema de cálculo de IMC.
 * <p>
 * Esta classe estende {@link Pessoa} e adiciona o atributo específico
 * {@code modalidade}, além de sobrescrever o comportamento de classificação
 * de IMC para refletir critérios diferentes aplicados a atletas.
 * </p>
 *
 * <p>Este é um exemplo de uso de <strong>herança e polimorfismo</strong>,
 * onde o método de classificação de IMC é adaptado conforme o tipo de pessoa.</p>
 */
public class Atleta extends Pessoa {
    private String modalidade;

    /**
     * Cria uma nova instância de Atleta.
     *
     * @param nome nome do atleta
     * @param idade idade do atleta
     * @param peso peso do atleta em kg
     * @param altura altura do atleta em metros
     * @param modalidade modalidade esportiva praticada pelo atleta
     */
    public Atleta(String nome, int idade, double peso,
                  double altura, String modalidade) {
        super(nome, idade, peso, altura);
        this.modalidade = modalidade;
    }

    /**
     * Classifica o IMC de acordo com critérios específicos para atletas.
     * <p>
     * Diferente da classe base, a classificação considera faixas ajustadas
     * para desempenho físico de atletas.
     * </p>
     *
     * @param imc valor do índice de massa corporal calculado
     * @return descrição da classificação do IMC para atletas
     */
    @Override
    public String classificarIMC(double imc) {
        if (imc < 20.0) return "Abaixo do ideal para atleta";
        else if (imc < 27.0) return "Ideal para atleta";
        else return "Acima do ideal para atleta";
    }

    /**
     * Retorna o perfil completo do atleta incluindo sua modalidade esportiva.
     * <p>
     * Este método estende o comportamento da classe {@link Pessoa},
     * adicionando informações específicas do atleta.
     * </p>
     *
     * @return string contendo os dados completos do atleta
     */
    @Override
    public String exibirPerfil() {
        return super.exibirPerfil() + " | Modalidade: " + modalidade;
    }
}