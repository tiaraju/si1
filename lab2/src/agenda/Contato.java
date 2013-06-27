package agenda;

import java.util.ArrayList;
import java.util.List;

public class Contato {
		
	private String nome;
	private List<String>emails;
	private List<NumeroDeTelefone> telefones;
	
	
	public Contato(String nome, ArrayList<NumeroDeTelefone> telefones,ArrayList<String> emails) {
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


	public List<NumeroDeTelefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<NumeroDeTelefone> telefones) {
		this.telefones = telefones;
	}


	public List<String> getEmails() {
		return emails;
	}


	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
	
	

}
