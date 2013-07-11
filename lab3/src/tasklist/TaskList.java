package tasklist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exceptions.InvalidNameException;

public class TaskList {

	List<Task> pendingTasks;
	List<Task> completedTasks;

	public TaskList(){
		this.pendingTasks= new ArrayList<Task>();
		this.completedTasks= new ArrayList<Task>();
	}

	public void addTask(String name, String description,int year,int month,int date) {
		try{
			Task task = new Task(name,description,year,month,date);
			if(!pendingTasks.contains(task))
				pendingTasks.add(task);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void addTask(String name, String description,Date date) {
		try{
			Task task = new Task(name,description,date);
			if(!pendingTasks.contains(task))
				pendingTasks.add(task);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void addTask(Task t){
		if(!pendingTasks.contains(t)){
			pendingTasks.add(t);
		}

	}

	public void addTask(String name){
		try{
			Task task = new Task(name);
			if(!pendingTasks.contains(task))
				pendingTasks.add(task);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public int size(){
		return getPendingTasks().size()+getCompletedTasks().size();
	}

	public void markAsCompleted(Task task){
		task.setIsCompleted(true);
		getPendingTasks().remove(task);
		getCompletedTasks().add(task);
	}

	public void removeTask(Task task){
		if(task.IsCompleted()){
			getCompletedTasks().remove(task);
		}else{
			getPendingTasks().remove(task);
		}
	}

	public List<Task> getCompletedTasks(){
		return completedTasks;
	}

	public List<Task> getPendingTasks(){
		return pendingTasks;
	}

	public Task search(String name) throws InvalidNameException{

		Task task = new Task(name);
		if(completedTasks.contains(task)){
			int index = completedTasks.indexOf(task);
			return completedTasks.get(index);
		}else if(pendingTasks.contains(task)){
			int index = pendingTasks.indexOf(task);
			return pendingTasks.get(index);
		}
		return null;
	}

}
