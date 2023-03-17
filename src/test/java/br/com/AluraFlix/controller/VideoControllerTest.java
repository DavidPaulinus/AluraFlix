package br.com.AluraFlix.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.AluraFlix.model.record.VideoDTO;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
public class VideoControllerTest {
	
	@Autowired
	private MockMvc mock;

	@Autowired
	private JacksonTester<VideoDTO> json;
	
	private String uri = "/videos";
	
	@Test
	void deveRetornar201PorCadastrarVideo() throws Exception {		
		var video = json.write(new VideoDTO("titulo","descricao","url")).getJson();
		
		mock.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.content(video)
				).andExpect(MockMvcResultMatchers.status().is(201));
	}
	
	@Test
	void deveRetornar200PorDetalharVideoPorId() throws Exception {		
		mock.perform(MockMvcRequestBuilders.get(uri + "/{id}", 4)).andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void deveRetornar200PorListarVideos() throws Exception {
		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void deveRetornar200PorAtualizarVideo() throws Exception {
		var video = json.write(new VideoDTO("titulo2","descricao","url")).getJson();
		
		mock.perform(MockMvcRequestBuilders.put(uri + "/{id}", 4)
				.contentType(MediaType.APPLICATION_JSON)
				.content(video)	
				).andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void deveRetornar200PorApagarVideo() throws Exception {
		mock.perform(MockMvcRequestBuilders.delete(uri+"/{id}", 4)).andExpect(MockMvcResultMatchers.status().is(200));
	}
}
