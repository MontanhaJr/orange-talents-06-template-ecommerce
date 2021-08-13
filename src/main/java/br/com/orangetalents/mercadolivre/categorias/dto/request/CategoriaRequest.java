package br.com.orangetalents.mercadolivre.categorias.dto.request;

import br.com.orangetalents.mercadolivre.categorias.Categoria;
import br.com.orangetalents.mercadolivre.categorias.repository.CategoriaRepository;
import br.com.orangetalents.mercadolivre.validation.annotation.unique.IsUniqueValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class CategoriaRequest {
    private Long id;

    @NotNull
    @NotBlank
    @IsUniqueValidator(classe = Categoria.class, nomeAtributo = "nome")
    private String nome;

    private Long idCategoriaMae;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdCategoriaMae() {
        return idCategoriaMae;
    }

    public CategoriaRequest(@NotBlank String nome, Long categoriaMae) {
        this.nome = nome;
        this.idCategoriaMae = categoriaMae;
    }

    public Categoria toModel(CategoriaRepository categoriaRepository) {
        Categoria categoria = new Categoria(this.nome);

        if (idCategoriaMae != null) {
            Optional<Categoria> categoriaMae = categoriaRepository.findById(idCategoriaMae);

            if (categoriaMae.isEmpty())
            {
                return null;
            }
            categoria.setCategoriaMae(categoriaMae.get());
        }

        return categoria;
    }
}
