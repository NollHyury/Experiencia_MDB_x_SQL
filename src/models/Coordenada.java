package models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coordenada {

	@Id
	@GeneratedValue
	private Long id;
	private int idTaxi;
	private Date data;
	private double Latitude;
	private double Longetude;
	
	
	
	
	public Coordenada() {
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public int getIdTaxi() {
		return idTaxi;
	}




	public void setIdTaxi(int idTaxi) {
		this.idTaxi = idTaxi;
	}





	public double getLatitude() {
		return Latitude;
	}




	public void setLatitude(double latitude) {
		Latitude = latitude;
	}




	public double getLongetude() {
		return Longetude;
	}




	public void setLongetude(double longetude) {
		Longetude = longetude;
	}




	public Date getData() {
		return data;
	}




	public void setData(Date data) {
			this.data = data;
		
	}




	@Override
	public String toString() {
		return "Coordenada [ idTaxi=" + idTaxi + ", data=" + data + ", Latitude=" + Latitude
				+ ", Longetude=" + Longetude + "]";
	}
	
	



	
	
	
	
	
	
	
	
	
	

}
