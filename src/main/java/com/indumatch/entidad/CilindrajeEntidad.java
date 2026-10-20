package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilNumero;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class CilindrajeEntidad {
	
	private UUID id;
	private LineaModeloEntidad lineaModelo;
	private int valor;
	
	public CilindrajeEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setLineaModelo(new LineaModeloEntidad());
		setValor(UtilNumero.CERO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public LineaModeloEntidad getLineaModelo() {
		return lineaModelo;
	}
	
	public void setLineaModelo(LineaModeloEntidad lineaModelo) {
		this.lineaModelo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(lineaModelo, new LineaModeloEntidad());
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
