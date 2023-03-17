package br.com.AluraFlix.model;

import br.com.AluraFlix.model.record.categoria.CategoriaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_catorias")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String cor;

	public Categoria(CategoriaDTO dto) {
		this.titulo = dto.titulo();
		this.cor = dto.cor();
	}

	public void atualizar(@Valid CategoriaDTO dto) {
		this.titulo = dto.titulo();
		this.cor = dto.cor();		
	}
}
