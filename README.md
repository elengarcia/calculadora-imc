# Calculadora IMC 1.0

## Descrição

Sistema de cálculo de IMC (Índice de Massa Corporal) desenvolvido em Java para demonstrar conceitos de Programação Orientada a Objetos (POO).

O sistema permite cadastrar pessoas e atletas, calcular o IMC, exibir a classificação correspondente e manter um histórico dos cálculos realizados durante a execução do programa.

---

## Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

* Java JDK 21 ou superior
* Maven 3.8 ou superior
* Terminal ou IDE compatível com Java

Verificar versões instaladas:

```bash
java -version
mvn -version
```

---

## Dependências Utilizadas

O projeto utiliza bibliotecas externas para melhorar a experiência de desenvolvimento e a interface em terminal (CLI), além de aplicar boas práticas de código.

### Jansi (org.fusesource.jansi)

```xml
<dependency>
    <groupId>org.fusesource.jansi</groupId>
    <artifactId>jansi</artifactId>
    <version>2.4.0</version>
</dependency>
```
A biblioteca Jansi foi utilizada para permitir a utilização de cores e formatação ANSI no terminal, tornando a interface mais intuitiva e legível.

No contexto do projeto, ela é aplicada para:

 - Destacar mensagens de erro, sucesso e alerta
 - Melhorar a experiência do usuário no CLI
 - Simular uma interface mais interativa sem uso de GUI
 - Garantir compatibilidade entre diferentes sistemas operacionais

### JetBrains Annotations (org.jetbrains:annotations)

```xml
<dependency>
    <groupId>org.jetbrains</groupId>
    <artifactId>annotations</artifactId>
    <version>24.0.1</version>
</dependency>
```
A biblioteca JetBrains Annotations foi utilizada para reforçar a qualidade e legibilidade do código através de anotações como @NotNull.

No projeto, ela contribui para:

 - Documentação explícita de contratos de métodos
 - Melhoria na leitura e manutenção do código
 - Auxílio em análise estática por IDEs
 - Redução de erros como NullPointerException
 - Maior clareza na intenção dos parâmetros

---

## Como compilar

### Utilizando Maven

```bash
mvn clean compile
```

Ou gerar o pacote:

```bash
mvn clean package
```

---

## Como executar

### Pela IDE

Execute a classe:

```text
Main.java
```

### Pelo Maven

```bash
mvn exec:java -Dexec.mainClass="Main"
```

### Pelo arquivo JAR (caso gerado)

```bash
java -jar target/calculadora-imc-1.0-0.jar
```

---

## Demonstração de uso

Exemplo de execução:

```text
⚡ Sistema de Cálculo de IMC ⚡

╔══════════════════════════════════════════════════╗
║               ⚡ SISTEMA IMC 1.0 ⚡                ║
╠══════════════════════════════════════════════════╣
║  [1] Cadastrar Pessoa                            ║
║  [2] Cadastrar Atleta                            ║
║  [3] Calcular IMC (última pessoa cadastrada)     ║
║  [4] Exibir Histórico                            ║
║  [0] Encerrar Sistema                            ║
╚══════════════════════════════════════════════════╝

➜ Opção:
1

➜ Nome: Marcos Palmeira
➜ Idade: 25
➜ Peso (kg): 80
➜ Altura (m): 1.75

Pessoa cadastrada com sucesso!

➜ Opção:
3

╔══════════════════════════════════════════════════╗
║  ⚡ SISTEMA IMC 1.0 ⚡                             ║
║  HISTÓRICO                                       ║
╚══════════════════════════════════════════════════╝
Carregando histórico!
.....

   → Marcos Palmeira → IMC: 26.12 (Sobrepeso)
```

---

## Estrutura do Projeto

```text
src/br/edu/sistematizacao/
├── Main.java
├── MenuUI.java
├── SistemaIMC.java
├── Pessoa.java
├── Atleta.java
├── PessoaBase.java
├── CalculadoraIMC.java
├── CalculadoraRecursiva.java
├── Historico.java
└── EntradaInvalidaException.java
```

### Principais classes
| Classe                   | Responsabilidade                                                                                  |
|--------------------------|---------------------------------------------------------------------------------------------------|
| Main                     | Ponto de entrada da aplicação e controle do fluxo principal do sistema                            |
| MenuUI                   | Responsável pela interface de console, exibição de menus e leitura de dados do usuário            |
| SistemaIMC               | Gerencia os cálculos de IMC e o histórico de registros realizados                                 |
| Pessoa                   | Representa uma pessoa cadastrada com nome, idade, peso e altura                                   |
| Atleta                   | Especialização da classe Pessoa com classificação de IMC diferenciada                             |
| PessoaBase               | Classe base para reutilização de atributos e comportamentos comuns                                |
| CalculadoraIMC           | Interface responsável por definir o contrato de cálculo e classificação de IMC |
| CalculadoraRecursiva     | Implementa operações matemáticas utilizando recursão para fins didáticos                          |
| Historico                | Gerencia o armazenamento e exibição do histórico de cálculos |
| EntradaInvalidaException | Exceção personalizada utilizada para validação das entradas do usuário                            |

---

## Conceitos de Programação Orientada a Objetos Aplicados

O projeto foi desenvolvido utilizando os principais conceitos de POO:

### Encapsulamento

Os atributos das classes são privados e acessados por métodos públicos, garantindo controle sobre os dados.

### Herança

A classe `Atleta` herda características da classe `Pessoa`, reutilizando atributos e comportamentos comuns.

### Polimorfismo

A classificação do IMC pode ser sobrescrita na classe `Atleta`, permitindo comportamentos diferentes para objetos tratados pela mesma referência do tipo `Pessoa`.

### Composição

A classe `SistemaIMC` mantém um objeto `Histórico`, reunindo os cálculos realizados durante a sessão.

### Tratamento de Exceções

O sistema utiliza a exceção personalizada `EntradaInvalidaException` para validar dados digitados pelo usuário e garantir maior robustez na entrada de informações.

---

## Notas do Autor

Projeto desenvolvido para fins acadêmicos com foco na aplicação de conceitos de Programação Orientada a Objetos em Java.
