package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ModeloMotoDTO {
	
	private UUID id;
	private CilindrajeDTO cilindraje;
	
	public ModeloMotoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCilindraje(new CilindrajeDTO());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public CilindrajeDTO getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(CilindrajeDTO cilindraje) {
		this.cilindraje = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cilindraje, new CilindrajeDTO());
	}
	
}
