package br.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TB_Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cliente_ID")
	private int id;
	
	@Column(name="cliente_NOME")
	private String cliente;
	
	@Column(name="cliente_CPF")
	private int cpf;
	
	@Column(name="cliente_ENTRADA")
	private Calendar entrada = Calendar.getInstance();

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Calendar getEntrada() {
		return entrada;
	}

	public void setEntrada(Calendar entrada) {
		this.entrada = entrada;
	}
	
}
