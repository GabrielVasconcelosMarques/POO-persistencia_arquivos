package banco_superior_modelo;

import banco_superior.persistencia.IPersistenciaCliente;
import banco_superior.persistencia.PersistenciaEmArquivoCliente;

public class Programa {
	public static void main(String[] args) {
		
		
		// criando contas, e clientes
		IConta conta1 = new ContaCorrente("111", "222", "12/01/2021");
		
		IConta conta2 = new ContaPoupanca("222", "333", "10/01/2021");
		
		
		ClientePessoaFisica cliente1 = new ClientePessoaFisica("Gabriel", "083", "10/01/2021", "Gabrielvasco3431@gmail.com");
		
		ClientePessoaJuridica cliente2 = new ClientePessoaJuridica("Everton", "044", "12/02/2020", "Ellg1@gmail.com");
		
		cliente1.adicionarContas(conta1);
		cliente2.adicionarContas(conta2);
		
		cliente1.adicionarTelefone("83206942");
		cliente2.adicionarTelefone("06542563");
		
		
		
		
		// iniciando a persistencia
		IPersistenciaCliente pac = new PersistenciaEmArquivoCliente();
	
		// persistindo dados de pessoa fisica
		pac.cadastrarCliente(cliente1);
		
		ICliente obj = pac.localizarClientePorCPF("083");
		
		System.out.println(obj);
		
		System.out.println("______________________________________________________________________-");
		
		
		// persistindo dados de pessoa juridica
		pac.cadastrarCliente(cliente2);
		ICliente obj2 = pac.localizarClientePorCNPJ("044");
		
		System.out.println(obj2);
		
		// testando se o usuário ja estiver cadastrado
		pac.cadastrarCliente(cliente1);
		
		
		
		

//		

//		
//		System.out.println("Contas criadas sem saldo");
//		System.out.println(cliente1);
//		System.out.println(cliente2);
//		
//		System.out.println("Mostrando conta");
//		System.out.println(conta1);
//		
//		conta1.depositar(1000f);
//		conta2.depositar(100f);
//		
//		conta1.transferencia(conta2, 100f);
//		
//		System.out.println("Contas após transferência");
//		System.out.println(cliente1);
//		System.out.println(cliente2);
//		
//		IConta conta4 = new ContaSalario("111", "000", "12/01/2020");
//		
//		conta4.transferencia(conta2, 200);
//		
//		
//		pac.cadastrarCliente(cliente1);
		
		
	}
		

}
