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
		Experimento experimentoSql = new Experimento(sql);
		Experimento experimentoMdb = new Experimento(mdb);
		
		experimentoMdb.InserirVariasCoordenadas(500);
		//experimentoMdb.procurarCoordenada(117.11678, 40.14313);
		experimentoSql.InserirVariasCoordenadas(500);
		//experimentoSql.procurarCoordenada(116.52934, 40.04491);
		
		
		
		
		
	}

}
