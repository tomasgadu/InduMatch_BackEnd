package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ProductoDominio {
	
	private UUID id;
	private String referencia;
	private String descripcion;
	private CategoriaProductoDominio categoriaProducto;
	private ModeloMotoDominio modeloMoto;
	private MarcaComercialDominio marcaComercial;
	
	
	private ProductoDominio(Builder builder) {
		this.id = builder.id;
		this.referencia = builder.referencia;
		this.descripcion = builder.descripcion;
		this.categoriaProducto = builder.categoriaProducto;
		this.modeloMoto = builder.modeloMoto;
		this.marcaComercial = builder.marcaComercial;
	}
	

	public UUID getId() {
		return id;
	}
	
	public String getReferencia() {
		return referencia;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public CategoriaProductoDominio getCategoriaProducto() {
		return categoriaProducto;
	}
	
	public ModeloMotoDominio getModeloMoto() {
		return modeloMoto;
	}
	
	public MarcaComercialDominio getMarcaComercial() {
		return marcaComercial;
	}
	
	public static class Builder {
		private UUID id;
		private String referencia;
		private String descripcion;
		private CategoriaProductoDominio categoriaProducto;
		private ModeloMotoDominio modeloMoto;
		private MarcaComercialDominio marcaComercial;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			referencia = UtilTexto.VACIO;
			descripcion = UtilTexto.VACIO;
			categoriaProducto = new CategoriaProductoDominio.Builder().build();
			modeloMoto = new ModeloMotoDominio.Builder().build();
			marcaComercial = new MarcaComercialDominio.Builder().build();
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder referencia(String referencia) {
			this.referencia = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(referencia);
			return this;
		}
		
		public Builder descripcion(String descripcion) {
			this.descripcion = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(descripcion);
			return this;
		}
		
		public Builder categoriaProducto(CategoriaProductoDominio categoriaProducto) {
			this.categoriaProducto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(categoriaProducto, new CategoriaProductoDominio.Builder().build());
			return this;
		}
		
		public Builder modeloMoto(ModeloMotoDominio modeloMoto) {
			this.modeloMoto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(modeloMoto, new ModeloMotoDominio.Builder().build());
			return this;
		}
		
		public Builder marcaComercial(MarcaComercialDominio marcaComercial) {
			this.marcaComercial = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaComercial, new MarcaComercialDominio.Builder().build());
			return this;
		}
		
		public ProductoDominio build() {
			return new ProductoDominio(this);
		}
		
	}
}
