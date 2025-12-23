package com.sistemavagas.gerenciamentoVagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID ID;
	private String name;
	
	@NotBlank()
	@Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
	private String username;
	
	@Email(message = "O campo [email] deve conter um email válido")
	private String email;
	
	@Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres")
	private String password;
	private String description;
	private String curriculum;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public UUID getID() {
		return ID;
	}
	public void setID(UUID iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	

    private CandidateEntity() {
        // JPA exige construtores sem parametros
    }
	
	public CandidateEntity(UUID iD, String name,
			@Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço") String username,
			@Email(message = "O campo [email] deve conter um email válido") String email,
			@Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres") String password,
			String description, String curriculum, LocalDateTime createdAt) {
		super();
		ID = iD;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.description = description;
		this.curriculum = curriculum;
		this.createdAt = createdAt;
	}
	
	
	
}
