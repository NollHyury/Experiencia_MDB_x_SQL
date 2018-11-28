package cronometro;

public class Temporizador {

	public long horaInicio;
	public long horaFim;
	
	
	
	public String iniciaCronometro(String operacao) {
		long tinicial = System.currentTimeMillis(); 
		horaInicio = tinicial;
		return "temporizador iniciado para a operacao: "+operacao ;
	}
	
	public String finalizaCronometro(String operacao) {
		long tfinal = System.currentTimeMillis();
		horaFim = tfinal;
		long milisTotal = horaFim - horaInicio;
		long segundos = ( milisTotal / 1000 ) % 60;
		long minutos  = ( milisTotal / 60000 ) % 60;     // 60000   = 60 * 1000
		long horas    = milisTotal / 3600000;            // 3600000 = 60 * 60 * 1000
		return "tempo levado para realizar a operacao: "+operacao  +",foi de: "+ String.format("%02d:%02d:%02d", horas, minutos, segundos)+"h";
	}
	
}
