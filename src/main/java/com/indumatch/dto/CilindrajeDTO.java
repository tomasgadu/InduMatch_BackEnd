package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilNumero;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class CilindrajeDTO {
	
	private UUID id;
	private LineaModeloDTO lineaModelo;
	private int valor;
	
	public CilindrajeDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setLineaModelo(new LineaModeloDTO());
		setValor(UtilNumero.CERO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public LineaModeloDTO getLineaModelo() {
		return lineaModelo;
	}
	
	public void setLineaModelo(LineaModeloDTO lineaModelo) {
		this.lineaModelo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(lineaModelo, new LineaModeloDTO());
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
