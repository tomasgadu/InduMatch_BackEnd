package com.indumatch.negocio.negocio.assembler.impl;

import com.indumatch.dominio.PaisDominio;
import com.indumatch.entidad.PaisEntidad;
import com.indumatch.negocio.negocio.assembler.EntidadAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class PaisEntidadAssembler implements EntidadAssembler<PaisDominio, PaisEntidad> {

	private static final EntidadAssembler<PaisDominio, PaisEntidad> instancia = new PaisEntidadAssembler();
	
	private PaisEntidadAssembler() {

	}

	public static EntidadAssembler<PaisDominio, PaisEntidad> getInstance() {
		return instancia;
	}

	@Override
	public PaisEntidad convertirAEntidad(PaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new PaisDominio.Builder().build());
		return new PaisEntidad(dominioTmp.getId(),
				dominioTmp.getNombre(),
				dominioTmp.getCodigo());
	}

	@Override
	public PaisDominio convertirADominio(PaisEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PaisEntidad());
		return new PaisDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.codigo(entidadTmp.getCodigo())
				.build();
	}
}
