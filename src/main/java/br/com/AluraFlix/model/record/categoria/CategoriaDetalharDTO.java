package br.com.AluraFlix.model.record.categoria;

import br.com.AluraFlix.model.Categoria;

public record CategoriaDetalharDTO(String titulo, String cor) {
	public CategoriaDetalharDTO(Categoria cat) {
		this(cat.getTitulo(), cat.getCor());
	}
}
