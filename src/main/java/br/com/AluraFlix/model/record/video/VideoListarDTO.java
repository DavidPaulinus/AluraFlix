package br.com.AluraFlix.model.record.video;

import br.com.AluraFlix.model.Video;

public record VideoListarDTO(String titulo, String descricao, String url) {
	public VideoListarDTO(Video vid) {
		this(vid.getTitulo(), vid.getDescricao(), vid.getUrl());
	}
}
