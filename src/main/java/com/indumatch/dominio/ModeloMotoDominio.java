package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ModeloMotoDominio {
	
	private UUID id;
	private CilindrajeDominio cilindraje;
	
	
	private ModeloMotoDominio(Builder builder) {
		this.id = builder.id;
		this.cilindraje = builder.cilindraje;
	}
	

	public UUID getId() {
		return id;
	}
	
	public CilindrajeDominio getCilindraje() {
		return cilindraje;
	}
	
	public static class Builder {
		private UUID id;
		private CilindrajeDominio cilindraje;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cilindraje = new CilindrajeDominio.Builder().build();
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder cilindraje(CilindrajeDominio cilindraje) {
			this.cilindraje = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cilindraje, new CilindrajeDominio.Builder().build());
			return this;
		}
		
		public ModeloMotoDominio build() {
			return new ModeloMotoDominio(this);
		}
		
	}
}
