package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class HomologacionDominio {
	
	private UUID id;
	private MarcaComercialDominio marcaComercial;
	private String codigo;
	private ProductoDominio producto;
	
	
	private HomologacionDominio(Builder builder) {
		this.id = builder.id;
		this.marcaComercial = builder.marcaComercial;
		this.codigo = builder.codigo;
		this.producto = builder.producto;
	}
	

	public UUID getId() {
		return id;
	}
	
	public MarcaComercialDominio getMarcaComercial() {
		return marcaComercial;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public ProductoDominio getProducto() {
		return producto;
	}
	
	public static class Builder {
		private UUID id;
		private MarcaComercialDominio marcaComercial;
		private String codigo;
		private ProductoDominio producto;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			marcaComercial = new MarcaComercialDominio.Builder().build();
			codigo = UtilTexto.VACIO;
			producto = new ProductoDominio.Builder().build();
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder marcaComercial(MarcaComercialDominio marcaComercial) {
			this.marcaComercial = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaComercial, new MarcaComercialDominio.Builder().build());
			return this;
		}
		
		public Builder codigo(String codigo) {
			this.codigo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(codigo);
			return this;
		}
		
		public Builder producto(ProductoDominio producto) {
			this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoDominio.Builder().build());
			return this;
		}
		
		public HomologacionDominio build() {
			return new HomologacionDominio(this);
		}
		
	}
}
