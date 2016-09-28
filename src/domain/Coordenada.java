package domain;

import java.io.Serializable;

public class Coordenada implements Serializable {

	private int idArquivo;
	private String data;
	private String hora;
	private double latitude;
	private double longitude;

	public Coordenada() {
	}

	public Coordenada(int idArquivo, String data ,String hora,double latitude, double longitude) {
		super();
		this.idArquivo = idArquivo;
		this.data = data;
		this.hora = hora;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(int idArquivo) {
		this.idArquivo = idArquivo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
