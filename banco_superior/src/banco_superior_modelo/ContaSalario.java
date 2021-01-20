package banco_superior_modelo;

import java.io.Serializable;

public class ContaSalario implements IConta, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaSalario(String numeroConta, String agencia, String dataAbertura) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.dataAbertura = dataAbertura;
		this.saldo = 0f;
		this.status = true;
	}
	
	

	@Override
	public String toString() {
		return "ContaSalario [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}



	@Override
	public void sacar(float valorSacado) {
		if(valorSacado > 0 && this.saldo >= valorSacado && this.status) {
			this.saldo -= valorSacado;
		} else if (valorSacado <= 0){
			System.err.println("Valor digitado incorreto para saque!!");
		} else if (this.status == false) {
			System.err.println("Operação inválida, conta inativa!!");
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
			System.err.println("Valor insuficiente para depósito!!");
		} else if(this.status == false) {
			System.err.println("Impossível realizar depósito, conta desativada!!");
		} else {
			System.out.println("Não foi possível realizar o depósito!!");
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
		System.err.println("Conta salário não faz transferência!!");
	}

}
