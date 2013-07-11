package beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tasklist.Task;
import tasklist.TaskList;

@ManagedBean (name="tasklistbean") 
@SessionScoped
public class TaskListBean {


	TaskList taskList= new TaskList();
	List<Task> completed = taskList.getCompletedTasks();
	List<Task> pending = taskList.getPendingTasks();


	String name;
	String description;
	Date taskDate;



	public List<Task> getCompletedTasks(){
		return completed;
	}


	public Date getDate() {
		return taskDate;
	}


	public void setDate(Date taskDate) {
		this.taskDate = taskDate;
	}


	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}

	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Task>getPendingTasks(){
		return pending;
	}

	public String addTask(){
		if(this.description == null || this.description.equals("")){
		taskList.addTask(name);
		}
		
		taskList.addTask(name, description,taskDate);
		return index();
	}

	public String index(){
		return "index?faces-redirect=true";
	}

	public String cadastro(){
		return "cadastro?faces-redirect=true";
	}

	public Task search(){
		try{
			return taskList.search(name);
		}catch(Exception e){}
		
		return null;
	}
}
