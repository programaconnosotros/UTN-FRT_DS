package edu.bascula.aplicacion;

import java.time.LocalDate;

import edu.bascula.datos.Repositorio;
import edu.bascula.dominio.Alarma;
import edu.bascula.dominio.Lectura;
import edu.bascula.dominio.Pesaje;
import edu.bascula.dominio.Vehiculo;

public class ControladorRecibirEvento 
{

	public void registrarEvento(String dispositivo, LocalDate fecha, String codigoVehiculo, double peso,
			String mensaje) {
		
		Lectura nuevaLectura = null;		
		
		Vehiculo vehiculo = Repositorio.buscarVehiculo(codigoVehiculo);
		
		nuevaLectura  = (esPesaje(peso, mensaje))? new Pesaje(dispositivo, fecha, vehiculo, peso) : nuevaLectura ;
		
		nuevaLectura  = (esAlarma(peso, mensaje))? new Alarma(dispositivo, fecha, vehiculo, mensaje) : nuevaLectura ;
		
					
		Repositorio.registrarLectura(nuevaLectura);
		
		
	}
	
	private boolean esPesaje(double peso, String mensaje) {
		return peso !=0 && mensaje == null;
	}
	
	private boolean esAlarma(double peso, String mensaje) {
		return peso == 0 && mensaje != null;
	}

}
