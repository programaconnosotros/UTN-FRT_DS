package edu.bascula.dominio;

import java.time.LocalDate;

public class Pesaje extends Lectura
{
	
	private double peso; 
	
	public Pesaje(String dispositivo,LocalDate fecha, Vehiculo vehiculo, double peso) 
	{
		super(dispositivo,fecha,vehiculo);
		this.peso = peso;
	}	

	public double getPeso() {
		return peso;
	}
	
	@Override
	public String tipo() {
		return "Pesaje";
	}
	
	
	
}
