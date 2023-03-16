package br.com.AluraFlix.model;

import br.com.AluraFlix.model.record.VideoDTO;
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
@Table(name = "tb_videos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private String url;

	public Video(@Valid VideoDTO dto) {
		this.titulo = dto.titulo();
		this.descricao = dto.descricao();
		this.url = dto.url();
	}
}
