package com.sistemavagas.gerenciamentoVagas.modules.company.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sistemavagas.gerenciamentoVagas.modules.company.dto.AuthCompanyDTO;
import com.sistemavagas.gerenciamentoVagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Value;


@Service
public class AuthCompanyUseCase {
	
	@Value("${security.token.secret}")
	private String secretKey;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
		var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
				() -> {
					throw new UsernameNotFoundException("Company not found");
				});
		var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());
		
		//Se não for igual -> erro
		if(!passwordMatches) {
			throw new AuthenticationException();
		}
		
		//Se for igual, gerar token
		Algorithm algorithm = Algorithm.HMAC256(secretKey);
		var token = JWT.create().withIssuer("javagas")
				.withSubject(company.getId().toString())
				.withClaim("roles", Arrays.asList("COMPANY"))
				.sign(algorithm);
		return token;
	}
}
