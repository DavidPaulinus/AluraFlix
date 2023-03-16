package br.com.AluraFlix.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AluraFlix.model.Video;

public interface VideoReposiroty extends JpaRepository<Video, Long> {

}
