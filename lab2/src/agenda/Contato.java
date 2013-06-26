package agenda;

import java.util.ArrayList;
import java.util.List;

public class Contato {
		
	private String nome;
	private List<String> telefones,emails;
	
	
	public Contato(String nome, ArrayList<String> telefones,ArrayList<String> emails) {
		this.nome=nome;
		this.telefones=telefones;
		this.emails=emails;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}


	public List<String> getEmails() {
		return emails;
	}


	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
	
	

}
