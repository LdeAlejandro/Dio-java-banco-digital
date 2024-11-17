package banco;

import java.util.List;

import cliente.Cliente;


public interface IBanco {

    void adicionarCliente(Cliente cliente);  
    
    void removerCliente(Cliente cliente);  

    void criarContaCorrente(Cliente cliente);  

    void criarContaPoupanca(Cliente cliente);  

    void criarConta(Cliente cliente, String tipoConta); 
    
    List<Cliente> getClientes();  
    

}
