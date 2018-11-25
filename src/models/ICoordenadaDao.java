package models;

import java.io.IOException;

public interface ICoordenadaDao<T> {

	
	void save(T t) throws IOException;
	
	
	T getOne(double latitude,double longetude);
	
	
	void close();
	
	
	
	
	
	
}
