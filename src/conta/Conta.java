package conta;
import java.util.List;

import cliente.Cliente;
import cliente.ICliente;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente.adicionarContas(this);
	}
	
	@Override
	public void sacar(double valor) {
		System.out.println(String.format("Sacando:  %.2f" , valor));
		this.saldo -= valor;
	}
	
	@Override
	public void depositar(double valor) {
		System.out.println(String.format("Depositando: %.2f Para a conta: %s", valor, numero));
		this.saldo += valor;
	}
	
	@Override
	public void transferir(double valor, Conta contaDestino) {
		System.out.println(String.format("Transferindo: %.2f Para a conta: %s", valor, contaDestino.numero));

		this.saldo -= valor;
		contaDestino.depositar(valor); 
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
