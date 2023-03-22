package br.com.AluraFlix.model;

import br.com.AluraFlix.model.record.video.VideoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	
	public Video(@Valid VideoDTO dto){
		this.id = dto.id();
		this.titulo = dto.titulo();
		this.descricao = dto.descricao();
		this.url = dto.url();
		this.categoria = dto.categoria();
	}

	public void atualizar(@Valid VideoDTO dto){
		this.id = dto.id();
		this.titulo = dto.titulo();
		this.descricao = dto.descricao();
		this.url = dto.url();
		this.categoria = dto.categoria();
	}
}
