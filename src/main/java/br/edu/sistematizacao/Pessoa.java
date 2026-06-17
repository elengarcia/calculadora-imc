package br.edu.sistematizacao;
/**
 * Representa uma pessoa no sistema de cálculo de IMC.
 * <p>
 * Esta classe estende {@link PessoaBase} e implementa {@link CalculadoraIMC},
 * sendo responsável por armazenar dados físicos e realizar o cálculo e
 * classificação do IMC para pessoas comuns.
 * </p>
 *
 * <p>Também serve como base para especializações, como {@link Atleta},
 * demonstrando uso de herança e polimorfismo.</p>
 */
public class Pessoa extends PessoaBase implements CalculadoraIMC {

    private double  peso;
    private double  altura;
    private boolean ativo;

    /**
     * Cria uma nova instância de Pessoa.
     *
     * @param nome nome da pessoa
     * @param idade idade da pessoa
     * @param peso peso da pessoa em kg
     * @param altura altura da pessoa em metros
     */
    public Pessoa(String nome, int idade, double peso, double altura) {
        super(nome, idade);
        this.peso   = peso;
        this.altura = altura;
        this.ativo  = true;
    }

    /**
     * Retorna o peso da pessoa.
     *
     * @return peso em quilogramas
     */
    public double  getPeso()    { return peso; }

    /**
     * Retorna o peso da pessoa.
     *
     * @return peso em quilogramas
     */
    public double  getAltura() { return altura; }

    /**
     * Indica se a pessoa está ativa no sistema.
     *
     * @return {@code true} se estiver ativa, caso contrário {@code false}
     */
    public boolean isAtivo()   { return ativo; }

    /**
     * Calcula o Índice de Massa Corporal (IMC).
     * <p>
     * O cálculo é feito pela fórmula:
     * {@code IMC = peso / (altura²)}
     * utilizando recursividade para o cálculo da potência.
     * </p>
     *
     * @param peso peso da pessoa em kg
     * @param altura altura da pessoa em metros
     * @return valor do IMC calculado
     */
    @Override
    public double calcularIMC(double peso, double altura) {
        double alturaQuadrado = CalculadoraRecursiva.potencia(altura, 2);
        return peso / alturaQuadrado;
    }

    /**
     * Classifica o IMC de acordo com faixas padrão da Organização Mundial da Saúde.
     *
     * @param imc valor do índice de massa corporal calculado
     * @return descrição da classificação do IMC
     */
    @Override
    public String classificarIMC(double imc) {
        if      (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25.0) return "Peso normal";
        else if (imc < 30.0) return "Sobrepeso";
        else if (imc < 35.0) return "Obesidade grau I";
        else if (imc < 40.0) return "Obesidade grau II";
        else                   return "Obesidade grau III";
    }

    /**
     * Retorna uma representação textual do perfil da pessoa.
     *
     * @return dados formatados da pessoa
     */
    @Override
    public String exibirPerfil() {
        return "Pessoa: " + nome + " | Idade: " + idade +
                " | Peso: " + peso + "kg | Altura: " + altura + "m";
    }
}
