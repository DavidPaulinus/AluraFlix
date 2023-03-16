package br.com.AluraFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.AluraFlix.model.Video;
import br.com.AluraFlix.util.repository.VideoReposiroty;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VideoService {

	@Autowired
	private VideoReposiroty repo;

	public Page<Video> listar() {
		return new PageImpl<Video>(repo.findAll());
	}

	public Video detalharPorId(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Não encontrado."));
	}

	public void salvarVideo(Video video) {
		repo.save(video);
	}

}
