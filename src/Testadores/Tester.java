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
		System.out.println(mdb.getNomeDoBanco());
		
		
		
		
		
		
	}

}
