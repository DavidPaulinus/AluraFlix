package br.com.AluraFlix.util.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.AluraFlix.model.Categoria;
import br.com.AluraFlix.model.Video;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	@Query("SELECT v FROM Video v WHERE v.categoria.id = :id")
	List<Video> achaVideoPorCategoria(Long id);

}
