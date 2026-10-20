package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class HomologacionDTO {
	
	private UUID id;
	private MarcaComercialDTO marcaComercial;
	private String codigo;
	private ProductoDTO producto;
	
	public HomologacionDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setMarcaComercial(new MarcaComercialDTO());
		setCodigo(UtilTexto.VACIO);
		setProducto(new ProductoDTO());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public MarcaComercialDTO getMarcaComercial() {
		return marcaComercial;
	}
	
	public void setMarcaComercial(MarcaComercialDTO marcaComercial) {
		this.marcaComercial = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaComercial, new MarcaComercialDTO());
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(codigo);
	}
	
	public ProductoDTO getProducto() {
		return producto;
	}
	
	public void setProducto(ProductoDTO producto) {
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoDTO());
	}
	
}
