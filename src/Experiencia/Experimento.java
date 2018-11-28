package Experiencia;

import java.io.IOException;

import fileReader.LeitorTxt;
import models.BancoDeDados;
import models.Coordenada;
import cronometro.*;

public class Experimento {
	
	protected LeitorTxt leitorTxt;
	protected BancoDeDados bd;
	protected Temporizador temp;
	
	public Experimento(BancoDeDados bd) {
		this.leitorTxt = new LeitorTxt();
		this.bd = bd;
		this.temp = new Temporizador();
		
	}
	
	
	public void InserirVariasCoordenadas(int quantidadeDeCoordenadas) throws IOException {
		System.out.println(temp.iniciaCronometro("InserirVariasCoordenadas"));
		for (int i = 0; i < quantidadeDeCoordenadas; i++) {
			
			Coordenada c = leitorTxt.CoordenadaAleatoria();
			bd.save(c);
			System.out.println("coordenada inserida até o momento: "+i
					+ "no banco: "+bd.getNomeDoBanco());
			
		}
		bd.close();
		System.out.println(temp.finalizaCronometro("InserirVariasCoordenadas"));
	}

	public Coordenada procurarCoordenada(double Latitude, double Longetude) {
		System.out.println(temp.iniciaCronometro("procurarCoordenada"));
		Coordenada c =  bd.getOne(Latitude, Longetude);
		bd.close();
		System.out.println(temp.finalizaCronometro("procurarCoordenada"));
		return c;
		
	}
	
	public Coordenada coordenadaEncontrada(Coordenada c) {
		return c;
	}
	
	

	
	
}
