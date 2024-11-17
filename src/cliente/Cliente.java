package cliente;
import java.util.ArrayList;
import java.util.List;

import conta.Conta;

public abstract class Cliente implements ICliente {
	
	private static int contadorIdCliente = 1;
	private final int idCliente; 
	private String nome;
	private String sobreNome;
	private String cpf;
	private List<Conta> contas;
	
	public Cliente(String nome, String sobreNome, String cpf) {
		this.idCliente = contadorIdCliente++;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.contas = new ArrayList<>();
	}
	

	public String getSobreNome() {
		return sobreNome;
	}


	public String getCpf() {
		return cpf;
	}

	public List<Conta> getContas() {
		return contas;
	}


	public void adicionarContas(Conta conta) {
		this.contas.add(conta);
	}
	
	public void removerContas(Conta conta) {
		this.contas.remove(conta);
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	@Override
    public String toString() {
        return "Cliente{" +
               "idCliente=" + idCliente +
               ", nome='" + nome + '\'' +
               ", sobreNome='" + sobreNome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", contas=" + contas +
               '}';
    }

}
