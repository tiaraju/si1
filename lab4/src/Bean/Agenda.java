package Bean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import Controller.Controladora;
import Model.Contato;
import Model.Telefone;
import Model.Usuario;

@ManagedBean(name = "agendaBean", eager = true)
@SessionScoped
public class Agenda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DATA = "data.txt";
	private String login;
	private String password;

	private String newLogin;
	private String newPassword;

	private ArrayList<Contato> contatos;
	private Controladora controller;


	private String email;
	private Contato contato;
	private Telefone telefone;
	private Contato contatoSelecionado;
	private boolean telefoneInvalido;
	private String contatoValido;
	private String tipoDeBusca;
	private String busca;
	private ArrayList<Contato> resultadoBusca;

	public Agenda() {
		try {
			read();
		} catch (IOException e) { }
		inicializarBean();
	}

	private void inicializarBean() {		
		this.login = "";
		this.password = "";
		this.newLogin = "";
		this.newPassword = "";

		this.email = "";
		this.contatoValido = "false";
		this.telefoneInvalido = false;
		this.contato = new Contato();
		this.telefone = new Telefone();
		this.contatoSelecionado = new Contato();
		//		contatoSelecionado.setNome("Renan");
		this.busca = "";
		this.tipoDeBusca = "1";
		this.resultadoBusca = new ArrayList<Contato>();
	}

	public void persistirDados() throws IOException {
		FileOutputStream recodableData = null;
		ObjectOutputStream out = null;
		try {
			recodableData = new FileOutputStream(DATA);
			out = new ObjectOutputStream(recodableData);
			out.writeObject(contatos);
			out.writeObject(controller.getUsuarios());
			out.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void read() throws IOException {
		FileInputStream reader = null;
		ObjectInputStream in = null;
		try {
			reader = new FileInputStream(DATA);
			in = new ObjectInputStream(reader);
			this.controller = (Controladora) in.readObject();
			in.close();
		} catch (IOException ex) {
			this.controller= new Controladora();
			persistirDados();
		} catch (ClassNotFoundException ex) {
			this.controller= new Controladora();
		}catch(Exception e){
			this.controller= new Controladora();
		}
	}


	public String getNewLogin() {
		return newLogin;
	}

	public void setNewLogin(String newLogin) {
		this.newLogin = newLogin;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public String saveButton() {
		Usuario novoUsuario = new Usuario(newLogin, newPassword);
		if(this.controller.addUsuario(novoUsuario)){
			msgUsuario("Usuario Cadastrado", "Seja Bem-vindo " + newLogin);
			inicializarBean();
			this.contatos = novoUsuario.getContatos();
			try {
				persistirDados();
			} catch (Exception e) {
			}
			return "index.seam";
		} else{
			msgUsuario("Usuario ja existente", "Escolha outro login");
			return "";
		}



		//		if(this.controladora.getUsuarios() == null){
		//			this.controladora.setUsuarios(new ArrayList<Usuario>());
		//		}
		//		if (!this.controladora.getUsuarios().contains(temp)) {
		//			this.controladora.addUsuario(temp);
		//			msgUsuario("Usuario Cadastrado", "Seja Bem-vindo " + newLogin);
		//			inicializarBean();
		//			this.contatos = temp.getContatos();
		//			try {
		//				persistirDados();
		//				return "index.seam";
		//			} catch (Exception e) {
		//			}
		//		}
		//		msgUsuario("Usuario ja existente", "Escolha outro login");
		//		return "";
	}

	public String loginButton() {
		ArrayList<Contato> contatos = this.controller.buscaUsuario(login, password);
		if(contatos != null){
			this.contatos=contatos;
			msgUsuario("Usuario logado", "Seja Bem-vindo " + login);
			return "agenda.seam";
		} else{
			msgUsuario("Login nao realizado", "Senha errada ou Login inexistente");
			return "";	
		}

		//		if (this.controladora.getUsuarios() != null) {
		//			for (Usuario user : this.controladora.getUsuarios()) {
		//				ArrayList<Contato> temp = user.confereLogin(login, password);
		//				if (temp != null) {
		//					this.contatos = temp;
		//					msgUsuario("Usuario logado", "Seja Bem-vindo " + login);
		//					return "index.seam";
		//				}
		//			}
		//		}
		//		System.out.println("CCCCCCCCCCCCCCCC");
		//		msgUsuario("Login nao realizado", "Senha errada ou Login inexistente");
		//		return "";
	}

	public String logoffButton() {
		inicializarBean();
		return "index.seam";
	}

	private void msgUsuario(String string1, String string2) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(string1, string2));
	}


	public void addTelefone(ActionEvent event) {
		this.telefoneInvalido = false;
		try {
			this.contato.addTelefone(telefone);
			persistirDados();
		} catch (  IllegalArgumentException e) {
			this.telefoneInvalido = true;
		} catch (IOException e) {
		}
		this.telefone = new Telefone();
	}



	public void removeEmail(String email) {
		this.contato.removeEmail(email);
		try {
			persistirDados();
		} catch (Exception e) {
		}
	}

	public void cancelarContato(ActionEvent event) {
		this.telefoneInvalido = false;
		this.contato = new Contato();
		try {
			persistirDados();
		} catch (Exception e) {
		}

	}

	public void addEmail() {
		this.contato.addEmail(this.email);
		this.email = "";
		try {
			persistirDados();
		} catch (Exception e) {
		}
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void addContato(ActionEvent event) throws IllegalArgumentException{
		if (!contatos.contains(contato)) {
			contatos.add(contato);
			resultadoBusca.add(contato);
		}
		contato = new Contato();
		this.telefone = new Telefone();
		try {
			this.persistirDados();
		} catch (Exception e) {
		}
	}

	public void removeTelefone(Telefone tel) {
		contato.removeTelefone(tel);
		try {
			persistirDados();
		} catch (Exception e) {
			msgUsuario("O contato nao pode ficar sem numero", "O contato nao pode ficar sem numero");
		}

	}

	public void setContato(Contato contato) {
		this.contato = contato;

	}

	public void setContatoSelecionado(Contato contatoSelecionado) {
		this.contatoSelecionado = contatoSelecionado;

	}

	public ArrayList<Contato> getContatos() {
		return contatos;
	}

	public Contato getContatoSelecionado() {
		return contatoSelecionado;
	}

	public void setSelectedContact(Contato selectedContact) {
		this.contatoSelecionado = selectedContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public Contato getContato() {
		return contato;
	}

	public String getTipoDeBusca() {
		return tipoDeBusca;
	}

	public void setTipoDeBusca(String tipoDeBusca) {
		this.tipoDeBusca = tipoDeBusca;

	}

	public boolean getTelefoneInvalido() {
		return telefoneInvalido;
	}

	public String getContatoValido() {
		boolean temp = !(this.contato.getNome().equals("") || this.contato
				.getTelefones().isEmpty());
		this.contatoValido = new Boolean(temp).toString();
		return contatoValido;
	}

	private void buscaNome(AjaxBehaviorEvent event){
		this.resultadoBusca = new ArrayList<Contato>();
		for (Contato contato : contatos) {
			if(contato.getNome().toLowerCase().contains(busca.toLowerCase())){
				resultadoBusca.add(contato);
			}
		}
	}

	private void buscaMenorIdade(AjaxBehaviorEvent event){
		this.resultadoBusca = new ArrayList<Contato>();
		String idade=null;
		if(busca.startsWith("0")){
			idade=busca.substring(1);
		}else{
			idade=busca;
		}
		for (Contato contato : contatos) {
			if(contato.getIdade().compareTo(idade)<0){
				resultadoBusca.add(contato);
			}
		}

	}

	private void buscaMaiorIdade(AjaxBehaviorEvent event){
		String idade=null;
		if(busca.startsWith("0")){
			idade=busca.substring(1);
		}else{
			idade=busca;
		}
		this.resultadoBusca = new ArrayList<Contato>();
		for (Contato contato : contatos) {
			if(contato.getIdade().compareTo(idade)>0){
				resultadoBusca.add(contato);
			}
		}
	}

	private void buscaIgualIdade(AjaxBehaviorEvent event){
		String idade=null;
		if(busca.startsWith("0")){
			idade=busca.substring(1);
		}else{
			idade=busca;
		}
		this.resultadoBusca = new ArrayList<Contato>();
		for (Contato contato : contatos) {
			if(contato.getIdade().equals(idade)){
				resultadoBusca.add(contato);
			}
		}
	}
	public void fazBusca(AjaxBehaviorEvent event) {
		if(tipoDeBusca.equals("1")){
			buscaNome(event);
		}
		else if (tipoDeBusca.equals("2")){
			buscaMenorIdade(event);
		}
		else if(tipoDeBusca.equals("1")){
			buscaIgualIdade(event);
		}else{
			buscaMaiorIdade(event);
		}

	}

	public ArrayList<Contato> getResultadoBusca() {
		return resultadoBusca;
	}
}
