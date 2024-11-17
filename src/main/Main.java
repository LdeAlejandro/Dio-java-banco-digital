package main;
import cliente.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class Main {

	public static void main(String [] args) {
		
		Cliente cliente = new Cliente("Alejandro", "Garcia", "12312321");
		
		System.out.println(cliente.toString());
		
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		cc.depositar(100);
		cc.transferir(23, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}
}
