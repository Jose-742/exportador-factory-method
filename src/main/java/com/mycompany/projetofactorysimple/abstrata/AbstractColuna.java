package com.mycompany.projetofactorysimple.abstrata;

import com.mycompany.projetofactorysimple.interfaces.Coluna;
import com.mycompany.projetofactorysimple.model.Produto;

import java.util.function.Function;

public abstract class AbstractColuna  implements Coluna {
    private String titulo;
    private Function<Produto, Object> obtemValorColuna;

    public AbstractColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
    	this.titulo = titulo;
        this.obtemValorColuna = obtemValorColuna;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String exportarCabecalho() {
        return abrir() + titulo + fechar();
    }

    @Override
    public String exportarDado(Produto produto) {
        return abrir() +  obtemValorColuna.apply(produto).toString() + fechar();
    }
}
