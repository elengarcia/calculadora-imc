package br.edu.sistematizacao;

/**
 * Exceção personalizada utilizada para representar erros de validação de entrada do usuário.
 * <p>
 * Esta exceção é lançada quando o usuário fornece dados inválidos durante a execução
 * do sistema, como valores vazios, formatos incorretos ou números fora do intervalo permitido.
 * </p>
 *
 * <p>Por ser uma extensão de {@link RuntimeException}, não exige tratamento obrigatório
 * (unchecked exception), permitindo que o fluxo do sistema seja interrompido ou tratado
 * de forma opcional.</p>
 */
public class EntradaInvalidaException extends  RuntimeException {

    /**
     * Cria uma nova exceção de entrada inválida com uma mensagem descritiva.
     *
     * @param mensagem descrição do erro ocorrido durante a validação da entrada
     */
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
