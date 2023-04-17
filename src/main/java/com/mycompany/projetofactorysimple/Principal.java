package com.mycompany.projetofactorysimple;


import com.mycompany.projetofactorysimple.interfaces.ExportadorListaProduto;
import com.mycompany.projetofactorysimple.model.Produto;

import java.util.List;

public class Principal {

    public static void main(String[] args) {
    	List<Produto> produtos = List.of(
                new Produto("TV", "LG", "132-A", 120),
                new Produto("Notebook", "Asus", "New age", 341),
                new Produto("Smartphone", "Samsung", "Galaxy S10", 214));
    	
    	System.out.println("Lista de Produtos em HTML \n");
    	var exportador = ExportadorListaProduto.newInstance("html");
    	System.out.println(exportador.exportar(produtos));
    	
    	System.out.println("\nLista de Produtos em Markdown");
    	var exportadorMark = ExportadorListaProduto.newInstance("md");
    	System.out.println(exportadorMark.exportar(produtos));
        
       /* System.out.println("\nLista de Produtos em CSV ");
    	ExportadorLista exportadorCSV= ExportadorLista.newInstance("csv");
    	System.out.println(exportadorCSV.exportar(produtos));*/
    }
}
