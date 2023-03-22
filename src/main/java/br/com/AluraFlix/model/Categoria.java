package br.com.AluraFlix.model;

import br.com.AluraFlix.model.record.categoria.CategoriaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_categorias")
@Getter
@NoArgsConstructor
public class Categoria {
	@Id
	private Long id;
	private String titulo;
	private String cor;

	public Categoria(@Valid CategoriaDTO dto) {
		if(dto.id() == null || dto.titulo() == null || dto.cor() == null) {
			throw new NullPointerException("Todos os campos são obrigaórito");
		}
		this.id = dto.id();
		this.titulo = dto.titulo();
		this.cor = dto.cor();
	}

	public void atualizar(@Valid CategoriaDTO dto) {
		if(dto.id() == null || dto.titulo() == null || dto.cor() == null) {
			throw new NullPointerException("Todos os campos são obrigaórito");
		}
		this.id = dto.id();
		this.titulo = dto.titulo();
		this.cor = dto.cor();
	}

	public Categoria(Long id, String titulo, String cor) {
		if(id == null || titulo == null || cor == null) {
			throw new NullPointerException("Todos os campos são obrigaórito");
		}
		this.id = id;
		this.titulo = titulo;
		this.cor = cor;
	}

}
