package conta;

import java.util.Scanner;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		// Instanciamento
		ContaCorrente cc1 = new ContaCorrente(123456, 0001, 1, "Ana", 500.0f, 1200.0f);
		cc1.visualizar();
		cc1.sacar(50.5f);
		cc1.visualizar();
		cc1.depositar(200);
		cc1.visualizar();

		ContaCorrente cc2 = new ContaCorrente(34635, 0006, 1, "Jane", 600.0f);
		cc2.visualizar();

		ContaPoupanca cp1 = new ContaPoupanca(673412, 0001, 2, "Maria", 1000.0f, 12);
		cp1.visualizar();
		cp1.sacar(300);
		cp1.visualizar();
		cp1.depositar(1500);
		cp1.visualizar();

		Scanner leia = new Scanner(System.in);

		int opcao;

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
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Ecomic Bank - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta \n\n");
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas \n\n");
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque \n\n");
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito");
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas \n\n");
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida");
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
}
