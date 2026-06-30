package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository{
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void listarTodos() {
		for(var Produto : listaProdutos) {
			Produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Produto Produto) {
		listaProdutos.add(Produto);
		System.out.printf("O Produto com ID %d foi cadastrado com sucesso!%n", Produto.getId());
	}

	@Override
	public void procurarPorId(int id) {
		
		Optional<Produto> Produto = buscarNaCollection(id);
		
		if (Produto.isPresent())
			Produto.get().visualizar();
		else
			System.out.printf("\nO Produto com ID %d não foi encontrado!", id);
		
	}

	@Override
	public void atualizar(Produto Produto) {
		
		Optional<Produto> buscaProduto = buscarNaCollection(Produto.getId());
		
		if (buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), Produto);
			System.out.printf("\nO Produto com ID %d foi atualizado com sucesso!", Produto.getId());
		}else
			System.out.printf("\nO Produto com ID %d não foi encontrado!", Produto.getId());
		
	}

	@Override
	public void deletar(int id) {

		Optional<Produto> Produto = buscarNaCollection(id);
		
		if (Produto.isPresent()) {
			if (listaProdutos.remove(Produto.get()))
				System.out.printf("\nO Produto com ID %d foi excluído com sucesso!", id);
		}else
			System.out.printf("\nO Produto com ID %d não foi encontrado!", id);
		
	}
	
	public int gerarId() {
		return ++ id;
	}
	
	public Optional<Produto> buscarNaCollection(int id){
		for(var produto : listaProdutos) {
			if (produto.getId() == id)
				return Optional.of(produto);
		}
		return Optional.empty();
	}
}
