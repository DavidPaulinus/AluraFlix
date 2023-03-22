package br.com.AluraFlix.model.record.categoria;

import br.com.AluraFlix.model.Categoria;

public record CategoriaListarDTO(Long id, String titulo, String cor) {
	public CategoriaListarDTO(Categoria cat) {
		this(cat.getId(), cat.getTitulo(), cat.getCor());
	}

}
