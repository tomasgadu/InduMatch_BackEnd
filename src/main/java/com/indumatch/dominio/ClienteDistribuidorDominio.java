package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteDistribuidorDominio {
	
	private UUID id;
	private ClienteDominio cliente;
	private String razonSocial;
	private String nombreComercial;
	
	
	private ClienteDistribuidorDominio(Builder builder) {
		this.id = builder.id;
		this.cliente = builder.cliente;
		this.razonSocial = builder.razonSocial;
		this.nombreComercial = builder.nombreComercial;
	}
	

	public UUID getId() {
		return id;
	}
	
	public ClienteDominio getCliente() {
		return cliente;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public String getNombreComercial() {
		return nombreComercial;
	}
	
	public static class Builder {
		private UUID id;
		private ClienteDominio cliente;
		private String razonSocial;
		private String nombreComercial;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cliente = new ClienteDominio.Builder().build();
			razonSocial = UtilTexto.VACIO;
			nombreComercial = UtilTexto.VACIO;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder cliente(ClienteDominio cliente) {
			this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDominio.Builder().build());
			return this;
		}
		
		public Builder razonSocial(String razonSocial) {
			this.razonSocial = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(razonSocial);
			return this;
		}
		
		public Builder nombreComercial(String nombreComercial) {
			this.nombreComercial = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombreComercial);
			return this;
		}
		
		public ClienteDistribuidorDominio build() {
			return new ClienteDistribuidorDominio(this);
		}
		
	}
}
