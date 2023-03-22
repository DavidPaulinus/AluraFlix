package br.com.AluraFlix.model.record.video;

import br.com.AluraFlix.model.Video;

public record VideoListarDTO(Long id, String titulo, String descricao, String url, Long categoriaId) {
	public VideoListarDTO(Video vid) {
		this(vid.getId(), vid.getTitulo(), vid.getDescricao(), vid.getUrl(), vid.getCategoria().getId());
	}
}
