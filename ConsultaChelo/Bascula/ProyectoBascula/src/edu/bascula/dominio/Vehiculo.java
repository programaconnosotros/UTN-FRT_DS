package edu.bascula.dominio;

public class Vehiculo {
	
	private String codigo;
	private String modelo;	
	
	public Vehiculo(String codigo, String modelo) {
		this.codigo = codigo;
		this.modelo = modelo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
