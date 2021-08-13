package br.com.orangetalents.mercadolivre.categorias;

import br.com.orangetalents.mercadolivre.categorias.repository.CategoriaRepository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String nome;

    @ManyToOne
    private Categoria categoriaMae;


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoriaMae() {
        return categoriaMae;
    }

    public void setCategoriaMae(Categoria categoriaMae) {
        this.categoriaMae = categoriaMae;
    }

    @Deprecated
    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(String nome, Categoria categoriaMae) {
        this.nome = nome;
        this.categoriaMae = categoriaMae;
    }

    public Categoria adicionaCategoriaMae(CategoriaRepository categoriaRepository) {

        Optional<Categoria> categoriaMae = categoriaRepository.findByNome(this.categoriaMae.getNome());

        if (categoriaMae.isEmpty()) {
            categoriaRepository.save(categoriaMae.get());
            return categoriaMae.get();
        }

        return categoriaMae.get();
    }
}
