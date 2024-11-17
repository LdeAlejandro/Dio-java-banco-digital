package banco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cliente.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;



public class Banco implements IBanco{
	

	 private List<Cliente> clientes;
	   
	    public Banco() {
	    	this.clientes = new ArrayList<>();
	    }

	 // Método que retorna uma lista imutável de clientes do banco
		public List<Cliente> getClientes() {
			return Collections.unmodifiableList(clientes);
		}

		public void adicionarCliente(Cliente cliente) {
		    this.clientes.add(cliente);
		}

		public void removerCliente(Cliente cliente) {
		    this.clientes.remove(cliente);
		}
		
		public void criarContaCorrente(Cliente cliente) {
		    ContaCorrente cc = new ContaCorrente(cliente);
		    cliente.adicionarContas(cc);
		}

		public void criarContaPoupanca(Cliente cliente) {
		    ContaPoupanca cp = new ContaPoupanca(cliente);
		    cliente.adicionarContas(cp);
		}
		
		 
	    public void criarConta(Cliente cliente, String tipoConta) {
	        Conta novaConta = null;
	        if ("corrente".equalsIgnoreCase(tipoConta)) {
	            novaConta = new ContaCorrente(cliente);
	        } else if ("poupanca".equalsIgnoreCase(tipoConta)) {
	            novaConta = new ContaPoupanca(cliente);
	        }
	        
	        if (novaConta != null) {
	            cliente.adicionarContas(novaConta);
	        }
	    }
		
		
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder("Banco{\nClientes:\n");
	        for (Cliente cliente : clientes) {
	            sb.append(cliente.toString()).append("\n");
	        }
	        sb.append("}");
	        return sb.toString();
	    }

}
