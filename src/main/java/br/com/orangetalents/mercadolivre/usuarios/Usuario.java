package br.com.orangetalents.mercadolivre.usuarios;

import br.com.orangetalents.mercadolivre.usuarios.dto.request.SenhaLimpa;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) @NotNull @NotBlank
    private String login;

    @Column(nullable = false) @NotNull @NotBlank
    private String senha;

    @Column(nullable = false)
    private LocalDateTime dataHoraCriacao;

    public Long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    @Deprecated
    public Usuario() {
    }

    public Usuario(@NotNull @NotBlank @Email String login,
                   @NotBlank @NotNull @Length(min = 6) SenhaLimpa senhaLimpa) {
        Assert.isTrue(StringUtils.hasLength(login),"email não pode ser em branco");
        Assert.notNull(senhaLimpa,"o objeto do tipo senha limpa nao pode ser nulo");

        this.login = login;
        this.senha = senhaLimpa.hashSenha();
        this.dataHoraCriacao = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
