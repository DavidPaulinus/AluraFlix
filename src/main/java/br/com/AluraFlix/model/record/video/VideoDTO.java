package br.com.AluraFlix.model.record.video;

import jakarta.validation.constraints.NotBlank;

public record VideoDTO(
		@NotBlank
		String titulo,
		
		@NotBlank
		String descricao,
		
		@NotBlank
		String url) {

}
