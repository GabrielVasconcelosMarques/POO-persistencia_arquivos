package banco_superior.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import banco_superior_modelo.ClientePessoaFisica;
import banco_superior_modelo.ClientePessoaJuridica;
import banco_superior_modelo.ICliente;

public class PersistenciaEmArquivoCliente implements IPersistenciaCliente{
	
	private List<ICliente> clientesCadastrados = new ArrayList<ICliente>();
	
	public PersistenciaEmArquivoCliente() {
		lerConteudoArquivo();
	}

	@Override
	public void cadastrarCliente(ICliente obj) {
		if(!clientesCadastrados.contains(obj)) {
			clientesCadastrados.add(obj);
			salvarEmArquivo();
		} else {
			System.err.println("Cliente j� se encontra cadastrado!");
		}
	
	}

	@Override
	public ICliente localizarClientePorCPF(String cpf) {
		ICliente cliente = new ClientePessoaFisica(cpf);
		
		if(clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}
		return cliente;
	}

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) {
		ICliente cliente = new ClientePessoaJuridica(cnpj);
		
		if(clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}
		return cliente;
	}

	@Override
	public void removerCliente(ICliente obj) {
		if(clientesCadastrados.contains(obj)) {
			clientesCadastrados.remove(obj);
			salvarEmArquivo();
		} else {
			System.err.println("Cliente n�o est� cadastrado, imposs�vel de remover!");
		}
	}
	
	private void salvarEmArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("clientes_cadastrados.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void lerConteudoArquivo() {
		try {
			FileInputStream fis = new FileInputStream("clientes_cadastrados.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			clientesCadastrados = (ArrayList<ICliente>)obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
