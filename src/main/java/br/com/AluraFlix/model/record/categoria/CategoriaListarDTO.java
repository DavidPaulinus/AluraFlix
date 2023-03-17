package br.com.AluraFlix.model.record.categoria;

import br.com.AluraFlix.model.Categoria;

public record CategoriaListarDTO(String titulo, String cor) {
	public CategoriaListarDTO(Categoria cat) {
		this(cat.getTitulo(), cat.getCor());
	}

}
