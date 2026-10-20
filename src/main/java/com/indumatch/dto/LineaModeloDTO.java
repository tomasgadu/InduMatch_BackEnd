package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class LineaModeloDTO {
	
	private UUID id;
	private MarcaFabricanteDTO marcaFabricante;
	private String nombre;
	
	public LineaModeloDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setMarcaFabricante(new MarcaFabricanteDTO());
		setNombre(UtilTexto.VACIO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public MarcaFabricanteDTO getMarcaFabricante() {
		return marcaFabricante;
	}
	
	public void setMarcaFabricante(MarcaFabricanteDTO marcaFabricante) {
		this.marcaFabricante = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaFabricante, new MarcaFabricanteDTO());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
	}
	
}
