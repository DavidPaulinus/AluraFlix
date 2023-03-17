package br.com.AluraFlix.model.record.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(
		@NotBlank
		String titulo,
		
		@NotBlank
		String cor) {

}
