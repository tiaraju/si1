package agenda;

import java.util.ArrayList;


public class Agenda {
	
	ListaDeContatos listadeContatos;
	
	public Agenda(){
		listadeContatos= new ListaDeContatos();
	}
	
	public void addContato(String nome, ArrayList<NumeroDeTelefone> telefones, ArrayList<String> emails){
		listadeContatos.addContato(nome, telefones, emails);
	}
	
	public ListaDeContatos getListaDeContatos(){
		return listadeContatos;
	}
	
	public Contato buscaContato(String nome){
		return listadeContatos.getContato(nome);
	}

}
