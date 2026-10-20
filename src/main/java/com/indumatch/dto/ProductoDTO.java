package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ProductoDTO {
	
	private UUID id;
	private String referencia;
	private String descripcion;
	private CategoriaProductoDTO categoriaProducto;
	private ModeloMotoDTO modeloMoto;
	private MarcaComercialDTO marcaComercial;
	
	public ProductoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setReferencia(UtilTexto.VACIO);
		setDescripcion(UtilTexto.VACIO);
		setCategoriaProducto(new CategoriaProductoDTO());
		setModeloMoto(new ModeloMotoDTO());
		setMarcaComercial(new MarcaComercialDTO());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public String getReferencia() {
		return referencia;
	}
	
	public void setReferencia(String referencia) {
		this.referencia = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(referencia);
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(descripcion);
	}
	
	public CategoriaProductoDTO getCategoriaProducto() {
		return categoriaProducto;
	}
	
	public void setCategoriaProducto(CategoriaProductoDTO categoriaProducto) {
		this.categoriaProducto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(categoriaProducto, new CategoriaProductoDTO());
	}
	
	public ModeloMotoDTO getModeloMoto() {
		return modeloMoto;
	}
	
	public void setModeloMoto(ModeloMotoDTO modeloMoto) {
		this.modeloMoto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(modeloMoto, new ModeloMotoDTO());
	}
	
	public MarcaComercialDTO getMarcaComercial() {
		return marcaComercial;
	}
	
	public void setMarcaComercial(MarcaComercialDTO marcaComercial) {
		this.marcaComercial = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaComercial, new MarcaComercialDTO());
	}
	
}
