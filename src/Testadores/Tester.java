package Testadores;

import java.io.IOException;

import Experiencia.Experimento;
import dataMongo.MDBDAO;
import dataSQL.SQLData;
import models.Coordenada;

public class Tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MDBDAO mdb = new MDBDAO();
		SQLData sql = new SQLData();
		
		
		Experimento master = new Experimento(sql);
		System.out.println(master.procurarCoordenada(116.6551,40.22203));
		
	
		
		
		
		
	}

}
