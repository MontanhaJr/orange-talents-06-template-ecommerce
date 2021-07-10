package br.com.orangetalents.mercadolivre.usuarios;

import br.com.orangetalents.mercadolivre.usuarios.dto.request.SenhaLimpa;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) @NotNull @NotBlank
    private String login;

    @Column(nullable = false) @NotNull @NotBlank
    private String senha;

    @Column(nullable = false)
    private LocalDateTime dataHoraCriacao;

    public Usuario(@NotNull @NotBlank @Email String login,
                   @NotBlank @NotNull @Length(min = 6) SenhaLimpa senhaLimpa) {
        Assert.isTrue(StringUtils.hasLength(login),"email não pode ser em branco");
        Assert.notNull(senhaLimpa,"o objeto do tipo senha limpa nao pode ser nulo");

        this.login = login;
        this.senha = senhaLimpa.hashSenha();
        this.dataHoraCriacao = LocalDateTime.now();
    }
}
