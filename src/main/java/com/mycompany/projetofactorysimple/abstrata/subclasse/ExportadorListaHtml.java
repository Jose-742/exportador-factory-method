
package com.mycompany.projetofactorysimple.abstrata.subclasse;

import java.util.function.Function;

import com.mycompany.projetofactorysimple.abstrata.AbstractExportadorLista;
import com.mycompany.projetofactorysimple.model.Produto;

public class ExportadorListaHtml  extends AbstractExportadorLista {

	@Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>";
    }

    @Override
    public String abrirLinha() {
        return "<tr>";
    }

    @Override
    public String fecharLinha() {
        return "</tr>";
    }

    @Override
    public String abrirLinhaTitulo() {
    	 return "<tr>";
    }

    @Override
    public String fecharLinhaTitulo() {
    	 return "</tr>";
    }

	@Override
	public void addNewColuna(Function<Produto, Object> funcaoValorColuna, String titulo) {
		 addColuna(new ColunaHtml(funcaoValorColuna, titulo));
	}
}
