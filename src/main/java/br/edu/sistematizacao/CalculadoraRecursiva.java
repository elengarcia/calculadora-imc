package br.edu.sistematizacao;

/**
 * Classe utilitária que implementa operações matemáticas utilizando recursão.
 * <p>
 * Esta classe foi criada com fins didáticos para demonstrar o uso de
 * recursividade em cálculos matemáticos simples.
 * </p>
 */
public class CalculadoraRecursiva {

    /**
     * Calcula a potência de um número utilizando recursão.
     * <p>
     * O método resolve {@code base ^ exp} aplicando recursividade simples.
     * Também suporta expoentes negativos, utilizando a propriedade matemática:
     * {@code base^-n = 1 / base^n}.
     * </p>
     *
     * <p>Casos especiais:</p>
     * <ul>
     *   <li>{@code exp == 0} → retorna 1</li>
     *   <li>{@code exp < 0} → calcula o inverso da potência positiva</li>
     *   <li>{@code base == 0 && exp < 0} → lança exceção</li>
     * </ul>
     *
     * @param base número base da potência
     * @param exp expoente (pode ser positivo, zero ou negativo)
     * @return resultado de {@code base ^ exp}
     *
     * @implNote Implementação recursiva simples (não otimizada para grandes expoentes).
     */
    public static double potencia(double base, int exp) {
        if (exp == 0) return 1;

        if (base == 0 && exp < 0) {
            throw new IllegalArgumentException("0 não pode ser elevado a expoente negativo");
        }

        if (exp < 0) {
            return 1 / potencia(base, -exp);
        }

        return base * potencia(base, exp - 1);
    }
}
