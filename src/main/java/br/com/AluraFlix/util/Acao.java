package br.com.AluraFlix.util;

import br.com.AluraFlix.model.Categoria;

public class Acao {
	public Categoria verificaCategoria(Categoria cat){

		if (cat == null) {
			return new Categoria(1l, "LIVRE", "COR");
		}		
		return cat;
	}

}
