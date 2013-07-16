package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tasklist.Data;
import tasklist.Task;
/**
 * 
 * @author tiaraju
 *
 */
public class Controller {

	private List<Task> tarefas;
	private List<Task> tarefasCompletas;
	private List<Task> tarefafsIncompletas;


	public List<Task> getTarefasCompletas() {
		return tarefasCompletas;
	}

	public void setTarefasCompletas(List<Task> TasksCompletas) {
		this.tarefasCompletas = TasksCompletas;
	}

	public List<Task> getTarefasIncompletas() {
		return tarefafsIncompletas;
	}

	public void setTarefasIncompletas(List<Task> TasksIncompletas) {
		this.tarefafsIncompletas = TasksIncompletas;
	}

	public void adicionaTarefa(Task Task) {
		this.tarefas.add(Task);
		this.addTarefaIncompleta(Task);
	}

	public List<Task> getTarefas() {
		return this.tarefas;
	}

	public void ordena(Comparator<Task> comparador) {
		Collections.sort(this.tarefas, comparador);
	}

	public void ordenaCompletas(Comparator<Task> comparador) {
		Collections.sort(this.tarefasCompletas, comparador);
	}

	public void ordenaIncompletas(Comparator<Task> comparador) {
		Collections.sort(this.tarefafsIncompletas, comparador);
	}

	public void addTarefaIncompleta(Task Task) {
		this.tarefafsIncompletas.add(Task);
	}

	public void addTarefaCompleta(Task Task) {
		this.tarefasCompletas.add(Task);
	}

	public void removeTarefaIncompleta(Task Task) {
		this.tarefafsIncompletas.remove(Task);
		this.tarefas.remove(Task);
	}
	public Controller() {
		this.tarefas = new ArrayList<Task>();
		this.tarefasCompletas = new ArrayList<Task>();
		this.tarefafsIncompletas = new ArrayList<Task>();
		try {
			Task task1 = new Task("Reuniao");
			Task task2 = new Task("Consulta");
			Task task3 = new Task("Aula");
			Task task4 = new Task("Appointment");
			Task task5 = new Task("Party");
			task1.setDescricao("reuniao do projeto");
			task2.setDescricao("consulta no dentista");
			task3.setDescricao("aula de si1");
			task4.setDescricao("appointment with manager");
			task5.setDescricao("lazy time");
			task1.setDataConclusao(new Data(10,11,2015));
			task2.setDataConclusao(new Data(12,8,2015));
			task3.setDataConclusao(new Data(14,5,2015));
			task4.setDataConclusao(new Data(16,9,2015));
			task5.setDataConclusao(new Data(23,7,2015));
			adicionaTarefa(task1);
			adicionaTarefa(task2);
			adicionaTarefa(task5);
			adicionaTarefa(task3);
			adicionaTarefa(task4);
		} catch (Exception e) {
		}
	}
	
	public void setCompleted(Task Task) {
		for (Task task : this.tarefas) {
			if (Task.equals(Task)) {
				if (!task.getStatus()) {
					task.setStatus(true);
					addTarefaCompleta(task);
					removeTarefaIncompleta(task);
				}
				break;
			}
		}
	}

	public void removeTarefaCompleta(Task Task) {
		this.tarefasCompletas.remove(Task);
	}

	public void removeTarefa(Task Task) {
		if (Task.getStatus() == true) {
			this.removeTarefaCompleta(Task);
		} else {
			this.removeTarefaIncompleta(Task);
		}
		this.getTarefas().remove(Task);
	}

	public void editTarefa(Task oldTask, Task newTask) throws IllegalArgumentException{

		if (this.getTarefas().contains(newTask)) {
			if (!oldTask.getNome().equals(newTask.getNome())) {
				throw new IllegalArgumentException("nome errado");
			}
		}
		for (int i = 0; i < this.getTarefas().size(); i++) {
			if (oldTask.equals(this.getTarefas().get(i))) {
				this.removeTarefa(oldTask);
				this.getTarefas().add(newTask);
				if (newTask.getStatus()) {
					this.addTarefaCompleta(newTask);
				} else {
					this.addTarefaIncompleta(newTask);
				}
				break;
			}
		}
	}
}