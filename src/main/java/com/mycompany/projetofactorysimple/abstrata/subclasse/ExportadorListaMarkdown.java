package com.mycompany.projetofactorysimple.abstrata.subclasse;

import java.util.function.Function;

import com.mycompany.projetofactorysimple.abstrata.AbstractExportadorLista;
import com.mycompany.projetofactorysimple.interfaces.Coluna;
import com.mycompany.projetofactorysimple.model.Produto;

public class ExportadorListaMarkdown extends AbstractExportadorLista{

	@Override
	public String abrirTabela() {
		return "";
	}

	@Override
	public String fecharTabela() {
		return "";
	}

	@Override
	public String abrirLinha() {
		return "";
	}

	@Override
	public String fecharLinha() {
		return "";
	}

	@Override
	public String abrirLinhaTitulo() {
		return "";
	}

	@Override
	public String fecharLinhaTitulo() {
		StringBuilder builder = new StringBuilder();
		for(Coluna coluna : getColunas()) {
			builder.append(coluna.abrir() +  "-----");
		}
		 builder.append("\n");
		return builder.toString();
	}

	@Override
	public void addNewColuna(Function<Produto, Object> funcaoValorColuna, String titulo) {
		addColuna(new ColunaMarkdown(funcaoValorColuna, titulo) );
		
	}

}
