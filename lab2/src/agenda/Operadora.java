package agenda;

public enum Operadora{
	
	TIM(01), OI(02), CLARO(03), VIVO(04),RESIDENCIAL(05); 
	private int valor;
	
	Operadora(int valor){
		this.valor=valor;
	}
	
	public int getValor(){
		return this.valor;
	}
}
