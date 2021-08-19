package br.com.orangetalents.mercadolivre.usuarios.dto.request;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Representa uma senha limpa no sistema
 *
 */
public class SenhaLimpa {

    private String senha;

    public SenhaLimpa() {
    }

    public SenhaLimpa(@NotBlank @NotNull @Length(min = 6) String senha) {
        Assert.hasLength(senha, "A senha nao pode ser em branco");
        Assert.isTrue(senha.length()>=6,"A senha tem que ter no mínimo 6 caracteres");

        this.senha = senha;
    }

    public String hashSenha() {
        return new BCryptPasswordEncoder().encode(this.senha);
    }
}
