package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class LineaModeloDominio {
	
	private UUID id;
	private MarcaFabricanteDominio marcaFabricante;
	private String nombre;
	
	
	private LineaModeloDominio(Builder builder) {
		this.id = builder.id;
		this.marcaFabricante = builder.marcaFabricante;
		this.nombre = builder.nombre;
	}
	

	public UUID getId() {
		return id;
	}
	
	public MarcaFabricanteDominio getMarcaFabricante() {
		return marcaFabricante;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public static class Builder {
		private UUID id;
		private MarcaFabricanteDominio marcaFabricante;
		private String nombre;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			marcaFabricante = new MarcaFabricanteDominio.Builder().build();
			nombre = UtilTexto.VACIO;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder marcaFabricante(MarcaFabricanteDominio marcaFabricante) {
			this.marcaFabricante = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaFabricante, new MarcaFabricanteDominio.Builder().build());
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}
		
		public LineaModeloDominio build() {
			return new LineaModeloDominio(this);
		}
		
	}
}
