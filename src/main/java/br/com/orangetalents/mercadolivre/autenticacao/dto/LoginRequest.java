package br.com.orangetalents.mercadolivre.autenticacao.dto;

import br.com.orangetalents.mercadolivre.usuarios.dto.request.SenhaLimpa;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {

	@NotBlank
	private String login;
	@NotBlank
	@Size(min = 6)
	private String senha;

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(this.login, senha);
	}

}
