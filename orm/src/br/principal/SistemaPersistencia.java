package br.principal;

import org.junit.Test;

import br.dao.ClienteDAO;
import br.dao.FuncionarioDAO;
import br.model.Cliente;
import br.model.Funcionario;

public class SistemaPersistencia {
	
	private FuncionarioDAO daoFunc = new FuncionarioDAO();
	private ClienteDAO daoCli = new ClienteDAO();
	private Funcionario funcionario = new Funcionario();
	private Cliente cliente = new Cliente();
	
	@Test
	public void cadastrarFuncionario(){
		funcionario.setFuncionario("Ricardo");
		funcionario.setCpf(123);
		daoFunc.inserir(funcionario);
	}
	
	@Test
	public void localizarFuncionario(){
		funcionario = daoFunc.localizar(1);
		System.out.println(funcionario.getFuncionario());
	}
	
	@Test
	public void cadastrarCliente(){
		cliente.setCliente("Ricardo");
		cliente.setCpf(123);
		daoCli.inserir(cliente);
	}
	
	@Test
	public void localizarCliente(){
		cliente = daoCli.localizar(1);
		System.out.println(cliente.getCliente());
	}

}
