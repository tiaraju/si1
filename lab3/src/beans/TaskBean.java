package beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import tasklist.Task;


@ManagedBean(name="taskbean")
public class TaskBean {
	
	Task task;
	String name;
	String description;
	Date taskDate;
	
	@PostConstruct
	  public void preparaDados()  {    
		this.task= new Task();
	  }
	
	public String getName(){
		return task.getName();
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getDescription(){
		return task.getDescription();
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}


	public void setDate(Date taskDate) {
		this.taskDate = taskDate;
	}


	public Date getDate(){
		return task.getDate();
	}

}
