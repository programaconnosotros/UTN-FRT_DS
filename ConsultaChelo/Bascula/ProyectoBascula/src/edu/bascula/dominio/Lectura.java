package edu.bascula.dominio;

import java.time.LocalDate;

public class Lectura 
{	
	private String dispositivo;
	
	private LocalDate fecha; 
	
	private Vehiculo vehiculo;
	
	private EstadoLectura estado;
	
	
	public Lectura(String dispositivo, LocalDate fecha, Vehiculo vehiculo) 
	{
		this(dispositivo,fecha,vehiculo,EstadoLectura.PENDIENTE);
	}
	
	public Lectura(String dispositivo, LocalDate fecha, Vehiculo vehiculo, EstadoLectura estado) 
	{
		this.dispositivo = dispositivo;
		this.fecha = fecha;
		this.vehiculo = vehiculo;
		this.estado = estado;		
	}

	public String getDispositivo() {
		return dispositivo;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public String tipo() {
		return "Lectura";
	}
	
	
}
