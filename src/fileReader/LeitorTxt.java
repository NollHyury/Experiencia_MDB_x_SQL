package fileReader;
import models.Coordenada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LeitorTxt {

	
	private Random aleatorio =  new Random();
	private List<Coordenada> listaDeCordenada = new ArrayList<>();
	
	//metodo para gerar um numero aleatório 
	protected int gerarNumeroRamdom(int numeroLimite) throws IOException {
		if(numeroLimite ==0) {
			return 0;
		}
		int numero = aleatorio.nextInt(numeroLimite);
		return numero;
		
		
	}
	
	//metodo para identificar quantos arquivos temos na pasta
	protected int numeroDeArquivosNaPasta() {
		File file = new File("C:\\Users\\hyury\\eclipse-workspace\\ComparacaoDeBD\\release\\taxi_log_2008_by_id");
		int retorno = file.listFiles().length;
		return retorno;
		
	}
	
	// metodo que grava as informações dos arquivos em uma lista local para podermos usala depois
	protected void gravarFilesNaList() throws IOException{
			int id = gerarNumeroRamdom(numeroDeArquivosNaPasta());
			String endereco = "C:\\Users\\hyury\\eclipse-workspace\\ComparacaoDeBD\\release\\taxi_log_2008_by_id\\"+id+".txt";
			if(!new File(endereco).exists()) {
				gravarFilesNaList();
			}
			else {
			FileReader arq = new FileReader(endereco);
			BufferedReader lerArq = new BufferedReader(arq);
			 
			String linha = lerArq.readLine();
			    
			while (linha != null) {
				Coordenada c = gerarCoordenada(linha);
			    listaDeCordenada.add(c);
			    linha = lerArq.readLine();
			} 
			
			arq.close();
			}
		}
	
	// metodo que converte a string vinda do arquivo em data, fazendo assim com que o objeto aceite o tipo de dados vindo do arquivo
	protected Date formatarData(String s){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
		
	}
	
	// metodo que transforma a string vinda do arquivo em um objeto do tipo COORDENADA
	protected Coordenada gerarCoordenada(String stringDados){
		Coordenada cTaxi =  new Coordenada();
		String[] vetorSplit = null;
		vetorSplit = stringDados.split(",");
		
		cTaxi.setIdTaxi(Integer.parseInt(vetorSplit[0]));
		cTaxi.setData(formatarData(vetorSplit[1]));
		cTaxi.setLatitude(Double.parseDouble(vetorSplit[2]));
		cTaxi.setLongetude(Double.parseDouble(vetorSplit[3]));
		return cTaxi;
		
		
	}
		
	// neste metodo geramos uma coordenada aleatória que será enviada para salvarmos no banco
	public Coordenada CoordenadaAleatoria() throws IOException {
		gravarFilesNaList();
		int enderecoLista = gerarNumeroRamdom(getListaDeCordenada().size());
		if(enderecoLista == 0) {
			return CoordenadaAleatoria();
		}
		else {
		Coordenada coordenadaAleatoria = getListaDeCordenada().get(enderecoLista);
		limparList();
		return coordenadaAleatoria;
		}
	}
	
	protected void limparList() {
		this.listaDeCordenada.clear();
	}
	
	public List<Coordenada> getListaDeCordenada() {
		return listaDeCordenada;
	}

	public void setListaDeCordenada(List<Coordenada> listaDeCordenada) {
		this.listaDeCordenada = listaDeCordenada;
	}
	
	
	
	
}
