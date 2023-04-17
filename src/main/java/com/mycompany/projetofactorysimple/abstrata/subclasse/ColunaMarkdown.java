package com.mycompany.projetofactorysimple.abstrata.subclasse;

import java.util.function.Function;

import com.mycompany.projetofactorysimple.abstrata.AbstractColuna;
import com.mycompany.projetofactorysimple.model.Produto;

class ColunaMarkdown extends AbstractColuna{
	
	public ColunaMarkdown(Function<Produto, Object> obtemValorColuna, String titulo) {
		super(obtemValorColuna, titulo);
	}

	@Override
	public String abrir() {
		return " | ";
	}

	@Override
	public String fechar() {
		return "";
	}

}
