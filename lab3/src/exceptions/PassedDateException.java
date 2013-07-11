package exceptions;

public class PassedDateException extends Exception {
private String msg;  
	
	public PassedDateException(String msg){  
		super(msg);  
		this.msg = msg;  
	}
	
	public String getMessage(){  
		return msg;  
	} 

}
