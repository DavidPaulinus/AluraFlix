package br.com.AluraFlix.model.record.video;

import br.com.AluraFlix.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VideoDTO(
		@NotNull Long id,
		
		@NotBlank String titulo,

		@NotBlank String descricao,

		@NotBlank String url,

		Categoria categoria) {

}
