
package com.mycompany.projetofactorysimple.interfaces;

import java.util.List;
import java.util.function.Function;

import com.mycompany.projetofactorysimple.abstrata.subclasse.ExportadorListaHtml;
import com.mycompany.projetofactorysimple.abstrata.subclasse.ExportadorListaMarkdown;
import com.mycompany.projetofactorysimple.model.Produto;

public interface ExportadorListaProduto {

	String abrirTabela();
	String fecharTabela();
	String abrirLinha();
	String fecharLinha();
	String abrirLinhaTitulo();
	String fecharLinhaTitulo();
	String exportar(List<Produto> listaProduto);

	void addNewColuna(Function<Produto, Object> funcaoValorColuna, String titulo);

	static ExportadorListaProduto newInstance() {
		return newInstance("html");
	}

	static ExportadorListaProduto newInstance(String extensaoArquivoExportacao) {
		if (extensaoArquivoExportacao.equalsIgnoreCase("html"))
			return new ExportadorListaHtml();
		else if (extensaoArquivoExportacao.equalsIgnoreCase("md"))
			return new ExportadorListaMarkdown();
		throw new UnsupportedOperationException("Formato não suportado: " + extensaoArquivoExportacao);
	}

}
