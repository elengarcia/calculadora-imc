package br.edu.sistematizacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar e exibir o histórico de cálculos de IMC.
 * <p>
 * Esta classe mantém uma lista de registros gerados durante a execução do sistema,
 * permitindo o acompanhamento dos cálculos realizados em uma sessão.
 * </p>
 */
public class Historico {
    private final List<String> registros = new ArrayList<>();

    /**
     * Classe responsável por armazenar e exibir o histórico de cálculos de IMC.
     * <p>
     * Esta classe mantém uma lista de registros gerados durante a execução do sistema,
     * permitindo o acompanhamento dos cálculos realizados em uma sessão.
     * </p>
     */
    public void adicionar(String r) { registros.add(r); }

    /**
     * Exibe todos os registros armazenados no histórico.
     * <p>
     * Caso não existam registros, uma mensagem informando a ausência de dados
     * é exibida no console.
     * </p>
     */
    public void exibir() {
        if (registros.isEmpty()) {
            System.out.println("Nenhum cálculo registrado."); return;
        }
        for (String r : registros) System.out.println("  → " + r);
    }
}
