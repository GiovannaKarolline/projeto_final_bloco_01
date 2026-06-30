package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                 Pestshop SeuPetFeliz                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por ID                ");
			System.out.println("            4 - Atualizar Dados do Produto           ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro!");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("\nPestshop SeuPetFeliz - Para quem cuida dos seus pequenos");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Produto\n\n");

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados do Produto - por ID\n\n");

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do Produto\n\n");

				keyPress();
				break;
			case 5:
				System.out.println("Apagar Produto\n\n");

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Giovanna Karolline");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/GiovannaKarolline");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		System.out.println("\n\nPressione Enter para Continuar...");
		leia.nextLine();
	}
}
