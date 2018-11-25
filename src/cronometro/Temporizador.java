package cronometro;

public class Temporizador {

	public long horaInicio;
	public long horaFim;
	
	
	
	public String iniciaCronometro() {
		long tinicial = System.currentTimeMillis(); 
		horaInicio = tinicial;
		return "temporizador iniciado" ;
	}
	
	public String finalizaCronometro() {
		long tfinal = System.currentTimeMillis();
		horaFim = tfinal;
		long milisTotal = horaFim - horaInicio;
		long segundos = ( milisTotal / 1000 ) % 60;
		long minutos  = ( milisTotal / 60000 ) % 60;     // 60000   = 60 * 1000
		long horas    = milisTotal / 3600000;            // 3600000 = 60 * 60 * 1000
		return "tempo levado para inserir os arquivos:  "+ String.format("%02d:%02d:%02d", horas, minutos, segundos)+"h";
	}
	
}
