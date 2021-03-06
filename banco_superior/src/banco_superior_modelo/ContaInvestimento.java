package banco_superior_modelo;

import java.io.Serializable;

public class ContaInvestimento implements IConta, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaInvestimento(String numeroConta, String agencia, String dataAbertura) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.dataAbertura = dataAbertura;
		this.saldo = 0f;
		this.status = true;
	}
	
	

	@Override
	public String toString() {
		return "ContaInvestimento [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo
				+ ", status=" + status + ", dataAbertura=" + dataAbertura + "]";
	}



	@Override
	public void sacar(float valorSacado) {
		if(valorSacado > 0 && this.saldo >= (valorSacado+(valorSacado*TAXA_SACAR_CONTA_INVESTIMENTO)) && this.status) {
			this.saldo -= (valorSacado+(valorSacado*TAXA_SACAR_CONTA_INVESTIMENTO));
		} else if (valorSacado <= 0){
			System.err.println("Valor digitado incorreto para saque!!");
		} else if (this.status == false) {
			System.err.println("Opera��o inv�lida, conta inativa!!");
		} else {
			System.err.println("Saldo insuficiente para saque");
		}
		
	}

	@Override
	public void depositar(float valorDepositado) {
		if (valorDepositado>0 && this.status) {
			this.saldo += valorDepositado;
			System.out.println("Valor depositado com sucesso!!");
		} else if (valorDepositado<=0) {
			System.err.println("Valor insuficiente para dep�sito!!");
		} else if(this.status == false) {
			System.err.println("Imposs�vel realizar dep�sito, conta desativada!!");
		} else {
			System.out.println("N�o foi poss�vel realizar o dep�sito!!");
		}
		
	}

	@Override
	public void desativarConta() {
		this.status = false;
		System.out.println("Conta desativada com sucesso!!");
		
	}

	@Override
	public void ativarConta() {
		this.status = true;
		System.out.println("Conta ativada com sucesso!!");
		
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) {
		if(contaDestino instanceof ContaPoupanca) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO_POUPANCA));
			contaDestino.depositar(valorTransferido);
		} else if (contaDestino instanceof ContaCorrente) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO_CORRENTE));
			contaDestino.depositar(valorTransferido);
		} else if (contaDestino instanceof ContaSalario) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO_SALARIO));
			contaDestino.depositar(valorTransferido);
		} else {
			this.sacar(valorTransferido);
			contaDestino.depositar(valorTransferido);
		}
		
	}

}
