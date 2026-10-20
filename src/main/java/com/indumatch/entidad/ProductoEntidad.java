package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ProductoEntidad {
	
	private UUID id;
	private String referencia;
	private String descripcion;
	private CategoriaProductoEntidad categoriaProducto;
	private ModeloMotoEntidad modeloMoto;
	private MarcaComercialEntidad marcaComercial;
	
	public ProductoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setReferencia(UtilTexto.VACIO);
		setDescripcion(UtilTexto.VACIO);
		setCategoriaProducto(new CategoriaProductoEntidad());
		setModeloMoto(new ModeloMotoEntidad());
		setMarcaComercial(new MarcaComercialEntidad());
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
	
	public CategoriaProductoEntidad getCategoriaProducto() {
		return categoriaProducto;
	}
	
	public void setCategoriaProducto(CategoriaProductoEntidad categoriaProducto) {
		this.categoriaProducto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(categoriaProducto, new CategoriaProductoEntidad());
	}
	
	public ModeloMotoEntidad getModeloMoto() {
		return modeloMoto;
	}
	
	public void setModeloMoto(ModeloMotoEntidad modeloMoto) {
		this.modeloMoto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(modeloMoto, new ModeloMotoEntidad());
	}
	
	public MarcaComercialEntidad getMarcaComercial() {
		return marcaComercial;
	}
	
	public void setMarcaComercial(MarcaComercialEntidad marcaComercial) {
		this.marcaComercial = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaComercial, new MarcaComercialEntidad());
	}
	
}
