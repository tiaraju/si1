package tasklist;

/**
 * 
 * @author tiaraju
 *
 */
public class Data implements Comparable<Data> {

	private int day;
	private int year;
	private int month;

	public Data(int day, int month, int year) throws IllegalArgumentException {
		if (day < 1 || day > 31)
			throw new IllegalArgumentException();
		if (month == 2 && day > 29)
			throw new IllegalArgumentException();
		if (month == 2 && day == 29) {
			if (!(year % 4 == 0)) {
				throw new IllegalArgumentException();
			} else {
				if ((year % 100 == 0))
					throw new IllegalArgumentException();
			}
		}
		if(month>12 || month <0){
			throw new IllegalArgumentException();
		}
		if (day == 31 && (month == 11 || month == 9|| month == 6 || month == 4 || month == 2)) {
			throw new IllegalArgumentException();
		}		

		this.day = day;
		this.month = month;
		this.year = year;
	}


	public void setAno(int ano) throws IllegalArgumentException {
		if (ano > 1900) {
			this.year = ano;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public Data() {
	}

	public int getDia() {
		return day;
	}

	public void setDia(int dia) throws IllegalArgumentException {
		if (dia >= 1 && dia <= 31) {
			this.day = dia;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getAno() {
		return year;
	}
	public int getMes() {
		return month;
	}

	public void setMes(int month) throws IllegalArgumentException {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			throw new IllegalArgumentException();
		}
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Data))
			return false;
		Data data = (Data)obj;
		return this.getDia() ==  data.getDia()&& this.getMes() ==  data.getMes()&& this.getAno() ==  data.getAno();
	}

	@Override
	public int compareTo(Data data) {
		if (data.getAno() < this.getAno()) {
			return 1;
		}
		else if (data.getAno() > this.getAno()) {
			return -1;
		} else {
			if (data.getMes() > this.getMes()) {
				return -1;
			} else if (data.getMes() < this.getMes()) {
				return 1;
			} else {
				if (data.getDia() > this.getDia()) {
					return -1;
				} else if (data.getDia() < this.getDia()) {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
	}
}
