package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class HomologacionEntidad {
	
	private UUID id;
	private MarcaComercialEntidad marcaComercial;
	private String codigo;
	private ProductoEntidad producto;
	
	public HomologacionEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setMarcaComercial(new MarcaComercialEntidad());
		setCodigo(UtilTexto.VACIO);
		setProducto(new ProductoEntidad());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public MarcaComercialEntidad getMarcaComercial() {
		return marcaComercial;
	}
	
	public void setMarcaComercial(MarcaComercialEntidad marcaComercial) {
		this.marcaComercial = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaComercial, new MarcaComercialEntidad());
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(codigo);
	}
	
	public ProductoEntidad getProducto() {
		return producto;
	}
	
	public void setProducto(ProductoEntidad producto) {
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoEntidad());
	}
	
}
