package br.com.AluraFlix.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AluraFlix.model.Video;

@Repository 
public interface VideoReposiroty extends JpaRepository<Video, Long> {
	
}
