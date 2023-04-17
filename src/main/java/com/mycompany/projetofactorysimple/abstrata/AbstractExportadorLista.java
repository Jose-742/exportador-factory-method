
package com.mycompany.projetofactorysimple.abstrata;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.projetofactorysimple.interfaces.Coluna;
import com.mycompany.projetofactorysimple.interfaces.ExportadorListaProduto;
import com.mycompany.projetofactorysimple.model.Produto;

public abstract class AbstractExportadorLista implements ExportadorListaProduto {
    private final List<Coluna> colunas;
    
	public AbstractExportadorLista(){
        colunas = new ArrayList<>();
        addNewColuna(Produto::getId, "ID");
        addNewColuna(Produto::getDescricao, "Descrição");
        addNewColuna(Produto::getMarca, "Marca");
        addNewColuna(Produto::getModelo, "Modelo");
        addNewColuna(Produto::getEstoque, "Estoque");
    }
	
	protected void addColuna(Coluna coluna) {    	
		colunas.add(coluna);
	}
	
    
    @Override
    public String exportar(List<Produto> listaProdutos) {
       StringBuilder builder = new StringBuilder();
       builder.append(abrirTabela());
       
       builder.append(abrirLinhaTitulo());
       for(Coluna coluna : colunas) {
    	   builder.append(coluna.exportarCabecalho());
       }
       builder.append(fecharLinha());
       builder.append("\n");
       builder.append(fecharLinhaTitulo());
       gerarLinhaProdutos(builder, listaProdutos);
       builder.append(fecharTabela());
       return builder.toString();  
    }
        
    protected List<Coluna> getColunas() {
		return colunas;
	}
    
    private void gerarLinhaProdutos(StringBuilder builder, List<Produto> listaProdutos) {
    	for(Produto produto : listaProdutos) {
    		builder.append(gerarColunasLinha(produto));
    	}
    }
    
    protected String gerarColunasLinha(Produto produto) {
    	StringBuilder builder = new StringBuilder();
    	builder.append(abrirLinha());
    	for(Coluna coluna : colunas) {
    		builder.append(coluna.exportarDado(produto));
    	}
    	builder.append(fecharLinha());
    	builder.append("\n");
    	return builder.toString();
    }
}
