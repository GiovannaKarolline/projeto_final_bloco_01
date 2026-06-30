package projeto_final_bloco_01.model;

public class Alimento extends Produto{
	int pesoEmGramas;
	String sabor;
	
	public Alimento(int id, String nome, int categoria, float preco, int tipoAnimal, int pesoEmGramas, String sabor) {
		super(id, nome, categoria, preco, tipoAnimal);
		this.pesoEmGramas = pesoEmGramas;
		this.sabor = sabor;
	}

	public int getPesoEmGramas() {
		return pesoEmGramas;
	}

	public void setPesoEmGramas(int pesoEmGramas) {
		this.pesoEmGramas = pesoEmGramas;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Peso em Gramas: " + this.pesoEmGramas);
		System.out.println("Sabor: " + this.sabor);
	}
	
}
