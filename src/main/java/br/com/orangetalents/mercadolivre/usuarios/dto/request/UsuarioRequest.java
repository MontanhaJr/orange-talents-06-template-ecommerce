package br.com.orangetalents.mercadolivre.usuarios.dto.request;


import br.com.orangetalents.mercadolivre.usuarios.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioRequest {

    private Long id;

    @NotNull @NotBlank @Email
    private String login;

    @NotNull @NotBlank @Length(min = 6)
    private String senha;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public UsuarioRequest() {
    }

    public Usuario toModel() {
        return new Usuario(this.login, new SenhaLimpa(this.senha));
    }
}
