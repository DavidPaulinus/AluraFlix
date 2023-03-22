package br.com.AluraFlix.model.record.categoria;

import br.com.AluraFlix.model.Categoria;

public record CategoriaDetalharDTO(Long id, String titulo, String cor) {
	public CategoriaDetalharDTO(Categoria cat) {
		this(cat.getId(), cat.getTitulo(), cat.getCor());
	}
}
