package br.com.orangetalents.mercadolivre.categorias.dto.response;

import br.com.orangetalents.mercadolivre.categorias.Categoria;

public class CategoriaResponse {
    private String nome;

    private CategoriaResponse categoriaMae;

    public String getNome() {
        return nome;
    }

    public CategoriaResponse getCategoriaMae() {
        return categoriaMae;
    }

    public CategoriaResponse(Categoria categoria) {
        this.nome = categoria.getNome();
        if (categoria.getCategoriaMae() != null) {
            this.categoriaMae = new CategoriaResponse(categoria.getCategoriaMae());
        }
    }
}
