package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteNaturalEntidad {
	
	private UUID id;
	private ClienteEntidad cliente;
	private String nombre;
	
	public ClienteNaturalEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
		setNombre(UtilTexto.VACIO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public ClienteEntidad getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteEntidad cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteEntidad());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
	}
	
}
