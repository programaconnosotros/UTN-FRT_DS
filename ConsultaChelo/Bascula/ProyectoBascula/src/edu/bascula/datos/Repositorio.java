package edu.bascula.datos;

import java.util.ArrayList;

import edu.bascula.dominio.Lectura;
import edu.bascula.dominio.Pesaje;
import edu.bascula.dominio.Vehiculo;
import edu.bascula.transversal.exceptions.VehiculoNoEncontradoException;

public class Repositorio {
	
	public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	
	public static ArrayList<Lectura> lecturas = new ArrayList<>();
	
	public static void registrarVehiculo(Vehiculo nuevo) {
		vehiculos.add(nuevo);
	}
	
	public static Vehiculo buscarVehiculo(String codigoVehiculo) {
		for(Vehiculo v : vehiculos) {
			
			if(v.getCodigo().equals(codigoVehiculo)) {
				return v;
			}
		}
		throw new VehiculoNoEncontradoException();
	}

	public static void registrarLectura(Lectura nuevaLectura) {
		lecturas.add(nuevaLectura);		
	}

	public static Lectura getUltimoEventoRegistrado() {
		// TODO Auto-generated method stub
		return lecturas.get(lecturas.size()-1);
	}
}
