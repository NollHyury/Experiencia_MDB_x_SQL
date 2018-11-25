package dataMongo;

import com.mongodb.MongoClient;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;



public class MDBData{

	// Criando a conexão
	 protected MongoClient conexao;
	 protected DB dataBase;
	 private DBCollection collection;
	 
	 public MDBData() {
		 try {
			this.conexao = new MongoClient("localhost",27017); //conecta com o mongodb
			this.dataBase = conexao.getDB("TAXITRAJECTORY"); //conecta com o database desejado
			this.collection = dataBase.getCollection("Coordenada"); // conecta com a collection desejada
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 

	public DBCollection getCollection() {
		return collection;
	}

	public void setCollection(String nameOfCollection) {
		this.collection = this.dataBase.getCollection(nameOfCollection);
	}
	


}