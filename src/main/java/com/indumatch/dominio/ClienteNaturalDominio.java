package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteNaturalDominio {
	
	private UUID id;
	private ClienteDominio cliente;
	private String nombre;
	
	
	private ClienteNaturalDominio(Builder builder) {
		this.id = builder.id;
		this.cliente = builder.cliente;
		this.nombre = builder.nombre;
	}
	

	public UUID getId() {
		return id;
	}
	
	public ClienteDominio getCliente() {
		return cliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public static class Builder {
		private UUID id;
		private ClienteDominio cliente;
		private String nombre;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cliente = new ClienteDominio.Builder().build();
			nombre = UtilTexto.VACIO;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder cliente(ClienteDominio cliente) {
			this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDominio.Builder().build());
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}
		
		public ClienteNaturalDominio build() {
			return new ClienteNaturalDominio(this);
		}
		
	}
}
