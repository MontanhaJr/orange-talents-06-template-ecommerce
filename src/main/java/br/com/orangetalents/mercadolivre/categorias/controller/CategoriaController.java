package br.com.orangetalents.mercadolivre.categorias.controller;

import br.com.orangetalents.mercadolivre.categorias.Categoria;
import br.com.orangetalents.mercadolivre.categorias.dto.request.CategoriaRequest;
import br.com.orangetalents.mercadolivre.categorias.dto.response.CategoriaResponse;
import br.com.orangetalents.mercadolivre.categorias.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequest request) {

        Categoria categoria = request.toModel(categoriaRepository);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        categoriaRepository.save(categoria);

        return ResponseEntity.ok().body(new CategoriaResponse(categoria));
    }
}
