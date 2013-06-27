package agenda;

import java.util.ArrayList;
import java.util.List;

public class ListaDeContatos {

	List<Contato> listaDeContatos;

	public ListaDeContatos(){
		listaDeContatos= new ArrayList<Contato>();
	}

	public int getTotalDeContatos() {
		return listaDeContatos.size();
	}

	public void addContato(String nome, ArrayList<NumeroDeTelefone> telefones, ArrayList<String> emails) {
		Contato newContato = new Contato(nome,telefones,emails);
		listaDeContatos.add(newContato);
	}

	public List<Contato> getContatos() {
		return listaDeContatos;
	}
	
	public Contato getContato(String nome){
		for(Contato c: listaDeContatos){
			if(c.getNome().equals(nome)){
				return c;
			}
		}
		return null;
	}

}
