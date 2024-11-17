package conta;
import cliente.Cliente;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = (int) (Math.random() * 10000);
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente; 
	
	 // Construtor da conta, inicializa a agência e número da conta
	protected Conta(Cliente cliente) {
		this.cliente = cliente;
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
	}
	
	@Override
	public void sacar(double valor) {
		
		if(valor <=0 || saldo < valor) {
			System.out.println("Valor de saque inválido!");
			return;
		}
		
		this.saldo -= valor;
		System.out.println("============================");
		System.out.println(String.format("Sacando:  %.2f" , valor));
	}
	
	@Override
	public void depositar(double valor) {
		System.out.println("============================");
		System.out.println(String.format("Depositando: %.2f Para a conta: %s", valor, numero));
		this.saldo += valor;
	}
	
	@Override
	public void transferir(double valor, Conta contaDestino) {
		 if (valor <= 0 || saldo < valor) {
		        System.out.println("Transferência inválida!");
		        return;
		    }
		System.out.println("============================");
		System.out.println(String.format(this.cliente.getNome() +" Tranferiu: %.2f Para a conta: %s", valor, contaDestino.numero + " de "+ contaDestino.cliente.getNome()));

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
		//System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	@Override
	public String toString() {
	    return String.format("Conta{agencia=%d, numero=%d, saldo=%.2f}", agencia, numero, saldo);
	}
}
