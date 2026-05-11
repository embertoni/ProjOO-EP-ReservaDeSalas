# Sistema de Reserva de Salas de Estudo

Este projeto implementa um sistema de reserva de salas de estudo para um campus universitário, permitindo que estudantes e professores consultem a disponibilidade de salas, façam reservas e recebam notificações sobre alterações ou conflitos.

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
    javac -d out src/main/java/com/universidade/reserva/*.java src/main/java/com/universidade/reserva/factories/*.java src/main/java/com/universidade/reserva/observers/*.java src/main/java/com/universidade/reserva/salas/*.java src/main/java/com/universidade/reserva/strategies/*.java
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
0. Sair
Escolha uma opção: 1

--- Criar Nova Reserva ---
Tipo da Sala (individual, grupo, laboratorio): individual
Nome da Sala: Sala Individual 101
Capacidade da Sala (apenas para grupo/laboratorio, digite 0 para individual): 0
Nome do Usuário: aluno1
Início (AAAA-MM-DD HH:MM): 2026-05-11 09:00
Fim (AAAA-MM-DD HH:MM): 2026-05-11 10:00
Reserva criada com sucesso: Reserva [ID=..., Sala=Sala Individual 101, Usuário=aluno1, Início=2026-05-11T09:00, Fim=2026-05-11T10:00]
[Notificação por Email] Enviando email para aluno1 sobre a ação 'criada' na reserva: ...
[Relatório Diário] Atualizado para a data: 2026-05-11

... (e assim por diante)
```

## Autores

- Enrico Manzolli Bertoni - RA: 176259
- Nicolas Almeida Faria - RA: 178194
