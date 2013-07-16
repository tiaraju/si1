package tasklist;

import java.util.Comparator;
/**
 * 
 * @author tiaraju
 *
 */
public class DateCriation implements Comparator<Task>{
	
	@Override
	public int compare(Task task, Task task1) {
		if(task.getDataCriacao().equals(task1.getDataCriacao())){
			return task.getNome().compareTo(task1.getNome());
		}
		return task.getDataCriacao().compareTo(task1.getDataCriacao());
	}
}