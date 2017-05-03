
public class CalculaValor {
	
	private final Acesso __acesso;
	private int __quantidadeDeHoras;
	private int __quantidadeDeMinutos;
	private float __valorTotal;
	
	public CalculaValor(Acesso acesso) {
		__acesso = acesso;
		__quantidadeDeHoras = __acesso.horaSaida - __acesso.horaEntrada;
		__quantidadeDeMinutos = 0;
		
	}

	public float calculaValor(){
		
		calculaHoraEMinutos();
		
		__valorTotal = 0; 
		__valorTotal += __quantidadeDeHoras * __acesso.VALOR_HORA;
		__valorTotal += Math.ceil(__quantidadeDeMinutos / 15.0) * __acesso.VALOR_FRACAO;		
		
		if (__quantidadeDeHoras >=9)
			return __acesso.VALOR_DIARIA;
		else 
			return __valorTotal;
		
	}
	
	public void calculaHoraEMinutos(){
		
		if (__acesso.horaSaida == __acesso.horaEntrada)
			__quantidadeDeMinutos = __acesso.minutosSaida - __acesso.minutosEntrada;
		else if (__acesso.horaSaida > __acesso.horaEntrada && __acesso.minutosEntrada == __acesso.minutosSaida){
			__quantidadeDeMinutos = 0;
			__quantidadeDeHoras = __acesso.horaSaida - __acesso.horaEntrada;
		}
		else if (__acesso.horaSaida > __acesso.horaEntrada && __acesso.minutosEntrada > __acesso.minutosSaida){ 
			__quantidadeDeMinutos = __acesso.minutosSaida - __acesso.minutosEntrada;}
		else if (__acesso.horaSaida > __acesso.horaEntrada && __acesso.minutosSaida < __acesso.minutosEntrada){
			__quantidadeDeMinutos = __acesso.minutosSaida + (60 - __acesso.minutosEntrada);
			__quantidadeDeHoras = __quantidadeDeHoras - 1;
		}
		else {
			__quantidadeDeHoras = 0;
			__quantidadeDeMinutos = 0;
		}
		
	}
	

}
