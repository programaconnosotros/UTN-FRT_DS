package edu.bascula.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.bascula.aplicacion.ControladorRecibirEvento;
import edu.bascula.datos.Repositorio;
import edu.bascula.dominio.Alarma;
import edu.bascula.dominio.Lectura;
import edu.bascula.dominio.Pesaje;
import edu.bascula.dominio.Vehiculo;
import edu.bascula.transversal.exceptions.VehiculoNoEncontradoException;

public class TestFlujoNormal {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {		
		Repositorio.registrarVehiculo(new Vehiculo("ABC123","Ford Fiesta"));
	}

	@Test
	public void testCrearPesaje() {
		
		// 1 Caso de prueba : Registrar Exitosamente un pesaje
		
		// 1- Preparacion 
		
		String dispositivo = "XD123";
		
		LocalDate fecha = LocalDate.now();
		
		String codigoVehiculo = "ABC123";
		
		double peso = 100;
		
		String mensaje = null;
		
		ControladorRecibirEvento controlador = new ControladorRecibirEvento();
		
		//Ejecucion				
		
		controlador.registrarEvento(dispositivo,fecha,codigoVehiculo,peso,mensaje);
		
		// Comprobacion
		
		Lectura evento = Repositorio.getUltimoEventoRegistrado();
		
		Assert.assertEquals(dispositivo, evento.getDispositivo());	
		
	}
	
	@Test
	public void testCrearAlarma() 
	{
		String dispositivo = "ZF456";
		
		LocalDate fecha = LocalDate.now();
		
		String codigoVehiculo = "ABC123";
		
		double peso = 0;
		
		String mensaje = "El dispositivo se rompio";
		
		ControladorRecibirEvento controlador = new ControladorRecibirEvento();
		
		//Ejecucion				
		
		controlador.registrarEvento(dispositivo,fecha,codigoVehiculo,peso,mensaje);
		
		// Comprobacion
		
		Lectura evento = Repositorio.getUltimoEventoRegistrado();
		
		Assert.assertEquals(dispositivo, evento.getDispositivo());	
	}
	
	@Test 
	public void RegistrarPesajeConVehiculoInexistente() 
	{	
				
			try 
			{
				String dispositivo = "XD123";
				
				LocalDate fecha = LocalDate.now();
				
				String codigoVehiculo = "ABC456";
				
				double peso = 100;
				
				String mensaje = null;
				
				ControladorRecibirEvento controlador = new ControladorRecibirEvento();
				
				//Ejecucion				
				
				controlador.registrarEvento(dispositivo,fecha,codigoVehiculo,peso,mensaje);
				
				// Comprobacion
				
				Lectura evento = Repositorio.getUltimoEventoRegistrado();
				
				Assert.fail("Debería notificarme que no existe el vehiculo");
			}
			catch(VehiculoNoEncontradoException errorEsperado) {
				String mensajeEsperado = "El vehiculo no se encontró";
				
				Assert.assertEquals(errorEsperado.getMessage(),mensajeEsperado);
			}
			catch(Exception e) {
				Assert.fail("Debería notificarme que no existe el vehiculo");
			}
				
	}
}
