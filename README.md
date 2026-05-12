# Sistema de Reserva de Salas de Estudo

## Descrição do Projeto

Este projeto simula um sistema de reserva de salas de estudo para uma universidade, atendendo a requisitos específicos de funcionalidade e aplicando diversos padrões de projeto de software. O objetivo é gerenciar a disponibilidade de diferentes tipos de salas, permitir reservas e cancelamentos, detectar colisões de horários e notificar usuários sobre eventos importantes, além de gerar relatórios. A implementação visa demonstrar um desenvolvimento orgânico e colaborativo, utilizando o GitHub para controle de versão.

## Requisitos Funcionais Implementados

### O sistema atende aos seguintes requisitos funcionais:

- RF-01: Gerenciamento de Salas: O sistema permite a criação e gerenciamento de diferentes tipos de salas (individuais, de grupo, laboratórios), cada uma com suas características específicas.

- RF-02: Reserva e Cancelamento: Usuários podem reservar salas para períodos específicos e cancelar reservas existentes.

- RF-03: Detecção de Colisões: O sistema detecta automaticamente conflitos de horário para a mesma sala e aplica políticas de reserva para resolver ou impedir tais colisões.

- RF-04: Notificações: Usuários são notificados (simuladamente via console) sobre a confirmação ou cancelamento de suas reservas.

- RF-05: Relatórios Diários: O sistema gera relatórios diários das reservas realizadas, fornecendo um resumo das atividades.

- RF-06 (Extensão - Decorator): Serviços Adicionais: Permite adicionar serviços extras às reservas (e.g., equipamento multimídia, serviço de limpeza) de forma dinâmica, com custos associados.


## Estrutura do Projeto

```
src/		# Código-fonte principal
docs/		# Diagramas e documentação complementar
README.md	# Instruções de uso, visão geral e autores
```

## Como Rodar o Projeto

Este projeto é um aplicativo Java simples de console. Para compilá-lo e executá-lo, siga os passos abaixo:

### Pré-requisitos

*   **Java Development Kit (JDK) 11 ou superior**: Certifique-se de ter o JDK instalado e configurado em sua máquina. Você pode verificar a versão do Java com `java -version` e `javac -version`.

### Compilação

1.  Navegue até o diretório raiz do projeto `ProjOO-EP-ReservaDeSalas` no seu terminal:
    ```bash
    cd ProjOO-EP-ReservaDeSalas
    ```

2.  Compile os arquivos Java. Você pode fazer isso manualmente ou usando um sistema de build como Maven ou Gradle. Para uma compilação manual simples:
    ```bash
    javac -d out src/main/java/com/universidade/reserva/*.java src/main/java/com/universidade/reserva/factories/*.java src/main/java/com/universidade/reserva/observers/*.java src/main/java/com/universidade/reserva/salas/*.java src/main/java/com/universidade/reserva/strategies/*.java src/main/java/com/universidade/reserva/decorator/*.java 
    ```
    Isso criará um diretório `out` e colocará os arquivos `.class` compilados lá, mantendo a estrutura de pacotes.

### Execução

1.  Após a compilação, execute o programa a partir do diretório raiz do projeto, especificando o diretório `out` como o classpath:
    ```bash
    java -cp out com.universidade.reserva.Main
    ```

2.  O programa iniciará um menu interativo no console, onde você poderá criar, cancelar e listar reservas, além de gerar relatórios e mudar a política de reserva.

### Exemplo de Interação

```
Sistema de Reserva de Salas de Estudo iniciado.

Salas disponíveis configuradas: [Sala Individual 101, Sala de Grupo 201, Laboratório 301]

--- Menu Principal ---
1. Criar Reserva
2. Cancelar Reserva
3. Listar Todas as Reservas
4. Gerar Relatório Diário
5. Mudar Política de Reserva (Atual: PoliticaPrimeiroAReservar)
6. Demonstrar Padrão Decorator
0. Sair
Escolha uma opção: 1

--- Criar Nova Reserva ---
Tipo da Sala (individual, grupo, laboratorio): individual
Nome da Sala: Sala Individual 101
Capacidade da Sala (apenas para grupo/laboratorio, digite 0 para individual): 0
Nome do Usuário: alunoTeste
Início (AAAA-MM-DD HH:MM): 2026-05-12 10:00
Fim (AAAA-MM-DD HH:MM): 2026-05-12 11:00
Reserva criada com sucesso: Reserva [ID=..., Sala=Sala Individual 101, Usuário=alunoTeste, Início=2026-05-12T10:00, Fim=2026-05-12T11:00, Custo Total=50.00]
[Notificação por Email] Enviando email para alunoTeste sobre a ação 'criada' na reserva: ...
[Relatório Diário] Atualizado para a data: 2026-05-12

--- Menu Principal ---
...
Escolha uma opção: 6

--- Demonstração do Padrão Decorator ---
Reserva Base: Reserva da Sala de Grupo 305 por alunoDecorator de 14:00 a 16:00 | Custo: 50.00
Reserva com Multimídia: Reserva da Sala de Grupo 305 por alunoDecorator de 14:00 a 16:00, com equipamento multimídia | Custo: 75.00
Reserva Completa (Multimídia + Limpeza): Reserva da Sala de Grupo 305 por alunoDecorator de 14:00 a 16:00, com equipamento multimídia, com serviço de limpeza | Custo: 105.00
Outra Reserva (Limpeza + Multimídia): Reserva da Sala de Grupo 305 por professorDecorator de 16:00 a 18:00, com serviço de limpeza, com equipamento multimídia | Custo: 105.00

Observação: As reservas decoradas acima são apenas para demonstração do padrão Decorator e não são persistidas no ReservaService.

--- Menu Principal ---
...
Escolha uma opção: 0
Saindo...
Sistema de Reserva de Salas de Estudo finalizado.
```

## Autores

- Enrico Manzolli Bertoni - RA: 176259
- Nicolas Almeida Faria - RA: 178194
