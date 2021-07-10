package br.com.orangetalents.mercadolivre.usuarios.controller;

import br.com.orangetalents.mercadolivre.usuarios.Usuario;
import br.com.orangetalents.mercadolivre.usuarios.dto.request.SenhaLimpa;
import br.com.orangetalents.mercadolivre.usuarios.dto.request.UsuarioRequest;
import br.com.orangetalents.mercadolivre.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/usuario")
    public ResponseEntity<?> criar(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRequest.toModel();
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }
}
