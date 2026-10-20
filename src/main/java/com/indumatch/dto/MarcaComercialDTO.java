package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class MarcaComercialDTO {
	
	private UUID id;
	private String nombre;
	private String descripcion;
	private ClienteDistribuidorDTO clienteDistribuidor;
	private MarcaComercialDTO marcaMadre;
	
	public MarcaComercialDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIO);
		setDescripcion(UtilTexto.VACIO);
		setClienteDistribuidor(new ClienteDistribuidorDTO());
		// marcaMadre no se inicializa por defecto para evitar una recursión infinita (autorreferencia)
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(descripcion);
	}
	
	public ClienteDistribuidorDTO getClienteDistribuidor() {
		return clienteDistribuidor;
	}
	
	public void setClienteDistribuidor(ClienteDistribuidorDTO clienteDistribuidor) {
		this.clienteDistribuidor = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteDistribuidor, new ClienteDistribuidorDTO());
	}
	
	public MarcaComercialDTO getMarcaMadre() {
		return marcaMadre;
	}
	
	public void setMarcaMadre(MarcaComercialDTO marcaMadre) {
		this.marcaMadre = marcaMadre;
	}
	
}
