package br.com.AluraFlix.model.record;

import br.com.AluraFlix.model.Video;

public record VideoDetalhamentoDTO(String titulo, String descricao, String url) {
	public VideoDetalhamentoDTO(Video vid) {
		this(vid.getTitulo(), vid.getDescricao(), vid.getUrl());
	}
}
