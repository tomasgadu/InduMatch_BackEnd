package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class MarcaComercialEntidad {
	
	private UUID id;
	private String nombre;
	private String descripcion;
	private ClienteDistribuidorEntidad clienteDistribuidor;
	private MarcaComercialEntidad marcaMadre;
	
	public MarcaComercialEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIO);
		setDescripcion(UtilTexto.VACIO);
		setClienteDistribuidor(new ClienteDistribuidorEntidad());
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
	
	public ClienteDistribuidorEntidad getClienteDistribuidor() {
		return clienteDistribuidor;
	}
	
	public void setClienteDistribuidor(ClienteDistribuidorEntidad clienteDistribuidor) {
		this.clienteDistribuidor = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteDistribuidor, new ClienteDistribuidorEntidad());
	}
	
	public MarcaComercialEntidad getMarcaMadre() {
		return marcaMadre;
	}
	
	public void setMarcaMadre(MarcaComercialEntidad marcaMadre) {
		this.marcaMadre = marcaMadre;
	}
	
}
