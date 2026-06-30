package projeto_final_bloco_01.model;

public class Medicacao extends Produto{
	int tipoUso;
	String funcao;
	boolean exigePrescricao;
	
	public Medicacao(int id, String nome, int categoria, float preco, int tipoAnimal, int tipoUso, String funcao,
			boolean exigePrescricao) {
		super(id, nome, categoria, preco, tipoAnimal);
		this.tipoUso = tipoUso;
		this.funcao = funcao;
		this.exigePrescricao = exigePrescricao;
	}

	public int getTipoUso() {
		return tipoUso;
	}

	public void setTipoUso(int tipoUso) {
		this.tipoUso = tipoUso;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public boolean isExigePrescricao() {
		return exigePrescricao;
	}

	public void setExigePrescricao(boolean exigePrescricao) {
		this.exigePrescricao = exigePrescricao;
	}

	@Override
	public void visualizar() {
		String exigePrescricao = "", tipoUso = "";
		
		if(this.exigePrescricao) {
			exigePrescricao = "Sim";
		}else {
			exigePrescricao = "Não";
		}
		
		switch(this.tipoUso) {
		case 1:
			tipoUso = "Uso tópico";
			break;
		case 2:
			tipoUso = "Ingestão";
			break;
		case 3:
			tipoUso = "Injetável";
			break;
		}

		super.visualizar();
		System.out.println("Tipo de Uso: " + tipoUso);
		System.out.println("Função: " + this.funcao);
		System.out.println("Exige prescrição? " + exigePrescricao);
	}
}
