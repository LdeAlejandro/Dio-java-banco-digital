package banco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cliente.Cliente;


public class Banco {
	

	 private List<Cliente> clientes;
	   
	    public Banco() {
	    	this.clientes = new ArrayList<>();
	    }

		public List<Cliente> getClientes() {
			return Collections.unmodifiableList(clientes);
		}

		public void adicionarCliente(Cliente cliente) {
		    this.clientes.add(cliente);
		}

		public void removerCliente(Cliente cliente) {
		    this.clientes.remove(cliente);
		}
		
		@Override
		public String toString() {
		    return "Banco{" +
		           "clientes=" + clientes +
		           '}';
		}

}
