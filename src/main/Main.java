package main;
import banco.Banco;
import cliente.Cliente;
import conta.Conta;

public class Main {

	public static void main(String [] args) {
		
		Banco banco = new Banco();
		Cliente cliente1 = new Cliente("Alejandro", "Garcia", "12312321", banco);
		Cliente cliente2 = new Cliente("Jâo", "Pedro", "23423", banco);
		
		banco.criarConta(cliente1, "corrente");
        banco.criarConta(cliente1, "poupanca");
        banco.criarConta(cliente2, "corrente");
		
        //Cliente 1
		Conta ccCliente1 = cliente1.getContas().get(0);
		Conta poupancaCliente1 = cliente1.getContas().get(1);

		ccCliente1.imprimirExtrato();
		poupancaCliente1.imprimirExtrato();
		
		ccCliente1.depositar(100);
		ccCliente1.sacar(25);
		ccCliente1.transferir(23, poupancaCliente1);
		
		ccCliente1.imprimirExtrato();
		poupancaCliente1.imprimirExtrato();
		//****************************************************
		
		//Cliente 2
		Conta ccCliente2 = cliente2.getContas().get(0);
		//depositar dinheiro na conta
		ccCliente2.depositar(160);
		
		//transferir para conta corrente do cliente 1 50
		ccCliente2.transferir(50, ccCliente1);
		
		ccCliente2.imprimirExtrato();
		ccCliente1.imprimirExtrato();
		
		
		//****************************************************
		
		//exibir info do cliente usando toString
		System.out.println("Informação do cliente" + ccCliente1.toString());
		
		  // Exibir clientes usando getClientes
        System.out.println("Clientes no banco:");
        for (Cliente client : banco.getClientes()) {
            System.out.println(client);
        }

        /*exibir a lista de cliente com toString
        // Exibir a lista de clientes completa
        System.out.println("\nInformações completas do banco:");
        System.out.println(banco);
		*/
	}
}
