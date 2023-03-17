package br.com.AluraFlix.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AluraFlix.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
