package br.com.orangetalents.mercadolivre.usuarios.repository;

import br.com.orangetalents.mercadolivre.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
