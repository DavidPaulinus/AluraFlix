package br.com.AluraFlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.AluraFlix.model.Video;
import br.com.AluraFlix.model.record.VideoDTO;
import br.com.AluraFlix.model.record.VideoDetalhamentoDTO;
import br.com.AluraFlix.model.record.VideoListarDTO;
import br.com.AluraFlix.service.VideoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/videos")
public class AluraFlixController {
	
	@Autowired
	private VideoService service;
	
	@GetMapping
	public ResponseEntity<Page<VideoListarDTO>> getVideos(){
		return ResponseEntity.ok(service.listar().map(VideoListarDTO::new));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VideoDetalhamentoDTO> getVideo(@PathVariable Long id){
		return ResponseEntity.ok(new VideoDetalhamentoDTO(service.detalharPorId(id)));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VideoDetalhamentoDTO> cadastraVideo(@RequestBody @Valid VideoDTO dto, UriComponentsBuilder uri){
		var video = new Video(dto);	
		service.salvarVideo(video);
		
		return ResponseEntity.created(
				uri.path("/videos").
				buildAndExpand(video.getId()).toUri()
				)
				.body(new VideoDetalhamentoDTO(video));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VideoDetalhamentoDTO> atualizarVideo(@RequestBody @Valid VideoDTO dto, @PathVariable Long id){
		var vid = service.atualizar(id, dto);
		
		return ResponseEntity.ok(new VideoDetalhamentoDTO(vid));
	}
}
