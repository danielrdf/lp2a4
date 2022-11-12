package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private Date dataIngresso;
	private Date dataConclusao;
	
	private Curso curso;
	
	public Aluno() {
	}

	public Aluno(Integer id, String nome, String email, Date dataIngresso, Date dataConclusao, Curso curso) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataIngresso = dataIngresso;
		this.dataConclusao = dataConclusao;
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", dataIngresso=" + dataIngresso
				+ ", dataConclusao=" + dataConclusao + ", curso=" + curso + "]";
	}
	
}