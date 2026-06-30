package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Acessorio;
import projeto_final_bloco_01.model.Alimento;
import projeto_final_bloco_01.model.Medicacao;
import projeto_final_bloco_01.model.Produto;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ProdutoController produtoController = new ProdutoController();

	public static void main(String[] args) {

		int opcao;
		
		criarProdutosTeste();

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
				cadastrarProduto();
				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");
				listarProdutos();
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados do Produto - por ID\n\n");
				procurarPorId();
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do Produto\n\n");
				atualizarProduto();
				keyPress();
				break;
			case 5:
				System.out.println("Apagar Produto\n\n");
				deletarProduto();
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

	
	  public static void criarProdutosTeste() { 
		  produtoController.cadastrar( new Alimento(produtoController.gerarId(), "Ração", 1, 200.00f, 2, 10000, "carne")); 
		  produtoController.cadastrar( new Medicacao(produtoController.gerarId(), "Meloxican", 2, 40.00f, 1, 2, "anti-inflamatório", true)); 
		  produtoController.cadastrar( new Acessorio(produtoController.gerarId(), "Osso de Brinquedo", 3, 20.00f, 2, "silicone", 2)); 
	  }
	 

	public static void listarProdutos() {
		produtoController.listarTodos();
	}

	public static void cadastrarProduto() {

		System.out.println("Digite o nome do produto: ");
		String nome = leia.nextLine();

		System.out.println("Selecione a categoria do produto (1 - Alimento | 2 - Medicação ou Suplemento | 3 - Acessório ou brinquedo): ");
		int categoria = leia.nextInt();

		System.out.println("Digite o preço do produto: ");
		float preco = leia.nextFloat();
		
		System.out.println("Selecione o tipo de animal que o produto é destinado \n(1 - Ave | 2 - Cachorro | 3 - Gato | 4 - Réptil | 5 - Peixe): ");
		int tipoAnimal = leia.nextInt();

		switch (categoria) {
			case 1 -> {
				System.out.println("Digite o peso em gramas do produto: ");
				int peso = leia.nextInt();
				
				System.out.println("Digite o sabor do produto: ");
				leia.skip("\\R");
				String sabor = leia.nextLine();
	
				produtoController
						.cadastrar(new Alimento(produtoController.gerarId(), nome, categoria, preco, tipoAnimal, peso, sabor));
			}
			case 2 -> {
				System.out.println("Selecione o tipo de uso do medicamento/suplemento: \n(1 - Uso Tópico | 2 - Ingestão | 3 - Injetável): ");
				int tipoUso = leia.nextInt();
				
				System.out.println("Digite a função do medicamento/suplemento (como antibiótico, anti-inflamatório, vitamina C):");
				String funcao = leia.nextLine();
				
				System.out.printf("\nEsse medicamento exige prescrição? (S/N)");
				String resposta = String.valueOf(leia.next().charAt(0));
				boolean exigePrescricao;
				
				if (resposta.equalsIgnoreCase("S"))
					exigePrescricao = true;
				else
					exigePrescricao = false;
				
				produtoController.cadastrar(new Medicacao(produtoController.gerarId(), nome, categoria, preco, tipoAnimal, tipoUso, funcao, exigePrescricao));
			}
			case 3 -> {
				System.out.println("Digite o principal material do acessório/brinquedo (como silicone, PVC, sisal):");
				String material = leia.nextLine();
				
				System.out.println("Selecione o porte do animal que o acessório/brinquedo é destinado \n(1 - Pequeno | 2 - Médio | 3 - Grande): ");
				int porteAnimal = leia.nextInt();
				
				produtoController.cadastrar(new Acessorio(produtoController.gerarId(), nome, categoria, preco, tipoAnimal, material, porteAnimal));
		}
			default -> System.out.println("Categoria de produto inválida!");
		}
	}

	public static void procurarPorId() {

		System.out.println("Digite o ID do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		produtoController.procurarPorId(id);

	}

	public static void deletarProduto() {

		System.out.println("Digite o ID do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		Optional<Produto> produto = produtoController.buscarNaCollection(id);

		if (produto.isPresent()) {

			// Confirmação da exclusão

			System.out.printf("\nTem certeza que você deseja excluir o produto com ID %d (S/N)?", id);
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S"))
				produtoController.deletar(id);
			else
				System.out.println("\nOperação cancelada!");

		} else {
			System.out.printf("\nO produto com ID %d não foi encontrado!", id);
		}

	}

	public static void atualizarProduto() {

		System.out.println("Digite o ID do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		Optional<Produto> produto = produtoController.buscarNaCollection(id);

		if (produto.isPresent()) {
			// Obtém os dados atuais da produto
			String nome = produto.get().getNome();
			int categoria = produto.get().getCategoria();
			float preco = produto.get().getPreco();
			int tipoAnimal  = produto.get().getTipoAnimal();
			
			// Atualiza o nome ou mantém o valor atual
			System.out.printf("Nome atual: %s"
					+ "%nDigite o novo nome do produto (Pressione ENTER para manter o valor atual): ", nome);
			String entrada = leia.nextLine();

			nome = entrada.isEmpty() ? nome : entrada;

			// Atualiza o preço ou mantém o valor atual
			System.out.printf("Preço atual: %.2f" + "%nDigite o novo preço (Pressione ENTER para manter o valor atual): ",
					preco);
			entrada = leia.nextLine();

			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));
			
			System.out.println("Selecione o tipo de animal que o produto é destinado \nTipos: 1 - Ave | 2 - Cachorro | 3 - Gato | 4 - Réptil | 5 - Peixe : ");
			entrada = leia.nextLine();
			
			tipoAnimal = entrada.isEmpty() ? tipoAnimal : Integer.parseInt(entrada);
			
			switch (categoria) {
			case 1 -> {
				Alimento produtoAlimento = (Alimento) produto.get();
				int peso = produtoAlimento.getPesoEmGramas();
				String sabor = produtoAlimento.getSabor();
			
				System.out.printf(
						"Peso atual: %d" + "%nDigite o novo peso (em gramas) (Pressione ENTER para manter o valor atual): ",
						peso);
				entrada = leia.nextLine();

				peso = entrada.isEmpty() ? peso : Integer.parseInt(entrada);
				
				System.out.printf(
						"Sabor atual: %s" + "%nDigite o novo sabor do alimento (Pressione ENTER para manter o valor atual): ",
						sabor);
				entrada = leia.nextLine();

				sabor = entrada.isEmpty() ? sabor : entrada;

				produtoController.atualizar(new Alimento(id, nome, categoria, preco, tipoAnimal, peso, sabor));

			}
			case 2 -> {
				Medicacao produtoMedicacao = (Medicacao) produto.get();
				int tipoUso = produtoMedicacao.getTipoUso();
				String funcao = produtoMedicacao.getFuncao();
				boolean exigePrescricao = produtoMedicacao.isExigePrescricao();
				String exigePrescricaoString = "";

				// Atualiza o tipo de uso ou mantém o valor atual
				System.out.printf("Tipo de uso atual: %d" + "%nSelecione o novo tipo de uso do produto.\nTipos de uso: 1 - Uso Tópico | 2 - Ingestão | 3 - Injetável"
						+ "(Pressione ENTER para manter o valor atual): ", tipoUso);
				entrada = leia.nextLine();

				tipoUso = entrada.isEmpty() ? tipoUso : Integer.parseInt(entrada);
				
				System.out.printf("Função atual: %s" + "%nDigite a nova função do produto\n(como antibiótico, anti-inflamatório, vitamina C, etc.)"
						+ "(Pressione ENTER para manter o valor atual): ", funcao);
				entrada = leia.nextLine();

				funcao = entrada.isEmpty() ? funcao : entrada;
				
				if(exigePrescricao) {
					exigePrescricaoString = "Sim";
				}else {
					exigePrescricaoString = "Não";
				}
				
				System.out.printf("Exige prescrição? atualmente: %s" + "%nEsse medicamento ainda exige prescrição? (S/N)"
						+ "(Pressione ENTER para manter o valor atual): ", exigePrescricaoString);
				entrada = String.valueOf(leia.next().toLowerCase().charAt(0));
				
				if(!entrada.isEmpty()) {
					switch(entrada) {
					case "s":
						exigePrescricao = true;
						break;
					case "n":
						exigePrescricao = false;
						break;
					}
				}

				produtoController.atualizar(new Medicacao(id, nome, categoria, preco, tipoAnimal, tipoUso, funcao, exigePrescricao));
			}
			case 3 ->{
				Acessorio produtoAcessorio = (Acessorio) produto.get();
				String material = produtoAcessorio.getMaterial();
				int porteAnimal = produtoAcessorio.getPorteAnimal();
				
				System.out.printf("Material atual: %s" + "%nDigite o novo material do produto\n(como silicone, PVC, sisal)"
						+ "(Pressione ENTER para manter o valor atual): ", material);
				entrada = leia.nextLine();
				
				material = entrada.isEmpty() ? material : entrada;
				
				System.out.printf("Porte animal atual: %d" + "%nSelecione o novo porte de animal que o acessório/brinquedo é destinado \nPortes: 1 - Pequeno | 2 - Médio | 3 - Grande"
						+ "(Pressione ENTER para manter o valor atual): ", porteAnimal);
				entrada = leia.nextLine();

				porteAnimal = entrada.isEmpty() ? porteAnimal : Integer.parseInt(entrada);
				
				produtoController.atualizar(new Acessorio(id, nome, categoria, preco, tipoAnimal, material, porteAnimal));
				
				break;
			}	
			default -> System.out.println("Categoria de produto inválida!");
			}

		} else {
			System.out.printf("\nO produto com ID %d não foi encontrado!", id);
		}

	}
}
