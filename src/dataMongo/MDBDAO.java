package dataMongo;

import java.io.IOException;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;


import com.google.gson.Gson;

import models.BancoDeDados;
import models.Coordenada;
public class MDBDAO extends BancoDeDados {

	protected MDBData MDBData ;
	protected Gson gson;
	
	public MDBDAO() {
		this.MDBData = new MDBData();
		this.gson = new Gson();
	}
	
	
	protected DBObject ConverterDbObject(Coordenada c) throws IOException {
		String coo = gson.toJson(c);
		JsonParser jsonToken = new JsonParser();
	    JsonObject objToken = jsonToken.parse(coo).getAsJsonObject();
	    objToken.remove("id");
		DBObject dbObject = (DBObject) JSON
				.parse(objToken.toString());
		return dbObject;
	}
	
	
	@Override
	public void save(Coordenada c) throws IOException {
		MDBData.getCollection().insert(ConverterDbObject(c));
		
	}


	public Coordenada getOne(double latitude, double longetude) {
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("Latitude", latitude);
		whereQuery.put("Longetude", longetude);
		BasicDBObject ok = (BasicDBObject) MDBData.getCollection().findOne(whereQuery);
	    return gson.fromJson(ok.toString(), Coordenada.class);
	    
	}

	@Override
	public void close() {
		this.MDBData.conexao.close();
		
	}


	
	

}
