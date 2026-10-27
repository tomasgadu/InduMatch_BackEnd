package com.indumatch.negocio.negocio.assembler.impl;

import com.indumatch.dominio.CiudadDominio;
import com.indumatch.entidad.CiudadEntidad;
import com.indumatch.negocio.negocio.assembler.EntidadAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class CiudadEntidadAssembler implements EntidadAssembler<CiudadDominio, CiudadEntidad> {

	private static final EntidadAssembler<CiudadDominio, CiudadEntidad> instancia = new CiudadEntidadAssembler();
	
	private CiudadEntidadAssembler() {

	}

	public static EntidadAssembler<CiudadDominio, CiudadEntidad> getInstance() {
		return instancia;
	}

	@Override
	public CiudadEntidad convertirAEntidad(CiudadDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new CiudadDominio.Builder().build());
		return new CiudadEntidad(dominioTmp.getId(),
				dominioTmp.getNombre(),
				DepartamentoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getDepartamento()));
	}

	@Override
	public CiudadDominio convertirADominio(CiudadEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new CiudadEntidad());
		return new CiudadDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.departamento(DepartamentoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getDepartamento()))
				.build();
	}
}
