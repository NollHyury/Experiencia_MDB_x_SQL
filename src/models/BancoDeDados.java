package models;

public abstract class BancoDeDados implements ICoordenadaDao<Coordenada> {

	private String nomeDoBanco;

	
	
	public String getNomeDoBanco() {
		return this.getClass().getName().toUpperCase();
	}

	public void setNomeDoBanco(String nomeDoBanco) {
		this.nomeDoBanco = nomeDoBanco;
	}
	
	
	
}
