package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer matricula;
	private String nome;
	private String email;
	
	public Aluno() {
	}

	public Aluno(Integer matricula, String nome, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return matricula;
	}

	public void setId(Integer id) {
		this.matricula = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [matricula=" + matricula + ", nome=" + nome + ", email=" + email + "]";
	}
	
}
