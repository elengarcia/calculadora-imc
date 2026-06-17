package br.edu.sistematizacao;

/**
 * Classe base abstrata que representa os dados comuns de uma pessoa no sistema.
 * <p>
 * Esta classe serve como estrutura base para outras entidades, como {@link Pessoa}
 * e {@link Atleta}, centralizando atributos e comportamentos comuns.
 * </p>
 *
 * <p>Por ser abstrata, não pode ser instanciada diretamente, sendo utilizada
 * apenas como superclasse.</p>
 */
public abstract class PessoaBase {
    protected String nome;
    protected int    idade;

    /**
     * Cria uma instância base de pessoa com nome e idade.
     *
     * @param nome nome da pessoa
     * @param idade idade da pessoa
     */
    public PessoaBase(String nome, int idade) {
        this.nome  = nome;
        this.idade = idade;
    }

    /**
     * Retorna uma representação textual do perfil da pessoa.
     * <p>
     * Este método deve ser implementado pelas subclasses para fornecer
     * informações específicas de cada tipo de pessoa.
     * </p>
     *
     * @return descrição formatada do perfil
     */
    public abstract String exibirPerfil();

    /**
     * Retorna o nome da pessoa.
     *
     * @return nome da pessoa
     */
    public String getNome()  { return nome; }

    /**
     * Retorna a idade da pessoa.
     *
     * @return idade da pessoa
     */
    public int    getIdade() { return idade; }
}
