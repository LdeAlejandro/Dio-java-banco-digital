package cliente;

import java.util.List;

import conta.Conta;

public interface ICliente {
	
	public String getSobreNome();

	public String getCpf();

	public List<Conta> getContas();


	public void adicionarContas(Conta conta);
	
	public void removerContas(Conta conta);

	public String getNome();

	public void setNome(String nome);

}
