package edu.bascula.dominio;

import java.time.LocalDate;

public class Alarma extends Lectura
{
	
	private String mensaje;
	
	public Alarma(String dispositivo,LocalDate fecha, Vehiculo vehiculo,String mensaje) 
	{
		super(dispositivo,fecha,vehiculo);
		this.mensaje = mensaje;
	}
	
	@Override
	public String tipo() {
		return "Alarma";
	}
}
