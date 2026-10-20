package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class PaisDominio {
	
	private UUID id;
	private String nombre;
	private String codigo;
	
	
	private PaisDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.codigo = builder.codigo;
	}
	

	public UUID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public static class Builder {
		private UUID id;
		private String nombre;
		private String codigo;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
			codigo = UtilTexto.VACIO;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}
		
		public Builder codigo(String codigo) {
			this.codigo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(codigo);
			return this;
		}
		
		public PaisDominio build() {
			return new PaisDominio(this);
		}
		
	}
}
