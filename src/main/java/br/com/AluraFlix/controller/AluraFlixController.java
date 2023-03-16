package br.com.AluraFlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.AluraFlix.model.record.VideoListarDTO;
import br.com.AluraFlix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class AluraFlixController {
	
	@Autowired
	private VideoService service;
	
	@GetMapping
	public ResponseEntity<Page<VideoListarDTO>> getVideos(){
		return ResponseEntity.ok(service.listar().map(VideoListarDTO::new));
	} 
}
