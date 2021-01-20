package banco_superior_modelo;

public interface IConta {
	
	float TAXA_SACAR_CONTA_CORRENTE = 0.02f;
	float TAXA_SACAR_CONTA_POUPANCA = 0.01f;
	float TAXA_SACAR_CONTA_INVESTIMENTO = 0.03f;
	
	float RENDIMENTO_CONTA_POUPANCA = 0.03f;
	float TAXA_ADMINISTRACAO_POUPANCA = 0.04f;
	float TAXA_ADMINISTRACAO_CORRENTE = 0.05f;
	float TAXA_ADMINISTRACAO_INVESTIMENTO = 0.05f;
	float TAXA_ADMINISTRACAO_SALARIO = 0.01f;
	
	public void sacar(float valorSacado);
	
	public void depositar(float valorDepositado);
	
	public void desativarConta();
	
	public void ativarConta();
	
	public void transferencia(IConta contaDestino, float valorTransferido);
	
	public String toString();
	
	

}
