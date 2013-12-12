package br.com.delogic.jpasy.populator;

import javax.persistence.Column;
import javax.persistence.Id;

public class Person {

	private Long id;

	@Column()
	private String name;

	private int codigo;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
