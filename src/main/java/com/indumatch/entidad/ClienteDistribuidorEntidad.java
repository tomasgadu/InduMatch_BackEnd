package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteDistribuidorEntidad {
	
	private UUID id;
	private ClienteEntidad cliente;
	private String razonSocial;
	private String nombreComercial;
	
	public ClienteDistribuidorEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
		setRazonSocial(UtilTexto.VACIO);
		setNombreComercial(UtilTexto.VACIO);
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
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(razonSocial);
	}
	
	public String getNombreComercial() {
		return nombreComercial;
	}
	
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombreComercial);
	}
	
}
