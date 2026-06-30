package projeto_final_bloco_01.model;

public class Acessorio extends Produto{
	String material;
	int porteAnimal;
	
	public Acessorio(int id, String nome, int categoria, float preco, int tipoAnimal, String material, int porteAnimal) {
		super(id, nome, categoria, preco, tipoAnimal);
		this.material = material;
		this.porteAnimal = porteAnimal;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getPorteAnimal() {
		return porteAnimal;
	}

	public void setPorteAnimal(int porteAnimal) {
		this.porteAnimal = porteAnimal;
	}

	@Override
	public void visualizar() {
		
		String porte = "";

		switch (this.porteAnimal) {
		case 1:
			porte = "Pequeno";
			break;
		case 2:
			porte = "Médio";
			break;
		case 3:
			porte = "Grande";
			break;
		}
		
		super.visualizar();
		System.out.println("Material: " + this.material);
		System.out.println("Para o porte de animal: " + porte);
	}
	
	
	
}
