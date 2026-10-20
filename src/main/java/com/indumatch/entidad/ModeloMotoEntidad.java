package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ModeloMotoEntidad {
	
	private UUID id;
	private CilindrajeEntidad cilindraje;
	
	public ModeloMotoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCilindraje(new CilindrajeEntidad());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public CilindrajeEntidad getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(CilindrajeEntidad cilindraje) {
		this.cilindraje = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cilindraje, new CilindrajeEntidad());
	}
	
}
