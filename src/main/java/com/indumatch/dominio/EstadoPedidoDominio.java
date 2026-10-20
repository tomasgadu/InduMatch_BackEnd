package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class EstadoPedidoDominio {
	
	private UUID id;
	private String nombre;
	
	
	private EstadoPedidoDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
	}
	

	public UUID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public static class Builder {
		private UUID id;
		private String nombre;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}
		
		public EstadoPedidoDominio build() {
			return new EstadoPedidoDominio(this);
		}
		
	}
}
