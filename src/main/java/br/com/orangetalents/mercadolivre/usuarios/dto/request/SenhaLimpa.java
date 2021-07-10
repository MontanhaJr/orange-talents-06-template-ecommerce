package br.com.orangetalents.mercadolivre.usuarios.dto.request;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SenhaLimpa {

    private String senha;

    public SenhaLimpa(@NotBlank @NotNull @Length(min = 6) String senha) {
        this.senha = senha;
    }

    public String hashSenha() {
        return new BCryptPasswordEncoder().encode(this.senha);
    }
}
