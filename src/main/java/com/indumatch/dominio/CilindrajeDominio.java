package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilNumero;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class CilindrajeDominio {
	
	private UUID id;
	private LineaModeloDominio lineaModelo;
	private int valor;
	
	
	private CilindrajeDominio(Builder builder) {
		this.id = builder.id;
		this.lineaModelo = builder.lineaModelo;
		this.valor = builder.valor;
	}
	

	public UUID getId() {
		return id;
	}
	
	public LineaModeloDominio getLineaModelo() {
		return lineaModelo;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static class Builder {
		private UUID id;
		private LineaModeloDominio lineaModelo;
		private int valor;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			lineaModelo = new LineaModeloDominio.Builder().build();
			valor = UtilNumero.CERO;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder lineaModelo(LineaModeloDominio lineaModelo) {
			this.lineaModelo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(lineaModelo, new LineaModeloDominio.Builder().build());
			return this;
		}
		
		public Builder valor(int valor) {
			this.valor = valor;
			return this;
		}
		
		public CilindrajeDominio build() {
			return new CilindrajeDominio(this);
		}
		
	}
}
