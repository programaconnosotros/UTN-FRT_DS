package edu.bascula.transversal.exceptions;

public class VehiculoNoEncontradoException extends RuntimeException
{
	public VehiculoNoEncontradoException() {
		super("El vehiculo no se encontró");
	}
}
