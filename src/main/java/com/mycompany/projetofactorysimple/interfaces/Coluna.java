package com.mycompany.projetofactorysimple.interfaces;

import com.mycompany.projetofactorysimple.model.Produto;

public interface Coluna {
    public  String getTitulo();
    public void setTitulo(String titulo);
    public String abrir();
    public String fechar();
    public String exportarCabecalho();
    public String exportarDado(Produto produto);
}
