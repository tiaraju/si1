package exceptions;

public class InvalidNameException extends Exception{
	private String msg;  
	
	public InvalidNameException(String msg){  
		super(msg);  
		this.msg = msg;  
	}
	
	public String getMessage(){  
		return msg;  
	} 
}
