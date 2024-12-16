package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo = 0, limite;
		
		System.out.println("\nCriar contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 
		100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 
		100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f,
		12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Mariana dos Santos", 8000f,
		18);
		contas.cadastrar(cp2);

		Scanner leia = new Scanner(System.in);

		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO Economic Bank                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " 
			+ Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Ecomic Bank - O seu Futuro "
				+ "começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta \n\n");

				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();

					switch (tipo) {
						case 1 -> {
							System.out.println("Digite o limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, 
							titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do Aniversário da Conta: ");
							aniversario = leia.nextInt();
							contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, 
							titular, saldo, aniversario));
						}
					}

				} while (tipo < 1 && tipo > 2);

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas \n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque \n\n");
				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito");
				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas \n\n");
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida");
				keyPress();
				break;
			}
		}

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Beatriz Novais");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
