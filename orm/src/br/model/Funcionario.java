package br.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="TB_FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="funcionario_ID")
	private int id;
	
	@Column(name="funcionario_NOME")
	private String funcionario;
	
	@Column(name="funcionario_CPF")
	private int cpf;
	
	@Column(name="funcionario_ENTRADA")
	private Calendar entrada = Calendar.getInstance();
	
	
	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
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
