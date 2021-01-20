package banco_superior_modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClientePessoaJuridica implements ICliente, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String cnpj;
	String nome;
	String dataNascimento;
	String email;
	
	HashSet<String> telefones = new HashSet<String>();
	
	private List<IConta> contas = new ArrayList<IConta>();
	
	public ClientePessoaJuridica(String nome, String cnpj, String dataNascimento, String email) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}
	

	public ClientePessoaJuridica(String cnpj) {
		this.cnpj = cnpj;
	}


	@Override
	public String toString() {
		return "ClientePessoaJuridica [cnpj=" + cnpj + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", email=" + email + ", telefones=" + telefones + ", contas=" + contas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePessoaJuridica other = (ClientePessoaJuridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
	
	protected void adicionarContas(IConta contaCliente) {
		this.contas.add(contaCliente);
		System.out.println("Conta adicionada com sucesso!!");
	}
	
	public boolean contemConta(IConta contaCliente) {
		return this.contas.contains(contaCliente);
	}
	
	public void removerConta(IConta conta) {
		if(contas.contains(conta)) {
			contas.remove(conta);
			System.out.println("Conta removida com sucesso!!");
		} else {
			System.out.println("Impossível remover conta, conta inexistente!!");
		}
	}
	
	public void adicionarTelefone(String telefone) {
		this.telefones.add(telefone);
		System.out.println("Telefone adicionado com sucesso!!");
	}
	
	public void removerTelefone(String telefone) {
		if(telefones.contains(telefone)) {
			telefones.remove(telefone);
			System.out.println("Telefone removido com sucesso!!");
		} else {
			System.out.println("Ete número de telefone não está na lista!!");
		}
	}

}
