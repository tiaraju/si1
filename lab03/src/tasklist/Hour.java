package tasklist;

import exceptions.*;
/**
 * 
 * @author tiaraju
 *
 */
public class Hour implements Comparable<Hour>{

	private int hora;
	private int minutos;
	
	public Hour(int hora, int minutos) throws InvalidHourException, InvalidMinuteException{
		if(hora > 23 || hora < 0) throw new InvalidHourException();
		if(minutos > 59 || minutos < 0) throw new InvalidMinuteException();
		this.hora = hora;
		this.minutos = minutos;
	}

	public Hour() {		
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) throws InvalidHourException {
		if(hora > 23 || hora < 0) throw new InvalidHourException();
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) throws InvalidMinuteException {
		if(minutos > 59 || minutos < 0) throw new InvalidMinuteException();
		this.minutos = minutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hora;
		result = prime * result + minutos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Hour)) return false;
		return this.hora==((Hour)obj).hora && this.minutos==((Hour)obj).minutos;
	}
	
	@Override
	public String toString(){
		return this.getHora() + ":" + this.getMinutos();
	}	
	
	@Override
	public int compareTo(Hour hora) {
		if(this.getHora() < hora.getHora()) return -1;
		else if(this.getHora() > hora.getHora()) return 1;
		else{ //horas iguais
			if(this.getMinutos() > hora.getMinutos()) return 1;
			if(this.getMinutos() < hora.getMinutos()) return -1;
			else return 0;
		}
	}
}
