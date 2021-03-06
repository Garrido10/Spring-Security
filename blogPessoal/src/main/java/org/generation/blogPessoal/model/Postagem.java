package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Create Table
@Table(name = "tb_postagens") // nome da tabela

public class Postagem {

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_incremento
	private long id; // bigint

	@NotNull(message = "O atributo título é Obrigatório!") // Não pode ser nulo
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres") // máx
																													// e
																													// min
																													// de
																													// caracteres
	private String titulo; // varchar

	@NotNull(message = "O atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 500 caracteres")
	private String texto; // varchar

	// @Temporal: Indica se o atributo receberá uma data ou um Timestamp (Data e
	// hora do sistema)
	// System.currentTimeMillis(): insere os milisegundos na hora
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis()); // Date Timestamp()

	@ManyToOne // indica que a classe Postagem possui um relacionamento muitos para um com a
				// classe Tema
	@JsonIgnoreProperties("postagem") // faz com que não haja um loop, ou seja, uma recursividade infinita
	private Tema tema; // objeto Tema (chave estrangeira) da classe Postagem na relação com a classe
						// Tema e exibe o tema da postagem

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	// Métodos Get e Set

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
