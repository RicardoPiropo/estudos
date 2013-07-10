import br.dao.FuncionarioDAO;
import br.model.Funcionario;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		funcionario = dao.localizar(1);
		System.out.println(funcionario.getId());
		System.out.println(funcionario.getFuncionario());
	}

}
