package projeto_final_bloco_01.model;

public abstract class Produto {
	int id;
	String nome;
	float preco;
	int tipoAnimal;
	int categoria;
	
	public Produto(int id, String nome, int categoria, float preco, int tipoAnimal) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.tipoAnimal = tipoAnimal;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public int getTipoAnimal() {
		return tipoAnimal;
	}
	
	public void setTipoAnimal(int tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	
	public int getCategoria() {
		return categoria;
	}

	public void visualizar() {

		String categoria = "", tipoAnimal = "";

		switch (this.categoria) {
		case 1:
			categoria = "Alimento";
			break;
		case 2:
			categoria = "Medicação ou Suplemento";
			break;
		case 3:
			categoria = "Acessório ou brinquedo";
			break;
		}
		
		switch (this.tipoAnimal) {
		case 1:
			tipoAnimal = "Ave";
			break;
		case 2:
			tipoAnimal = "Cachorro";
			break;
		case 3:
			tipoAnimal = "Felino";
			break;
		case 4:
			tipoAnimal = "Réptil";
			break;
		case 5:
			tipoAnimal = "Peixe";
			break;
		}

		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Produto:");
		System.out.println("***********************************************************");
		System.out.println("Nome do Produto: " + this.nome);
		System.out.println("ID do Produto: " + this.id);
		System.out.println("Tipo de Produto: " + categoria);
		System.out.println("Para o Tipo de Animal: " + tipoAnimal);
		System.out.printf("Preço: R$ %.2f%n", this.preco);

	}
	
}
