package Experiencia;

import java.io.IOException;

import fileReader.LeitorTxt;
import models.BancoDeDados;
import models.Coordenada;
import cronometro.*;

public class Experimento {
	
	protected LeitorTxt leitorTxt;
	protected BancoDeDados bd;
	
	public Experimento(BancoDeDados bd) {
		this.leitorTxt = new LeitorTxt();
		this.bd = bd;
		
	}
	
	
	public String InserirVariasCoordenadas(int quantidadeDeCoordenadas) throws IOException {
		Temporizador temp = new Temporizador();
		temp.iniciaCronometro();
		for (int i = 0; i < quantidadeDeCoordenadas; i++) {
			
			Coordenada c = leitorTxt.CoordenadaAleatoria();
			bd.save(c);
			System.out.println("coordenada inserida até o momento: "+i);
			
		}
		bd.close();
		return temp.finalizaCronometro();
	}

	public Coordenada procurarCoordenada(double Latitude, double Longetude) {
		Coordenada c =  bd.getOne(Latitude, Longetude);
		bd.close();
		return c;
		
	}

	
	
}
