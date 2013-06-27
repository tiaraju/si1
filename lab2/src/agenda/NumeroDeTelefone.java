package agenda;

public class NumeroDeTelefone {
	private String numero;
	private Operadora operadora;
	private String codigoDeArea;

	
	
	public NumeroDeTelefone(String codigoDeArea,String numero, Operadora operadora) {

		this.numero = numero;
		this.operadora = operadora;
		this.codigoDeArea = codigoDeArea;
	}

	public String getNumero() {
		return numero;
	}

	public Operadora getNumOperadora() {
		return operadora;
	}

	public String getCodigoDeArea() {
		return codigoDeArea;
	}

	public String toString(){
		return operadora.getValor()+"-"+codigoDeArea+"-"+numero;
	}


}
