package com.universidade.reserva;

import com.universidade.reserva.observers.NotificacaoEmailObserver;
import com.universidade.reserva.observers.RelatorioDiarioObserver;
import com.universidade.reserva.strategies.PoliticaPrimeiroAReservar;
import com.universidade.reserva.strategies.PoliticaPrioridadeProfessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ReservaService reservaService;
    private static Scanner scanner;
    private static RelatorioDiarioObserver relatorioObserver;

    public static void main(String[] args) {
        System.out.println("Sistema de Reserva de Salas de Estudo iniciado.\n");

        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println("Salas disponíveis configuradas: " + config.getAvailableRooms() + "\n");

        reservaService = new ReservaService();
        scanner = new Scanner(System.in);

        // Registrar observadores
        reservaService.adicionarObservador(new NotificacaoEmailObserver());
        relatorioObserver = new RelatorioDiarioObserver();
        reservaService.adicionarObservador(relatorioObserver);

        menuPrincipal();

        scanner.close();
        System.out.println("\nSistema de Reserva de Salas de Estudo finalizado.");
    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Criar Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Listar Todas as Reservas");
            System.out.println("4. Gerar Relatório Diário");
            System.out.println("5. Mudar Política de Reserva (Atual: " + reservaService.politicaDeReserva.getClass().getSimpleName() + ")");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    criarReserva();
                    break;
                case 2:
                    cancelarReserva();
                    break;
                case 3:
                    listarTodasReservas();
                    break;
                case 4:
                    gerarRelatorioDiario();
                    break;
                case 5:
                    mudarPoliticaDeReserva();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void criarReserva() {
        System.out.println("\n--- Criar Nova Reserva ---");
        System.out.print("Tipo da Sala (individual, grupo, laboratorio): ");
        String tipoSala = scanner.nextLine();
        System.out.print("Nome da Sala: ");
        String nomeSala = scanner.nextLine();
        System.out.print("Capacidade da Sala (apenas para grupo/laboratorio, digite 0 para individual): ");
        int capacidadeSala = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Início (AAAA-MM-DD HH:MM): ");
        String inicioStr = scanner.nextLine();
        System.out.print("Fim (AAAA-MM-DD HH:MM): ");
        String fimStr = scanner.nextLine();

        try {
            LocalDateTime inicio = LocalDateTime.parse(inicioStr.replace(" ", "T"));
            LocalDateTime fim = LocalDateTime.parse(fimStr.replace(" ", "T"));

            reservaService.criarReserva(tipoSala, nomeSala, capacidadeSala, usuario, inicio, fim);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data/hora inválido. Use AAAA-MM-DD HH:MM.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void cancelarReserva() {
        System.out.println("\n--- Cancelar Reserva ---");
        System.out.print("ID da Reserva a cancelar: ");
        String idReserva = scanner.nextLine();
        reservaService.cancelarReserva(idReserva);
    }

    private static void listarTodasReservas() {
        System.out.println("\n--- Todas as Reservas ---");
        List<Reserva> todasReservas = reservaService.getAllReservas();
        if (todasReservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (Reserva r : todasReservas) {
                System.out.println(r);
            }
        }
    }

    private static void gerarRelatorioDiario() {
        System.out.println("\n--- Gerar Relatório Diário ---");
        System.out.print("Data do relatório (AAAA-MM-DD): ");
        String dataStr = scanner.nextLine();
        try {
            LocalDate data = LocalDate.parse(dataStr);
            relatorioObserver.gerarRelatorioDiario(data);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Use AAAA-MM-DD.");
        }
    }

    private static void mudarPoliticaDeReserva() {
        System.out.println("\n--- Mudar Política de Reserva ---");
        System.out.println("1. Política 'Primeiro a Reservar'");
        System.out.println("2. Política 'Prioridade para Professor'");
        System.out.print("Escolha a nova política: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        switch (escolha) {
            case 1:
                reservaService.setPoliticaDeReserva(new PoliticaPrimeiroAReservar());
                System.out.println("Política de reserva alterada para 'Primeiro a Reservar'.");
                break;
            case 2:
                reservaService.setPoliticaDeReserva(new PoliticaPrioridadeProfessor());
                System.out.println("Política de reserva alterada para 'Prioridade para Professor'.");
                break;
            default:
                System.out.println("Opção inválida. A política de reserva não foi alterada.");
        }
    }
}
