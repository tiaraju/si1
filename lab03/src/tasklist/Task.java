package tasklist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author tiaraju
 *
 */
public class Task implements Comparable<Task> {

	private String name;
	private String description;
	private boolean status;
	private Data criationDate;
	private Data conclusionDate;
	private Hour conclusionTime;
	private Date date;
	private DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	private Hour criationTime;

	public Task(String nome) throws NumberFormatException, IllegalArgumentException {
		if(nome == null || nome.equals("")){
			throw new IllegalArgumentException();
		}
		this.date=new Date();
		this.name = nome;
		this.status = false;
		this.criationDate = getSystemHour(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
		this.conclusionDate = new Data();
		this.conclusionTime = new Hour();
		this.description = "";
		this.criationTime = new Hour(Integer.parseInt(this.dateFormat.format(this.date).substring(0, 2)), Integer.parseInt(this.dateFormat.format(this.date).substring(3, 5)));
	}


	public Hour getHoraCriacao() {
		return criationTime;
	}

	public void setHoraCriacao(Hour horaCriacao) {
		this.criationTime = horaCriacao;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public Data getDataCriacao() {
		return criationDate;
	}
	private Data getSystemHour(String data) throws NumberFormatException,IllegalArgumentException {
		return new Data(Integer.parseInt(data.substring(0, 2)),
				Integer.parseInt(data.substring(3, 5)), Integer.parseInt(data
						.substring(6, 10)));
	}

	public void setDataCriacao(Data dataCriacao) {
		this.criationDate = dataCriacao;
	}

	public Data getDataConclusao() {
		return conclusionDate;
	}


	public Hour getHoraConclusao() {
		return conclusionTime;
	}

	public void setHoraConclusao(Hour horaConclusao) {
		this.conclusionTime = horaConclusao;
	}

	public String getDescricao() {
		return description;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Task))
			return false;
		Task task = (Task)obj;
		return this.getNome().equals((task).getNome());
	}
	
	public void setDataConclusao(Data dataConclusao) throws IllegalArgumentException {
		if (dataConclusao != null &&!dataConclusao.equals(new Data())) {
			if (this.getDataCriacao().compareTo(dataConclusao) == 0) {
				if (this.getHoraConclusao().compareTo(this.getHoraCriacao()) < 0) {
					throw new IllegalArgumentException();
				}
			}
			if (this.getDataCriacao().compareTo(dataConclusao) > 0) {
				throw new IllegalArgumentException();
			}
		}
		this.conclusionDate = dataConclusao;
	}
	public void setDescricao(String descricao) {
		if (descricao == null)
			throw new NullPointerException();
		this.description = descricao;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Nome: " + this.getNome() + ", DataCriacao: "
				+ this.getDataCriacao() + ", DataConclusao: "
				+ this.getDataConclusao();
	}
	@Override
	public int compareTo(Task task) {
		if (this.getDataConclusao().compareTo(task.getDataConclusao()) != 0) {
			return getDataConclusao().compareTo(task.getDataConclusao());
		}
		return this.getNome().compareTo(task.getNome());
	}
}
