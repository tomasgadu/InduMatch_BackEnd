package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteDistribuidorDTO {
	
	private UUID id;
	private ClienteDTO cliente;
	private String razonSocial;
	private String nombreComercial;
	
	public ClienteDistribuidorDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteDTO());
		setRazonSocial(UtilTexto.VACIO);
		setNombreComercial(UtilTexto.VACIO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public ClienteDTO getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteDTO cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDTO());
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
