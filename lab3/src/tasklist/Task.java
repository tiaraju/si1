package tasklist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import exceptions.*;
/**
 * 
 * @author tiaraju
 *
 */
public class Task implements Comparable<Task> {

	private String nome;
	private Data dataCriacao;
	private Data dataConclusao;
	private Hour horaConclusao;
	private String descricao;
	private boolean status;
	private DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	private Date date = new Date();
	private Hour horaCriacao;

	public Task(String nome) throws NumberFormatException,
			InvalidHourException, InvalidMinuteException,
			InvalidDayException, InvalidMonthException, InvalidYearException {
		this.nome = nome;
		this.status = false;
		this.dataCriacao = getDataSystem(new SimpleDateFormat("dd/MM/yyyy")
				.format(Calendar.getInstance().getTime()));
		this.dataConclusao = new Data();
		this.horaConclusao = new Hour();
		this.descricao = "";
		this.horaCriacao = new Hour(Integer.parseInt(this.dateFormat.format(
				this.date).substring(0, 2)), Integer.parseInt(this.dateFormat
				.format(this.date).substring(3, 5)));
	}

	private Data getDataSystem(String data) throws NumberFormatException,
			InvalidDayException, InvalidMonthException, InvalidYearException {
		return new Data(Integer.parseInt(data.substring(0, 2)),
				Integer.parseInt(data.substring(3, 5)), Integer.parseInt(data
						.substring(6, 10)));
	}

	public Hour getHoraCriacao() {
		return horaCriacao;
	}

	public void setHoraCriacao(Hour horaCriacao) {
		this.horaCriacao = horaCriacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Data getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Data dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Data getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Data dataConclusao)
			throws InvalidDateException {
		if (!dataConclusao.equals(new Data())) {
			if (this.getDataCriacao().compareTo(dataConclusao) > 0) {
				throw new InvalidDateException();
			}
			if (this.getDataCriacao().compareTo(dataConclusao) == 0) {
				if (this.getHoraConclusao().compareTo(this.getHoraCriacao()) > 0) {
					throw new InvalidDateException();
				}
			}
		}
		this.dataConclusao = dataConclusao;
	}

	public Hour getHoraConclusao() {
		return horaConclusao;
	}

	public void setHoraConclusao(Hour horaConclusao) {
		this.horaConclusao = horaConclusao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao == null)
			throw new NullPointerException();
		this.descricao = descricao;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Task))
			return false;
		return this.getNome().equals(((Task) obj).getNome());
	}

	@Override
	public int compareTo(Task tarefa) {
		if (this.getDataConclusao().compareTo(tarefa.getDataConclusao()) != 0) {
			return getDataConclusao().compareTo(tarefa.getDataConclusao());
		}
		return this.getNome().compareTo(tarefa.getNome());
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + ", DataCriacao: "
				+ this.getDataCriacao() + ", DataConclusao: "
				+ this.getDataConclusao();
	}
}
